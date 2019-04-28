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
     * 坦克的 X 轴位置
     */
    private int mTankX;

    /**
     * 坦克的 Y 轴位置
     */
    private int mTankY;

    /**
     * 坦克的方向
     */
    private Dir mDir;

    /**
     * 坦克移动的步长（ 速度 ）
     */
    private static final int TANK_STEP = 2;

    /**
     * 获取坦克方向
     *
     * @return 方向枚举
     */
    public Dir getDir() {
        return mDir;
    }

    /**
     * 设置坦克方向
     *
     * @param dir 方向枚举
     */
    public void setDir(Dir dir) {
        this.mDir = dir;
    }

    /**
     * 无参构造
     */
    public Tank() {
    }

    /**
     * 构造方法
     *
     * @param mTankX 初始化 X 轴
     * @param mTankY 初始化 Y 轴
     * @param mDir   初始化的方向
     */
    public Tank(int mTankX, int mTankY, Dir mDir) {
        this.mTankX = mTankX;
        this.mTankY = mTankY;
        this.mDir = mDir;
    }

    /**
     * 坦克绘制的方法
     *
     * @param g 画笔
     */
    public void paint(Graphics g) {
        g.fillRect(mTankX, mTankY, TANK_WIDTH, TANK_HEIGHT);
        switch (mDir) {
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
