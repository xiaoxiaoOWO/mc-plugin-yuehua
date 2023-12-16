package com.xiaoxiaoowo.yuehua.data;


import com.xiaoxiaoowo.yuehua.data.slot.Slot;
import com.xiaoxiaoowo.yuehua.data.slot.SlotBuilder;
import com.xiaoxiaoowo.yuehua.system.Act;
import com.xiaoxiaoowo.yuehua.system.DataContainer;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public final class GongData extends Data {
    //36鞋，37裤，38甲，39头

    public int arrow;
    public int arrow_score;
    public int arrow_mul;

    public int arrow_count_max;
    //不严格持久化数据
    public int arrow_count;
    //拉弓时间
    public long time_pulling;

    //弓弩ready
    public boolean readyBow;
    public boolean readyCrossBow;


    public GongData(Player player) {
        super(player);

        PersistentDataContainer pck = player.getPersistentDataContainer();
        arrow_score = pck.get(DataContainer.arrow, PersistentDataType.INTEGER);
        arrow_count_max = pck.get(DataContainer.arrow_count_max, PersistentDataType.INTEGER);
        arrow_count = pck.get(DataContainer.arrow_count, PersistentDataType.INTEGER);
        arrow = arrow_score;
        arrow_mul = 100;

        time_pulling = 0L;
        readyBow = true;
        readyCrossBow = true;

        Act.initGong(this, slot0.id);
        Act.initGong(this, slot1.id);
        Act.initGong(this, slot2.id);
        Act.initGong(this, slot36.id);
        Act.initGong(this, slot37.id);
        Act.initGong(this, slot38.id);
        Act.initGong(this, slot39.id);
        Act.initGong(this, slot40.id);



    }

    public String toString() {
        return super.toString()
               + "arrow: " + arrow + "\n"
               + "arrow_count_max: " + arrow_count_max + "\n"
               + "arrow_count: " + arrow_count + "\n"
               + "slot0: " + slot0.id + "\n"
               + "slot1: " + slot1.id + "\n"
               + "slot2: " + slot2.id + "\n"
               + "slot36: " + slot36.id + "\n"
               + "slot37: " + slot37.id + "\n"
               + "slot38: " + slot38.id + "\n"
               + "slot39: " + slot39.id + "\n"
               + "slot40: " + slot40.id ;
    }

    public void updateArrow() {
        arrow = Math.max(0, arrow_score * arrow_mul / 100);
    }

    public void setArrowScore(int value) {
        arrow_score = value;
        updateArrow();
    }

    public void updateArrowMul(int value) {
        arrow_mul += value;
        updateArrow();
    }

}
