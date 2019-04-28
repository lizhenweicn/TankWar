
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

    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 600;

    /**
     * 主战坦克
     */
    private Tank mMainTank = new Tank(200, 200, Dir.DOWN);

    private Bullet mBullet = new Bullet(50, 50, Dir.DOWN);

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
        mMainTank.paint(g);
        mBullet.paint(g);
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
                default:
                    break;
            }
            setMainTankDir();
        }

        /**
         * 设置坦克方向
         */
        private void setMainTankDir() {
            if (!mBU && !mBD && !mBL && !mBR) {
                mMainTank.setMoving(false);
            } else {
                mMainTank.setMoving(true);
                if (mBU) {
                    mMainTank.setTankDir(Dir.UP);
                }
                if (mBD) {
                    mMainTank.setTankDir(Dir.DOWN);
                }
                if (mBL) {
                    mMainTank.setTankDir(Dir.LEFT);
                }
                if (mBR) {
                    mMainTank.setTankDir(Dir.RIGHT);
                }
            }
        }
    }

}
