import java.awt.Frame;
import java.awt.Graphics;
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
     * 坦克的宽度
     */
    private static final int TANK_WIDTH = 50;

    /**
     * 坦克的高度
     */
    private static final int TANK_HEIGHT = 50;

    /**
     * 坦克移动的步长（ 速度 ）
     */
    private static final int TANK_STEP = 200;

    /**
     * 坦克的 X 轴位置
     */
    private int mTankX = 200;

    /**
     * 坦克的 Y 轴位置
     */
    private int mTankY = 200;

    public TankFrame() {
        //  设置窗口尺寸
        setSize(800, 600);
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
     * 窗口需要重新绘制( 创建 | 最小化 )的时候，自动调用该方法
     *
     * @param g 相当于【 画笔 】
     */
    @Override
    public void paint(Graphics g) {
        System.out.println("窗口重新绘制");
        g.fillRect(mTankX, mTankY, TANK_WIDTH, TANK_HEIGHT);
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
                    mBU = true;
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

            //  通知窗口进行重绘
            repaint();
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
                    mBU = false;
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
        }
    }

}
