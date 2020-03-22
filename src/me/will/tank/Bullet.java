package me.will.tank;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * @author : zhenweiLi
 * @date :2019-04-28 20:52
 * DESC : 子弹类
 */
public class Bullet extends BaseGameObject {

    /**
     * 子弹的宽度
     */
    public static final int BULLET_WIDTH = ResManager.mBulletD.getWidth();

    /**
     * 子弹的高度
     */
    public static final int BULLET_HEIGHT = ResManager.mBulletD.getHeight();

    /**
     * 子弹移动速度( 正向 )
     */
    private static final int BULLET_SPEED = PropertyManager.getAsInt("BULLET_SPEED", 6);

    /**
     * 子弹的 X 轴位置
     */
    private int mBulletX;

    /**
     * 子弹的 Y 轴位置
     */
    private int mBulletY;

    /**
     * 子弹方向
     */
    private Dir mBulletDir;

    /**
     * 子弹是否存在
     */
    private boolean mIsLiving = true;

    /**
     * 游戏道具模型
     */
    private GameModel mGameModel;

    /**
     * 子弹的分组
     */
    private Group mGroup;

    /**
     * 矩形范围
     */
    private Rectangle mRectangle = new Rectangle();

    public Group getGroup() {
        return mGroup;
    }

    public void setGroup(Group mGroup) {
        this.mGroup = mGroup;
    }

    public Rectangle getRectangle() {
        return mRectangle;
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
    public Bullet(int bulletX, int bulletY, Dir bulletDir, Group group, GameModel gameModel) {
        this.mBulletX = bulletX;
        this.mBulletY = bulletY;
        this.mBulletDir = bulletDir;
        this.mGroup = group;
        this.mGameModel = gameModel;

        this.mRectangle.x = bulletX;
        this.mRectangle.y = bulletY;
        this.mRectangle.width = BULLET_WIDTH;
        this.mRectangle.height = BULLET_HEIGHT;

        this.mGameModel.add(this);
    }

    /**
     * 子弹绘制的方法
     *
     * @param g 画笔
     */
    @Override
    public void paint(Graphics g) {

        if (!mIsLiving) {
            mGameModel.remove(this);
        }

        switch (mBulletDir) {
            case U:
                g.drawImage(ResManager.mBulletU, mBulletX, mBulletY, null);
                break;
            case D:
                g.drawImage(ResManager.mBulletD, mBulletX, mBulletY, null);
                break;
            case L:
                g.drawImage(ResManager.mBulletL, mBulletX, mBulletY, null);
                break;
            case R:
                g.drawImage(ResManager.mBulletR, mBulletX, mBulletY, null);
                break;
            case LU:
                g.drawImage(ResManager.mBulletLU, mBulletX, mBulletY, null);
                break;
            case LD:
                g.drawImage(ResManager.mBulletLD, mBulletX, mBulletY, null);
                break;
            case RU:
                g.drawImage(ResManager.mBulletRU, mBulletX, mBulletY, null);
                break;
            case RD:
                g.drawImage(ResManager.mBulletRD, mBulletX, mBulletY, null);
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
                mBulletX -= BULLET_SPEED;
                break;
            case U:
                mBulletY -= BULLET_SPEED;
                break;
            case R:
                mBulletX += BULLET_SPEED;
                break;
            case D:
                mBulletY += BULLET_SPEED;
                break;
            case LU:
                mBulletX -= BULLET_SPEED - 2;
                mBulletY -= BULLET_SPEED - 2;
                break;
            case LD:
                mBulletX -= BULLET_SPEED - 2;
                mBulletY += BULLET_SPEED - 2;
                break;
            case RU:
                mBulletX += BULLET_SPEED - 2;
                mBulletY -= BULLET_SPEED - 2;
                break;
            case RD:
                mBulletX += BULLET_SPEED - 2;
                mBulletY += BULLET_SPEED - 2;
                break;
            default:
                break;
        }

        //  更新矩形坐标
        this.mRectangle.x = this.mBulletX;
        this.mRectangle.y = this.mBulletY;

        if (mBulletX < 0 || mBulletY < 0 || mBulletX > TankFrame.GAME_WIDTH || mBulletY > TankFrame.GAME_HEIGHT) {
            mIsLiving = false;
        }

    }

    /**
     * 检测坦克和子弹是否发生碰撞的方法
     *
     * @param tank 坦克实例
     */
    public void collideWith(Tank tank) {

        //  默认不开启队友伤害
        if (this.mGroup == tank.getGroup()) {
            return;
        }

        //  子弹死亡则无需检测
        if (!this.mIsLiving) {
            return;
        }

        //  碰撞检测
        if (this.getRectangle().intersects(tank.getRectangle())) {
            this.die();
            tank.die();
            //  显示爆炸效果
            int explodeX = tank.getTankX() + tank.getTankWidth() / 2 - Explode.EXPLODE_WIDTH / 2;
            int explodeY = tank.getTankY() + tank.getTankHeight() / 2 - Explode.EXPLODE_HEIGHT / 2;
            new Explode(explodeX, explodeY, mGameModel);
        }
    }

    /**
     * 子弹消亡
     */
    private void die() {
        this.mIsLiving = false;
    }

}
