package me.will.tank.strategy;

import me.will.tank.props.Tank;

/**
 * @author : zhenweiLi
 * @date :2020-03-21 20:35
 * DESC : 开火策略模式
 */
public interface FireStrategy {

    /**
     * 具体的开火方式
     */
    void fire(Tank tank);

}
