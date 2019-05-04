package me.will.tank;

import java.awt.Graphics;
import java.util.List;

/**
 * @author : zhenweiLi
 * @date :2019-04-28 20:23
 * DESC : 坦克类
 */
public class Tank {

    /**
     * 坦克的宽度
     */
    private static final int TANK_WIDTH = 50;

    /**
     * 坦克的高度
     */
    private static final int TANK_HEIGHT = 50;

    /**
     * 坦克移动速度( 正向 )
     */
    private static final int TANK_SPEED = 4;

    /**
     * 坦克的 X 轴位置
     */
    private int mTankX;

    /**
     * 坦克的 Y 轴位置
     */
    private int mTankY;

    /**
     * 坦克方向
     */
    private Dir mTankDir;

    /**
     * 坦克运动状态
     */
    private boolean moving = false;

    /**
     * 游戏窗口
     */
    private TankFrame mTankFrame;

    /**
     * 获取坦克方向
     *
     * @return 方向枚举
     */
    public Dir getTankDir() {
        return mTankDir;
    }

    /**
     * 设置坦克方向
     *
     * @param dir 方向枚举
     */
    public void setTankDir(Dir dir) {
        this.mTankDir = dir;
    }

    /**
     * 获取坦克是否移动的状态
     *
     * @return 是否运动
     */
    public boolean isMoving() {
        return moving;
    }

    /**
     * 设置坦克是否移动的状态
     *
     * @param moving 是否运动
     */
    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    /**
     * 无参构造
     */
    public Tank() {
    }

    /**
     * 构造方法
     *
     * @param tankX 初始化 X 轴
     * @param tankY 初始化 Y 轴
     * @param dir   初始化的方向
     */
    public Tank(int tankX, int tankY, Dir dir, TankFrame tankFrame) {
        this.mTankX = tankX;
        this.mTankY = tankY;
        this.mTankDir = dir;
        this.mTankFrame = tankFrame;
    }

    /**
     * 坦克绘制的方法
     *
     * @param g 画笔
     */
    public void paint(Graphics g) {
        switch (mTankDir) {
            case U:
                g.drawImage(ResManager.mTankU, mTankX, mTankY, null);
                break;
            case D:
                g.drawImage(ResManager.mTankD, mTankX, mTankY, null);
                break;
            case L:
                g.drawImage(ResManager.mTankL, mTankX, mTankY, null);
                break;
            case R:
                g.drawImage(ResManager.mTankR, mTankX, mTankY, null);
                break;
            case LU:
                g.drawImage(ResManager.mTankLU, mTankX, mTankY, null);
                break;
            case LD:
                g.drawImage(ResManager.mTankLD, mTankX, mTankY, null);
                break;
            case RU:
                g.drawImage(ResManager.mTankRU, mTankX, mTankY, null);
                break;
            case RD:
                g.drawImage(ResManager.mTankRD, mTankX, mTankY, null);
                break;
            default:
                break;
        }
        move();
    }

    /**
     * 坦克移动的方法
     */
    private void move() {

        if (!isMoving()) {
            return;
        }

        switch (mTankDir) {
            case U:
                mTankY -= TANK_SPEED;
                break;
            case D:
                mTankY += TANK_SPEED;
                break;
            case L:
                mTankX -= TANK_SPEED;
                break;
            case R:
                mTankX += TANK_SPEED;
                break;
            case LU:
                mTankX -= TANK_SPEED - 1;
                mTankY -= TANK_SPEED - 1;
                break;
            case LD:
                mTankX -= TANK_SPEED - 1;
                mTankY += TANK_SPEED - 1;
                break;
            case RU:
                mTankX += TANK_SPEED - 1;
                mTankY -= TANK_SPEED - 1;
                break;
            case RD:
                mTankX += TANK_SPEED - 1;
                mTankY += TANK_SPEED - 1;
                break;
            default:
                break;
        }
    }

    /**
     * 发射子弹
     */
    public void fire() {
        List<Bullet> bulletList = mTankFrame.getBulletList();
        bulletList.add(new Bullet(this.mTankX, this.mTankY, this.mTankDir, this.mTankFrame));
    }
}
