package me.will.tank.decorator;

import me.will.tank.props.BaseGameProps;

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
    private BaseGameProps mGameProps;

    public GamePropsDecorator(BaseGameProps gameProps) {
        this.mGameProps = gameProps;
    }

    @Override
    public void paint(Graphics g) {
        if (mGameProps != null) {
            mGameProps.paint(g);
        }
    }
}
