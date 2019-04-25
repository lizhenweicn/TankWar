import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author : zhenweiLi
 * @date :2019-04-25 20:40
 * DESC : 坦克大战主窗口
 */
public class TankFrame extends Frame {

    public TankFrame() throws HeadlessException {
        //  设置窗口尺寸
        setSize(800,600);
        //  设置窗口是否可扩展
        setResizable(false);
        //  设置窗口标题
        setTitle("TankWar");
        //  显示窗口是否可见
        setVisible(true);
        //  设置窗口关闭方法
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    /**
     * 窗口需要重新绘制的时候，自动调用该方法
     * @param g 相当于【 画笔 】
     */
    @Override
    public void paint(Graphics g) {
        g.fillRect(200, 200, 50, 50);
    }

}
