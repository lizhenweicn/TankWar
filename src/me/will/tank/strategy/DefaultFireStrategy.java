package me.will.tank.strategy;

import me.will.tank.manager.ResManager;
import me.will.tank.utils.Audio;
import me.will.tank.enums.Dir;
import me.will.tank.enums.Group;
import me.will.tank.props.Bullet;
import me.will.tank.props.Tank;

/**
 * @author : zhenweiLi
 * @date :2020-03-21 20:34
 * DESC : 默认开火方案（ 单例 ）
 */
public class DefaultFireStrategy implements FireStrategy {

    private static final DefaultFireStrategy INSTANCE = new DefaultFireStrategy();

    private DefaultFireStrategy() {
    }

    public static DefaultFireStrategy getInstance() {
        if (INSTANCE == null) {
            return new DefaultFireStrategy();
        }
        return INSTANCE;
    }

    @Override
    public void fire(Tank tank) {
        int tankX = tank.getRectangle().x;
        int tankY = tank.getRectangle().y;
        Group group = tank.getGroup();
        Dir tankDir = tank.getTankDir();
        int tankWidth = ResManager.getTankWidth();
        int tankHeight = ResManager.getTankHeight();
        int bulletWidth = ResManager.getBulletWidth();
        int bulletHeight = ResManager.getBulletHeight();
        switch (tankDir) {
            case U:
                new Bullet(tankX + (tankWidth >> 1) - (bulletWidth >> 1), tankY - bulletHeight, tankDir, group);
                break;
            case D:
                new Bullet(tankX + (tankWidth >> 1) - (bulletWidth >> 1), tankY + tankHeight, tankDir, group);
                break;
            case L:
                new Bullet(tankX - bulletWidth, tankY + (tankHeight >> 1) - (bulletHeight >> 1), tankDir, group);
                break;
            case R:
                new Bullet(tankX + tankWidth, tankY + (tankHeight >> 1) - (bulletHeight >> 1), tankDir, group);
                break;
            case LU:
                new Bullet(tankX - bulletWidth, tankY - bulletWidth, tankDir, group);
                break;
            case LD:
                new Bullet(tankX - tankWidth + bulletWidth, tankY + tankWidth, tankDir, group);
                break;
            case RU:
                new Bullet(tankX + tankWidth, tankY - (bulletWidth >> 1), tankDir, group);
                break;
            case RD:
                new Bullet(tankX + tankWidth, tankY + tankHeight, tankDir, group);
                break;
            default:
                break;
        }

        if (group == Group.GOOD) {
            new Thread(() -> new Audio("audio/tank_fire.wav").play()).start();
        }
    }
}
