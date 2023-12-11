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

public final class ZhanData extends Data {
    //36鞋，37裤，38甲，39头

    public Slot slot0;
    public Slot slot1;
    public Slot slot2;
    public Slot slot36;
    public Slot slot37;
    public Slot slot38;
    public Slot slot39;
    public Slot slot40;


    public ZhanData(Player player) {
        super(player);
        PlayerInventory inv = player.getInventory();

        ItemStack item0 = inv.getItem(0);
        ItemStack item1 = inv.getItem(1);
        ItemStack item2 = inv.getItem(2);
        ItemStack item36 = inv.getItem(36);
        ItemStack item37 = inv.getItem(37);
        ItemStack item38 = inv.getItem(38);
        ItemStack item39 = inv.getItem(39);
        ItemStack item40 = inv.getItem(40);

        if (item0 != null && item0.getType() == Material.DIAMOND_PICKAXE) {
            PersistentDataContainer pck = item0.getPersistentDataContainer();
            if (0 == pck.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                if (1 == pck.get(DataContainer.job, PersistentDataType.INTEGER)) {
                    slot0 = SlotBuilder.slot0Builder(pck.get(DataContainer.id, PersistentDataType.STRING));
                } else {
                    slot0 = new Slot("null");
                }
            } else {
                slot0 = new Slot("null");
            }
        } else {
            slot0 = new Slot("null");
        }

        if (item1 != null && item1.getType() == Material.DIAMOND_PICKAXE) {
            PersistentDataContainer pck = item1.getPersistentDataContainer();
            if (1 == pck.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                if (1 == pck.get(DataContainer.job, PersistentDataType.INTEGER)) {
                    slot1 = SlotBuilder.slot1Builder(pck.get(DataContainer.id, PersistentDataType.STRING));
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
            PersistentDataContainer pck = item2.getPersistentDataContainer();
            if (2 == pck.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                if (1 == pck.get(DataContainer.job, PersistentDataType.INTEGER)) {
                    slot2 = SlotBuilder.slot2Builder(pck.get(DataContainer.id, PersistentDataType.STRING));
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
            PersistentDataContainer pck = item36.getPersistentDataContainer();
            if (1 == pck.get(DataContainer.job, PersistentDataType.INTEGER)) {
                slot36 = SlotBuilder.slot36Builder(pck.get(DataContainer.id, PersistentDataType.STRING));
            } else {
                slot36 = new Slot("null");
            }
        } else {
            slot36 = new Slot("null");
        }

        if (item37 != null) {
            PersistentDataContainer pck = item37.getPersistentDataContainer();
            if (1 == pck.get(DataContainer.job, PersistentDataType.INTEGER)) {
                slot37 = SlotBuilder.slot37Builder(pck.get(DataContainer.id, PersistentDataType.STRING));
            } else {
                slot37 = new Slot("null");
            }
        } else {
            slot37 = new Slot("null");
        }

        if (item38 != null) {
            PersistentDataContainer pck = item38.getPersistentDataContainer();
            if (1 == pck.get(DataContainer.job, PersistentDataType.INTEGER)) {
                slot38 = SlotBuilder.slot38Builder(pck.get(DataContainer.id, PersistentDataType.STRING));
            } else {
                slot38 = new Slot("null");
            }
        } else {
            slot38 = new Slot("null");
        }

        if (item39 != null) {
            PersistentDataContainer pck = item39.getPersistentDataContainer();
            if (1 == pck.get(DataContainer.job, PersistentDataType.INTEGER)) {
                slot39 = SlotBuilder.slot39Builder(pck.get(DataContainer.id, PersistentDataType.STRING));
            } else {
                slot39 = new Slot("null");
            }
        } else {
            slot39 = new Slot("null");
        }

        if (item40 != null && item40.getType() == Material.SHIELD) {
            PersistentDataContainer pck = item40.getPersistentDataContainer();
            slot40 = SlotBuilder.slot40Builder(pck.get(DataContainer.id, PersistentDataType.STRING));
        } else {
            slot40 = new Slot("null");
        }

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
        return super.toString() + "\nid: " + slot0.id + "\nid: " + slot1.id + "\nid: "
                + slot2.id + "\nid: " + slot36.id + "\nid: " + slot37.id + "\nid: "
                + slot38.id + "\nid: " + slot39.id + "\nid: " + slot40.id;
    }
}
