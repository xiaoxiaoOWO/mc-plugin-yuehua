package org.xiaoxiao.yuehua.data;

import de.tr7zw.nbtapi.NBT;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.xiaoxiao.yuehua.system.Scores;

public final class GongData extends Data {
    //36鞋，37裤，38甲，39头

    public int arrow;
    public int arrow_score;
    public int arrow_mul;
    //拉弓时间
    public long time_pulling;
    //射击次数
    public int count_shoot;
    public int auto_arrow;

    //弩ready
    public boolean readyCrossBow;


    public String slot0 = null;
    public String slot1 = null;
    public String slot2 = null;
    public String slot36 = null;
    public String slot37 = null;
    public String slot38 = null;
    public String slot39 = null;
    public String slot40 = null;


    public GongData(Player player) {
        super(player);


        String name = player.getName();
        arrow_score = Scores.getArrow(name);
        arrow = arrow_score;
        arrow_mul = 100;

        time_pulling = 0L;
        count_shoot = 0;
        auto_arrow = Scores.getAuto_arrow(name);
        readyCrossBow = true;


        PlayerInventory inv = player.getInventory();
        ItemStack item0 = inv.getItem(0);
        ItemStack item1 = inv.getItem(1);
        ItemStack item2 = inv.getItem(2);
        ItemStack item36 = inv.getItem(36);
        ItemStack item37 = inv.getItem(37);
        ItemStack item38 = inv.getItem(38);
        ItemStack item39 = inv.getItem(39);
        ItemStack item40 = inv.getItem(40);


        if (item0 != null) {
            Material type = item0.getType();
            if (type == Material.BOW || type == Material.CROSSBOW) {
                slot0 = NBT.get(item0, nbt -> nbt.getString("id"));
            }
        }

        if (item1 != null && item1.getType() == Material.DIAMOND_PICKAXE) {
            if (1 == NBT.get(item1, nbt -> nbt.getInteger("slot"))) {
                if (2 == NBT.get(item1, nbt -> nbt.getInteger("job"))) {
                    slot1 = NBT.get(item1, nbt -> nbt.getString("id"));
                }
            }
        }

        if (item2 != null && item2.getType() == Material.DIAMOND_PICKAXE) {
            if (2 == NBT.get(item2, nbt -> nbt.getInteger("slot"))) {
                if (2 == NBT.get(item2, nbt -> nbt.getInteger("job"))) {
                    slot2 = NBT.get(item2, nbt -> nbt.getString("id"));
                }
            }
        }

        if (item36 != null) {
            if (2 == NBT.get(item36, nbt -> nbt.getInteger("job"))) {
                slot36 = NBT.get(item36, nbt -> nbt.getString("id"));
            }
        }

        if (item37 != null) {
            if (2 == NBT.get(item37, nbt -> nbt.getInteger("job"))) {
                slot37 = NBT.get(item37, nbt -> nbt.getString("id"));
            }
        }

        if (item38 != null) {
            if (2 == NBT.get(item38, nbt -> nbt.getInteger("job"))) {
                slot38 = NBT.get(item38, nbt -> nbt.getString("id"));
            }
        }

        if (item39 != null) {
            if (2 == NBT.get(item39, nbt -> nbt.getInteger("job"))) {
                slot39 = NBT.get(item39, nbt -> nbt.getString("id"));
            }
        }

        if (item40 != null && item40.getType() == Material.DIAMOND_PICKAXE) {
            if (40 == NBT.get(item40, nbt -> nbt.getInteger("slot"))) {
                if (2 == NBT.get(item40, nbt -> nbt.getInteger("job"))) {
                    slot40 = NBT.get(item40, nbt -> nbt.getString("id"));
                }
            }
        }

    }

    public String toString() {
        return super.toString() + "\narrow: " + arrow + "\nslot0: " + slot0 + "\nslot1: " + slot1 + "\nslot2: " + slot2 + "\nslot36: " + slot36 + "\nslot37: " + slot37 + "\nslot38: " + slot38 + "\nslot39: " + slot39 + "\nslot40: " + slot40;
    }

    public void updateArrow() {
        arrow = Math.max(0, arrow_score * arrow_mul / 100);
    }

    public void updateArrowScore(int value) {
        arrow_score = value;
        updateArrow();
    }

    public void updateArrowCountScore(int value) {
    }


    public void updateArrowMul(int value) {
        arrow_mul += value;
        updateArrow();
    }

}
