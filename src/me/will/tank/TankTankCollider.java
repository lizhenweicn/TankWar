package me.will.tank;

/**
 * @author : zhenweiLi
 * @date :2020-03-22 07:40
 * DESC : 子弹和坦克的碰撞检测器
 */
public class TankTankCollider implements Collider {
    @Override
    public void collide(BaseGameObject o1, BaseGameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Tank) {
            ((Tank) o1).collideWith((Tank) o2);
        }
//        if (o2 instanceof Bullet && o1 instanceof Tank){
//            collide(o2, o1);
//        }
    }
}
