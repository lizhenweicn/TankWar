import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author : zhenweiLi
 * @date :2019-04-21 09:30
 * DESC : new 出一个窗口
 */
public class T {
    public static void main(String[] args) {
        //  创建窗口
        Frame f = new Frame();
        //  设置窗口尺寸
        f.setSize(800,600);
        //  设置窗口是否可扩展
        f.setResizable(false);
        //  设置窗口标题
        f.setTitle("TankWar");
        //  显示窗口是否可见
        f.setVisible(true);
        //  设置窗口关闭方法
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
