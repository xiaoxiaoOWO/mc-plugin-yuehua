package org.xiaoxiao.yuehua.data;

import de.tr7zw.nbtapi.NBT;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.xiaoxiao.yuehua.system.Scores;

public final class DanData extends Data {
    //36鞋，37裤，38甲，39头

    public int zhenfa;
    public int zhenfa_score;
    public int zhenfa_mul;

    public String slot0 = null;
    public String slot1 = null;
    public String slot2 = null;
    public String slot3 = null;
    public String slot4 = null;
    public String slot5 = null;
    public String slot36 = null;
    public String slot37 = null;
    public String slot38 = null;
    public String slot39 = null;
    public String slot40 = null;


    public DanData(Player player) {
        super(player);
        String name = player.getName();
        zhenfa_score = Scores.getZhenfa(name);
        zhenfa = zhenfa_score;
        zhenfa_mul = 100;

        PlayerInventory inv = player.getInventory();
        ItemStack item0 = inv.getItem(0);
        ItemStack item1 = inv.getItem(1);
        ItemStack item2 = inv.getItem(2);
        ItemStack item3 = inv.getItem(3);
        ItemStack item4 = inv.getItem(4);
        ItemStack item5 = inv.getItem(5);
        ItemStack item36 = inv.getItem(36);
        ItemStack item37 = inv.getItem(37);
        ItemStack item38 = inv.getItem(38);
        ItemStack item39 = inv.getItem(39);
        ItemStack item40 = inv.getItem(40);


        if (item0 != null && item1.getType() == Material.DIAMOND_PICKAXE) {
            if (0 == NBT.get(item1, nbt -> nbt.getInteger("slot"))) {
                if (3 == NBT.get(item1, nbt -> nbt.getInteger("job"))) {
                    slot0 = NBT.get(item1, nbt -> nbt.getString("id"));
                }
            }
        }


        if (item1 != null && item1.getType() == Material.DIAMOND_PICKAXE) {
            if (1 == NBT.get(item1, nbt -> nbt.getInteger("slot"))) {
                if (3 == NBT.get(item1, nbt -> nbt.getInteger("job"))) {
                    slot1 = NBT.get(item1, nbt -> nbt.getString("id"));
                }
            }
        }
        if (item2 != null && item2.getType() == Material.DIAMOND_PICKAXE) {
            if (2 == NBT.get(item2, nbt -> nbt.getInteger("slot"))) {
                if (3 == NBT.get(item2, nbt -> nbt.getInteger("job"))) {
                    slot2 = NBT.get(item2, nbt -> nbt.getString("id"));
                }
            }
        }
        if (item3 != null && item3.getType() == Material.DIAMOND_PICKAXE) {
            if (3 == NBT.get(item3, nbt -> nbt.getInteger("slot"))) {
                if (3 == NBT.get(item3, nbt -> nbt.getInteger("job"))) {
                    slot3 = NBT.get(item3, nbt -> nbt.getString("id"));
                }
            }
        }
        if (item4 != null && item4.getType() == Material.DIAMOND_PICKAXE) {
            if (4 == NBT.get(item4, nbt -> nbt.getInteger("slot"))) {
                if (3 == NBT.get(item4, nbt -> nbt.getInteger("job"))) {
                    slot4 = NBT.get(item4, nbt -> nbt.getString("id"));
                }
            }
        }
        if (item5 != null && item5.getType() == Material.DIAMOND_PICKAXE) {
            if (5 == NBT.get(item5, nbt -> nbt.getInteger("slot"))) {
                if (3 == NBT.get(item5, nbt -> nbt.getInteger("job"))) {
                    slot5 = NBT.get(item5, nbt -> nbt.getString("id"));
                }
            }
        }

        if (item36 != null) {
            if (3 == NBT.get(item36, nbt -> nbt.getInteger("job"))) {
                slot36 = NBT.get(item36, nbt -> nbt.getString("id"));
            }
        }

        if (item37 != null) {
            if (3 == NBT.get(item37, nbt -> nbt.getInteger("job"))) {
                slot37 = NBT.get(item37, nbt -> nbt.getString("id"));
            }
        }

        if (item38 != null) {
            if (3 == NBT.get(item38, nbt -> nbt.getInteger("job"))) {
                slot38 = NBT.get(item38, nbt -> nbt.getString("id"));
            }
        }

        if (item39 != null) {
            if (3 == NBT.get(item39, nbt -> nbt.getInteger("job"))) {
                slot39 = NBT.get(item39, nbt -> nbt.getString("id"));
            }
        }

        if (item40 != null && item40.getType() == Material.DIAMOND_PICKAXE) {
            if (40 == NBT.get(item40, nbt -> nbt.getInteger("slot"))) {
                if (3 == NBT.get(item40, nbt -> nbt.getInteger("job"))) {
                    slot40 = NBT.get(item40, nbt -> nbt.getString("id"));
                }
            }
        }

    }

    public String toString() {
        return super.toString() + "\nzhenfa: " + zhenfa + "\nslot1: " + slot1 + "\nslot2: " + slot2 + "\nslot3: " + slot3 + "\nslot4: " + slot4 + "\nslot5: " + slot5 + "\nslot36: " + slot36 + "\nslot37: " + slot37 + "\nslot38: " + slot38 + "\nslot39: " + slot39 + "\nslot40: " + slot40;
    }

    public void updateZhenfa() {
        zhenfa = Math.max(0, zhenfa_score * zhenfa_mul / 100);
    }

    public void updateZhenfaScore(int value) {
        zhenfa_score = value;
        updateZhenfa();
    }

    public void updateZhenfaMul(int value) {
        zhenfa_mul += value;
        updateZhenfa();
    }

}
