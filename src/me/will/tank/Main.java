package me.will.tank;

/**
 * @author : zhenweiLi
 * @date :2019-04-21 09:30
 * DESC : new 出一个窗口
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {

        //  新建主窗口
        TankFrame tankFrame = new TankFrame();

        //  初始化敌方坦克
        int tankListSize = PropertyManager.getAsInt("INIT_TANK_COUNT", 5);
        int offset = (TankFrame.GAME_WIDTH - tankListSize * Tank.TANK_WIDTH) / (tankListSize + 1);
        for (int i = 0; i < tankListSize; i++) {
            Tank tank = new Tank((Tank.TANK_WIDTH + offset) * i + offset, offset, Dir.D, Group.BAD, tankFrame);
            tankFrame.getTankList().add(tank);
        }

        ////  播放背景音乐
        //  new Thread(() -> new Audio("audio/war1.wav").loop()).start();

        //  每隔 50 毫秒主窗口自动绘制
        while (true) {
            Thread.sleep(16);
            tankFrame.repaint();
        }

    }
}
