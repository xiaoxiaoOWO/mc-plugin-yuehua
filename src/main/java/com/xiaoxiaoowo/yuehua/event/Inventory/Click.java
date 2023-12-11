package com.xiaoxiaoowo.yuehua.event.Inventory;

import com.xiaoxiaoowo.yuehua.Yuehua;
import com.xiaoxiaoowo.yuehua.commands.playercommand.Yh;
import com.xiaoxiaoowo.yuehua.data.Data;
import com.xiaoxiaoowo.yuehua.system.DataContainer;
import com.xiaoxiaoowo.yuehua.utils.SQL;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;

public final class Click implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        String title = event.getView().getOriginalTitle();
        switch (title) {
            case "§l§b主菜单" -> {
                event.setCancelled(true);
                ItemStack currentItem = event.getCurrentItem();
                if (currentItem == null) {
                    return;
                }
                Player whoClicked = (Player) event.getWhoClicked();
                switch (currentItem.getType()) {
                    case BLUE_DYE -> {
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                if (whoClicked.getPersistentDataContainer().get(DataContainer.mainland, PersistentDataType.BOOLEAN)) {
                                    whoClicked.openInventory(Yh.QIAN_KUN_BAG);
                                } else {
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            whoClicked.sendMessage(Component.translatable("nomainland"));
                                            whoClicked.closeInventory();
                                        }
                                    }.runTask(Yuehua.instance);
                                }

                            }
                        }.runTask(Yuehua.instance);
                    }
                }
            }
            case "§l§b乾坤袋" -> {
                event.setCancelled(true);

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        ItemStack currentItem = event.getCurrentItem();
                        if (currentItem == null) {
                            return;
                        }
                        Player whoClicked = (Player) event.getWhoClicked();
                        if (currentItem.getType() == Material.BLUE_DYE) {
                            switch (currentItem.getPersistentDataContainer().get(DataContainer.id, PersistentDataType.INTEGER)) {
                                case 1 -> {
                                    Data data = Yuehua.playerData.get(whoClicked.getUniqueId());
                                    if (data.inventory1 == null) {
                                        PersistentDataContainer pdc = whoClicked.getPersistentDataContainer();
                                        if (pdc.get(DataContainer.qkd1, PersistentDataType.BOOLEAN)) {
                                            data.inventory1 = SQL.retrievePlayerInventory1(whoClicked);
                                        } else {
                                            new BukkitRunnable() {
                                                @Override
                                                public void run() {
                                                    whoClicked.sendMessage(Component.translatable("unqkd"));
                                                    whoClicked.closeInventory();
                                                }
                                            }.runTask(Yuehua.instance);
                                            return;
                                        }
                                    }
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            whoClicked.openInventory(data.inventory1);
                                        }
                                    }.runTask(Yuehua.instance);
                                }
                                case 2 -> {
                                    Data data = Yuehua.playerData.get(whoClicked.getUniqueId());
                                    if (data.inventory2 == null) {
                                        PersistentDataContainer pdc = whoClicked.getPersistentDataContainer();
                                        if (pdc.get(DataContainer.qkd2, PersistentDataType.BOOLEAN)) {
                                            data.inventory2 = SQL.retrievePlayerInventory1(whoClicked);
                                        } else {
                                            new BukkitRunnable() {
                                                @Override
                                                public void run() {
                                                    whoClicked.sendMessage(Component.translatable("unqkd"));
                                                    whoClicked.closeInventory();
                                                }
                                            }.runTask(Yuehua.instance);
                                            return;
                                        }
                                    }
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            whoClicked.openInventory(data.inventory2);
                                        }
                                    }.runTask(Yuehua.instance);
                                }

                                case 3 -> {
                                    Data data = Yuehua.playerData.get(whoClicked.getUniqueId());
                                    if (data.inventory3 == null) {
                                        PersistentDataContainer pdc = whoClicked.getPersistentDataContainer();
                                        if (pdc.get(DataContainer.qkd3, PersistentDataType.BOOLEAN)) {
                                            data.inventory3 = SQL.retrievePlayerInventory1(whoClicked);
                                        } else {
                                            new BukkitRunnable() {
                                                @Override
                                                public void run() {
                                                    whoClicked.sendMessage(Component.translatable("unqkd"));
                                                    whoClicked.closeInventory();
                                                }
                                            }.runTask(Yuehua.instance);
                                            return;
                                        }
                                    }
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            whoClicked.openInventory(data.inventory3);
                                        }
                                    }.runTask(Yuehua.instance);
                                }

                                case 4 -> {
                                    Data data = Yuehua.playerData.get(whoClicked.getUniqueId());
                                    if (data.inventory4 == null) {
                                        PersistentDataContainer pdc = whoClicked.getPersistentDataContainer();
                                        if (pdc.get(DataContainer.qkd4, PersistentDataType.BOOLEAN)) {
                                            data.inventory4 = SQL.retrievePlayerInventory1(whoClicked);
                                        } else {
                                            new BukkitRunnable() {
                                                @Override
                                                public void run() {
                                                    whoClicked.sendMessage(Component.translatable("unqkd"));
                                                    whoClicked.closeInventory();
                                                }
                                            }.runTask(Yuehua.instance);
                                            return;
                                        }
                                    }
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            whoClicked.openInventory(data.inventory4);
                                        }
                                    }.runTask(Yuehua.instance);
                                }

                                case 5 -> {
                                    Data data = Yuehua.playerData.get(whoClicked.getUniqueId());
                                    if (data.inventory5 == null) {
                                        PersistentDataContainer pdc = whoClicked.getPersistentDataContainer();
                                        if (pdc.get(DataContainer.qkd5, PersistentDataType.BOOLEAN)) {
                                            data.inventory5 = SQL.retrievePlayerInventory1(whoClicked);
                                        } else {
                                            new BukkitRunnable() {
                                                @Override
                                                public void run() {
                                                    whoClicked.sendMessage(Component.translatable("unqkd"));
                                                    whoClicked.closeInventory();
                                                }
                                            }.runTask(Yuehua.instance);
                                            return;
                                        }
                                    }
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            whoClicked.openInventory(data.inventory5);
                                        }
                                    }.runTask(Yuehua.instance);
                                }

                                case 6 -> {
                                    Data data = Yuehua.playerData.get(whoClicked.getUniqueId());
                                    if (data.inventory6 == null) {
                                        PersistentDataContainer pdc = whoClicked.getPersistentDataContainer();
                                        if (pdc.get(DataContainer.qkd6, PersistentDataType.BOOLEAN)) {
                                            data.inventory6 = SQL.retrievePlayerInventory1(whoClicked);
                                        } else {
                                            new BukkitRunnable() {
                                                @Override
                                                public void run() {
                                                    whoClicked.sendMessage(Component.translatable("unqkd"));
                                                    whoClicked.closeInventory();
                                                }
                                            }.runTask(Yuehua.instance);
                                            return;
                                        }
                                    }
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            whoClicked.openInventory(data.inventory6);
                                        }
                                    }.runTask(Yuehua.instance);
                                }

                                case 7 -> {
                                    Data data = Yuehua.playerData.get(whoClicked.getUniqueId());
                                    if (data.inventory7 == null) {
                                        PersistentDataContainer pdc = whoClicked.getPersistentDataContainer();
                                        if (pdc.get(DataContainer.qkd7, PersistentDataType.BOOLEAN)) {
                                            data.inventory7 = SQL.retrievePlayerInventory1(whoClicked);
                                        } else {
                                            new BukkitRunnable() {
                                                @Override
                                                public void run() {
                                                    whoClicked.sendMessage(Component.translatable("unqkd"));
                                                    whoClicked.closeInventory();
                                                }
                                            }.runTask(Yuehua.instance);
                                            return;
                                        }
                                    }
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            whoClicked.openInventory(data.inventory7);
                                        }
                                    }.runTask(Yuehua.instance);
                                }

                                case 8 -> {
                                    Data data = Yuehua.playerData.get(whoClicked.getUniqueId());
                                    if (data.inventory8 == null) {
                                        PersistentDataContainer pdc = whoClicked.getPersistentDataContainer();
                                        if (pdc.get(DataContainer.qkd8, PersistentDataType.BOOLEAN)) {
                                            data.inventory8 = SQL.retrievePlayerInventory1(whoClicked);
                                        } else {
                                            new BukkitRunnable() {
                                                @Override
                                                public void run() {
                                                    whoClicked.sendMessage(Component.translatable("unqkd"));
                                                    whoClicked.closeInventory();
                                                }
                                            }.runTask(Yuehua.instance);
                                            return;
                                        }
                                    }
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            whoClicked.openInventory(data.inventory8);
                                        }
                                    }.runTask(Yuehua.instance);
                                }

                                case 9 -> {
                                    Data data = Yuehua.playerData.get(whoClicked.getUniqueId());
                                    if (data.inventory9 == null) {
                                        PersistentDataContainer pdc = whoClicked.getPersistentDataContainer();
                                        if (pdc.get(DataContainer.qkd9, PersistentDataType.BOOLEAN)) {
                                            data.inventory9 = SQL.retrievePlayerInventory1(whoClicked);
                                        } else {
                                            new BukkitRunnable() {
                                                @Override
                                                public void run() {
                                                    whoClicked.sendMessage(Component.translatable("unqkd"));
                                                    whoClicked.closeInventory();
                                                }
                                            }.runTask(Yuehua.instance);
                                            return;
                                        }
                                    }
                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            whoClicked.openInventory(data.inventory9);
                                        }
                                    }.runTask(Yuehua.instance);
                                }
                            }
                        } else {
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    whoClicked.openInventory(Yh.MAIN_MENU);
                                }
                            }.runTask(Yuehua.instance);
                        }
                    }
                }.runTaskAsynchronously(Yuehua.instance);
            }

            case "§l§b乾坤袋☯一", "§l§b乾坤袋☯二", "§l§b乾坤袋☯三", "§l§b乾坤袋☯四", "§l§b乾坤袋☯五",
                    "§l§b乾坤袋☯六", "§l§b乾坤袋☯七", "§l§b乾坤袋☯八", "§l§b乾坤袋☯九" -> {
                if (event.getSlot() == 53) {
                    event.setCancelled(true);
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            Player whoClicked = (Player) event.getWhoClicked();
                            whoClicked.openInventory(Yh.QIAN_KUN_BAG);
                        }
                    }.runTask(Yuehua.instance);
                }
            }

        }
    }
}
