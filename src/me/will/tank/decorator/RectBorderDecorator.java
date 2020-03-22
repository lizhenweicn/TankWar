package me.will.tank.decorator;

import me.will.tank.props.BaseGameProps;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * @author : zhenweiLi
 * @date :2020-03-22 12:31
 * DESC : 矩形边框装饰器
 */
public class RectBorderDecorator extends GamePropsDecorator {

    private Rectangle mRect;

    public RectBorderDecorator(BaseGameProps gameProps) {
        super(gameProps);
        this.mRect = gameProps.getRectangle();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Color color = g.getColor();
        g.setColor(Color.YELLOW);
        g.drawRect(mRect.x, mRect.y, mRect.width, mRect.height);
        g.setColor(color);
    }
}
