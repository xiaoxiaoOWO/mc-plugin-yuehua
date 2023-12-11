package com.xiaoxiaoowo.yuehua.event.player;

import com.xiaoxiaoowo.yuehua.Yuehua;
import com.xiaoxiaoowo.yuehua.data.DanData;
import com.xiaoxiaoowo.yuehua.data.Data;
import com.xiaoxiaoowo.yuehua.data.GongData;
import com.xiaoxiaoowo.yuehua.data.ZhanData;
import com.xiaoxiaoowo.yuehua.system.Act;
import com.xiaoxiaoowo.yuehua.system.DataContainer;
import io.papermc.paper.event.player.PlayerFlowerPotManipulateEvent;
import io.papermc.paper.event.player.PlayerInventorySlotChangeEvent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;


public final class InventorySlotChange implements Listener {


    @EventHandler
    public void onInventorySlotChange(PlayerInventorySlotChangeEvent e) {
        int slot = e.getSlot();
        switch (slot) {
            case 0 -> {
                Player player = e.getPlayer();
                Data data = Yuehua.playerData.get(player.getUniqueId());
                if (data == null) {
                    return;
                }
                int job = data.job;
                switch (job) {
                    case 1 -> {
                        ItemStack old = e.getOldItemStack();
                        ItemStack now = e.getNewItemStack();
                        if (old.getType() == Material.DIAMOND_PICKAXE) {
                            //当槽位和职业都满足时去除激活
                            PersistentDataContainer pdc = old.getItemMeta().getPersistentDataContainer();
                            if (slot == pdc.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                                if (job == pdc.get(DataContainer.job, PersistentDataType.INTEGER)) {
                                    Act.deActZhan(player, (ZhanData) data, pdc.get(DataContainer.id, PersistentDataType.STRING));
                                }
                            }

                        }
                        if (now.getType() == Material.DIAMOND_PICKAXE) {
                            //当槽位和职业都满足时激活
                            PersistentDataContainer pdc = now.getItemMeta().getPersistentDataContainer();
                            if (slot == pdc.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                                if (job == pdc.get(DataContainer.job, PersistentDataType.INTEGER)) {
                                    Act.actZhan(player, (ZhanData) data, pdc.get(DataContainer.id, PersistentDataType.STRING));
                                }
                            }
                        }
                    }
                    case 2 -> {
                        GongData gongData = (GongData) data;
                        if (gongData.readyBow && gongData.readyCrossBow) {
                            ItemStack old = e.getOldItemStack();
                            Material oldType = old.getType();
                            ItemStack now = e.getNewItemStack();
                            Material nowType = now.getType();
                            //若激活，可能是弓，弩
                            if (oldType == Material.BOW || oldType == Material.CROSSBOW) {
                                //当槽位和职业都满足时去除激活
                                PersistentDataContainer pdc = old.getItemMeta().getPersistentDataContainer();
                                Act.deActGong(player, gongData, pdc.get(DataContainer.id, PersistentDataType.STRING));
                            }

                            //若要激活
                            if (nowType == Material.BOW || nowType == Material.CROSSBOW) {
                                //当槽位和职业都满足时激活
                                PersistentDataContainer pdc = now.getItemMeta().getPersistentDataContainer();
                                Act.actGong(player, gongData, pdc.get(DataContainer.id, PersistentDataType.STRING));
                            }
                        }
                    }
                    case 3 -> {
                        ItemStack old = e.getOldItemStack();
                        ItemStack now = e.getNewItemStack();
                        if (old.getType() == Material.DIAMOND_PICKAXE) {
                            //当槽位和职业都满足时去除激活
                            PersistentDataContainer pdc = old.getItemMeta().getPersistentDataContainer();
                            if (slot == pdc.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                                if (job == pdc.get(DataContainer.job, PersistentDataType.INTEGER)) {
                                    Act.deActDan(player, (DanData) data, pdc.get(DataContainer.id, PersistentDataType.STRING));
                                }
                            }

                        }
                        if (now.getType() == Material.DIAMOND_PICKAXE) {
                            //当槽位和职业都满足时激活
                            PersistentDataContainer pdc = now.getItemMeta().getPersistentDataContainer();
                            if (slot == pdc.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                                if (job == pdc.get(DataContainer.job, PersistentDataType.INTEGER)) {
                                    Act.actDan(player, (DanData) data, pdc.get(DataContainer.id, PersistentDataType.STRING));
                                }
                            }
                        }
                    }
                }
            }


            case 1, 2 -> {
                Player player = e.getPlayer();
                Data data = Yuehua.playerData.get(player.getUniqueId());
                if (data == null) {
                    return;
                }
                int job = data.job;
                ItemStack old = e.getOldItemStack();
                ItemStack now = e.getNewItemStack();
                if (old.getType() == Material.DIAMOND_PICKAXE) {
                    //当槽位和职业都满足时去除激活
                    PersistentDataContainer pdc = old.getItemMeta().getPersistentDataContainer();
                    if (slot == pdc.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                        if (job == pdc.get(DataContainer.job, PersistentDataType.INTEGER)) {
                            switch (job) {
                                case 1 ->
                                        Act.deActZhan(player, (ZhanData) data, pdc.get(DataContainer.id, PersistentDataType.STRING));
                                case 2 ->
                                        Act.deActGong(player, (GongData) data, pdc.get(DataContainer.id, PersistentDataType.STRING));
                                case 3 ->
                                        Act.deActDan(player, (DanData) data, pdc.get(DataContainer.id, PersistentDataType.STRING));
                            }
                        }
                    }

                }
                if (now.getType() == Material.DIAMOND_PICKAXE) {
                    //当槽位和职业都满足时激活
                    PersistentDataContainer pdc = now.getItemMeta().getPersistentDataContainer();
                    if (slot == pdc.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                        if (job == pdc.get(DataContainer.job, PersistentDataType.INTEGER)) {
                            switch (job) {
                                case 1 ->
                                        Act.actZhan(player, (ZhanData) data, pdc.get(DataContainer.id, PersistentDataType.STRING));
                                case 2 ->
                                        Act.actGong(player, (GongData) data, pdc.get(DataContainer.id, PersistentDataType.STRING));
                                case 3 ->
                                        Act.actDan(player, (DanData) data, pdc.get(DataContainer.id, PersistentDataType.STRING));
                            }
                        }
                    }
                }
            }


            case 3, 4, 5 -> {
                Player player = e.getPlayer();
                Data data = Yuehua.playerData.get(player.getUniqueId());
                if (data == null) {
                    return;
                }
                int job = data.job;
                if (job != 3) {
                    return;
                }
                ItemStack old = e.getOldItemStack();
                ItemStack now = e.getNewItemStack();
                if (old.getType() == Material.DIAMOND_PICKAXE) {
                    //当槽位和职业都满足时去除激活
                    PersistentDataContainer pdc = old.getItemMeta().getPersistentDataContainer();
                    if (slot == pdc.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                        if (job == pdc.get(DataContainer.job, PersistentDataType.INTEGER)) {
                            Act.deActDan(player, (DanData) data, pdc.get(DataContainer.id, PersistentDataType.STRING));
                        }
                    }

                }
                if (now.getType() == Material.DIAMOND_PICKAXE) {
                    //当槽位和职业都满足时激活
                    PersistentDataContainer pdc = now.getItemMeta().getPersistentDataContainer();
                    if (slot == pdc.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                        if (job == pdc.get(DataContainer.job, PersistentDataType.INTEGER)) {
                            Act.actDan(player, (DanData) data, pdc.get(DataContainer.id, PersistentDataType.STRING));
                        }
                    }
                }
            }


            case 8 -> {
                Player player = e.getPlayer();
                Data data = Yuehua.playerData.get(player.getUniqueId());
                if (data == null) {
                    return;
                }
                ItemStack old = e.getOldItemStack();
                ItemStack now = e.getNewItemStack();
                //铁镐，去激活
                if (old.getType() == Material.IRON_PICKAXE) {
                    Act.deActAll(player, data, old.getItemMeta().getPersistentDataContainer().get(DataContainer.id, PersistentDataType.STRING));
                }
                if (now.getType() == Material.IRON_PICKAXE) {
                    Act.actAll(player, data, now.getItemMeta().getPersistentDataContainer().get(DataContainer.id, PersistentDataType.STRING));
                }
            }


            case 36, 37, 38, 39 -> {
                Player player = e.getPlayer();
                Data data = Yuehua.playerData.get(player.getUniqueId());
                if (data == null) {
                    return;
                }
                int job = data.job;
                ItemStack old = e.getOldItemStack();
                ItemStack now = e.getNewItemStack();
                //若激活，则不为空即可
                if (old.getType() != Material.AIR) {
                    //当职业都满足时去除激活
                    PersistentDataContainer pdc = old.getPersistentDataContainer();
                    if (job == pdc.get(DataContainer.job, PersistentDataType.INTEGER)) {
                        switch (job) {
                            case 1 ->
                                    Act.deActZhan(player, (ZhanData) data, pdc.get(DataContainer.id, PersistentDataType.STRING));
                            case 2 ->
                                    Act.deActGong(player, (GongData) data, pdc.get(DataContainer.id, PersistentDataType.STRING));
                            case 3 ->
                                    Act.deActDan(player, (DanData) data, pdc.get(DataContainer.id, PersistentDataType.STRING));
                        }
                    }
                }
                //若要激活，不为空即可
                if (now.getType() != Material.AIR) {
                    //当职业都满足时激活
                    PersistentDataContainer pdc = now.getPersistentDataContainer();
                    if (job == pdc.get(DataContainer.job, PersistentDataType.INTEGER)) {
                        switch (job) {
                            case 1 ->
                                    Act.actZhan(player, (ZhanData) data, pdc.get(DataContainer.id, PersistentDataType.STRING));
                            case 2 ->
                                    Act.actGong(player, (GongData) data, pdc.get(DataContainer.id, PersistentDataType.STRING));
                            case 3 ->
                                    Act.actDan(player, (DanData) data, pdc.get(DataContainer.id, PersistentDataType.STRING));
                        }
                    }
                }
            }


            case 40 -> {
                Player player = e.getPlayer();
                Data data = Yuehua.playerData.get(player.getUniqueId());
                if (data == null) {
                    return;
                }
                int job = data.job;
                ItemStack old = e.getOldItemStack();
                ItemStack now = e.getNewItemStack();
                Material nowType = now.getType();
                //副手
                switch (job) {
                    case 1 -> {
                        //若激活，只可能是盾牌
                        if (old.getType() == Material.SHIELD) {
                            //当槽位和职业都满足时去除激活
                            Act.deActZhan(player, (ZhanData) data, old.getPersistentDataContainer().get(DataContainer.id, PersistentDataType.STRING));
                        }
                        //若要激活
                        if (nowType == Material.SHIELD) {
                            //当槽位和职业都满足时激活

                            Act.actZhan(player, (ZhanData) data, now.getPersistentDataContainer().get(DataContainer.id, PersistentDataType.STRING));
                        }
                    }
                    case 2 -> {
                        if (old.getType() == Material.GOLDEN_PICKAXE) {
                            //当槽位和职业都满足时去除激活
                            PersistentDataContainer pdc = old.getPersistentDataContainer();
                            if (job == pdc.get(DataContainer.id, PersistentDataType.INTEGER)) {
                                Act.deActGong(player, (GongData) data, pdc.get(DataContainer.id, PersistentDataType.STRING));
                            }
                        }
                        if (nowType == Material.GOLDEN_PICKAXE) {
                            PersistentDataContainer pdc = now.getPersistentDataContainer();
                            if (job == pdc.get(DataContainer.id, PersistentDataType.INTEGER)) {
                                Act.actGong(player, (GongData) data, pdc.get(DataContainer.id, PersistentDataType.STRING));
                            }
                        }
                    }
                    case 3 -> {
                        if (old.getType() == Material.GOLDEN_PICKAXE) {
                            //当槽位和职业都满足时去除激活
                            PersistentDataContainer pdc = old.getPersistentDataContainer();
                            if (job == pdc.get(DataContainer.id, PersistentDataType.INTEGER)) {
                                Act.deActDan(player, (DanData) data, pdc.get(DataContainer.id, PersistentDataType.STRING));
                            }
                        }
                        if (nowType == Material.GOLDEN_PICKAXE) {
                            PersistentDataContainer pdc = now.getPersistentDataContainer();
                            if (job == pdc.get(DataContainer.id, PersistentDataType.INTEGER)) {
                                Act.actDan(player, (DanData) data, pdc.get(DataContainer.id, PersistentDataType.STRING));
                            }
                        }
                    }
                }
            }

        }
    }
}


