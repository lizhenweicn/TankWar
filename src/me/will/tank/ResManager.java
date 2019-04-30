package me.will.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author : zhenweiLi
 * @date :2019-04-30 20:33
 * DESC : 资源管理者
 */
public class ResManager {

    public static BufferedImage mTankU, mTankD, mTankL, mTankR;
    public static BufferedImage mBulletU, mBulletD, mBulletL, mBulletR;

    static {
        try {
            mTankU = ImageIO.read(ResManager.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
            mTankD = ImageIO.read(ResManager.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
            mTankL = ImageIO.read(ResManager.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
            mTankR = ImageIO.read(ResManager.class.getClassLoader().getResourceAsStream("images/tankR.gif"));

            mBulletU = ImageIO.read(ResManager.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
            mBulletD = ImageIO.read(ResManager.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
            mBulletL = ImageIO.read(ResManager.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
            mBulletR = ImageIO.read(ResManager.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
