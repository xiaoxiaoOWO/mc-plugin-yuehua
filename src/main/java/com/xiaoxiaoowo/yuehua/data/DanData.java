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


public final class DanData extends Data {
    //36鞋，37裤，38甲，39头

    public int zhenfa;
    public int zhenfa_score;
    public int zhenfa_mul;
    public int zhenfaLevel;

    public Slot slot3;
    public Slot slot4;
    public Slot slot5;


    public DanData(Player player) {
        super(player);
        PersistentDataContainer pck = player.getPersistentDataContainer();
        zhenfa_score = pck.get(DataContainer.zhenfa, PersistentDataType.INTEGER);
        zhenfaLevel = pck.get(DataContainer.zhenfa_level, PersistentDataType.INTEGER);
        String slot3ID = pck.get(DataContainer.slot3, PersistentDataType.STRING);
        String slot4ID = pck.get(DataContainer.slot4, PersistentDataType.STRING);
        String slot5ID = pck.get(DataContainer.slot5, PersistentDataType.STRING);

        zhenfa = zhenfa_score;
        zhenfa_mul = 100;

        slot3 = SlotBuilder.slot3Builder(slot3ID);
        slot4 = SlotBuilder.slot4Builder(slot4ID);
        slot5 = SlotBuilder.slot5Builder(slot5ID);

        Act.initDan(this,slot0.id);
        Act.initDan(this,slot1.id);
        Act.initDan(this,slot2.id);
        Act.initDan(this,slot3.id);
        Act.initDan(this,slot4.id);
        Act.initDan(this,slot5.id);
        Act.initDan(this,slot36.id);
        Act.initDan(this,slot37.id);
        Act.initDan(this,slot38.id);
        Act.initDan(this,slot39.id);
        Act.initDan(this,slot40.id);

        updateZhenfa();



    }

    public String toString() {
        return super.toString()
                + "zhenfa: " + zhenfa + "\n"
                + "zhenfaLevel: " + zhenfaLevel + "\n"
                + "slot0:" + slot0.id + "\n"
                + "slot1:" + slot1.id + "\n"
                + "slot2:" + slot2.id + "\n"
                + "slot3:" + slot3.id + "\n"
                + "slot4:" + slot4.id + "\n"
                + "slot5:" + slot5.id + "\n"
                + "slot36:" + slot36.id + "\n"
                + "slot37:" + slot37.id + "\n"
                + "slot38:" + slot38.id + "\n"
                + "slot39:" + slot39.id + "\n"
                + "slot40:" + slot40.id ;
    }

    public void updateZhenfa() {
        zhenfa = Math.max(0, zhenfa_score * zhenfa_mul / 100);
    }

    public void setZhenfaScore(int value) {
        zhenfa_score = value;
        updateZhenfa();
    }

    public void updateZhenfaMul(int value) {
        zhenfa_mul += value;
        updateZhenfa();
    }

}
