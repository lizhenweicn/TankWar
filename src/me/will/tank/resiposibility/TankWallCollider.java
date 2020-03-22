package me.will.tank.resiposibility;

import me.will.tank.decorator.BaseGameProps;
import me.will.tank.props.Tank;
import me.will.tank.props.Wall;

/**
 * @author : zhenweiLi
 * @date :2020-03-22 07:40
 * DESC : 子弹和墙的碰撞检测器
 */
public class TankWallCollider implements Collider {

    @Override
    public void collide(BaseGameProps o1, BaseGameProps o2) {
        if (o1 instanceof Tank && o2 instanceof Wall) {
            collideWith((Tank) o1, (Wall) o2);
        }
    }

    /**
     * 检测坦克和墙是否发生碰撞的方法
     */
    private void collideWith(Tank tank, Wall wall) {

        //  坦克死亡则无需检测
        if (!tank.isLiving()) {
            return;
        }

        //  碰撞检测 : 返回之前位置。
        if (tank.getRectangle().intersects(wall.getRectangle())) {
            tank.back();
        }
    }
}
