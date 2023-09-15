package org.xiaoxiao.yuehua.event.player;

import de.tr7zw.nbtapi.NBT;
import io.papermc.paper.event.player.PlayerInventorySlotChangeEvent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.xiaoxiao.yuehua.Yuehua;
import org.xiaoxiao.yuehua.data.DanData;
import org.xiaoxiao.yuehua.data.Data;
import org.xiaoxiao.yuehua.data.GongData;
import org.xiaoxiao.yuehua.data.ZhanData;
import org.xiaoxiao.yuehua.system.act.Act;

public final class InventorySlotChange implements Listener {


    @EventHandler
    public void onInventorySlotChange(PlayerInventorySlotChangeEvent e) {
        int slot = e.getSlot();
        if (slot < 6) {
            Player player = e.getPlayer();
            Data data = Yuehua.playerData.get(player.getUniqueId());
            int job = data.job;
            switch (job) {
                case 1 -> {
                    if (slot < 3) {
                        if (data.ready) {
                            ItemStack old = e.getOldItemStack();
                            ItemStack now = e.getNewItemStack();
                            if (old.getType() == Material.DIAMOND_PICKAXE) {
                                //当槽位和职业都满足时去除激活
                                if (slot == NBT.get(old, nbt -> nbt.getInteger("slot"))) {
                                    if (job == NBT.get(old, nbt -> nbt.getInteger("job"))) {
                                        Act.DeActZhan(player, (ZhanData) data, old);
                                    }
                                }

                            }
                            if (now.getType() == Material.DIAMOND_PICKAXE) {
                                //当槽位和职业都满足时激活
                                if (slot == NBT.get(now, nbt -> nbt.getInteger("slot"))) {
                                    if (job == NBT.get(now, nbt -> nbt.getInteger("job"))) {
                                        Act.ActZhan(player, (ZhanData) data, now);
                                    } else {
                                        player.getInventory().setItem(slot, new ItemStack(Material.AIR));
                                    }
                                }
                            }
                        }
                    }
                }
                case 2 -> {
                    if (slot != 0) {
                        if (data.ready) {
                            ItemStack old = e.getOldItemStack();
                            Material oldType = old.getType();
                            ItemStack now = e.getNewItemStack();
                            Material nowType = now.getType();
                            //若激活，可能是弓，弩，或者钻石镐
                            if (oldType == Material.DIAMOND_PICKAXE) {
                                //当槽位和职业都满足时去除激活
                                if (slot == NBT.get(old, nbt -> nbt.getInteger("slot"))) {
                                    if (job == NBT.get(old, nbt -> nbt.getInteger("job"))) {
                                        Act.DeActGong(player, (GongData) data, old);
                                    }
                                }
                            }
                            //若要激活，只能是铁镐
                            if (nowType == Material.DIAMOND_PICKAXE) {
                                //当槽位和职业都满足时激活
                                if (slot == NBT.get(now, nbt -> nbt.getInteger("slot"))) {
                                    if (job == NBT.get(now, nbt -> nbt.getInteger("job"))) {
                                        Act.ActGong(player, (GongData) data, now);
                                    } else {
                                        player.getInventory().setItem(slot, new ItemStack(Material.AIR));
                                    }
                                }
                            }
                        }
                    } else {
                        GongData gongData = (GongData) data;
                        if (gongData.ready && gongData.readyCrossBow) {
                            ItemStack old = e.getOldItemStack();
                            Material oldType = old.getType();
                            ItemStack now = e.getNewItemStack();
                            Material nowType = now.getType();
                            //若激活，可能是弓，弩，或者钻石镐
                            if (oldType == Material.BOW || oldType == Material.CROSSBOW) {
                                //当槽位和职业都满足时去除激活
                                Act.DeActGong(player, gongData, old);
                            }

                            //若要激活，只能是铁镐
                            if (nowType == Material.BOW || nowType == Material.CROSSBOW) {
                                //当槽位和职业都满足时激活
                                Act.ActGong(player, gongData, now);
                            }
                        }
                    }

                }
                case 3 -> {
                    if (data.ready) {
                        ItemStack old = e.getOldItemStack();
                        ItemStack now = e.getNewItemStack();
                        //若激活，一定是钻石镐
                        if (old.getType() == Material.DIAMOND_PICKAXE) {
                            //当槽位和职业都满足时去除激活
                            if (slot == NBT.get(old, nbt -> nbt.getInteger("slot"))) {
                                if (job == NBT.get(old, nbt -> nbt.getInteger("job"))) {
                                    Act.DeActDan(player, (DanData) data, old);
                                }
                            }

                        }
                        //若要激活，一定是铁镐
                        if (now.getType() == Material.DIAMOND_PICKAXE) {
                            //当槽位和职业都满足时激活
                            if (slot == NBT.get(now, nbt -> nbt.getInteger("slot"))) {
                                if (job == NBT.get(now, nbt -> nbt.getInteger("job"))) {
                                    Act.ActDan(player, (DanData) data, now);
                                } else {
                                    player.getInventory().setItem(slot, new ItemStack(Material.AIR));
                                }
                            }
                        }
                    }

                }
            }
        } else if (slot > 35) {
            Player player = e.getPlayer();
            Data data = Yuehua.playerData.get(player.getUniqueId());
            if (data.ready) {
                int job = data.job;
                ItemStack old = e.getOldItemStack();
                ItemStack now = e.getNewItemStack();
                Material nowType = now.getType();
                if (slot == 40) {
                    //副手
                    switch (job) {
                        case 1 -> {
                            //若激活，只可能是盾牌
                            if (old.getType() == Material.SHIELD) {
                                //当槽位和职业都满足时去除激活
                                Act.DeActZhan(player, (ZhanData) data, old);
                            }
                            //若要激活，只可能是铁镐
                            if (nowType == Material.SHIELD) {
                                //当槽位和职业都满足时激活
                                Act.ActZhan(player, (ZhanData) data, now);
                            } else if (nowType == Material.BOW || nowType == Material.CROSSBOW) {
                                player.getInventory().setItem(40, new ItemStack(Material.AIR));
                            }
                        }
                        case 2 -> {
                            //若激活，只可能是钻石镐
                            if (old.getType() == Material.DIAMOND_PICKAXE) {
                                //当槽位和职业都满足时去除激活
                                if (slot == NBT.get(old, nbt -> nbt.getInteger("slot"))) {
                                    if (job == NBT.get(old, nbt -> nbt.getInteger("job"))) {
                                        Act.DeActGong(player, (GongData) data, old);
                                    }
                                }
                            }
                            //若要激活，只可能是铁镐
                            if (nowType == Material.DIAMOND_PICKAXE) {
                                if (slot == NBT.get(now, nbt -> nbt.getInteger("slot"))) {
                                    if (job == NBT.get(now, nbt -> nbt.getInteger("job"))) {
                                        Act.ActGong(player, (GongData) data, now);
                                    } else {
                                        player.getInventory().setItem(slot, new ItemStack(Material.AIR));
                                    }
                                }
                            } else if (nowType == Material.SHIELD) {
                                player.getInventory().setItem(40, new ItemStack(Material.AIR));
                            }
                        }
                        case 3 -> {
                            //若激活，只可能是钻石镐
                            if (old.getType() == Material.DIAMOND_PICKAXE) {
                                //当槽位和职业都满足时去除激活
                                if (slot == NBT.get(old, nbt -> nbt.getInteger("slot"))) {
                                    if (job == NBT.get(old, nbt -> nbt.getInteger("job"))) {
                                        Act.DeActDan(player, (DanData) data, old);
                                    }
                                }
                            }
                            //若要激活，只可能是铁镐
                            if (now.getType() == Material.DIAMOND_PICKAXE) {
                                if (slot == NBT.get(now, nbt -> nbt.getInteger("slot"))) {
                                    if (job == NBT.get(now, nbt -> nbt.getInteger("job"))) {
                                        Act.ActDan(player, (DanData) data, now);
                                    } else {
                                        player.getInventory().setItem(slot, new ItemStack(Material.AIR));
                                    }
                                }
                            } else if (nowType == Material.SHIELD || nowType == Material.BOW || nowType == Material.CROSSBOW) {
                                player.getInventory().setItem(40, new ItemStack(Material.AIR));
                            }
                        }
                    }
                } else {
                    //装备
                    //若激活，则不为空即可
                    if (old.getType() != Material.AIR) {
                        //当职业都满足时去除激活
                        if (job == NBT.get(old, nbt -> nbt.getInteger("job"))) {
                            switch (job) {
                                case 1 -> Act.DeActZhan(player, (ZhanData) data, old);
                                case 2 -> Act.DeActGong(player, (GongData) data, old);
                                case 3 -> Act.DeActDan(player, (DanData) data, old);
                            }
                        } else {
                            player.getInventory().setItem(slot, new ItemStack(Material.AIR));
                        }
                    }
                    //若要激活，不为空即可
                    if (now.getType() != Material.AIR) {
                        //当职业都满足时激活
                        if (job == NBT.get(now, nbt -> nbt.getInteger("job"))) {
                            switch (job) {
                                case 1 -> Act.ActZhan(player, (ZhanData) data, now);
                                case 2 -> Act.ActGong(player, (GongData) data, now);
                                case 3 -> Act.ActDan(player, (DanData) data, now);
                            }
                        } else {
                            player.getInventory().setItem(slot, new ItemStack(Material.AIR));
                        }
                    }
                }
            }
        }
    }
}


