package me.will.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

/**
 * @author : zhenweiLi
 * @date :2019-04-30 20:33
 * DESC : 资源管理者
 */
public class ResManager {

    /**
     * 主战坦克的八个方向
     */
    public static BufferedImage mGoodTankU, mGoodTankD, mGoodTankL, mGoodTankR, mGoodTankLU, mGoodTankLD, mGoodTankRU, mGoodTankRD;

    /**
     * 敌方坦克的八个方向
     */
    public static BufferedImage mBadTankU, mBadTankD, mBadTankL, mBadTankR, mBadTankLU, mBadTankLD, mBadTankRU, mBadTankRD;

    /**
     * 坦克子弹的八个方向
     */
    public static BufferedImage mBulletU, mBulletD, mBulletL, mBulletR, mBulletLU, mBulletLD, mBulletRU, mBulletRD;

    /**
     * 坦克爆炸组图
     */
    public static BufferedImage[] explodes = new BufferedImage[16];

    static {

        try {

            //  主战坦克八个方向图片
            mGoodTankU = ImageIO.read(Objects.requireNonNull(ResManager.class.getClassLoader().getResourceAsStream("images/GoodTank1.png")));
            mGoodTankD = ImageUtil.rotateImage(mGoodTankU, 180);
            mGoodTankL = ImageUtil.rotateImage(mGoodTankU, -90);
            mGoodTankR = ImageUtil.rotateImage(mGoodTankU, +90);
            mGoodTankLU = ImageUtil.rotateImage(mGoodTankU, -45);
            mGoodTankLD = ImageUtil.rotateImage(mGoodTankU, -135);
            mGoodTankRU = ImageUtil.rotateImage(mGoodTankU, +45);
            mGoodTankRD = ImageUtil.rotateImage(mGoodTankU, +135);

            //  敌方坦克八个方向图片
            mBadTankU = ImageIO.read(Objects.requireNonNull(ResManager.class.getClassLoader().getResourceAsStream("images/BadTank1.png")));
            mBadTankD = ImageUtil.rotateImage(mBadTankU, 180);
            mBadTankL = ImageUtil.rotateImage(mBadTankU, -90);
            mBadTankR = ImageUtil.rotateImage(mBadTankU, +90);
            mBadTankLU = ImageUtil.rotateImage(mBadTankU, -45);
            mBadTankLD = ImageUtil.rotateImage(mBadTankU, -135);
            mBadTankRU = ImageUtil.rotateImage(mBadTankU, +45);
            mBadTankRD = ImageUtil.rotateImage(mBadTankU, +135);

            //  坦克子弹八个方向图片
            mBulletU = ImageIO.read(Objects.requireNonNull(ResManager.class.getClassLoader().getResourceAsStream("images/bulletU.png")));
            mBulletD = ImageUtil.rotateImage(mBulletU, 180);
            mBulletL = ImageUtil.rotateImage(mBulletU, -90);
            mBulletR = ImageUtil.rotateImage(mBulletU, +90);
            mBulletLU = ImageUtil.rotateImage(mBulletU, -45);
            mBulletLD = ImageUtil.rotateImage(mBulletU, -135);
            mBulletRU = ImageUtil.rotateImage(mBulletU, +45);
            mBulletRD = ImageUtil.rotateImage(mBulletU, +135);

            //  坦克爆炸组图
            for (int i = 0; i < 16; i++) {
                explodes[i] = ImageIO.read(Objects.requireNonNull(ResManager.class.getClassLoader().getResourceAsStream("images/e" + (i + 1) + ".gif")));
            }

        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }

}
