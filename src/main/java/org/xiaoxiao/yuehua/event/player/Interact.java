package org.xiaoxiao.yuehua.event.player;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.xiaoxiao.yuehua.Yuehua;
import org.xiaoxiao.yuehua.data.DanData;
import org.xiaoxiao.yuehua.data.Data;
import org.xiaoxiao.yuehua.data.GongData;
import org.xiaoxiao.yuehua.data.ZhanData;
import org.xiaoxiao.yuehua.system.rightClick.RightClickDan;
import org.xiaoxiao.yuehua.system.rightClick.RightClickGong;
import org.xiaoxiao.yuehua.system.rightClick.RightClickZhan;
import org.xiaoxiao.yuehua.util.GetEntity;

import java.util.HashMap;

public final class Interact implements Listener {
    private static final HashMap<String, RightClickZhan> rightClickZhan = new HashMap<>(100);
    private static final HashMap<String, RightClickGong> rightClickGong = new HashMap<>(100);
    private static final HashMap<String, RightClickDan> rightClickDan = new HashMap<>(100);


    public static void init() {

    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        //右键
        if (e.getAction().isRightClick() && e.getHand() == EquipmentSlot.HAND) {
            ItemStack item = e.getItem();
            if (item != null) {
                Material type = item.getType();
                if (type == Material.BOW) {
                    Player player = e.getPlayer();
                    Data data = Yuehua.playerData.get(player.getUniqueId());
                    if (data.job == 2) {
                        if (player.getInventory().getHeldItemSlot() == 0) {
                            GongData gongData = (GongData) data;
                            gongData.time_pulling = GetEntity.world.getTime();
                        } else {
                            e.setCancelled(true);
                            player.sendPlainMessage("§c请将弓放在第一格");
                        }
                    } else {
                        player.getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                    }
                } else if (type == Material.DIAMOND_PICKAXE) {
                    Player player = e.getPlayer();
                    int slot = player.getInventory().getHeldItemSlot();
                    Data data = Yuehua.playerData.get(player.getUniqueId());
                    int job = data.job;
                    switch (job) {
                        case 1 -> {
                            ZhanData zhanData = (ZhanData) data;
                            switch (slot) {
                                case 0 -> rightClickZhan.get(zhanData.slot0).run(player, zhanData);
                                case 1 -> rightClickZhan.get(zhanData.slot1).run(player, zhanData);
                                case 2 -> rightClickZhan.get(zhanData.slot2).run(player, zhanData);
                            }
                        }
                        case 2 -> {
                            GongData gongData = (GongData) data;
                            switch (slot) {
                                case 1 -> rightClickGong.get(gongData.slot1).run(player, gongData);
                                case 2 -> rightClickGong.get(gongData.slot2).run(player, gongData);
                            }
                        }
                        case 3 -> {
                            DanData danData = (DanData) data;
                            switch (slot) {
                                case 1 -> rightClickDan.get(danData.slot1).run(player, danData);
                                case 2 -> rightClickDan.get(danData.slot2).run(player, danData);
                                case 3 -> rightClickDan.get(danData.slot3).run(player, danData);
                                case 4 -> rightClickDan.get(danData.slot4).run(player, danData);
                                case 5 -> rightClickDan.get(danData.slot5).run(player, danData);
                            }
                        }
                    }
                } else if (type == Material.SHIELD) {
                    Player player = e.getPlayer();
                    int slot = player.getInventory().getHeldItemSlot();
                    Data data = Yuehua.playerData.get(player.getUniqueId());
                    if (data.job != 1) {
                        player.getInventory().setItem(slot, new ItemStack(Material.AIR));
                    }
                }
            }
        }
    }
}
