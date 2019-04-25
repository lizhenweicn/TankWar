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
     * 坦克的 X 轴位置
     */
    private int mTankX = 200;

    /**
     * 坦克的 Y 轴位置
     */
    private int mTankY = 200;

    /**
     * 坦克移动的步长（ 速度 ）
     */
    private int mTankStep = 200;

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
        g.fillRect(mTankX, mTankY, 50, 50);
    }

    /**
     * 键盘监听处理类
     */
    private class MyKeyListener extends KeyAdapter {

        /**
         * 当键盘按下时调用
         *
         * @param e 键盘事件
         */
        @Override
        public void keyPressed(KeyEvent e) {
            mTankX += mTankStep;
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
            super.keyReleased(e);
        }
    }

}
