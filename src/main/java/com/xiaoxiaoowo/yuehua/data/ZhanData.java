package com.xiaoxiaoowo.yuehua.data;


import com.xiaoxiaoowo.yuehua.system.Act;
import org.bukkit.entity.Player;

public final class ZhanData extends Data {
    //36鞋，37裤，38甲，39头

    public ZhanData(Player player) {
        super(player);


        Act.initZhan(this, slot0.id);
        Act.initZhan(this, slot1.id);
        Act.initZhan(this, slot2.id);
        Act.initZhan(this, slot36.id);
        Act.initZhan(this, slot37.id);
        Act.initZhan(this, slot38.id);
        Act.initZhan(this, slot39.id);
        Act.initZhan(this, slot40.id);

    }

    public String toString() {
        return super.toString()
               + "slot0:" + slot0.id + "\n"
               + "slot1:" + slot1.id + "\n"
               + "slot2:" + slot2.id + "\n"
               + "slot36:" + slot36.id + "\n"
               + "slot37:" + slot37.id + "\n"
               + "slot38:" + slot38.id + "\n"
               + "slot39:" + slot39.id + "\n"
               + "slot40:" + slot40.id;
    }
}
