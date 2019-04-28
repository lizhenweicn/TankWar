import java.awt.Color;
import java.awt.Graphics;

/**
 * @author : zhenweiLi
 * @date :2019-04-28 20:52
 * DESC : 子弹类
 */
public class Bullet {

    /**
     * 子弹的宽度
     */
    private static final int BULLET_WIDTH = 30;

    /**
     * 子弹的高度
     */
    private static final int BULLET_HEIGHT = 30;

    /**
     * 子弹移动速度
     */
    private static final int BULLET_SPEED = 10;

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
    private boolean mIsLive = true;

    /**
     * 游戏窗口
     */
    private TankFrame mTankFrame;

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
    public Bullet(int bulletX, int bulletY, Dir bulletDir, TankFrame tankFrame) {
        this.mBulletX = bulletX;
        this.mBulletY = bulletY;
        this.mBulletDir = bulletDir;
        this.mTankFrame = tankFrame;
    }

    /**
     * 子弹绘制的方法
     *
     * @param g 画笔
     */
    public void paint(Graphics g) {

        if (!mIsLive) {
            mTankFrame.getBulletList().remove(this);
        }

        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(mBulletX, mBulletY, BULLET_WIDTH, BULLET_HEIGHT);
        g.setColor(c);

        move();
    }

    /**
     * 子弹移动的方法
     */
    private void move() {

        switch (mBulletDir) {
            case LEFT:
                mBulletX -= BULLET_SPEED;
                break;
            case UP:
                mBulletY -= BULLET_SPEED;
                break;
            case RIGHT:
                mBulletX += BULLET_SPEED;
                break;
            case DOWN:
                mBulletY += BULLET_SPEED;
                break;
            default:
                break;
        }

        if (mBulletX < 0 || mBulletY < 0 || mBulletX > TankFrame.GAME_WIDTH || mBulletY > TankFrame.GAME_HEIGHT) {
            mIsLive = false;
        }

    }

}
