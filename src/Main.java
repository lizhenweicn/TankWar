/**
 * @author : zhenweiLi
 * @date :2019-04-21 09:30
 * DESC : new 出一个窗口
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        //  新建主窗口
        TankFrame tankFrame = new TankFrame();
        //  每隔 50 毫秒主窗口自动绘制
        while (true) {
            Thread.sleep(50);
            tankFrame.repaint();
        }
    }
}
