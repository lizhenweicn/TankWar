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
    private static final int TANK_WIDTH = 50;

    /**
     * 子弹的高度
     */
    private static final int TANK_HEIGHT = 50;

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
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(mBulletX, mBulletY, TANK_WIDTH, TANK_HEIGHT);
        g.setColor(c);

        mBulletY += BULLET_SPEED;
    }

}
