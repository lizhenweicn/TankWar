package me.will.tank.resiposibility;

import me.will.tank.props.BaseGameProps;
import me.will.tank.props.Bullet;
import me.will.tank.props.Wall;

/**
 * @author : zhenweiLi
 * @date :2020-03-22 07:40
 * DESC : 子弹和墙的碰撞检测器
 */
public class BulletWallCollider implements Collider {

    @Override
    public void collide(BaseGameProps o1, BaseGameProps o2) {
        if (o1 instanceof Bullet && o2 instanceof Wall) {
            collideWith((Bullet) o1, (Wall) o2);
        }
    }

    /**
     * 检测子弹和墙是否发生碰撞的方法
     */
    private void collideWith(Bullet bullet, Wall wall) {

        //  子弹死亡则无需检测
        if (!bullet.isLiving()) {
            return;
        }

        //  碰撞检测
        if (bullet.getRectangle().intersects(wall.getRectangle())) {
            bullet.die();
        }
    }

}
