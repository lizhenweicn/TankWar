package me.will.tank.props;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * @author : zhenweiLi
 * @date :2020-03-22 07:13
 * DESC : 游戏道具的父类
 */
public abstract class BaseGameProps {

    /**
     * 矩形范围
     * <p>
     * 每个子类都应有具有矩形区域
     */
    protected Rectangle mRectangle = new Rectangle();

    public Rectangle getRectangle() {
        return mRectangle;
    }

    /**
     * 游戏道具绘制自己的方法
     *
     * @param g 画笔
     */
    public abstract void paint(Graphics g);


}
