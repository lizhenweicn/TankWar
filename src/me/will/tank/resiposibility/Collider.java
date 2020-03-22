package me.will.tank.resiposibility;

import me.will.tank.props.BaseGameProps;

/**
 * @author : zhenweiLi
 * @date :2020-03-22 07:38
 * DESC : 碰撞器
 */
public interface Collider {

    void collide(BaseGameProps o1, BaseGameProps o2);

}
