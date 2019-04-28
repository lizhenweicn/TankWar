import java.awt.*;

/**
 * @author : zhenweiLi
 * @date :2019-04-28 20:52
 * DESC : 子弹类
 */
public class Bullet {

    /**
     * 子弹的宽度
     */
    private static final int TANK_WIDTH = 5;

    /**
     * 子弹的高度
     */
    private static final int TANK_HEIGHT = 5;

    /**
     * 子弹移动速度
     */
    private static final int BULLET_SPEED = 1;

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

    public Bullet() {
    }

    public Bullet(int bulletX, int bulletY, Dir bulletDir) {
        this.mBulletX = bulletX;
        this.mBulletY = bulletY;
        this.mBulletDir = bulletDir;
    }

    /**
     * 子弹绘制的方法
     *
     * @param g 画笔
     */
    public void paint(Graphics g) {
        g.fillOval(mBulletX, mBulletY, TANK_WIDTH, TANK_HEIGHT);
        mBulletY += BULLET_SPEED;
    }

}
