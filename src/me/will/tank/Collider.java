package me.will.tank;

/**
 * @author : zhenweiLi
 * @date :2020-03-22 07:38
 * DESC : 碰撞器
 */
public interface Collider {

    void collide(BaseGameObject o1, BaseGameObject o2);

}
