package me.will.tank;

/**
 * @author : zhenweiLi
 * @date :2020-03-22 07:40
 * DESC : 子弹和坦克的碰撞检测器
 */
public class TankTankCollider implements Collider {
    @Override
    public void collide(BaseGameObject o1, BaseGameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Tank) {
            collideWith((Tank) o1, (Tank) o2);
        }
    }

    /**
     * 检测坦克之间是否发生碰撞的方法
     */
    private void collideWith(Tank t1, Tank t2) {

        //  坦克死亡则无需检测
        if (!t1.isLiving()) {
            return;
        }

        //  碰撞检测 : 返回之前位置。
        //  注意 - 自己撞自己是没有任何意义的。
        if (t1.getRectangle().intersects(t2.getRectangle())) {
            if (t1 != t2) {
//                两个坦克相撞分别回到屏幕左右两侧的还原点( 废弃 )
//                this.mTankX = 0;
//                this.mTankY = TankFrame.GAME_HEIGHT >> 1;
//                tank.mTankX = TankFrame.GAME_WIDTH;
//                tank.mTankY = TankFrame.GAME_HEIGHT >> 1;
                t1.back();
                t2.back();
            }
        }
    }

}
