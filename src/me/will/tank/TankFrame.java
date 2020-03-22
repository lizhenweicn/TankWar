package me.will.tank;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author : zhenweiLi
 * @date :2019-04-25 20:40
 * DESC : 坦克大战主窗口
 */
public class TankFrame extends Frame {

    /**
     * 游戏区域宽度
     */
    public static final int GAME_WIDTH = PropertyManager.getAsInt("GAME_WIDTH", 1080);

    /**
     * 游戏区域高度
     */
    public static final int GAME_HEIGHT = PropertyManager.getAsInt("GAME_HEIGHT", 960);

    /**
     * 游戏物品模型
     */
    private GameModel mGameModel = new GameModel();

    /**
     * 坦克游戏的主窗口
     */
    public TankFrame() {
        //  设置窗口尺寸
        setSize(GAME_WIDTH, GAME_HEIGHT);
        //  设置窗口是否可扩展
        setResizable(false);
        //  设置窗口标题
        setTitle("TankWar");
        //  显示窗口是否可见
        setVisible(true);
        //  设置键盘监听处理类
        addKeyListener(new MyKeyListener());
        //  设置窗口关闭方法
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    /**
     * 双缓冲机制解决闪烁问题
     */
    private Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    /**
     * 窗口需要重新绘制( 创建 | 最小化 )的时候，自动调用该方法
     *
     * @param g 相当于【 画笔 】
     */
    @Override
    public void paint(Graphics g) {
        mGameModel.paint(g);
    }

    /**
     * 键盘监听处理类
     */
    private class MyKeyListener extends KeyAdapter {

        /**
         * 向上键是否被按压
         */
        private boolean mBU = false;

        /**
         * 向下键是否被按压
         */
        private boolean mBD = false;

        /**
         * 向左键是否被按压
         */
        private boolean mBL = false;

        /**
         * 向右键是否被按压
         */
        private boolean mBR = false;

        /**
         * 当键盘按下时调用
         *
         * @param e 键盘事件
         */
        @Override
        public void keyPressed(KeyEvent e) {

            ////  播放坦克移动的音效
            //  new Thread(() -> new Audio("audio/tank_move.wav").play()).start();
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    mBU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    mBD = true;
                    break;
                case KeyEvent.VK_LEFT:
                    mBL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    mBR = true;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        /**
         * 当键盘抬起的时调用
         *
         * @param e 键盘事件
         */
        @Override
        public void keyReleased(KeyEvent e) {
            //System.out.println("KeyEvent - keyReleased : " + e.getKeyCode());
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    mBU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    mBD = false;
                    break;
                case KeyEvent.VK_LEFT:
                    mBL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    mBR = false;
                    break;
                case KeyEvent.VK_CONTROL:
                case KeyEvent.VK_SPACE:
                    //  control 键抬起时发射子弹
                    Tank mMainTank = mGameModel.getMainTank();
                    mMainTank.fire();
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        /**
         * 设置坦克方向
         */
        private void setMainTankDir() {
            Tank mMainTank = mGameModel.getMainTank();
            if (!mBU && !mBD && !mBL && !mBR) {
                mMainTank.setMoving(false);
            } else {
                mMainTank.setMoving(true);
                if (mBU) {
                    if (mBL) {
                        mMainTank.setTankDir(Dir.LU);
                    } else if (mBR) {
                        mMainTank.setTankDir(Dir.RU);
                    } else {
                        mMainTank.setTankDir(Dir.U);
                    }
                }
                if (mBD) {
                    if (mBL) {
                        mMainTank.setTankDir(Dir.LD);
                    } else if (mBR) {
                        mMainTank.setTankDir(Dir.RD);
                    } else {
                        mMainTank.setTankDir(Dir.D);
                    }
                }
                if (mBL) {
                    if (mBU) {
                        mMainTank.setTankDir(Dir.LU);
                    } else if (mBD) {
                        mMainTank.setTankDir(Dir.LD);
                    } else {
                        mMainTank.setTankDir(Dir.L);
                    }
                }
                if (mBR) {
                    if (mBU) {
                        mMainTank.setTankDir(Dir.RU);
                    } else if (mBD) {
                        mMainTank.setTankDir(Dir.RD);
                    } else {
                        mMainTank.setTankDir(Dir.R);
                    }
                }
            }
        }
    }

}
