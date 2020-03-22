package me.will.tank.props;

import me.will.tank.decorator.RectBorderDecorator;
import me.will.tank.enums.Dir;
import me.will.tank.main.GameModel;
import me.will.tank.enums.Group;
import me.will.tank.manager.PropertyManager;
import me.will.tank.manager.ResManager;
import me.will.tank.main.TankFrame;

import java.awt.Graphics;

/**
 * @author : zhenweiLi
 * @date :2019-04-28 20:52
 * DESC : 子弹类
 */
public class Bullet extends BaseGameProps {

    /**
     * 子弹移动速度( 正向 )
     */
    private static final int BULLET_SPEED = PropertyManager.getAsInt("BULLET_SPEED", 6);

    /**
     * 子弹方向
     */
    private Dir mBulletDir;

    /**
     * 子弹是否存在
     */
    private boolean mIsLiving = true;

    /**
     * 子弹的分组
     */
    private Group mGroup;

    public Group getGroup() {
        return mGroup;
    }

    public boolean isLiving() {
        return mIsLiving;
    }

    /**
     * 无参构造
     */
    public Bullet() {
    }

    /**
     * 构造方法
     *
     * @param bulletX   初始化 X 轴
     * @param bulletY   初始化 Y 轴
     * @param bulletDir 初始化的方向
     */
    public Bullet(int bulletX, int bulletY, Dir bulletDir, Group group) {
        this.mRectangle.x = bulletX;
        this.mRectangle.y = bulletY;
        this.mRectangle.width = ResManager.getBulletWidth();
        this.mRectangle.height = ResManager.getBulletHeight();
        this.mBulletDir = bulletDir;
        this.mGroup = group;
        GameModel.getInstance().add(this);
    }

    /**
     * 子弹绘制的方法
     *
     * @param g 画笔
     */
    @Override
    public void paint(Graphics g) {

        if (!mIsLiving) {
            GameModel.getInstance().remove(this);
        }

        switch (mBulletDir) {
            case U:
                g.drawImage(ResManager.mBulletU, mRectangle.x, mRectangle.y, null);
                break;
            case D:
                g.drawImage(ResManager.mBulletD, mRectangle.x, mRectangle.y, null);
                break;
            case L:
                g.drawImage(ResManager.mBulletL, mRectangle.x, mRectangle.y, null);
                break;
            case R:
                g.drawImage(ResManager.mBulletR, mRectangle.x, mRectangle.y, null);
                break;
            case LU:
                g.drawImage(ResManager.mBulletLU, mRectangle.x, mRectangle.y, null);
                break;
            case LD:
                g.drawImage(ResManager.mBulletLD, mRectangle.x, mRectangle.y, null);
                break;
            case RU:
                g.drawImage(ResManager.mBulletRU, mRectangle.x, mRectangle.y, null);
                break;
            case RD:
                g.drawImage(ResManager.mBulletRD, mRectangle.x, mRectangle.y, null);
                break;
            default:
                break;
        }

        move();
    }

    /**
     * 子弹移动的方法
     */
    private void move() {

        switch (mBulletDir) {
            case L:
                mRectangle.x -= BULLET_SPEED;
                break;
            case U:
                mRectangle.y -= BULLET_SPEED;
                break;
            case R:
                mRectangle.x += BULLET_SPEED;
                break;
            case D:
                mRectangle.y += BULLET_SPEED;
                break;
            case LU:
                mRectangle.x -= BULLET_SPEED - 2;
                mRectangle.y -= BULLET_SPEED - 2;
                break;
            case LD:
                mRectangle.x -= BULLET_SPEED - 2;
                mRectangle.y += BULLET_SPEED - 2;
                break;
            case RU:
                mRectangle.x += BULLET_SPEED - 2;
                mRectangle.y -= BULLET_SPEED - 2;
                break;
            case RD:
                mRectangle.x += BULLET_SPEED - 2;
                mRectangle.y += BULLET_SPEED - 2;
                break;
            default:
                break;
        }

        if (mRectangle.x < 0 || mRectangle.y < 0 || mRectangle.x > TankFrame.GAME_WIDTH || mRectangle.y > TankFrame.GAME_HEIGHT) {
            mIsLiving = false;
        }

    }

    /**
     * 子弹消亡
     */
    public void die() {
        this.mIsLiving = false;
    }

}
