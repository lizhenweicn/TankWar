package me.will.tank.main;

import me.will.tank.decorator.GamePropsDecorator;
import me.will.tank.decorator.RectBorderDecorator;
import me.will.tank.enums.Dir;
import me.will.tank.enums.Group;
import me.will.tank.manager.PropertyManager;
import me.will.tank.props.BaseGameProps;
import me.will.tank.manager.ResManager;
import me.will.tank.props.Tank;
import me.will.tank.props.Wall;
import me.will.tank.resiposibility.BulletTankCollider;
import me.will.tank.resiposibility.BulletWallCollider;
import me.will.tank.resiposibility.ColliderChain;
import me.will.tank.resiposibility.TankTankCollider;
import me.will.tank.resiposibility.TankWallCollider;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import static me.will.tank.main.TankFrame.GAME_HEIGHT;
import static me.will.tank.main.TankFrame.GAME_WIDTH;

/**
 * @author : zhenweiLi
 * @date :2020-03-21 23:06
 * DESC : 坦克大战主数据
 */
public class GameModel {

    private static final GameModel INSTANCE = new GameModel();

    public static GameModel getInstance() {
        return INSTANCE;
    }

    static {
        INSTANCE.init();
    }

    /**
     * 主战坦克
     */
    private Tank mMainTank;

    /**
     * 游戏物体容器
     */
    private List<BaseGameProps> mGameObjectList = new ArrayList<>();

    /**
     * 游戏物体碰撞检测链
     */
    private ColliderChain mColliderChain = new ColliderChain();

    private GameModel() {
    }

    private void init() {
        //  初始化碰撞检测链
        mColliderChain
                .add(new TankTankCollider())
                .add(new TankWallCollider())
                .add(new BulletTankCollider())
                .add(new BulletWallCollider())
        ;
        //  主战坦克
        mMainTank = new Tank(
                (GAME_WIDTH - ResManager.getTankWidth()) / 2,
                GAME_HEIGHT - ResManager.getTankHeight() - ResManager.getBulletHeight(),
                Dir.U, Group.GOOD
        );
        //  初始化敌方坦克
        int tankListSize = PropertyManager.getAsInt("INIT_TANK_COUNT", 5);
        int offset = (TankFrame.GAME_WIDTH - tankListSize * ResManager.getTankWidth()) / (tankListSize + 1);
        for (int i = 0; i < tankListSize; i++) {
            new Tank((ResManager.getTankWidth() + offset) * i + offset, offset, Dir.D, Group.BAD);
        }
        //  初始化墙
        new Wall(150, 150, 200, 50);
        new Wall(550, 150, 200, 50);
        new Wall(300, 300, 50, 200);
        new Wall(550, 300, 50, 200);
    }

    public void add(BaseGameProps gameObject) {
        mGameObjectList.add(gameObject);
    }

    public void remove(BaseGameProps gameObject) {
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
                BaseGameProps o1 = mGameObjectList.get(i);
                BaseGameProps o2 = mGameObjectList.get(j);
////            mColliderChain.collide(o1, o2);
                ////  兼容装饰器模式
                BaseGameProps gameProps1;
                if (o1 instanceof GamePropsDecorator) {
                    gameProps1 = ((GamePropsDecorator) o1).getGameProps();
                } else {
                    gameProps1 = o1;
                }
                BaseGameProps gameProps2;
                if (o2 instanceof GamePropsDecorator) {
                    gameProps2 = ((GamePropsDecorator) o2).getGameProps();
                } else {
                    gameProps2 = o2;
                }
                mColliderChain.collide(gameProps1, gameProps2);
            }
        }

    }

    public Tank getMainTank() {
        return mMainTank;
    }
}
