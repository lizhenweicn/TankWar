package me.will.tank.props;

import me.will.tank.decorator.BaseGameProps;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * @author : zhenweiLi
 * @date :2020-03-22 09:55
 * DESC : 墙
 */
public class Wall extends BaseGameProps {

    /**
     * 墙的 X 轴位置
     */
    private int mWallX;

    /**
     * 墙的 Y 轴位置
     */
    private int mWallY;

    /**
     * 墙的宽度
     */
    private int mWallW;

    /**
     * 墙的高度
     */
    private int mWallH;

    /**
     * 矩形区域
     */
    private Rectangle mRectangle;

    public Rectangle getRectangle() {
        return mRectangle;
    }

    public Wall(int mWallX, int mWallY, int mWallW, int mWallH) {
        this.mWallX = mWallX;
        this.mWallY = mWallY;
        this.mWallW = mWallW;
        this.mWallH = mWallH;
        this.mRectangle = new Rectangle(mWallX, mWallY, mWallW, mWallH);
    }

    @Override
    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.DARK_GRAY);
        g.fillRect(mWallX, mWallY, mWallW, mWallH);
        g.setColor(color);
    }

}
