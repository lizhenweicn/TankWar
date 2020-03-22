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

    private List<BaseGameObject> mGameObjectList = new ArrayList<>();

    /**
     * 主战坦克
     */
    private Tank mMainTank;

//    /**
//     * 敌方容器
//     */
//    private List<Tank> mTankList = new ArrayList<>();
//
//    /**
//     * 子弹容器
//     */
//    private List<Bullet> mBulletList = new ArrayList<>();
//
//    /**
//     * 爆炸容器
//     */
//    private List<Explode> mExplodeList = new ArrayList<>();

//    public List<Tank> getTankList() {
//        return mTankList;
//    }
//
//    public void setTankList(List<Tank> mTankList) {
//        this.mTankList = mTankList;
//    }
//
//    public List<Bullet> getBulletList() {
//        return mBulletList;
//    }
//
//    public void setBulletList(List<Bullet> mBulletList) {
//        this.mBulletList = mBulletList;
//    }
//
//    public List<Explode> getExplodeList() {
//        return mExplodeList;
//    }
//
//    public void setExplodeList(List<Explode> mExplodeList) {
//        this.mExplodeList = mExplodeList;
//    }

    private Collider mCollider = new BulletTankCollider();
    private Collider mCollider2 = new TankTankCollider();

    public GameModel() {
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
//        g.drawString("子弹的数量:" + mBulletList.size(), 10, 60);
//        g.drawString("敌人的数量:" + mTankList.size(), 10, 80);
//        g.drawString("爆炸的数量:" + mExplodeList.size(), 10, 100);
        g.setColor(c);

        //  绘制主战坦克
//        mMainTank.paint(g);

//        //  绘制子弹
//        for (int i = 0; i < mBulletList.size(); i++) {
//            mBulletList.get(i).paint(g);
//        }
//
//        //  绘制敌方坦克
//        for (int i = 0; i < mTankList.size(); i++) {
//            mTankList.get(i).paint(g);
//        }
//
//        //  绘制爆炸效果
//        for (int i = 0; i < mExplodeList.size(); i++) {
//            mExplodeList.get(i).paint(g);
//        }

//        for (BaseGameObject baseGameObject : mGameObjectList) {
//            baseGameObject.paint(g);
//        }

        for (int i = 0; i < mGameObjectList.size(); i++) {
            mGameObjectList.get(i).paint(g);
        }

        //  碰撞检测
        for (int i = 0; i < mGameObjectList.size(); i++) {
            for (int j = 0; j < mGameObjectList.size(); j++) {
                BaseGameObject o1 = mGameObjectList.get(i);
                BaseGameObject o2 = mGameObjectList.get(j);
                mCollider.collide(o1, o2);
                mCollider2.collide(o1, o2);
            }
        }

    }

    public Tank getMainTank() {
        return mMainTank;
    }
}
