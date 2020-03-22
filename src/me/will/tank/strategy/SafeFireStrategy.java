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
 * DESC : 安全开火方案
 */
public class SafeFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank tank) {
        int tankX = tank.getRectangle().x;
        int tankY = tank.getRectangle().y;
        Group group = tank.getGroup();
        int tankWidth = ResManager.getTankWidth();
        int tankHeight = ResManager.getTankHeight();
        int bulletWidth = ResManager.getBulletWidth();
        int bulletHeight = ResManager.getBulletHeight();
        if (group == Group.GOOD) {
            new Bullet(tankX + (tankWidth >> 1) - (bulletWidth >> 1), tankY - bulletHeight, Dir.U, group);
            new Bullet(tankX + (tankWidth >> 1) - (bulletWidth >> 1), tankY + tankHeight, Dir.D, group);
            new Bullet(tankX - bulletWidth, tankY + (tankHeight >> 1) - (bulletHeight >> 1), Dir.L, group);
            new Bullet(tankX + tankWidth, tankY + (tankHeight >> 1) - (bulletHeight >> 1), Dir.R, group);
        } else {
            DefaultFireStrategy.getInstance().fire(tank);
        }
        if (group == Group.GOOD) {
            new Thread(() -> new Audio("audio/tank_fire.wav").play()).start();
        }
    }
}
