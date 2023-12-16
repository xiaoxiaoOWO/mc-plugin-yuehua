package com.xiaoxiaoowo.yuehua.event.player;

import com.xiaoxiaoowo.yuehua.Yuehua;
import com.xiaoxiaoowo.yuehua.data.DanData;
import com.xiaoxiaoowo.yuehua.data.Data;
import com.xiaoxiaoowo.yuehua.data.GongData;
import com.xiaoxiaoowo.yuehua.data.ZhanData;
import com.xiaoxiaoowo.yuehua.system.Act;
import com.xiaoxiaoowo.yuehua.system.DataContainer;
import io.papermc.paper.event.player.PlayerInventorySlotChangeEvent;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
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
                if (data == null || data.open) {
                    return;
                }
                int job = data.job;
                switch (job) {
                    case 1 -> {
                        ZhanData zhanData = (ZhanData) data;
                        Act.deActZhan(zhanData, data.slot0.id);
                        ItemStack now = e.getNewItemStack();
                        if (now.getType() == Material.DIAMOND_PICKAXE) {
                            //当槽位和职业都满足时激活
                            PersistentDataContainer pdc = now.getItemMeta().getPersistentDataContainer();
                            if (slot == pdc.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                                if (job == pdc.get(DataContainer.job, PersistentDataType.INTEGER)) {
                                    Act.actZhan(zhanData, pdc.get(DataContainer.id, PersistentDataType.STRING));
                                }
                            }
                        }
                    }
                    case 2 -> {
                        GongData gongData = (GongData) data;
                        if (gongData.readyBow && gongData.readyCrossBow) {

                            Act.deActGong(gongData, gongData.slot0.id);

                            ItemStack now = e.getNewItemStack();
                            Material nowType = now.getType();
                            //若要激活
                            if (nowType == Material.BOW || nowType == Material.CROSSBOW) {
                                //当槽位和职业都满足时激活
                                PersistentDataContainer pdc = now.getItemMeta().getPersistentDataContainer();
                                Act.actGong(gongData, pdc.get(DataContainer.id, PersistentDataType.STRING));
                            }
                        }
                    }
                    case 3 -> {
                        DanData danData = (DanData) data;

                        Act.deActDan(danData, danData.slot0.id);

                        ItemStack now = e.getNewItemStack();
                        if (now.getType() == Material.DIAMOND_PICKAXE) {
                            //当槽位和职业都满足时激活
                            PersistentDataContainer pdc = now.getItemMeta().getPersistentDataContainer();
                            if (slot == pdc.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                                if (job == pdc.get(DataContainer.job, PersistentDataType.INTEGER)) {
                                    Act.actDan(danData, pdc.get(DataContainer.id, PersistentDataType.STRING));
                                }
                            }
                        }
                    }
                }
            }


            case 1 -> {
                Player player = e.getPlayer();
                Data data = Yuehua.playerData.get(player.getUniqueId());
                if (data == null || data.open) {
                    return;
                }
                int job = data.job;

                switch (job) {
                    case 1 -> {
                        ZhanData zhanData = (ZhanData) data;
                        Act.deActZhan(zhanData, data.slot1.id);

                        ItemStack now = e.getNewItemStack();
                        if (now.getType() == Material.DIAMOND_PICKAXE) {
                            //当槽位和职业都满足时激活
                            PersistentDataContainer pdc = now.getItemMeta().getPersistentDataContainer();
                            if (slot == pdc.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                                if (job == pdc.get(DataContainer.job, PersistentDataType.INTEGER)) {
                                    Act.actZhan(zhanData, pdc.get(DataContainer.id, PersistentDataType.STRING));
                                }
                            }
                        }
                    }
                    case 2 -> {
                        GongData gongData = (GongData) data;
                        Act.deActGong(gongData, data.slot1.id);

                        ItemStack now = e.getNewItemStack();
                        if (now.getType() == Material.DIAMOND_PICKAXE) {
                            //当槽位和职业都满足时激活
                            PersistentDataContainer pdc = now.getItemMeta().getPersistentDataContainer();
                            if (slot == pdc.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                                if (job == pdc.get(DataContainer.job, PersistentDataType.INTEGER)) {
                                    Act.actGong(gongData, pdc.get(DataContainer.id, PersistentDataType.STRING));
                                }
                            }
                        }
                    }
                    case 3 -> {
                        DanData danData = (DanData) data;
                        Act.deActDan(danData, data.slot1.id);

                        ItemStack now = e.getNewItemStack();
                        if (now.getType() == Material.DIAMOND_PICKAXE) {
                            //当槽位和职业都满足时激活
                            PersistentDataContainer pdc = now.getItemMeta().getPersistentDataContainer();
                            if (slot == pdc.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                                if (job == pdc.get(DataContainer.job, PersistentDataType.INTEGER)) {
                                    Act.actDan(danData, pdc.get(DataContainer.id, PersistentDataType.STRING));
                                }
                            }
                        }
                    }
                }
            }

            case 2 -> {
                Player player = e.getPlayer();
                Data data = Yuehua.playerData.get(player.getUniqueId());
                if (data == null || data.open) {
                    return;
                }
                int job = data.job;

                switch (job) {
                    case 1 -> {
                        ZhanData zhanData = (ZhanData) data;
                        Act.deActZhan(zhanData, data.slot2.id);
                        ItemStack now = e.getNewItemStack();
                        if (now.getType() == Material.DIAMOND_PICKAXE) {
                            //当槽位和职业都满足时激活
                            PersistentDataContainer pdc = now.getItemMeta().getPersistentDataContainer();
                            if (slot == pdc.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                                if (job == pdc.get(DataContainer.job, PersistentDataType.INTEGER)) {
                                    Act.actZhan(zhanData, pdc.get(DataContainer.id, PersistentDataType.STRING));
                                }
                            }
                        }
                    }
                    case 2 -> {
                        GongData gongData = (GongData) data;
                        Act.deActGong(gongData, data.slot2.id);
                        ItemStack now = e.getNewItemStack();
                        if (now.getType() == Material.DIAMOND_PICKAXE) {
                            //当槽位和职业都满足时激活
                            PersistentDataContainer pdc = now.getItemMeta().getPersistentDataContainer();
                            if (slot == pdc.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                                if (job == pdc.get(DataContainer.job, PersistentDataType.INTEGER)) {
                                    Act.actGong(gongData, pdc.get(DataContainer.id, PersistentDataType.STRING));
                                }
                            }
                        }
                    }
                    case 3 -> {
                        DanData danData = (DanData) data;
                        Act.deActDan(danData, data.slot2.id);
                        ItemStack now = e.getNewItemStack();
                        if (now.getType() == Material.DIAMOND_PICKAXE) {
                            //当槽位和职业都满足时激活
                            PersistentDataContainer pdc = now.getItemMeta().getPersistentDataContainer();
                            if (slot == pdc.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                                if (job == pdc.get(DataContainer.job, PersistentDataType.INTEGER)) {
                                    Act.actDan(danData, pdc.get(DataContainer.id, PersistentDataType.STRING));
                                }
                            }
                        }
                    }
                }


            }


            case 3 -> {
                Player player = e.getPlayer();
                Data data = Yuehua.playerData.get(player.getUniqueId());
                if (data == null || data.open) {
                    return;
                }
                int job = data.job;
                if (job != 3) {
                    return;
                }
                DanData danData = (DanData) data;

                Act.deActDan(danData, danData.slot3.id);


                ItemStack now = e.getNewItemStack();
                if (now.getType() == Material.DIAMOND_PICKAXE) {
                    //当槽位和职业都满足时激活
                    PersistentDataContainer pdc = now.getItemMeta().getPersistentDataContainer();
                    if (slot == pdc.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                        if (job == pdc.get(DataContainer.job, PersistentDataType.INTEGER)) {
                            Act.actDan((DanData) data, pdc.get(DataContainer.id, PersistentDataType.STRING));
                        }
                    }
                }
            }

            case 4 -> {
                Player player = e.getPlayer();
                Data data = Yuehua.playerData.get(player.getUniqueId());
                if (data == null || data.open) {
                    return;
                }
                int job = data.job;
                if (job != 3) {
                    return;
                }
                DanData danData = (DanData) data;
                Act.deActDan(danData, danData.slot4.id);


                ItemStack now = e.getNewItemStack();
                if (now.getType() == Material.DIAMOND_PICKAXE) {
                    //当槽位和职业都满足时激活
                    PersistentDataContainer pdc = now.getItemMeta().getPersistentDataContainer();
                    if (slot == pdc.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                        if (job == pdc.get(DataContainer.job, PersistentDataType.INTEGER)) {
                            Act.actDan((DanData) data, pdc.get(DataContainer.id, PersistentDataType.STRING));
                        }
                    }
                }
            }

            case 5 -> {
                Player player = e.getPlayer();
                Data data = Yuehua.playerData.get(player.getUniqueId());
                if (data == null || data.open) {
                    return;
                }
                int job = data.job;
                if (job != 3) {
                    return;
                }
                DanData danData = (DanData) data;
                Act.deActDan(danData, danData.slot5.id);


                ItemStack now = e.getNewItemStack();
                if (now.getType() == Material.DIAMOND_PICKAXE) {
                    //当槽位和职业都满足时激活
                    PersistentDataContainer pdc = now.getItemMeta().getPersistentDataContainer();
                    if (slot == pdc.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                        if (job == pdc.get(DataContainer.job, PersistentDataType.INTEGER)) {
                            Act.actDan((DanData) data, pdc.get(DataContainer.id, PersistentDataType.STRING));
                        }
                    }
                }
            }


            case 8 -> {
                Player player = e.getPlayer();
                Data data = Yuehua.playerData.get(player.getUniqueId());
                if (data == null || data.open) {
                    return;
                }

                switch (data.job) {
                    case 1 -> Act.deActZhan((ZhanData) data, data.slot8.id);
                    case 2 -> Act.deActGong((GongData) data, data.slot8.id);
                    case 3 -> Act.deActDan((DanData) data, data.slot8.id);
                }

                ItemStack now = e.getNewItemStack();
                if (now.getType() == Material.IRON_PICKAXE) {
                    Act.actAll(data, now.getItemMeta().getPersistentDataContainer().get(DataContainer.id, PersistentDataType.STRING));
                }
            }

            case 36 -> {
                Player player = e.getPlayer();
                Data data = Yuehua.playerData.get(player.getUniqueId());
                if (data == null || data.open) {
                    return;
                }
                int job = data.job;

                switch (job) {
                    case 1 -> {
                        ZhanData zhanData = (ZhanData) data;
                        Act.deActZhan(zhanData, data.slot36.id);
                        ItemStack now = e.getNewItemStack();
                        //若要激活，不为空即可
                        if (now.getType() != Material.AIR) {
                            //当职业都满足时激活
                            PersistentDataContainer pdc = now.getPersistentDataContainer();
                            if (job == pdc.get(DataContainer.job, PersistentDataType.INTEGER)) {
                                Act.actZhan(zhanData, pdc.get(DataContainer.id, PersistentDataType.STRING));
                            }
                        }
                    }
                    case 2 -> {
                        GongData gongData = (GongData) data;
                        Act.deActGong(gongData, data.slot36.id);
                        ItemStack now = e.getNewItemStack();
                        //若要激活，不为空即可
                        if (now.getType() != Material.AIR) {
                            //当职业都满足时激活
                            PersistentDataContainer pdc = now.getPersistentDataContainer();
                            if (job == pdc.get(DataContainer.job, PersistentDataType.INTEGER)) {
                                Act.actGong(gongData, pdc.get(DataContainer.id, PersistentDataType.STRING));
                            }
                        }
                    }
                    case 3 -> {
                        DanData danData = (DanData) data;
                        Act.deActDan(danData, data.slot36.id);
                        ItemStack now = e.getNewItemStack();
                        //若要激活，不为空即可
                        if (now.getType() != Material.AIR) {
                            //当职业都满足时激活
                            PersistentDataContainer pdc = now.getPersistentDataContainer();
                            if (job == pdc.get(DataContainer.job, PersistentDataType.INTEGER)) {
                                Act.actDan(danData, pdc.get(DataContainer.id, PersistentDataType.STRING));
                            }
                        }
                    }
                }
            }


            case 37 -> {
                Player player = e.getPlayer();
                Data data = Yuehua.playerData.get(player.getUniqueId());
                if (data == null || data.open) {
                    return;
                }
                int job = data.job;

                switch (job) {
                    case 1 -> {
                        ZhanData zhanData = (ZhanData) data;
                        Act.deActZhan(zhanData, data.slot37.id);
                        ItemStack now = e.getNewItemStack();
                        //若要激活，不为空即可
                        if (now.getType() != Material.AIR) {
                            //当职业都满足时激活
                            PersistentDataContainer pdc = now.getPersistentDataContainer();
                            if (job == pdc.get(DataContainer.job, PersistentDataType.INTEGER)) {
                                Act.actZhan(zhanData, pdc.get(DataContainer.id, PersistentDataType.STRING));
                            }
                        }
                    }
                    case 2 -> {
                        GongData gongData = (GongData) data;
                        Act.deActGong(gongData, data.slot37.id);
                        ItemStack now = e.getNewItemStack();
                        //若要激活，不为空即可
                        if (now.getType() != Material.AIR) {
                            //当职业都满足时激活
                            PersistentDataContainer pdc = now.getPersistentDataContainer();
                            if (job == pdc.get(DataContainer.job, PersistentDataType.INTEGER)) {
                                Act.actGong(gongData, pdc.get(DataContainer.id, PersistentDataType.STRING));
                            }
                        }
                    }
                    case 3 -> {
                        DanData danData = (DanData) data;
                        Act.deActDan(danData, data.slot37.id);
                        ItemStack now = e.getNewItemStack();
                        //若要激活，不为空即可
                        if (now.getType() != Material.AIR) {
                            //当职业都满足时激活
                            PersistentDataContainer pdc = now.getPersistentDataContainer();
                            if (job == pdc.get(DataContainer.job, PersistentDataType.INTEGER)) {
                                Act.actDan(danData, pdc.get(DataContainer.id, PersistentDataType.STRING));
                            }
                        }
                    }
                }
            }

            case 38 -> {
                Player player = e.getPlayer();
                Data data = Yuehua.playerData.get(player.getUniqueId());
                if (data == null || data.open) {
                    return;
                }
                int job = data.job;

                switch (job) {
                    case 1 -> {
                        ZhanData zhanData = (ZhanData) data;
                        Act.deActZhan(zhanData, data.slot38.id);
                        ItemStack now = e.getNewItemStack();
                        //若要激活，不为空即可
                        if (now.getType() != Material.AIR) {
                            //当职业都满足时激活
                            PersistentDataContainer pdc = now.getPersistentDataContainer();
                            if (job == pdc.get(DataContainer.job, PersistentDataType.INTEGER)) {
                                Act.actZhan(zhanData, pdc.get(DataContainer.id, PersistentDataType.STRING));
                            }
                        }
                    }
                    case 2 -> {
                        GongData gongData = (GongData) data;
                        Act.deActGong(gongData, data.slot38.id);
                        ItemStack now = e.getNewItemStack();
                        //若要激活，不为空即可
                        if (now.getType() != Material.AIR) {
                            //当职业都满足时激活
                            PersistentDataContainer pdc = now.getPersistentDataContainer();
                            if (job == pdc.get(DataContainer.job, PersistentDataType.INTEGER)) {
                                Act.actGong(gongData, pdc.get(DataContainer.id, PersistentDataType.STRING));
                            }
                        }
                    }
                    case 3 -> {
                        DanData danData = (DanData) data;
                        Act.deActDan(danData, data.slot38.id);
                        ItemStack now = e.getNewItemStack();
                        //若要激活，不为空即可
                        if (now.getType() != Material.AIR) {
                            //当职业都满足时激活
                            PersistentDataContainer pdc = now.getPersistentDataContainer();
                            if (job == pdc.get(DataContainer.job, PersistentDataType.INTEGER)) {
                                Act.actDan(danData, pdc.get(DataContainer.id, PersistentDataType.STRING));
                            }
                        }
                    }
                }
            }

            case 39 -> {
                Player player = e.getPlayer();
                Data data = Yuehua.playerData.get(player.getUniqueId());
                if (data == null || data.open) {
                    return;
                }
                int job = data.job;

                switch (job) {
                    case 1 -> {
                        ZhanData zhanData = (ZhanData) data;
                        Act.deActZhan(zhanData, data.slot39.id);
                        ItemStack now = e.getNewItemStack();
                        //若要激活，不为空即可
                        if (now.getType() != Material.AIR) {
                            //当职业都满足时激活
                            PersistentDataContainer pdc = now.getPersistentDataContainer();
                            if (job == pdc.get(DataContainer.job, PersistentDataType.INTEGER)) {
                                Act.actZhan(zhanData, pdc.get(DataContainer.id, PersistentDataType.STRING));
                            }
                        }
                    }
                    case 2 -> {
                        GongData gongData = (GongData) data;
                        Act.deActGong(gongData, data.slot39.id);
                        ItemStack now = e.getNewItemStack();
                        //若要激活，不为空即可
                        if (now.getType() != Material.AIR) {
                            //当职业都满足时激活
                            PersistentDataContainer pdc = now.getPersistentDataContainer();
                            if (job == pdc.get(DataContainer.job, PersistentDataType.INTEGER)) {
                                Act.actGong(gongData, pdc.get(DataContainer.id, PersistentDataType.STRING));
                            }
                        }
                    }
                    case 3 -> {
                        DanData danData = (DanData) data;
                        Act.deActDan(danData, data.slot39.id);
                        ItemStack now = e.getNewItemStack();
                        //若要激活，不为空即可
                        if (now.getType() != Material.AIR) {
                            //当职业都满足时激活
                            PersistentDataContainer pdc = now.getPersistentDataContainer();
                            if (job == pdc.get(DataContainer.job, PersistentDataType.INTEGER)) {
                                Act.actDan(danData, pdc.get(DataContainer.id, PersistentDataType.STRING));
                            }
                        }
                    }
                }
            }


            case 40 -> {
                Player player = e.getPlayer();
                Data data = Yuehua.playerData.get(player.getUniqueId());
                if (data == null || data.open) {
                    return;
                }
                int job = data.job;
                ItemStack now = e.getNewItemStack();
                Material nowType = now.getType();
                //副手
                switch (job) {
                    case 1 -> {
                        ZhanData zhanData = (ZhanData) data;
                        Act.deActZhan(zhanData, data.slot40.id);
                        //若要激活
                        if (nowType == Material.SHIELD) {
                            //当槽位和职业都满足时激活
                            Act.actZhan(zhanData, now.getPersistentDataContainer().get(DataContainer.id, PersistentDataType.STRING));
                        }
                    }
                    case 2 -> {
                        GongData gongData = (GongData) data;
                        Act.deActGong(gongData, data.slot40.id);
                        if (nowType == Material.GOLDEN_PICKAXE) {
                            PersistentDataContainer pdc = now.getPersistentDataContainer();
                            if (job == pdc.get(DataContainer.id, PersistentDataType.INTEGER)) {
                                Act.actGong(gongData, pdc.get(DataContainer.id, PersistentDataType.STRING));
                            }
                        }
                    }
                    case 3 -> {
                        DanData danData = (DanData) data;
                        Act.deActDan(danData, data.slot40.id);
                        if (nowType == Material.GOLDEN_PICKAXE) {
                            PersistentDataContainer pdc = now.getPersistentDataContainer();
                            if (job == pdc.get(DataContainer.id, PersistentDataType.INTEGER)) {
                                Act.actDan(danData, pdc.get(DataContainer.id, PersistentDataType.STRING));
                            }
                        }
                    }
                }
            }

        }



    }
}


