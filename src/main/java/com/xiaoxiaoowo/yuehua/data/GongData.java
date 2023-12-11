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
    //拉弓时间
    public long time_pulling;

    //弓弩ready
    public boolean readyBow;
    public boolean readyCrossBow;


    public Slot slot0;
    public Slot slot1;
    public Slot slot2;
    public Slot slot36;
    public Slot slot37;
    public Slot slot38;
    public Slot slot39;
    public Slot slot40;

    public GongData(Player player) {
        super(player);

        PersistentDataContainer pck = player.getPersistentDataContainer();
        String name = player.getName();
        arrow_score = pck.get(DataContainer.arrow, PersistentDataType.INTEGER);
        arrow = arrow_score;
        arrow_mul = 100;

        time_pulling = 0L;
        readyBow = true;
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
                PersistentDataContainer pck2 = item0.getItemMeta().getPersistentDataContainer();
                slot0 = SlotBuilder.slot0Builder(pck2.get(DataContainer.id, PersistentDataType.STRING));
            } else {
                slot0 = new Slot("null");
            }
        } else {
            slot0 = new Slot("null");
        }

        if (item1 != null && item1.getType() == Material.DIAMOND_PICKAXE) {
            PersistentDataContainer pck2 = item1.getItemMeta().getPersistentDataContainer();
            if (1 == pck2.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                if (2 == pck2.get(DataContainer.job, PersistentDataType.INTEGER)) {
                    slot1 = SlotBuilder.slot1Builder(pck2.get(DataContainer.id, PersistentDataType.STRING));
                } else {
                    slot1 = new Slot("null");
                }
            } else {
                slot1 = new Slot("null");
            }
        } else {
            slot1 = new Slot("null");
        }

        if (item2 != null && item2.getType() == Material.DIAMOND_PICKAXE) {
            PersistentDataContainer pck2 = item2.getItemMeta().getPersistentDataContainer();
            if (2 == pck2.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                if (2 == pck2.get(DataContainer.job, PersistentDataType.INTEGER)) {
                    slot2 = SlotBuilder.slot2Builder(pck2.get(DataContainer.id, PersistentDataType.STRING));
                } else {
                    slot2 = new Slot("null");
                }
            } else {
                slot2 = new Slot("null");
            }
        } else {
            slot2 = new Slot("null");
        }

        if (item36 != null) {
            PersistentDataContainer pck2 = item36.getItemMeta().getPersistentDataContainer();
            if (2 == pck2.get(DataContainer.job, PersistentDataType.INTEGER)) {
                slot36 = SlotBuilder.slot36Builder(pck2.get(DataContainer.id, PersistentDataType.STRING));
            } else {
                slot36 = new Slot("null");
            }
        } else {
            slot36 = new Slot("null");
        }

        if (item37 != null) {
            PersistentDataContainer pck2 = item37.getItemMeta().getPersistentDataContainer();
            if (2 == pck2.get(DataContainer.job, PersistentDataType.INTEGER)) {
                slot37 = SlotBuilder.slot37Builder(pck2.get(DataContainer.id, PersistentDataType.STRING));
            } else {
                slot37 = new Slot("null");
            }
        } else {
            slot37 = new Slot("null");
        }

        if (item38 != null) {
            PersistentDataContainer pck2 = item38.getItemMeta().getPersistentDataContainer();
            if (2 == pck2.get(DataContainer.job, PersistentDataType.INTEGER)) {
                slot38 = SlotBuilder.slot38Builder(pck2.get(DataContainer.id, PersistentDataType.STRING));
            } else {
                slot38 = new Slot("null");
            }
        } else {
            slot38 = new Slot("null");
        }

        if (item39 != null) {
            PersistentDataContainer pck2 = item39.getItemMeta().getPersistentDataContainer();
            if (2 == pck2.get(DataContainer.job, PersistentDataType.INTEGER)) {
                slot39 = SlotBuilder.slot39Builder(pck2.get(DataContainer.id, PersistentDataType.STRING));
            } else {
                slot39 = new Slot("null");
            }
        } else {
            slot39 = SlotBuilder.slot39Builder("null");
        }

        if (item40 != null && item40.getType() == Material.GOLDEN_PICKAXE) {
            PersistentDataContainer pck2 = item40.getItemMeta().getPersistentDataContainer();
            if (2 == pck2.get(DataContainer.job, PersistentDataType.INTEGER)) {
                slot40 = SlotBuilder.slot40Builder(pck2.get(DataContainer.id, PersistentDataType.STRING));
            } else {
                slot40 = SlotBuilder.slot40Builder("null");
            }
        } else {
            slot40 = SlotBuilder.slot40Builder("null");
        }

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
        return super.toString() + "\narrow: " + arrow + "\nid: " + slot0.id + "\nid: "
                + slot1.id + "\nid: " + slot2.id + "\nid: " + slot36.id + "\nid: "
                + slot37.id + "\nid: " + slot38.id + "\nid: " + slot39.id + "\nid: " + slot40.id;
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
