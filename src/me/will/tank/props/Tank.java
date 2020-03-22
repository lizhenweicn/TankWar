package me.will.tank.props;

import me.will.tank.decorator.RectBorderDecorator;
import me.will.tank.enums.Dir;
import me.will.tank.strategy.FireStrategy;
import me.will.tank.main.GameModel;
import me.will.tank.enums.Group;
import me.will.tank.manager.PropertyManager;
import me.will.tank.manager.ResManager;
import me.will.tank.strategy.SafeFireStrategy;
import me.will.tank.main.TankFrame;

import java.awt.Graphics;
import java.util.Random;

/**
 * @author : zhenweiLi
 * @date :2019-04-28 20:23
 * DESC : 坦克类
 */
public class Tank extends BaseGameProps {

    /**
     * 坦克移动速度( 正向 )
     */
    private static final int TANK_SPEED = PropertyManager.getAsInt("TASK_SPEED", 2);

    /**
     * 坦克的原 X 轴位置
     */
    private int mTankOldX;

    /**
     * 坦克的原 Y 轴位置
     */
    private int mTankOldY;

    /**
     * 坦克方向
     */
    private Dir mTankDir;

    /**
     * 坦克运动状态
     */
    private boolean moving;

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
     * 坦克的开火策略（ 默认策略 ）
     */
    private FireStrategy fireStrategy = new SafeFireStrategy();

    public Group getGroup() {
        return mGroup;
    }

    public boolean isLiving() {
        return mIsLiving;
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
    public Tank(int tankX, int tankY, Dir dir, Group group) {
        this.mRectangle.x = tankX;
        this.mRectangle.y = tankY;
        this.mRectangle.width = ResManager.getTankWidth();
        this.mRectangle.height = ResManager.getTankHeight();
        this.mTankDir = dir;
        this.mGroup = group;
        this.moving = (group == Group.BAD);
        GameModel.getInstance().add(new RectBorderDecorator(this));
    }

    /**
     * 坦克绘制的方法
     *
     * @param g 画笔
     */
    @Override
    public void paint(Graphics g) {

        if (!mIsLiving) {
            GameModel.getInstance().remove(this);
        }

        switch (mTankDir) {
            case U:
                g.drawImage(this.mGroup == Group.GOOD ? ResManager.mGoodTankU : ResManager.mBadTankU, mRectangle.x, mRectangle.y, null);
                break;
            case D:
                g.drawImage(this.mGroup == Group.GOOD ? ResManager.mGoodTankD : ResManager.mBadTankD, mRectangle.x, mRectangle.y, null);
                break;
            case L:
                g.drawImage(this.mGroup == Group.GOOD ? ResManager.mGoodTankL : ResManager.mBadTankL, mRectangle.x, mRectangle.y, null);
                break;
            case R:
                g.drawImage(this.mGroup == Group.GOOD ? ResManager.mGoodTankR : ResManager.mBadTankR, mRectangle.x, mRectangle.y, null);
                break;
            case LU:
                g.drawImage(this.mGroup == Group.GOOD ? ResManager.mGoodTankLU : ResManager.mBadTankLU, mRectangle.x, mRectangle.y, null);
                break;
            case LD:
                g.drawImage(this.mGroup == Group.GOOD ? ResManager.mGoodTankLD : ResManager.mBadTankLD, mRectangle.x, mRectangle.y, null);
                break;
            case RU:
                g.drawImage(this.mGroup == Group.GOOD ? ResManager.mGoodTankRU : ResManager.mBadTankRU, mRectangle.x, mRectangle.y, null);
                break;
            case RD:
                g.drawImage(this.mGroup == Group.GOOD ? ResManager.mGoodTankRD : ResManager.mBadTankRD, mRectangle.x, mRectangle.y, null);
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

        //  记录上一次的位置
        mTankOldX = mRectangle.x;
        mTankOldY = mRectangle.y;

        if (!isMoving()) {
            return;
        }

        switch (mTankDir) {
            case U:
                mRectangle.y -= TANK_SPEED;
                break;
            case D:
                mRectangle.y += TANK_SPEED;
                break;
            case L:
                mRectangle.x -= TANK_SPEED;
                break;
            case R:
                mRectangle.x += TANK_SPEED;
                break;
            case LU:
                mRectangle.x -= TANK_SPEED - 1;
                mRectangle.y -= TANK_SPEED - 1;
                break;
            case LD:
                mRectangle.x -= TANK_SPEED - 1;
                mRectangle.y += TANK_SPEED - 1;
                break;
            case RU:
                mRectangle.x += TANK_SPEED - 1;
                mRectangle.y -= TANK_SPEED - 1;
                break;
            case RD:
                mRectangle.x += TANK_SPEED - 1;
                mRectangle.y += TANK_SPEED - 1;
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

    }

    /**
     * 边界检测
     */
    private void boundCheck() {

        if (this.mRectangle.x < 0) {
            this.mRectangle.x = 0;
        }

        if (this.mRectangle.y < 20) {
            this.mRectangle.y = 20;
        }

        if (this.mRectangle.x > TankFrame.GAME_WIDTH - ResManager.getTankWidth()) {
            this.mRectangle.x = TankFrame.GAME_WIDTH - ResManager.getTankWidth();
        }

        if (this.mRectangle.y > TankFrame.GAME_HEIGHT - ResManager.getTankHeight()) {
            this.mRectangle.y = TankFrame.GAME_HEIGHT - ResManager.getTankHeight();
        }

    }

    /**
     * 发射子弹
     */
    public void fire() {
        //  活着才能开火
        if (this.isLiving()) {
            fireStrategy.fire(this);
        }
    }

    public void back() {
        this.mRectangle.x = mTankOldX;
        this.mRectangle.y = mTankOldY;
    }

    /**
     * 坦克报废
     */
    public void die() {
        this.mIsLiving = false;
    }
}
