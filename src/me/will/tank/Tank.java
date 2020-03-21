package me.will.tank;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 * @author : zhenweiLi
 * @date :2019-04-28 20:23
 * DESC : 坦克类
 */
public class Tank {

    /**
     * 坦克的宽度
     */
    public static final int TANK_WIDTH = ResManager.mGoodTankD.getWidth();

    /**
     * 坦克的高度
     */
    public static final int TANK_HEIGHT = ResManager.mGoodTankD.getHeight();

    /**
     * 坦克移动速度( 正向 )
     */
    private static final int TANK_SPEED = PropertyManager.getAsInt("TASK_SPEED", 2);

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
    private boolean moving;

    /**
     * 游戏物品模型
     */
    private GameModel mGameModel;

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
     * 坦克是否存活
     */
    private boolean mIsLiving = true;

    /**
     * 获取坦克是否移动的状态
     *
     * @return 是否运动
     */
    public boolean isMoving() {
        return moving;
    }

    /**
     * 随机数生成器
     */
    private Random mRandom = new Random();

    /**
     * 坦克的分组
     */
    private Group mGroup;

    /**
     * 设置坦克是否移动的状态
     *
     * @param moving 是否运动
     */
    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    /**
     * 矩形范围
     */
    private Rectangle mRectangle = new Rectangle();

    /**
     * 坦克的开火策略（ 默认策略 ）
     */
    private FireStrategy fireStrategy = new SafeFireStrategy();

    public int getTankX() {
        return mTankX;
    }

    public int getTankY() {
        return mTankY;
    }

    public int getTankWidth() {
        return TANK_WIDTH;
    }

    public int getTankHeight() {
        return TANK_HEIGHT;
    }

    public Group getGroup() {
        return mGroup;
    }

    public void setGroup(Group mGroup) {
        this.mGroup = mGroup;
    }

    public Rectangle getRectangle() {
        return mRectangle;
    }

    public GameModel getGameModel() {
        return mGameModel;
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
    public Tank(int tankX, int tankY, Dir dir, Group group, GameModel gameModel) {
        this.mTankX = tankX;
        this.mTankY = tankY;
        this.mTankDir = dir;
        this.mGroup = group;
        this.mGameModel = gameModel;
        this.moving = (group == Group.BAD);
//        this.moving = false;

        this.mRectangle.x = tankX;
        this.mRectangle.y = tankY;
        this.mRectangle.width = TANK_WIDTH;
        this.mRectangle.height = TANK_HEIGHT;
        this.mGameModel.getTankList().add(this);
    }

    /**
     * 坦克绘制的方法
     *
     * @param g 画笔
     */
    public void paint(Graphics g) {

        if (!mIsLiving) {
            mGameModel.getTankList().remove(this);
        }

        switch (mTankDir) {
            case U:
                g.drawImage(this.mGroup == Group.GOOD ? ResManager.mGoodTankU : ResManager.mBadTankU, mTankX, mTankY, null);
                break;
            case D:
                g.drawImage(this.mGroup == Group.GOOD ? ResManager.mGoodTankD : ResManager.mBadTankD, mTankX, mTankY, null);
                break;
            case L:
                g.drawImage(this.mGroup == Group.GOOD ? ResManager.mGoodTankL : ResManager.mBadTankL, mTankX, mTankY, null);
                break;
            case R:
                g.drawImage(this.mGroup == Group.GOOD ? ResManager.mGoodTankR : ResManager.mBadTankR, mTankX, mTankY, null);
                break;
            case LU:
                g.drawImage(this.mGroup == Group.GOOD ? ResManager.mGoodTankLU : ResManager.mBadTankLU, mTankX, mTankY, null);
                break;
            case LD:
                g.drawImage(this.mGroup == Group.GOOD ? ResManager.mGoodTankLD : ResManager.mBadTankLD, mTankX, mTankY, null);
                break;
            case RU:
                g.drawImage(this.mGroup == Group.GOOD ? ResManager.mGoodTankRU : ResManager.mBadTankRU, mTankX, mTankY, null);
                break;
            case RD:
                g.drawImage(this.mGroup == Group.GOOD ? ResManager.mGoodTankRD : ResManager.mBadTankRD, mTankX, mTankY, null);
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

        //  敌方坦克随机开火
        if (mGroup == Group.BAD && mRandom.nextInt(100) > 95) {
            this.fire();
        }

        //  敌方坦克随机移动
        if (mGroup == Group.BAD && mRandom.nextInt(100) > 95) {
            this.mTankDir = Dir.values()[mRandom.nextInt(4)];
        }

        //  边界检测
        boundCheck();

        //  更新矩形坐标
        this.mRectangle.x = this.mTankX;
        this.mRectangle.y = this.mTankY;

    }

    /**
     * 边界检测
     */
    private void boundCheck() {

        if (this.mTankX < 0) {
            this.mTankX = 0;
        }

        if (this.mTankY < 20) {
            this.mTankY = 20;
        }

        if (this.mTankX > TankFrame.GAME_WIDTH - Tank.TANK_WIDTH) {
            this.mTankX = TankFrame.GAME_WIDTH - Tank.TANK_WIDTH;
        }

        if (this.mTankY > TankFrame.GAME_HEIGHT - Tank.TANK_HEIGHT) {
            this.mTankY = TankFrame.GAME_HEIGHT - Tank.TANK_HEIGHT;
        }

    }

    /**
     * 发射子弹
     */
    public void fire() {
        fireStrategy.fire(this);
    }

    /**
     * 坦克报废
     */
    public void die() {
        this.mIsLiving = false;
    }
}
