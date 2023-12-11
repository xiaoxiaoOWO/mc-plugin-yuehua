package com.xiaoxiaoowo.yuehua.event.Inventory;

import com.xiaoxiaoowo.yuehua.Yuehua;
import com.xiaoxiaoowo.yuehua.data.Data;
import com.xiaoxiaoowo.yuehua.system.Act;
import com.xiaoxiaoowo.yuehua.system.DataContainer;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

public final class Close implements Listener {
    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        Inventory inventory = event.getInventory();
        //是否为末影箱
        if (inventory.getType() != InventoryType.ENDER_CHEST) {
            return;
        }

        new BukkitRunnable() {
            @Override
            public void run() {
                Player player = (Player) event.getPlayer();
                Data data = Yuehua.playerData.get(player.getUniqueId());
                ItemStack item0 = inventory.getItem(0);
                ItemStack item1 = inventory.getItem(1);
                ItemStack item2 = inventory.getItem(2);
                ItemStack item3 = inventory.getItem(3);
                ItemStack item4 = inventory.getItem(4);
                ItemStack item5 = inventory.getItem(5);
                ItemStack item6 = inventory.getItem(6);
                ItemStack item7 = inventory.getItem(7);
                ItemStack item8 = inventory.getItem(8);
                ItemStack item9 = inventory.getItem(9);
                ItemStack item10 = inventory.getItem(10);


                if (Objects.equals(data.eSlot0.id, "null")) {
                    if (item0 != null && item0.getType() == Material.WOODEN_PICKAXE) {
                        PersistentDataContainer pdc = item0.getPersistentDataContainer();
                        if (0 == pdc.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                            Act.actAll(player, data, pdc.get(DataContainer.id, PersistentDataType.STRING));
                        }
                    }
                } else {
                    if (item0 != null && item0.getType() == Material.WOODEN_PICKAXE) {
                        PersistentDataContainer pdc = item0.getPersistentDataContainer();
                        if (0 == pdc.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                            String id = pdc.get(DataContainer.id, PersistentDataType.STRING);
                            if (!Objects.equals(id, data.eSlot0.id)) {
                                Act.deActAll(player, data, data.eSlot0.id);
                                Act.actAll(player, data, id);
                            }
                        } else {
                            Act.deActAll(player, data, data.eSlot0.id);
                        }
                    } else {
                        Act.deActAll(player, data, data.eSlot0.id);
                    }
                }

                if (Objects.equals(data.eSlot1.id, "null")) {
                    if (item1 != null && item1.getType() == Material.WOODEN_PICKAXE) {
                        PersistentDataContainer pdc = item1.getPersistentDataContainer();
                        if (1 == pdc.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                            Act.actAll(player, data, pdc.get(DataContainer.id, PersistentDataType.STRING));
                        }
                    }
                } else {
                    if (item1 != null && item1.getType() == Material.WOODEN_PICKAXE) {
                        PersistentDataContainer pdc = item1.getPersistentDataContainer();
                        if (1 == pdc.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                            String id = pdc.get(DataContainer.id, PersistentDataType.STRING);
                            if (!Objects.equals(id, data.eSlot1.id)) {
                                Act.deActAll(player, data, data.eSlot1.id);
                                Act.actAll(player, data, id);
                            }
                        } else {
                            Act.deActAll(player, data, data.eSlot1.id);
                        }
                    } else {
                        Act.deActAll(player, data, data.eSlot1.id);
                    }
                }

                if (Objects.equals(data.eSlot2.id, "null")) {
                    if (item2 != null && item2.getType() == Material.WOODEN_PICKAXE) {
                        PersistentDataContainer pdc = item2.getPersistentDataContainer();
                        if (2 == pdc.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                            Act.actAll(player, data, pdc.get(DataContainer.id, PersistentDataType.STRING));
                        }
                    }
                } else {
                    if (item2 != null && item2.getType() == Material.WOODEN_PICKAXE) {
                        PersistentDataContainer pdc = item2.getPersistentDataContainer();
                        if (2 == pdc.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                            String id = pdc.get(DataContainer.id, PersistentDataType.STRING);
                            if (!Objects.equals(id, data.eSlot2.id)) {
                                Act.deActAll(player, data, data.eSlot2.id);
                                Act.actAll(player, data, id);
                            }
                        } else {
                            Act.deActAll(player, data, data.eSlot2.id);
                        }
                    } else {
                        Act.deActAll(player, data, data.eSlot2.id);
                    }
                }

                if (Objects.equals(data.eSlot3.id, "null")) {
                    if (item3 != null && item3.getType() == Material.WOODEN_PICKAXE) {
                        PersistentDataContainer pdc = item3.getPersistentDataContainer();
                        if (3 == pdc.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                            Act.actAll(player, data, pdc.get(DataContainer.id, PersistentDataType.STRING));
                        }
                    }
                } else {
                    if (item3 != null && item3.getType() == Material.WOODEN_PICKAXE) {
                        PersistentDataContainer pdc = item3.getPersistentDataContainer();
                        if (3 == pdc.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                            String id = pdc.get(DataContainer.id, PersistentDataType.STRING);
                            if (!Objects.equals(id, data.eSlot3.id)) {
                                Act.deActAll(player, data, data.eSlot3.id);
                                Act.actAll(player, data, id);
                            }
                        } else {
                            Act.deActAll(player, data, data.eSlot3.id);
                        }
                    } else {
                        Act.deActAll(player, data, data.eSlot3.id);
                    }
                }

                if (Objects.equals(data.eSlot4.id, "null")) {
                    if (item4 != null && item4.getType() == Material.WOODEN_PICKAXE) {
                        PersistentDataContainer pdc = item4.getPersistentDataContainer();
                        if (4 == pdc.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                            Act.actAll(player, data, pdc.get(DataContainer.id, PersistentDataType.STRING));
                        }
                    }
                } else {
                    if (item4 != null && item4.getType() == Material.WOODEN_PICKAXE) {
                        PersistentDataContainer pdc = item4.getPersistentDataContainer();
                        if (4 == pdc.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                            String id = pdc.get(DataContainer.id, PersistentDataType.STRING);
                            if (!Objects.equals(id, data.eSlot4.id)) {
                                Act.deActAll(player, data, data.eSlot4.id);
                                Act.actAll(player, data, id);
                            }
                        } else {
                            Act.deActAll(player, data, data.eSlot4.id);
                        }
                    } else {
                        Act.deActAll(player, data, data.eSlot4.id);
                    }
                }

                if (Objects.equals(data.eSlot5.id, "null")) {
                    if (item5 != null && item5.getType() == Material.WOODEN_PICKAXE) {
                        PersistentDataContainer pdc = item5.getPersistentDataContainer();
                        if (5 == pdc.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                            Act.actAll(player, data, pdc.get(DataContainer.id, PersistentDataType.STRING));
                        }
                    }
                } else {
                    if (item5 != null && item5.getType() == Material.WOODEN_PICKAXE) {
                        PersistentDataContainer pdc = item5.getPersistentDataContainer();
                        if (5 == pdc.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                            String id = pdc.get(DataContainer.id, PersistentDataType.STRING);
                            if (!Objects.equals(id, data.eSlot5.id)) {
                                Act.deActAll(player, data, data.eSlot5.id);
                                Act.actAll(player, data, id);
                            }
                        } else {
                            Act.deActAll(player, data, data.eSlot5.id);
                        }
                    } else {
                        Act.deActAll(player, data, data.eSlot5.id);
                    }
                }

                if (Objects.equals(data.eSlot6.id, "null")) {
                    if (item6 != null && item6.getType() == Material.WOODEN_PICKAXE) {
                        PersistentDataContainer pdc = item6.getPersistentDataContainer();
                        if (6 == pdc.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                            Act.actAll(player, data, pdc.get(DataContainer.id, PersistentDataType.STRING));
                        }
                    }
                } else {
                    if (item6 != null && item6.getType() == Material.WOODEN_PICKAXE) {
                        PersistentDataContainer pdc = item6.getPersistentDataContainer();
                        if (6 == pdc.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                            String id = pdc.get(DataContainer.id, PersistentDataType.STRING);
                            if (!Objects.equals(id, data.eSlot6.id)) {
                                Act.deActAll(player, data, data.eSlot6.id);
                                Act.actAll(player, data, id);
                            }
                        } else {
                            Act.deActAll(player, data, data.eSlot6.id);
                        }
                    } else {
                        Act.deActAll(player, data, data.eSlot6.id);
                    }
                }

                if (Objects.equals(data.eSlot7.id, "null")) {
                    if (item7 != null && item7.getType() == Material.WOODEN_PICKAXE) {
                        PersistentDataContainer pdc = item7.getPersistentDataContainer();
                        if (7 == pdc.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                            Act.actAll(player, data, pdc.get(DataContainer.id, PersistentDataType.STRING));
                        }
                    }
                } else {
                    if (item7 != null && item7.getType() == Material.WOODEN_PICKAXE) {
                        PersistentDataContainer pdc = item7.getPersistentDataContainer();
                        if (7 == pdc.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                            String id = pdc.get(DataContainer.id, PersistentDataType.STRING);
                            if (!Objects.equals(id, data.eSlot7.id)) {
                                Act.deActAll(player, data, data.eSlot7.id);
                                Act.actAll(player, data, id);
                            }
                        } else {
                            Act.deActAll(player, data, data.eSlot7.id);
                        }
                    } else {
                        Act.deActAll(player, data, data.eSlot7.id);
                    }
                }

                if (Objects.equals(data.eSlot8.id, "null")) {
                    if (item8 != null && item8.getType() == Material.WOODEN_PICKAXE) {
                        PersistentDataContainer pdc = item8.getPersistentDataContainer();
                        if (8 == pdc.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                            Act.actAll(player, data, pdc.get(DataContainer.id, PersistentDataType.STRING));
                        }
                    }
                } else {
                    if (item8 != null && item8.getType() == Material.WOODEN_PICKAXE) {
                        PersistentDataContainer pdc = item8.getPersistentDataContainer();
                        if (8 == pdc.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                            String id = pdc.get(DataContainer.id, PersistentDataType.STRING);
                            if (!Objects.equals(id, data.eSlot8.id)) {
                                Act.deActAll(player, data, data.eSlot8.id);
                                Act.actAll(player, data, id);
                            }
                        } else {
                            Act.deActAll(player, data, data.eSlot8.id);
                        }
                    } else {
                        Act.deActAll(player, data, data.eSlot8.id);
                    }
                }

                if (Objects.equals(data.eSlot9.id, "null")) {
                    if (item9 != null && item9.getType() == Material.WOODEN_PICKAXE) {
                        PersistentDataContainer pdc = item9.getPersistentDataContainer();
                        if (9 == pdc.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                            Act.actAll(player, data, pdc.get(DataContainer.id, PersistentDataType.STRING));
                        }
                    }
                } else {
                    if (item9 != null && item9.getType() == Material.WOODEN_PICKAXE) {
                        PersistentDataContainer pdc = item9.getPersistentDataContainer();
                        if (9 == pdc.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                            String id = pdc.get(DataContainer.id, PersistentDataType.STRING);
                            if (!Objects.equals(id, data.eSlot9.id)) {
                                Act.deActAll(player, data, data.eSlot9.id);
                                Act.actAll(player, data, id);
                            }
                        } else {
                            Act.deActAll(player, data, data.eSlot9.id);
                        }
                    } else {
                        Act.deActAll(player, data, data.eSlot9.id);
                    }
                }

                if (Objects.equals(data.eSlot10.id, "null")) {
                    if (item10 != null && item10.getType() == Material.WOODEN_PICKAXE) {
                        PersistentDataContainer pdc = item10.getPersistentDataContainer();
                        if (10 == pdc.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                            Act.actAll(player, data, pdc.get(DataContainer.id, PersistentDataType.STRING));
                        }
                    }
                } else {
                    if (item10 != null && item10.getType() == Material.WOODEN_PICKAXE) {
                        PersistentDataContainer pdc = item10.getPersistentDataContainer();
                        if (10 == pdc.get(DataContainer.slot, PersistentDataType.INTEGER)) {
                            String id = pdc.get(DataContainer.id, PersistentDataType.STRING);
                            if (!Objects.equals(id, data.eSlot10.id)) {
                                Act.deActAll(player, data, data.eSlot10.id);
                                Act.actAll(player, data, id);
                            }
                        } else {
                            Act.deActAll(player, data, data.eSlot10.id);
                        }
                    } else {
                        Act.deActAll(player, data, data.eSlot10.id);
                    }
                }


            }
        }.runTaskAsynchronously(Yuehua.instance);
    }
}
