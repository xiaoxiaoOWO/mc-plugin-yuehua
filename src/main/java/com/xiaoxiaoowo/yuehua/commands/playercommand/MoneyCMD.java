package com.xiaoxiaoowo.yuehua.commands.playercommand;

import com.xiaoxiaoowo.yuehua.Yuehua;
import com.xiaoxiaoowo.yuehua.data.Data;
import com.xiaoxiaoowo.yuehua.itemstack.other.Money;
import com.xiaoxiaoowo.yuehua.system.DataContainer;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class  MoneyCMD implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        Data data = Yuehua.playerData.get(player.getUniqueId());
        Yuehua.scheduler.runTaskAsynchronously(
                Yuehua.instance,() -> {
                    if (args.length == 0) {
                        player.sendMessage(
                                Component.translatable("badarg")
                        );
                        return;
                    }
                    switch (args[0].toLowerCase()){
                        case "get" -> {
                            if (args.length != 3) {
                                player.sendMessage(
                                        Component.translatable("badarg")
                                );
                                return;
                            }

                            int amount = Integer.parseInt(args[2]);
                            if (amount <= 0) {
                                player.sendMessage(
                                        Component.translatable("badarg")
                                );
                                return;
                            }
                            if (amount > 2560) {
                                player.sendMessage(
                                        Component.translatable("toomuchmoney")
                                );
                                return;
                            }

                            switch (args[1].toLowerCase()){
                                case "铜钱" -> {
                                    if (amount > data.money) {
                                        player.sendMessage(
                                                Component.translatable("lackmoney").appendNewline()
                                                        .append(Component.translatable("moneycount",
                                                                        Component.text(data.money).color(NamedTextColor.AQUA)
                                                                )
                                                        )
                                        );
                                        return;
                                    }
                                    data.money -= amount;
                                    player.sendMessage(
                                            Component.translatable("moneycount",
                                                    Component.text(data.money).color(NamedTextColor.AQUA)
                                            )
                                    );

                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            ItemStack tongQian = Money.tongQian;
                                            tongQian.setAmount(amount);
                                            player.getInventory().addItem(tongQian);
                                        }
                                    }.runTask(Yuehua.instance);
                                }

                                case "金元宝" -> {
                                    int newAmount = amount * 10;
                                    if (newAmount > data.money) {
                                        player.sendMessage(
                                                Component.translatable("lackmoney").appendNewline()
                                                        .append(Component.translatable("moneycount",
                                                                        Component.text(data.money).color(NamedTextColor.AQUA)
                                                                )
                                                        )
                                        );
                                        return;
                                    }
                                    data.money -= newAmount;
                                    player.sendMessage(
                                            Component.translatable("moneycount",
                                                    Component.text(data.money).color(NamedTextColor.AQUA)
                                            )
                                    );

                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            ItemStack jinYuanBao = Money.jinYuanBao;
                                            jinYuanBao.setAmount(amount);
                                            player.getInventory().addItem(jinYuanBao);
                                        }
                                    }.runTask(Yuehua.instance);

                                }

                                case "银票" -> {
                                    int newAmount = amount * 100;
                                    if (newAmount > data.money) {
                                        player.sendMessage(
                                                Component.translatable("lackmoney").appendNewline()
                                                        .append(Component.translatable("moneycount",
                                                                        Component.text(data.money).color(NamedTextColor.AQUA)
                                                                )
                                                        )
                                        );
                                        return;
                                    }
                                    data.money -= newAmount;
                                    player.sendMessage(
                                            Component.translatable("moneycount",
                                                    Component.text(data.money).color(NamedTextColor.AQUA)
                                            )
                                    );

                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            ItemStack yinPiao = Money.yinPiao;
                                            yinPiao.setAmount(amount);
                                            player.getInventory().addItem(yinPiao);
                                        }
                                    }.runTask(Yuehua.instance);

                                }

                                case "翡翠" -> {

                                    int newAmount = amount * 1000;
                                    if (newAmount > data.money) {
                                        player.sendMessage(
                                                Component.translatable("lackmoney").appendNewline()
                                                        .append(Component.translatable("moneycount",
                                                                        Component.text(data.money).color(NamedTextColor.AQUA)
                                                                )
                                                        )
                                        );
                                        return;
                                    }
                                    data.money -= newAmount;
                                    player.sendMessage(
                                            Component.translatable("moneycount",
                                                    Component.text(data.money).color(NamedTextColor.AQUA)
                                            )
                                    );

                                    new BukkitRunnable() {
                                        @Override
                                        public void run() {
                                            ItemStack feiCui = Money.feiCui;
                                            feiCui.setAmount(amount);
                                            player.getInventory().addItem(feiCui);
                                        }
                                    }.runTask(Yuehua.instance);
                                }

                                default -> player.sendMessage(
                                        Component.translatable("badarg")
                                );
                            }


                        }
                        case "store" -> {

                            if (args.length != 3) {
                                player.sendMessage(
                                        Component.translatable("badarg")
                                );
                                return;
                            }

                            int amount = Integer.parseInt(args[2]);
                            if (amount <= 0) {
                                player.sendMessage(
                                        Component.translatable("badarg")
                                );
                                return;
                            }
                            if (amount > 2560) {
                                player.sendMessage(
                                        Component.translatable("toomuchmoney")
                                );
                                return;
                            }

                            switch (args[1].toLowerCase()){
                                case "铜钱" -> {
                                    PlayerInventory playerInventory = player.getInventory();
                                    ItemStack[] itemStacks = playerInventory.getContents();
                                    int count = 0;
                                    int length = itemStacks.length;
                                    List<Integer> slots = new ArrayList<>(length);
                                    for (int i = 0; i < length; i++) {
                                        ItemStack itemStack = itemStacks[i];
                                        if (itemStack == null) {
                                            continue;
                                        }
                                        if (itemStack.getType() != Material.BRICK) {
                                            continue;
                                        }
                                        if (!Objects.equals(itemStack.getPersistentDataContainer().get(DataContainer.id, PersistentDataType.STRING), "tongQian")) {
                                            continue;
                                        }
                                        slots.add(i);
                                        count += itemStack.getAmount();
                                    }

                                    if (count < amount) {
                                        player.sendMessage(
                                                Component.translatable("lessmoney")
                                        );
                                        return;
                                    }
                                    int inamout = amount;


                                    for (int slot : slots) {
                                        ItemStack itemStack = itemStacks[slot];
                                        int amoutNow = itemStack.getAmount();
                                        if (inamout > amoutNow) {
                                            inamout -= amoutNow;
                                            itemStack.setAmount(0);
                                        } else {
                                            itemStack.setAmount(amoutNow - inamout);
                                            break;
                                        }
                                    }

                                    data.money += amount;
                                    player.sendMessage(
                                            Component.translatable("moneycount",
                                                    Component.text(data.money).color(NamedTextColor.AQUA)
                                            )
                                    );
                                }

                                case "金元宝" -> {
                                    PlayerInventory playerInventory = player.getInventory();
                                    ItemStack[] itemStacks = playerInventory.getContents();
                                    int count = 0;
                                    int length = itemStacks.length;
                                    List<Integer> slots = new ArrayList<>(length);
                                    for (int i = 0; i < length; i++) {
                                        ItemStack itemStack = itemStacks[i];
                                        if (itemStack == null) {
                                            continue;
                                        }
                                        if (itemStack.getType() != Material.BRICK) {
                                            continue;
                                        }
                                        if (!Objects.equals(itemStack.getPersistentDataContainer().get(DataContainer.id, PersistentDataType.STRING), "jinYuanBao")) {
                                            continue;
                                        }
                                        slots.add(i);
                                        count += itemStack.getAmount();
                                    }

                                    if (count < amount) {
                                        player.sendMessage(
                                                Component.translatable("lessmoney")
                                        );
                                        return;
                                    }
                                    int inamout = amount;


                                    for (int slot : slots) {
                                        ItemStack itemStack = itemStacks[slot];
                                        int amoutNow = itemStack.getAmount();
                                        if (inamout > amoutNow) {
                                            inamout -= amoutNow;
                                            itemStack.setAmount(0);
                                        } else {
                                            itemStack.setAmount(amoutNow - inamout);
                                            break;
                                        }
                                    }

                                    data.money += amount * 10;
                                    player.sendMessage(
                                            Component.translatable("moneycount",
                                                    Component.text(data.money).color(NamedTextColor.AQUA)
                                            )
                                    );

                                }

                                case "银票" -> {
                                    PlayerInventory playerInventory = player.getInventory();
                                    ItemStack[] itemStacks = playerInventory.getContents();
                                    int count = 0;
                                    int length = itemStacks.length;
                                    List<Integer> slots = new ArrayList<>(length);
                                    for (int i = 0; i < length; i++) {
                                        ItemStack itemStack = itemStacks[i];
                                        if (itemStack == null) {
                                            continue;
                                        }
                                        if (itemStack.getType() != Material.BRICK) {
                                            continue;
                                        }
                                        if (!Objects.equals(itemStack.getPersistentDataContainer().get(DataContainer.id, PersistentDataType.STRING), "yinPiao")) {
                                            continue;
                                        }
                                        slots.add(i);
                                        count += itemStack.getAmount();
                                    }

                                    if (count < amount) {
                                        player.sendMessage(
                                                Component.translatable("lessmoney")
                                        );
                                        return;
                                    }
                                    int inamout = amount;


                                    for (int slot : slots) {
                                        ItemStack itemStack = itemStacks[slot];
                                        int amoutNow = itemStack.getAmount();
                                        if (inamout > amoutNow) {
                                            inamout -= amoutNow;
                                            itemStack.setAmount(0);
                                        } else {
                                            itemStack.setAmount(amoutNow - inamout);
                                            break;
                                        }
                                    }

                                    data.money += amount * 100;
                                    player.sendMessage(
                                            Component.translatable("moneycount",
                                                    Component.text(data.money).color(NamedTextColor.AQUA)
                                            )
                                    );


                                }

                                case "翡翠" -> {
                                    PlayerInventory playerInventory = player.getInventory();
                                    ItemStack[] itemStacks = playerInventory.getContents();
                                    int count = 0;
                                    int length = itemStacks.length;
                                    List<Integer> slots = new ArrayList<>(length);
                                    for (int i = 0; i < length; i++) {
                                        ItemStack itemStack = itemStacks[i];
                                        if (itemStack == null) {
                                            continue;
                                        }
                                        if (itemStack.getType() != Material.BRICK) {
                                            continue;
                                        }
                                        if (!Objects.equals(itemStack.getPersistentDataContainer().get(DataContainer.id, PersistentDataType.STRING), "feiCui")) {
                                            continue;
                                        }
                                        slots.add(i);
                                        count += itemStack.getAmount();
                                    }

                                    if (count < amount) {
                                        player.sendMessage(
                                                Component.translatable("lessmoney")
                                        );
                                        return;
                                    }
                                    int inamout = amount;


                                    for (int slot : slots) {
                                        ItemStack itemStack = itemStacks[slot];
                                        int amoutNow = itemStack.getAmount();
                                        if (inamout > amoutNow) {
                                            inamout -= amoutNow;
                                            itemStack.setAmount(0);
                                        } else {
                                            itemStack.setAmount(amoutNow - inamout);
                                            break;
                                        }
                                    }

                                    data.money += amount * 1000;
                                    player.sendMessage(
                                            Component.translatable("moneycount",
                                                    Component.text(data.money).color(NamedTextColor.AQUA)
                                            )
                                    );

                                }

                                default -> player.sendMessage(
                                        Component.translatable("badarg")
                                );
                            }


                        }
                        case "check" -> {
                            if (args.length != 1) {
                                player.sendMessage(
                                        Component.translatable("badarg")
                                );
                                return;
                            }
                            player.sendMessage(
                                    Component.translatable("moneycount", Component.text(data.money).color(NamedTextColor.AQUA)));
                        }

                        default -> player.sendMessage(
                                Component.translatable("badarg")
                        );
                    }
                }
        );


        return true;
    }
}
