package org.xiaoxiao.yuehua.event.player;

import de.tr7zw.nbtapi.NBT;
import io.papermc.paper.event.player.PlayerInventorySlotChangeEvent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.xiaoxiao.yuehua.Yuehua;
import org.xiaoxiao.yuehua.data.Data;
import org.xiaoxiao.yuehua.system.act.Act;

import java.util.Arrays;
import java.util.HashSet;

public final class InventorySlotChange implements Listener {
    private static final HashSet<Integer> slots = new HashSet<>(Arrays.asList(0, 1, 4, 5, 6, 7, 8, 9, 36, 37, 38, 39, 40));
    private static final HashSet<Integer> slots_zhan = new HashSet<>(Arrays.asList(5, 6, 7, 8));
    private static final HashSet<Integer> slots_gong = new HashSet<>(Arrays.asList(5, 6, 7, 40));


    @EventHandler
    public void onInventorySlotChange(PlayerInventorySlotChangeEvent e) {
        int slot = e.getSlot();
        if (slots.contains(slot)) {
            Player player = e.getPlayer();
            Data data = Yuehua.playerData.get(player.getUniqueId());
            int job = data.job;
            switch (job) {
                case 1 -> {
                    if (!slots_zhan.contains(slot)) {
                        ItemStack old = e.getOldItemStack();
                        ItemStack now = e.getNewItemStack();
                        //对旧进行是否需要去激活判断
                        if (old.getType() != Material.AIR) {
                            if (NBT.get(old, nbt -> nbt.getInteger("slot")) == slot) {
                                if (NBT.get(old, nbt -> nbt.getInteger("job")) == 1) {
                                    //去激活
                                    if (data.ready) {
                                        Act.DeActZhan(player, old);
                                    }
                                }
                            }
                        }
                        //对新是否需要激活判断
                        if (now.getType() != Material.AIR) {
                            if (NBT.get(now, nbt -> nbt.getInteger("slot")) == slot) {
                                if (NBT.get(now, nbt -> nbt.getInteger("job")) == 1) {
                                    //激活
                                    if (data.ready) {
                                        Act.ActZhan(player, now);
                                    }
                                }
                            }
                        }
                    }
                }
                case 2 -> {
                    if (!slots_gong.contains(slot)) {
                        ItemStack old = e.getOldItemStack();
                        ItemStack now = e.getNewItemStack();
                        //对旧进行是否需要去激活判断
                        if (old.getType() != Material.AIR) {
                            if (NBT.get(old, nbt -> nbt.getInteger("slot")) == slot) {
                                if (NBT.get(old, nbt -> nbt.getInteger("job")) == 2) {
                                    //去激活
                                    if (data.ready) {
                                        Act.DeActGong(player, old);
                                    }
                                }
                            }
                        }
                        //对新是否需要激活判断
                        if (now.getType() != Material.AIR) {
                            if (NBT.get(now, nbt -> nbt.getInteger("slot")) == slot) {
                                if (NBT.get(now, nbt -> nbt.getInteger("job")) == 2) {
                                    //激活
                                    if (data.ready) {
                                        Act.ActGong(player, now);
                                    }
                                }
                            }
                        }
                    }
                }
                case 3 -> {
                    if (slot != 1) {
                        ItemStack old = e.getOldItemStack();
                        ItemStack now = e.getNewItemStack();
                        //对旧进行是否需要去激活判断
                        if (old.getType() != Material.AIR) {
                            if (NBT.get(old, nbt -> nbt.getInteger("slot")) == slot) {
                                if (NBT.get(old, nbt -> nbt.getInteger("job")) == 3) {
                                    //去激活
                                    if (data.ready) {
                                        Act.DeActDan(player, old);
                                    }
                                }
                            }
                        }
                        //对新是否需要激活判断
                        if (now.getType() != Material.AIR) {
                            if (NBT.get(now, nbt -> nbt.getInteger("slot")) == slot) {
                                if (NBT.get(now, nbt -> nbt.getInteger("job")) == 3) {
                                    //激活
                                    if (data.ready) {
                                        Act.ActDan(player, now);
                                    }
                                }
                            }
                        }
                    }
                }
            }

        }
    }
}

