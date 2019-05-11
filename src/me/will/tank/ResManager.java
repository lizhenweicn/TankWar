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
     * 坦克的八个方向
     */
    public static BufferedImage mTankU, mTankD, mTankL, mTankR, mTankLU, mTankLD, mTankRU, mTankRD;

    /**
     * 子弹的八个方向
     */
    public static BufferedImage mBulletU, mBulletD, mBulletL, mBulletR, mBulletLU, mBulletLD, mBulletRU, mBulletRD;

    /**
     * 坦克爆炸组图
     */
    public static BufferedImage[] explodes = new BufferedImage[16];

    static {
        try {
            //  坦克八个方向图片
            mTankU = ImageIO.read(Objects.requireNonNull(ResManager.class.getClassLoader().getResourceAsStream("images/tankU.gif")));
            mTankD = ImageIO.read(Objects.requireNonNull(ResManager.class.getClassLoader().getResourceAsStream("images/tankD.gif")));
            mTankL = ImageIO.read(Objects.requireNonNull(ResManager.class.getClassLoader().getResourceAsStream("images/tankL.gif")));
            mTankR = ImageIO.read(Objects.requireNonNull(ResManager.class.getClassLoader().getResourceAsStream("images/tankR.gif")));
            mTankLU = ImageIO.read(Objects.requireNonNull(ResManager.class.getClassLoader().getResourceAsStream("images/tankLU.gif")));
            mTankLD = ImageIO.read(Objects.requireNonNull(ResManager.class.getClassLoader().getResourceAsStream("images/tankLD.gif")));
            mTankRU = ImageIO.read(Objects.requireNonNull(ResManager.class.getClassLoader().getResourceAsStream("images/tankRU.gif")));
            mTankRD = ImageIO.read(Objects.requireNonNull(ResManager.class.getClassLoader().getResourceAsStream("images/tankRD.gif")));

            //  子弹八个方向图片
            mBulletU = ImageIO.read(Objects.requireNonNull(ResManager.class.getClassLoader().getResourceAsStream("images/bulletU.gif")));
            mBulletD = ImageIO.read(Objects.requireNonNull(ResManager.class.getClassLoader().getResourceAsStream("images/bulletD.gif")));
            mBulletL = ImageIO.read(Objects.requireNonNull(ResManager.class.getClassLoader().getResourceAsStream("images/bulletL.gif")));
            mBulletR = ImageIO.read(Objects.requireNonNull(ResManager.class.getClassLoader().getResourceAsStream("images/bulletR.gif")));
            mBulletLU = ImageIO.read(Objects.requireNonNull(ResManager.class.getClassLoader().getResourceAsStream("images/bulletLU.gif")));
            mBulletLD = ImageIO.read(Objects.requireNonNull(ResManager.class.getClassLoader().getResourceAsStream("images/bulletLD.gif")));
            mBulletRU = ImageIO.read(Objects.requireNonNull(ResManager.class.getClassLoader().getResourceAsStream("images/bulletRU.gif")));
            mBulletRD = ImageIO.read(Objects.requireNonNull(ResManager.class.getClassLoader().getResourceAsStream("images/bulletRD.gif")));

            //  坦克爆炸组图
            for (int i = 0; i < 16; i++) {
                explodes[i] = ImageIO.read(Objects.requireNonNull(ResManager.class.getClassLoader().getResourceAsStream("images/e" + (i + 1) + ".gif")));
            }
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }

}
