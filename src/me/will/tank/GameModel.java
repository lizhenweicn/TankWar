package me.will.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import static me.will.tank.TankFrame.GAME_HEIGHT;
import static me.will.tank.TankFrame.GAME_WIDTH;

/**
 * @author : zhenweiLi
 * @date :2020-03-21 23:06
 * DESC : 游戏物品模型
 */
public class GameModel {

    /**
     * 主战坦克
     */
    private Tank mMainTank;

    /**
     * 游戏物体容器
     */
    private List<BaseGameObject> mGameObjectList = new ArrayList<>();

    /**
     * 游戏物体碰撞检测链
     */
    private ColliderChain mColliderChain = new ColliderChain();

    public GameModel() {
        //  初始化碰撞检测链
        mColliderChain
                .add(new TankTankCollider())
                .add(new TankWallCollider())
                .add(new BulletTankCollider())
                .add(new BulletWallCollider())
        ;
        //  主战坦克
        mMainTank = new Tank(
                (GAME_WIDTH - Tank.TANK_WIDTH) / 2,
                GAME_HEIGHT - Tank.TANK_HEIGHT - Bullet.BULLET_HEIGHT,
                Dir.U, Group.GOOD, this
        );
        //  初始化敌方坦克
        int tankListSize = PropertyManager.getAsInt("INIT_TANK_COUNT", 5);
        int offset = (TankFrame.GAME_WIDTH - tankListSize * Tank.TANK_WIDTH) / (tankListSize + 1);
        for (int i = 0; i < tankListSize; i++) {
            new Tank((Tank.TANK_WIDTH + offset) * i + offset, offset, Dir.D, Group.BAD, this);
        }
        //  初始化墙
        add(new Wall(150, 150, 200, 50));
        add(new Wall(550, 150, 200, 50));
        add(new Wall(300, 300, 50, 200));
        add(new Wall(550, 300, 50, 200));
    }

    public void add(BaseGameObject gameObject) {
        mGameObjectList.add(gameObject);
    }

    public void remove(BaseGameObject gameObject) {
        mGameObjectList.remove(gameObject);
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.setColor(c);

        for (int i = 0; i < mGameObjectList.size(); i++) {
            mGameObjectList.get(i).paint(g);
        }

        //  碰撞检测
        for (int i = 0; i < mGameObjectList.size(); i++) {
            for (int j = 0; j < mGameObjectList.size(); j++) {
                BaseGameObject o1 = mGameObjectList.get(i);
                BaseGameObject o2 = mGameObjectList.get(j);
                mColliderChain.collide(o1, o2);
            }
        }

    }

    public Tank getMainTank() {
        return mMainTank;
    }
}
