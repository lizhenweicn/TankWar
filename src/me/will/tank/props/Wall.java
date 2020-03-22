package me.will.tank.props;

import me.will.tank.decorator.RectBorderDecorator;
import me.will.tank.main.GameModel;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author : zhenweiLi
 * @date :2020-03-22 09:55
 * DESC : 墙
 */
public class Wall extends BaseGameProps {

    public Wall(int wallX, int wallY, int wallW, int wallH) {
        this.mRectangle.x = wallX;
        this.mRectangle.y = wallY;
        this.mRectangle.width = wallW;
        this.mRectangle.height = wallH;
        GameModel.getInstance().add(new RectBorderDecorator(this));
    }

    @Override
    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.DARK_GRAY);
        g.fillRect(mRectangle.x, mRectangle.y, mRectangle.width, mRectangle.height);
        g.setColor(color);
    }

}
