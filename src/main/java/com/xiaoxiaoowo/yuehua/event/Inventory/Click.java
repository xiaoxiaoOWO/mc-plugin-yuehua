package com.xiaoxiaoowo.yuehua.event.Inventory;

import com.xiaoxiaoowo.yuehua.Yuehua;
import com.xiaoxiaoowo.yuehua.commands.playercommand.Yh;
import com.xiaoxiaoowo.yuehua.data.Data;
import com.xiaoxiaoowo.yuehua.event.player.Join;
import com.xiaoxiaoowo.yuehua.system.DataContainer;
import com.xiaoxiaoowo.yuehua.utils.SQL;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffectType;

public final class Click implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        String title = event.getView().getOriginalTitle();
        switch (title) {
            case "main" -> {
                event.setCancelled(true);
                Player whoClicked = (Player) event.getWhoClicked();
                switch (event.getRawSlot()) {
                    case 0 -> Yuehua.scheduler.runTask(Yuehua.instance, () -> {
                        if (whoClicked.getPersistentDataContainer().get(DataContainer.fuben, PersistentDataType.INTEGER) == 0) {
                            whoClicked.openInventory(Yh.QIAN_KUN_BAG);
                        } else {
                            Yuehua.async(() -> whoClicked.sendMessage(Component.translatable("nomainland")));
                            whoClicked.closeInventory();

                        }
                    });


                    case 2 -> {
                        String name = whoClicked.getName();
                        Bukkit.dispatchCommand(Yuehua.console, "tpsbar " + name);
                    }
                    case 4 -> {
                        String name = whoClicked.getName();
                        Bukkit.dispatchCommand(Yuehua.console, "rambar " + name);
                    }
                    case 6 -> {
                        if (whoClicked.getPotionEffect(PotionEffectType.NIGHT_VISION) == null) {
                            whoClicked.addPotionEffect(Join.effect);
                        } else {
                            whoClicked.removePotionEffect(PotionEffectType.NIGHT_VISION);
                        }
                    }

                    case 8 -> {
                        Data data = Yuehua.playerData.get(whoClicked.getUniqueId());
                        Yuehua.scheduler.runTaskAsynchronously(
                                Yuehua.instance, () -> {
                                    if (data.shipinBar == null) {
                                        data.shipinBar = SQL.retrieveShipin(whoClicked);
                                    }
                                    Yuehua.scheduler.runTask(
                                            Yuehua.instance, () -> whoClicked.openInventory(data.shipinBar)
                                    );
                                }
                        );
                    }
                }
            }
            case "qkd" -> {
                event.setCancelled(true);
                Player whoClicked = (Player) event.getWhoClicked();
                Data data = Yuehua.playerData.get(whoClicked.getUniqueId());
                Yuehua.scheduler.runTaskAsynchronously(
                        Yuehua.instance, () -> {
                            switch (event.getRawSlot()) {
                                case 0 -> {
                                    if (data.inventory1 == null) {
                                        if (whoClicked.getScoreboardTags().contains("qkd1")) {
                                            data.inventory1 = SQL.retrievePlayerInventory1(whoClicked);
                                        } else {
                                            whoClicked.sendMessage(Component.translatable("unqkd"));
                                            Yuehua.scheduler.runTask(
                                                    Yuehua.instance, () -> {
                                                        whoClicked.closeInventory();
                                                    }
                                            );
                                            return;
                                        }
                                    }
                                    Yuehua.scheduler.runTask(
                                            Yuehua.instance, () -> whoClicked.openInventory(data.inventory1)
                                    );

                                }
                                case 1 -> {
                                    if (data.inventory2 == null) {
                                        if (whoClicked.getScoreboardTags().contains("qkd2")) {
                                            data.inventory2 = SQL.retrievePlayerInventory2(whoClicked);
                                        } else {
                                            whoClicked.sendMessage(Component.translatable("unqkd"));
                                            Yuehua.scheduler.runTask(
                                                    Yuehua.instance, () -> {
                                                        whoClicked.closeInventory();
                                                    }
                                            );
                                            return;
                                        }
                                    }
                                    Yuehua.scheduler.runTask(
                                            Yuehua.instance, () -> whoClicked.openInventory(data.inventory2)
                                    );
                                }

                                case 2 -> {
                                    if (data.inventory3 == null) {
                                        if (whoClicked.getScoreboardTags().contains("qkd3")) {
                                            data.inventory3 = SQL.retrievePlayerInventory3(whoClicked);
                                        } else {
                                            whoClicked.sendMessage(Component.translatable("unqkd"));
                                            Yuehua.scheduler.runTask(
                                                    Yuehua.instance, () -> {
                                                        whoClicked.closeInventory();
                                                    }
                                            );
                                            return;
                                        }
                                    }
                                    Yuehua.scheduler.runTask(
                                            Yuehua.instance, () -> whoClicked.openInventory(data.inventory3)
                                    );
                                }

                                case 3 -> {
                                    if (data.inventory4 == null) {
                                        if (whoClicked.getScoreboardTags().contains("qkd4")) {
                                            data.inventory4 = SQL.retrievePlayerInventory4(whoClicked);
                                        } else {
                                            whoClicked.sendMessage(Component.translatable("unqkd"));
                                            Yuehua.scheduler.runTask(
                                                    Yuehua.instance, () -> {
                                                        whoClicked.closeInventory();
                                                    }
                                            );
                                            return;
                                        }
                                    }
                                    Yuehua.scheduler.runTask(
                                            Yuehua.instance, () -> whoClicked.openInventory(data.inventory4)
                                    );
                                }

                                case 4 -> {
                                    if (data.inventory5 == null) {

                                        if (whoClicked.getScoreboardTags().contains("qkd5")) {
                                            data.inventory5 = SQL.retrievePlayerInventory5(whoClicked);
                                        } else {
                                            whoClicked.sendMessage(Component.translatable("unqkd"));
                                            Yuehua.scheduler.runTask(
                                                    Yuehua.instance, () -> {
                                                        whoClicked.closeInventory();
                                                    }
                                            );
                                            return;
                                        }
                                    }
                                    Yuehua.scheduler.runTask(
                                            Yuehua.instance, () -> whoClicked.openInventory(data.inventory5)
                                    );
                                }

                                case 5 -> {
                                    if (data.inventory6 == null) {

                                        if (whoClicked.getScoreboardTags().contains("qkd6")) {
                                            data.inventory6 = SQL.retrievePlayerInventory6(whoClicked);
                                        } else {
                                            whoClicked.sendMessage(Component.translatable("unqkd"));
                                            Yuehua.scheduler.runTask(
                                                    Yuehua.instance, () -> {
                                                        whoClicked.closeInventory();
                                                    }
                                            );
                                            return;
                                        }
                                    }
                                    Yuehua.scheduler.runTask(
                                            Yuehua.instance, () -> whoClicked.openInventory(data.inventory6)
                                    );
                                }

                                case 6 -> {
                                    if (data.inventory7 == null) {
                                        if (whoClicked.getScoreboardTags().contains("qkd7")) {
                                            data.inventory7 = SQL.retrievePlayerInventory7(whoClicked);
                                        } else {
                                            whoClicked.sendMessage(Component.translatable("unqkd"));
                                            Yuehua.scheduler.runTask(
                                                    Yuehua.instance, () -> {
                                                        whoClicked.closeInventory();
                                                    }
                                            );
                                            return;
                                        }
                                    }
                                    Yuehua.scheduler.runTask(
                                            Yuehua.instance, () -> whoClicked.openInventory(data.inventory7)
                                    );
                                }

                                case 7 -> {
                                    if (data.inventory8 == null) {
                                        if (whoClicked.getScoreboardTags().contains("qkd8")) {
                                            data.inventory8 = SQL.retrievePlayerInventory8(whoClicked);
                                        } else {
                                            whoClicked.sendMessage(Component.translatable("unqkd"));
                                            Yuehua.scheduler.runTask(
                                                    Yuehua.instance, () -> {
                                                        whoClicked.closeInventory();
                                                    }
                                            );
                                            return;
                                        }
                                    }
                                    Yuehua.scheduler.runTask(
                                            Yuehua.instance, () -> whoClicked.openInventory(data.inventory8)
                                    );
                                }

                                case 8 -> {
                                    if (data.inventory9 == null) {
                                        if (whoClicked.getScoreboardTags().contains("qkd9")) {
                                            data.inventory9 = SQL.retrievePlayerInventory9(whoClicked);
                                        } else {
                                            whoClicked.sendMessage(Component.translatable("unqkd"));
                                            Yuehua.scheduler.runTask(
                                                    Yuehua.instance, () -> {
                                                        whoClicked.closeInventory();
                                                    }
                                            );
                                            return;
                                        }
                                    }
                                    Yuehua.scheduler.runTask(
                                            Yuehua.instance, () -> whoClicked.openInventory(data.inventory9)
                                    );
                                }

                                case 17 -> {
                                    Yuehua.scheduler.runTask(
                                            Yuehua.instance, () -> whoClicked.openInventory(Yh.MAIN_MENU)
                                    );
                                }
                            }


                        }
                );

            }

            case "qkd1", "qkd2", "qkd3", "qkd4", "qkd5", "qkd6", "qkd7", "qkd8", "qkd9" -> {
                if (event.getSlot() == 53) {
                    event.setCancelled(true);
                    Yuehua.scheduler.runTask(Yuehua.instance, () -> {
                        Player whoClicked = (Player) event.getWhoClicked();
                        whoClicked.openInventory(Yh.QIAN_KUN_BAG);
                    });
                }
            }

            case "sp" -> {
                ItemStack item = event.getCurrentItem();
                if(item == null){
                    return;
                }
                switch (item.getType()){
                    case GREEN_DYE -> {
                        event.setCancelled(true);
                        Yuehua.scheduler.runTask(Yuehua.instance, () -> {
                            Player whoClicked = (Player) event.getWhoClicked();
                            whoClicked.openInventory(Yh.MAIN_MENU);
                        });
                    }
                    case YELLOW_DYE -> {
                        event.setCancelled(true);
                        Player whoClicked = (Player) event.getWhoClicked();
                        whoClicked.sendMessage(Component.translatable("unsp"));
                        Yuehua.scheduler.runTask(
                                Yuehua.instance, () -> {
                                    whoClicked.closeInventory();
                                }
                        );
                    }
                    case WOODEN_PICKAXE -> {
                    }
                    default -> {
                        event.setCancelled(true);
                        Player whoClicked = (Player) event.getWhoClicked();
                        Yuehua.scheduler.runTask(
                                Yuehua.instance, () -> {
                                    whoClicked.sendMessage(Component.translatable("unother"));
                                    whoClicked.closeInventory();
                                }
                        );
                    }
                }
            }

        }


    }
}
