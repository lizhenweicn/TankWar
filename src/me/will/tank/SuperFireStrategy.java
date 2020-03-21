package me.will.tank;

import static me.will.tank.Tank.TANK_HEIGHT;
import static me.will.tank.Tank.TANK_WIDTH;

/**
 * @author : zhenweiLi
 * @date :2020-03-21 20:34
 * DESC : 超级开火方案
 */
public class SuperFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank tank) {
        int tankX = tank.getTankX();
        int tankY = tank.getTankY();
        Group group = tank.getGroup();
        TankFrame tankFrame = tank.getTankFrame();
        if (group == Group.GOOD) {
            new Bullet(tankX + (TANK_WIDTH >> 1) - (Bullet.BULLET_WIDTH >> 1), tankY - Bullet.BULLET_HEIGHT, Dir.U, group, tankFrame);
            new Bullet(tankX + (TANK_WIDTH >> 1) - (Bullet.BULLET_WIDTH >> 1), tankY + TANK_HEIGHT, Dir.D, group, tankFrame);
            new Bullet(tankX - Bullet.BULLET_WIDTH, tankY + (TANK_HEIGHT >> 1) - (Bullet.BULLET_HEIGHT >> 1), Dir.L, group, tankFrame);
            new Bullet(tankX + TANK_WIDTH, tankY + (TANK_HEIGHT >> 1) - (Bullet.BULLET_HEIGHT >> 1), Dir.R, group, tankFrame);
            new Bullet(tankX - Bullet.BULLET_WIDTH, tankY - Bullet.BULLET_WIDTH, Dir.LU, group, tankFrame);
            new Bullet(tankX - TANK_WIDTH + Bullet.BULLET_WIDTH, tankY + TANK_WIDTH, Dir.LD, group, tankFrame);
            new Bullet(tankX + TANK_WIDTH, tankY - (Bullet.BULLET_WIDTH >> 1), Dir.RU, group, tankFrame);
            new Bullet(tankX + TANK_WIDTH, tankY + TANK_HEIGHT, Dir.RD, group, tankFrame);
        } else {
            DefaultFireStrategy.getInstance().fire(tank);
        }
        if (group == Group.GOOD) {
            new Thread(() -> new Audio("audio/tank_fire.wav").play()).start();
        }
    }
}
