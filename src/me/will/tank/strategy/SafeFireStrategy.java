package me.will.tank.strategy;

import me.will.tank.utils.Audio;
import me.will.tank.enums.Dir;
import me.will.tank.enums.Group;
import me.will.tank.props.Bullet;
import me.will.tank.props.Tank;

import static me.will.tank.props.Tank.TANK_HEIGHT;
import static me.will.tank.props.Tank.TANK_WIDTH;

/**
 * @author : zhenweiLi
 * @date :2020-03-21 20:34
 * DESC : 安全开火方案
 */
public class SafeFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank tank) {
        int tankX = tank.getTankX();
        int tankY = tank.getTankY();
        Group group = tank.getGroup();
        if (group == Group.GOOD) {
            new Bullet(tankX + (TANK_WIDTH >> 1) - (Bullet.BULLET_WIDTH >> 1), tankY - Bullet.BULLET_HEIGHT, Dir.U, group);
            new Bullet(tankX + (TANK_WIDTH >> 1) - (Bullet.BULLET_WIDTH >> 1), tankY + TANK_HEIGHT, Dir.D, group);
            new Bullet(tankX - Bullet.BULLET_WIDTH, tankY + (TANK_HEIGHT >> 1) - (Bullet.BULLET_HEIGHT >> 1), Dir.L, group);
            new Bullet(tankX + TANK_WIDTH, tankY + (TANK_HEIGHT >> 1) - (Bullet.BULLET_HEIGHT >> 1), Dir.R, group);
        } else {
            DefaultFireStrategy.getInstance().fire(tank);
        }
        if (group == Group.GOOD) {
            new Thread(() -> new Audio("audio/tank_fire.wav").play()).start();
        }
    }
}
