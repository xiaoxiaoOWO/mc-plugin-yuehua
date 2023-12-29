package com.xiaoxiaoowo.yuehua.commands.playercommand;

import com.xiaoxiaoowo.yuehua.Yuehua;
import com.xiaoxiaoowo.yuehua.data.Data;
import com.xiaoxiaoowo.yuehua.data.GongData;
import com.xiaoxiaoowo.yuehua.itemstack.other.Other;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public final class ArrowCMD implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        Data data = Yuehua.playerData.get(player.getUniqueId());
        Yuehua.scheduler.runTaskAsynchronously(
                Yuehua.instance, () -> {
                    if (args.length == 0) {
                        player.sendMessage(
                                Component.translatable("badarg")
                        );
                        return;
                    }
                    if (data.job != 2) {
                        player.sendMessage(
                                Component.translatable("notgong")
                        );
                        return;
                    }
                    GongData gongData = (GongData) data;
                    switch (args[0].toLowerCase()) {
                        case "get" -> {
                            if (args.length != 2) {
                                player.sendMessage(
                                        Component.translatable("badarg")
                                );
                                return;
                            }
                            int amount = Integer.parseInt(args[1]);
                            if (amount <= 0) {
                                player.sendMessage(
                                        Component.translatable("badarg")
                                );
                                return;
                            }

                            if (amount > 1280) {
                                player.sendMessage(
                                        Component.translatable("toomucharrow")
                                );
                                return;
                            }


                            if (amount > gongData.arrow_count) {
                                player.sendMessage(
                                        Component.translatable("lackarrow").appendNewline()
                                                .append(Component.translatable("arrowcount",
                                                                Component.text(gongData.arrow_count).color(NamedTextColor.AQUA)
                                                        )
                                                )
                                );
                                return;
                            }
                            gongData.arrow_count -= amount;
                            player.sendMessage(
                                    Component.translatable("arrowcount",
                                            Component.text(gongData.arrow_count).color(NamedTextColor.AQUA)
                                    )
                            );

                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    ItemStack arrow = Other.ARROW;
                                    arrow.setAmount(amount);
                                    player.getInventory().addItem(arrow);
                                }
                            }.runTask(Yuehua.instance);


                        }

                        case "store" -> {
                            if (args.length != 2) {
                                player.sendMessage(
                                        Component.translatable("badarg")
                                );
                                return;
                            }
                            int amount = Integer.parseInt(args[1]);
                            if (amount <= 0) {
                                player.sendMessage(
                                        Component.translatable("badarg")
                                );
                                return;
                            }
                            if (amount > 1280) {
                                player.sendMessage(
                                        Component.translatable("toomucharrow")
                                );
                                return;
                            }

                            int arrow_count = gongData.arrow_count;
                            int total = amount + arrow_count;
                            if (total > gongData.arrow_count_max) {
                                player.sendMessage(
                                        Component.translatable("lackcapacity").appendNewline()
                                                .append(Component.translatable("capacity",
                                                        Component.text(gongData.arrow_count_max).color(NamedTextColor.AQUA))
                                                ).appendNewline().
                                                append(Component.translatable("leftcapacity",
                                                        Component.text(gongData.arrow_count_max - gongData.arrow_count).color(NamedTextColor.AQUA)))
                                );
                                return;
                            }

                            PlayerInventory playerInventory = player.getInventory();
                            int count = 0;
                            Collection<ItemStack> itemStacks = (Collection<ItemStack>) playerInventory.all(Material.ARROW).values();

                            for (ItemStack itemStack : itemStacks) {
                                count += itemStack.getAmount();
                            }

                            if (count < amount) {
                                player.sendMessage(
                                        Component.translatable("lessarrow")
                                );
                                return;
                            }
                            int inamout = amount;


                            for (ItemStack itemStack : itemStacks) {
                                int amoutNow = itemStack.getAmount();
                                if (inamout > amoutNow) {
                                    inamout -= amoutNow;
                                    itemStack.setAmount(0);
                                } else {
                                    itemStack.setAmount(amoutNow - inamout);
                                    break;
                                }
                            }

                            gongData.arrow_count = total;
                            player.sendMessage(
                                    Component.translatable("arrowcount",
                                            Component.text(gongData.arrow_count).color(NamedTextColor.AQUA)
                                    )
                            );


                        }

                        case "check" -> {
                            if (args.length != 1) {
                                player.sendMessage(
                                        Component.translatable("badarg")
                                );
                                return;
                            }
                            player.sendMessage(
                                    Component.translatable("arrowcount", Component.text(gongData.arrow_count).color(NamedTextColor.AQUA))
                                            .appendNewline()
                                            .append(Component.translatable("capacity", Component.text(gongData.arrow_count_max).color(NamedTextColor.AQUA))
                                            ));


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
