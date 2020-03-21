package me.will.tank;

import java.awt.Graphics;

/**
 * @author : zhenweiLi
 * @date :2020-03-22 07:13
 * DESC : 游戏道具的父类
 */
public abstract class BaseGameObject {

    /**
     * 游戏道具绘制自己的方法
     *
     * @param g 画笔
     */
    public abstract void paint(Graphics g);

}
