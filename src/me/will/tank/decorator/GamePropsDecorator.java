package me.will.tank.decorator;

import java.awt.Graphics;

/**
 * @author : zhenweiLi
 * @date :2020-03-22 11:14
 * DESC : 游戏道具的装饰器
 */
public class GamePropsDecorator extends BaseGameProps {

    /**
     * 真正的游戏道具
     */
    private BaseGameProps gameObject;


    @Override
    public void paint(Graphics g) {

    }
}
