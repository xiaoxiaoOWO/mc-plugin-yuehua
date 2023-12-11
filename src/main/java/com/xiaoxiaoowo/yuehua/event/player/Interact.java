package com.xiaoxiaoowo.yuehua.event.player;

import com.xiaoxiaoowo.yuehua.Yuehua;
import com.xiaoxiaoowo.yuehua.data.DanData;
import com.xiaoxiaoowo.yuehua.data.Data;
import com.xiaoxiaoowo.yuehua.data.GongData;
import com.xiaoxiaoowo.yuehua.data.ZhanData;
import com.xiaoxiaoowo.yuehua.itemstack.Air;
import com.xiaoxiaoowo.yuehua.utils.GetEntity;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

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
                                    player.sendPlainMessage("§c请将弓放在第一格");
                                }
                            } else {
                                player.getInventory().setItemInMainHand(Air.air);
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
                                    rightClickZhan(slot, zhanData, player);
                                }
                                case 2 -> {
                                    GongData gongData = (GongData) data;
                                    rightClickGong(slot, gongData, player);
                                }
                                case 3 -> {
                                    DanData danData = (DanData) data;
                                    rightClickDan(slot, danData, player);
                                }
                            }
                        }
                        case IRON_PICKAXE -> {
                            Player player = e.getPlayer();
                            int slot = player.getInventory().getHeldItemSlot();
                            if (slot == 8) {
                                Data data = Yuehua.playerData.get(player.getUniqueId());
                                rightClickAll(data, player);
                            }
                        }
                        case SHIELD -> {
                            Player player = e.getPlayer();
                            Data data = Yuehua.playerData.get(player.getUniqueId());
                            if (data.job != 1) {
                                player.getInventory().setItemInMainHand(Air.air);
                            } else {
                                e.setCancelled(true);
                                player.sendPlainMessage("§c请将盾牌放在副手");
                            }
                        }
                    }
                } else {
                    switch (type) {
                        case SHIELD -> {
                            Player player = e.getPlayer();
                            Data data = Yuehua.playerData.get(player.getUniqueId());
                            if (data.job != 1) {
                                player.getInventory().setItemInOffHand(Air.air);
                            }
                        }
                        case BOW -> {
                            Player player = e.getPlayer();
                            Data data = Yuehua.playerData.get(player.getUniqueId());
                            if (data.job == 2) {
                                e.setCancelled(true);
                                player.sendPlainMessage("§c请将弓放在第一格");
                            } else {
                                player.getInventory().setItemInOffHand(Air.air);
                            }
                        }
                    }
                }
            }
        }
    }

    private static void rightClickZhan(int num, ZhanData zhanData, Player player) {
        String id = switch (num){
            case 1 -> zhanData.slot1.id;
            case 2 -> zhanData.slot2.id;
            default -> "null";
        };
        switch (id) {
        }

    }

    private static void rightClickDan(int num, DanData danData, Player player) {
        String id = switch (num){
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

    private static void rightClickGong(int num, GongData gongData, Player player) {
        String id = switch (num){
            case 1 -> gongData.slot1.id;
            case 2 -> gongData.slot2.id;
            default -> "null";
        };
        switch (id) {
        }

    }

    private static void rightClickAll(Data data, Player player) {
        switch (data.slot8.id){

        }
    }
}
