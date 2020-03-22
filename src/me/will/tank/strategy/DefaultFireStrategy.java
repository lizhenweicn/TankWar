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
 * DESC : 默认开火方案（ 单例 ）
 */
public class DefaultFireStrategy implements FireStrategy {

    private static final DefaultFireStrategy INSTANCE = new DefaultFireStrategy();

    private DefaultFireStrategy() {}

    public static DefaultFireStrategy getInstance() {
        if (INSTANCE == null) {
            return new DefaultFireStrategy();
        }
        return INSTANCE;
    }

    @Override
    public void fire(Tank tank) {
        int tankX = tank.getTankX();
        int tankY = tank.getTankY();
        Dir tankDir = tank.getTankDir();
        Group group = tank.getGroup();
        switch (tankDir) {
            case U:
                new Bullet(tankX + (TANK_WIDTH >> 1) - (Bullet.BULLET_WIDTH >> 1), tankY - Bullet.BULLET_HEIGHT, tankDir, group);
                break;
            case D:
                new Bullet(tankX + (TANK_WIDTH >> 1) - (Bullet.BULLET_WIDTH >> 1), tankY + TANK_HEIGHT, tankDir, group);
                break;
            case L:
                new Bullet(tankX - Bullet.BULLET_WIDTH, tankY + (TANK_HEIGHT >> 1) - (Bullet.BULLET_HEIGHT >> 1), tankDir, group);
                break;
            case R:
                new Bullet(tankX + TANK_WIDTH, tankY + (TANK_HEIGHT >> 1) - (Bullet.BULLET_HEIGHT >> 1), tankDir, group);
                break;
            case LU:
                new Bullet(tankX - Bullet.BULLET_WIDTH, tankY - Bullet.BULLET_WIDTH, tankDir, group);
                break;
            case LD:
                new Bullet(tankX - TANK_WIDTH + Bullet.BULLET_WIDTH, tankY + TANK_WIDTH, tankDir, group);
                break;
            case RU:
                new Bullet(tankX + TANK_WIDTH, tankY - (Bullet.BULLET_WIDTH >> 1), tankDir, group);
                break;
            case RD:
                new Bullet(tankX + TANK_WIDTH, tankY + TANK_HEIGHT, tankDir, group);
                break;
            default:
                break;
        }

        if (group == Group.GOOD) {
            new Thread(() -> new Audio("audio/tank_fire.wav").play()).start();
        }
    }
}
