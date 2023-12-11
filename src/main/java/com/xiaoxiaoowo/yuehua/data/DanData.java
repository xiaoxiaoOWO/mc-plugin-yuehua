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

    public Slot slot0;
    public Slot slot1;
    public Slot slot2;
    public Slot slot3;
    public Slot slot4;
    public Slot slot5;
    public Slot slot36;
    public Slot slot37;
    public Slot slot38;
    public Slot slot39;
    public Slot slot40;

    public DanData(Player player) {
        super(player);
        String name = player.getName();
        PersistentDataContainer pck = player.getPersistentDataContainer();
        zhenfa_score = pck.get(DataContainer.zhenfa, PersistentDataType.INTEGER);
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


        if (item0 != null && item0.getType() == Material.DIAMOND_PICKAXE) {
            PersistentDataContainer pck2 = item0.getPersistentDataContainer();
            if (0 == pck2.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                if (3 == pck2.get(DataContainer.job, PersistentDataType.INTEGER)) {
                    slot0 = SlotBuilder.slot0Builder(pck2.get(DataContainer.id, PersistentDataType.STRING));
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
            PersistentDataContainer pck2 = item1.getPersistentDataContainer();
            if (1 == pck2.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                if (3 == pck2.get(DataContainer.job, PersistentDataType.INTEGER)) {
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
            PersistentDataContainer pck2 = item2.getPersistentDataContainer();
            if (2 == pck2.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                if (3 == pck2.get(DataContainer.job, PersistentDataType.INTEGER)) {
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
        if (item3 != null && item3.getType() == Material.DIAMOND_PICKAXE) {
            PersistentDataContainer pck2 = item3.getPersistentDataContainer();
            if (3 == pck2.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                if (3 == pck2.get(DataContainer.job, PersistentDataType.INTEGER)) {
                    slot3 = SlotBuilder.slot3Builder(pck2.get(DataContainer.id, PersistentDataType.STRING));
                } else {
                    slot3 = new Slot("null");
                }
            } else {
                slot3 = new Slot("null");
            }
        } else {
            slot3 = new Slot("null");
        }
        if (item4 != null && item4.getType() == Material.DIAMOND_PICKAXE) {
            PersistentDataContainer pck2 = item4.getPersistentDataContainer();
            if (4 == pck2.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                if (3 == pck2.get(DataContainer.job, PersistentDataType.INTEGER)) {
                    slot4 = SlotBuilder.slot4Builder(pck2.get(DataContainer.id, PersistentDataType.STRING));
                } else {
                    slot4 = new Slot("null");
                }
            } else {
                slot4 = new Slot("null");
            }
        } else {
            slot4 = new Slot("null");
        }
        if (item5 != null && item5.getType() == Material.DIAMOND_PICKAXE) {
            PersistentDataContainer pck2 = item5.getPersistentDataContainer();
            if (5 == pck2.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                if (3 == pck2.get(DataContainer.job, PersistentDataType.INTEGER)) {
                    slot5 = SlotBuilder.slot5Builder(pck2.get(DataContainer.id, PersistentDataType.STRING));
                } else {
                    slot5 = new Slot("null");
                }
            } else {
                slot5 = new Slot("null");
            }
        } else {
            slot5 = new Slot("null");
        }

        if (item36 != null) {
            PersistentDataContainer pck2 = item36.getPersistentDataContainer();
            if (3 == pck2.get(DataContainer.job, PersistentDataType.INTEGER)) {
                slot36 = SlotBuilder.slot36Builder(pck2.get(DataContainer.id, PersistentDataType.STRING));
            } else {
                slot36 = new Slot("null");
            }
        } else {
            slot36 = new Slot("null");
        }

        if (item37 != null) {
            PersistentDataContainer pck2 = item37.getPersistentDataContainer();
            if (3 == pck2.get(DataContainer.job, PersistentDataType.INTEGER)) {
                slot37 = SlotBuilder.slot37Builder(pck2.get(DataContainer.id, PersistentDataType.STRING));
            } else {
                slot37 = new Slot("null");
            }
        } else {
            slot37 = new Slot("null");
        }

        if (item38 != null) {
            PersistentDataContainer pck2 = item38.getPersistentDataContainer();
            if (3 == pck2.get(DataContainer.job, PersistentDataType.INTEGER)) {
                slot38 = SlotBuilder.slot38Builder(pck2.get(DataContainer.id, PersistentDataType.STRING));
            } else {
                slot38 = new Slot("null");
            }
        } else {
            slot38 = new Slot("null");
        }

        if (item39 != null) {
            PersistentDataContainer pck2 = item39.getPersistentDataContainer();
            if (3 == pck2.get(DataContainer.job, PersistentDataType.INTEGER)) {
                slot39 = SlotBuilder.slot39Builder(pck2.get(DataContainer.id, PersistentDataType.STRING));
            } else {
                slot39 = new Slot("null");
            }
        } else {
            slot39 = new Slot("null");
        }

        if (item40 != null && item40.getType() == Material.GOLDEN_PICKAXE) {
            PersistentDataContainer pck2 = item40.getPersistentDataContainer();
            if (3 == pck2.get(DataContainer.job, PersistentDataType.INTEGER)) {
                slot40 = SlotBuilder.slot40Builder(pck2.get(DataContainer.id, PersistentDataType.STRING));
            }

        } else {
            slot40 = new Slot("null");
        }


        Act.initDan(this, slot0.id);
        Act.initDan(this, slot1.id);
        Act.initDan(this, slot2.id);
        Act.initDan(this, slot3.id);
        Act.initDan(this, slot4.id);
        Act.initDan(this, slot5.id);
        Act.initDan(this, slot36.id);
        Act.initDan(this, slot37.id);
        Act.initDan(this, slot38.id);
        Act.initDan(this, slot39.id);
        Act.initDan(this, slot40.id);


    }

    public String toString() {
        return super.toString() + "\nzhenfa: " + zhenfa + "\nid: " + slot0.id + "\nid: " + slot1.id
                + "\nid: " + slot2.id + "\nid: " + slot3.id + "\nid: " + slot4.id + "\nid: "
                + slot5.id + "\nid: " + slot36.id + "\nid: " + slot37.id + "\nid: "
                + slot38.id + "\nid: " + slot39.id + "\nid: " + slot40.id;
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
