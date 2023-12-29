package com.xiaoxiaoowo.yuehua.event.player;

import com.xiaoxiaoowo.yuehua.Yuehua;
import com.xiaoxiaoowo.yuehua.data.DanData;
import com.xiaoxiaoowo.yuehua.data.Data;
import com.xiaoxiaoowo.yuehua.data.GongData;
import com.xiaoxiaoowo.yuehua.data.ZhanData;
import com.xiaoxiaoowo.yuehua.display.test.TestRay;
import com.xiaoxiaoowo.yuehua.system.DataContainer;
import com.xiaoxiaoowo.yuehua.utils.Damage;
import com.xiaoxiaoowo.yuehua.utils.GetEntity;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public final class Interact implements Listener {


    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        //右键
        if (e.getAction().isRightClick()) {
            ItemStack item = e.getItem();
            if (item != null) {
                Material type = item.getType();
                if (e.getHand() == EquipmentSlot.HAND) {
                    switch (type) {
                        case BOW -> {
                            Player player = e.getPlayer();
                            Data data = Yuehua.playerData.get(player.getUniqueId());
                            if (data.job == 2) {
                                if (player.getInventory().getHeldItemSlot() == 0) {
                                    GongData gongData = (GongData) data;
                                    gongData.time_pulling = GetEntity.world.getGameTime();
                                } else {
                                    e.setCancelled(true);
                                    Yuehua.async(() -> player.sendMessage(
                                            Component.translatable("not1b")
                                    ));
                                }
                            } else {
                                player.getInventory().setItemInMainHand(null);
                            }
                        }
                        case DIAMOND_PICKAXE -> {
                            Player player = e.getPlayer();
                            int slot = player.getInventory().getHeldItemSlot();
                            Data data = Yuehua.playerData.get(player.getUniqueId());
                            int job = data.job;
                            switch (job) {
                                case 1 -> {
                                    ZhanData zhanData = (ZhanData) data;
                                    rightClickZhan(slot, zhanData);
                                }
                                case 2 -> {
                                    GongData gongData = (GongData) data;
                                    rightClickGong(slot, gongData);
                                }
                                case 3 -> {
                                    DanData danData = (DanData) data;
                                    rightClickDan(slot, danData);
                                }
                            }
                        }
                        case IRON_PICKAXE -> {
                            Player player = e.getPlayer();
                            int slot = player.getInventory().getHeldItemSlot();
                            if (slot == 8) {
                                Data data = Yuehua.playerData.get(player.getUniqueId());
                                rightClickAll(data);
                            }
                        }

                        case KELP -> {
                            Player player = e.getPlayer();
                            Data data = Yuehua.playerData.get(player.getUniqueId());
                            if (data.job != 3) {
                                return;
                            }
                            String id = item.getPersistentDataContainer().get(DataContainer.id, PersistentDataType.STRING);
                            zhenfa(id, (DanData) data);

                        }

                        case RAW_GOLD -> {
                            Player player = e.getPlayer();
                            int cmd = item.getCustomModelData();
                            int xp = switch (cmd) {
                                case 1 -> 10;
                                case 2 -> 20;
                                case 3 -> 50;
                                case 4 -> 100;
                                case 5 -> 200;
                                case 6 -> 500;
                                default -> 0;
                            };
                            int amount = item.getAmount();
                            xp *= amount;
                            player.getInventory().setItemInMainHand(null);
                            player.giveExp(xp, false);
                        }

//                        case STONE_PICKAXE -> {
//                            switch (item.getPersistentDataContainer().get(DataContainer.id, PersistentDataType.STRING)) {
//
//                            }
//                        }

                        case SHIELD -> {
                            Player player = e.getPlayer();
                            Data data = Yuehua.playerData.get(player.getUniqueId());
                            if (data.job != 1) {
                                player.getInventory().setItemInMainHand(null);
                            } else {
                                e.setCancelled(true);
                                Yuehua.async(() -> player.sendMessage(
                                        Component.translatable("notfs")
                                ));

                            }
                        }
//
//                        case DIAMOND_SWORD -> {
//                            Player player = e.getPlayer();
//                            Damage.damage(player,10,0,GetEntity.getRayMonster(player, 10));
//                            Damage.damage(player,10,0,GetEntity.getRayMonsterWithRoatation(player, 10,Math.PI/6));
//                            Damage.damage(player,10,0,GetEntity.getRayMonsterWithRoatation(player, 10,-Math.PI/6));
//                            TestRay.run(player);
//
//
//
//                        }
                    }
                } else {
                    switch (type) {
                        case SHIELD -> {
                            Player player = e.getPlayer();
                            Data data = Yuehua.playerData.get(player.getUniqueId());
                            if (data.job != 1) {
                                player.getInventory().setItemInOffHand(null);
                            }
                        }
                        case BOW -> {
                            Player player = e.getPlayer();
                            Data data = Yuehua.playerData.get(player.getUniqueId());
                            if (data.job == 2) {
                                e.setCancelled(true);
                                Yuehua.async(() -> player.sendMessage(
                                        Component.translatable("not1b")
                                ));
                            } else {
                                player.getInventory().setItemInOffHand(null);
                            }
                        }
                        case CROSSBOW -> {
                            Player player = e.getPlayer();
                            Data data = Yuehua.playerData.get(player.getUniqueId());
                            if (data.job == 2) {
                                e.setCancelled(true);
                                Yuehua.async(() -> player.sendMessage(
                                        Component.translatable("not1c")
                                ));
                            } else {
                                player.getInventory().setItemInOffHand(null);
                            }
                        }
                    }
                }
            }
        }
    }

    private static void rightClickZhan(int num, ZhanData zhanData) {
        String id = switch (num) {
            case 1 -> zhanData.slot1.id;
            case 2 -> zhanData.slot2.id;
            default -> "null";
        };
        switch (id) {
        }

    }

    private static void rightClickDan(int num, DanData danData) {
        String id = switch (num) {
            case 1 -> danData.slot1.id;
            case 2 -> danData.slot2.id;
            case 3 -> danData.slot3.id;
            case 4 -> danData.slot4.id;
            case 5 -> danData.slot5.id;
            default -> "null";
        };
        switch (id) {
        }

    }

    private static void rightClickGong(int num, GongData gongData) {
        String id = switch (num) {
            case 1 -> gongData.slot1.id;
            case 2 -> gongData.slot2.id;
            default -> "null";
        };
        switch (id) {
        }

    }

    private static void rightClickAll(Data data) {
        switch (data.slot8.id) {

        }
    }


    private static void zhenfa(String id, DanData danData) {
        switch (id) {

        }
    }
}
