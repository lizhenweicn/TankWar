import java.awt.*;

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
     * 坦克移动速度
     */
    private static final int TANK_STEP = 5;

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
    public Tank(int tankX, int tankY, Dir dir) {
        this.mTankX = tankX;
        this.mTankY = tankY;
        this.mTankDir = dir;
    }

    /**
     * 坦克绘制的方法
     *
     * @param g 画笔
     */
    public void paint(Graphics g) {
        g.fillRect(mTankX, mTankY, TANK_WIDTH, TANK_HEIGHT);
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
            case UP:
                mTankY -= TANK_STEP;
                break;
            case DOWN:
                mTankY += TANK_STEP;
                break;
            case LEFT:
                mTankX -= TANK_STEP;
                break;
            case RIGHT:
                mTankX += TANK_STEP;
                break;
            default:
                break;
        }
    }
}
