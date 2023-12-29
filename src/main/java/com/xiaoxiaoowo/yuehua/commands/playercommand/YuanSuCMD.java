package com.xiaoxiaoowo.yuehua.commands.playercommand;

import com.xiaoxiaoowo.yuehua.Yuehua;
import com.xiaoxiaoowo.yuehua.data.Data;
import com.xiaoxiaoowo.yuehua.itemstack.dz.YuanSu;
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

public final class YuanSuCMD implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        Data data = Yuehua.playerData.get(player.getUniqueId());
        new BukkitRunnable() {
            @Override
            public void run() {
                if (args.length == 0) {
                    player.sendMessage(
                            Component.translatable("badarg")
                    );
                    return;
                }


                switch (args[0].toLowerCase()) {
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
                                    Component.translatable("toomuchyuansu")
                            );
                            return;
                        }
                        switch (args[1]) {
                            case "金" -> {
                                if (amount > data.jinCount) {
                                    player.sendMessage(
                                            Component.translatable("lackyuansu").appendNewline()
                                                    .append(Component.translatable("jincount",
                                                                    Component.text(data.jinCount).color(NamedTextColor.AQUA)
                                                            )
                                                    )
                                    );
                                    return;
                                }
                                data.jinCount -= amount;
                                player.sendMessage(
                                        Component.translatable("jincount",
                                                Component.text(data.jinCount).color(NamedTextColor.AQUA)
                                        )
                                );

                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        ItemStack jin = YuanSu.jin;
                                        jin.setAmount(amount);
                                        player.getInventory().addItem(jin);
                                    }
                                }.runTask(Yuehua.instance);
                            }
                            case "木" -> {
                                if (amount > data.muCount) {
                                    player.sendMessage(
                                            Component.translatable("lackyuansu").appendNewline()
                                                    .append(Component.translatable("mucount",
                                                                    Component.text(data.muCount).color(NamedTextColor.AQUA)
                                                            )
                                                    )
                                    );
                                    return;
                                }
                                data.muCount -= amount;
                                player.sendMessage(
                                        Component.translatable("mucount",
                                                Component.text(data.muCount).color(NamedTextColor.AQUA)
                                        )
                                );
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        ItemStack mu = YuanSu.mu;
                                        mu.setAmount(amount);
                                        player.getInventory().addItem(mu);
                                    }
                                }.runTask(Yuehua.instance);
                            }
                            case "水" -> {
                                if (amount > data.shuiCount) {
                                    player.sendMessage(
                                            Component.translatable("lackyuansu").appendNewline()
                                                    .append(Component.translatable("shuicount",
                                                                    Component.text(data.shuiCount).color(NamedTextColor.AQUA)
                                                            )
                                                    )
                                    );
                                    return;
                                }
                                data.shuiCount -= amount;
                                player.sendMessage(
                                        Component.translatable("shuicount",
                                                Component.text(data.shuiCount).color(NamedTextColor.AQUA)
                                        )
                                );
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        ItemStack shui = YuanSu.shui;
                                        shui.setAmount(amount);
                                        player.getInventory().addItem(shui);
                                    }
                                }.runTask(Yuehua.instance);
                            }
                            case "火" -> {
                                if (amount > data.huoCount) {
                                    player.sendMessage(
                                            Component.translatable("lackyuansu").appendNewline()
                                                    .append(Component.translatable("huocount",
                                                                    Component.text(data.huoCount).color(NamedTextColor.AQUA)
                                                            )
                                                    )
                                    );
                                    return;
                                }
                                data.huoCount -= amount;
                                player.sendMessage(
                                        Component.translatable("huocount",
                                                Component.text(data.huoCount).color(NamedTextColor.AQUA)
                                        )
                                );
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        ItemStack huo = YuanSu.huo;
                                        huo.setAmount(amount);
                                        player.getInventory().addItem(huo);
                                    }
                                }.runTask(Yuehua.instance);
                            }
                            case "土" -> {
                                if (amount > data.tuCount) {
                                    player.sendMessage(
                                            Component.translatable("lackyuansu").appendNewline()
                                                    .append(Component.translatable("tucount",
                                                                    Component.text(data.tuCount).color(NamedTextColor.AQUA)
                                                            )
                                                    )
                                    );
                                    return;
                                }
                                data.tuCount -= amount;
                                player.sendMessage(
                                        Component.translatable("tucount",
                                                Component.text(data.tuCount).color(NamedTextColor.AQUA)
                                        )
                                );
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        ItemStack tu = YuanSu.tu;
                                        tu.setAmount(amount);
                                        player.getInventory().addItem(tu);
                                    }
                                }.runTask(Yuehua.instance);
                            }
                            case "精炼金" -> {
                                if (amount > data.refinedJinCount) {
                                    player.sendMessage(
                                            Component.translatable("lackyuansu").appendNewline()
                                                    .append(Component.translatable("rjincount",
                                                                    Component.text(data.refinedJinCount).color(NamedTextColor.AQUA)
                                                            )
                                                    )
                                    );
                                    return;
                                }
                                data.refinedJinCount -= amount;
                                player.sendMessage(
                                        Component.translatable("rjincount",
                                                Component.text(data.refinedJinCount).color(NamedTextColor.AQUA)
                                        )
                                );
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        ItemStack refinedJin = YuanSu.refined_jin;
                                        refinedJin.setAmount(amount);
                                        player.getInventory().addItem(refinedJin);
                                    }
                                }.runTask(Yuehua.instance);

                            }
                            case "精炼木" -> {
                                if (amount > data.refinedMuCount) {
                                    player.sendMessage(
                                            Component.translatable("lackyuansu").appendNewline()
                                                    .append(Component.translatable("rmucount",
                                                                    Component.text(data.refinedMuCount).color(NamedTextColor.AQUA)
                                                            )
                                                    )
                                    );
                                    return;
                                }
                                data.refinedMuCount -= amount;
                                player.sendMessage(
                                        Component.translatable("rmucount",
                                                Component.text(data.refinedMuCount).color(NamedTextColor.AQUA)
                                        )
                                );
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        ItemStack refinedMu = YuanSu.refined_mu;
                                        refinedMu.setAmount(amount);
                                        player.getInventory().addItem(refinedMu);
                                    }
                                }.runTask(Yuehua.instance);
                            }
                            case "精炼水" -> {
                                if (amount > data.refinedShuiCount) {
                                    player.sendMessage(
                                            Component.translatable("lackyuansu").appendNewline()
                                                    .append(Component.translatable("rshuicount",
                                                                    Component.text(data.refinedShuiCount).color(NamedTextColor.AQUA)
                                                            )
                                                    )
                                    );
                                    return;
                                }
                                data.refinedShuiCount -= amount;
                                player.sendMessage(
                                        Component.translatable("rshuicount",
                                                Component.text(data.refinedShuiCount).color(NamedTextColor.AQUA)
                                        )
                                );
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        ItemStack refinedShui = YuanSu.refined_shui;
                                        refinedShui.setAmount(amount);
                                        player.getInventory().addItem(refinedShui);
                                    }
                                }.runTask(Yuehua.instance);
                            }
                            case "精炼火" -> {
                                if (amount > data.refinedHuoCount) {
                                    player.sendMessage(
                                            Component.translatable("lackyuansu").appendNewline()
                                                    .append(Component.translatable("rhuocount",
                                                                    Component.text(data.refinedHuoCount).color(NamedTextColor.AQUA)
                                                            )
                                                    )
                                    );
                                    return;
                                }
                                data.refinedHuoCount -= amount;
                                player.sendMessage(
                                        Component.translatable("rhuocount",
                                                Component.text(data.refinedHuoCount).color(NamedTextColor.AQUA)
                                        )
                                );
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        ItemStack refinedHuo = YuanSu.refined_huo;
                                        refinedHuo.setAmount(amount);
                                        player.getInventory().addItem(refinedHuo);
                                    }
                                }.runTask(Yuehua.instance);
                            }
                            case "精炼土" -> {
                                if (amount > data.refinedTuCount) {
                                    player.sendMessage(
                                            Component.translatable("lackyuansu").appendNewline()
                                                    .append(Component.translatable("rtucount",
                                                                    Component.text(data.refinedTuCount).color(NamedTextColor.AQUA)
                                                            )
                                                    )
                                    );
                                    return;
                                }
                                data.refinedTuCount -= amount;
                                player.sendMessage(
                                        Component.translatable("rtucount",
                                                Component.text(data.refinedTuCount).color(NamedTextColor.AQUA)
                                        )
                                );
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        ItemStack refinedTu = YuanSu.refined_tu;
                                        refinedTu.setAmount(amount);
                                        player.getInventory().addItem(refinedTu);
                                    }
                                }.runTask(Yuehua.instance);
                            }
                            case "浓缩金" -> {
                                if (amount > data.concentratedJinCount) {
                                    player.sendMessage(
                                            Component.translatable("lackyuansu").appendNewline()
                                                    .append(Component.translatable("cjincount",
                                                                    Component.text(data.concentratedJinCount).color(NamedTextColor.AQUA)
                                                            )
                                                    )
                                    );
                                    return;
                                }
                                data.concentratedJinCount -= amount;
                                player.sendMessage(
                                        Component.translatable("cjincount",
                                                Component.text(data.concentratedJinCount).color(NamedTextColor.AQUA)
                                        )
                                );
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        ItemStack concentratedJin = YuanSu.concentrated_jin;
                                        concentratedJin.setAmount(amount);
                                        player.getInventory().addItem(concentratedJin);
                                    }
                                }.runTask(Yuehua.instance);
                            }
                            case "浓缩木" -> {
                                if (amount > data.concentratedMuCount) {
                                    player.sendMessage(
                                            Component.translatable("lackyuansu").appendNewline()
                                                    .append(Component.translatable("cmucount",
                                                                    Component.text(data.concentratedMuCount).color(NamedTextColor.AQUA)
                                                            )
                                                    )
                                    );
                                    return;
                                }
                                data.concentratedMuCount -= amount;
                                player.sendMessage(
                                        Component.translatable("cmucount",
                                                Component.text(data.concentratedMuCount).color(NamedTextColor.AQUA)
                                        )
                                );
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        ItemStack concentratedMu = YuanSu.concentrated_mu;
                                        concentratedMu.setAmount(amount);
                                        player.getInventory().addItem(concentratedMu);
                                    }
                                }.runTask(Yuehua.instance);
                            }
                            case "浓缩水" -> {
                                if (amount > data.concentratedShuiCount) {
                                    player.sendMessage(
                                            Component.translatable("lackyuansu").appendNewline()
                                                    .append(Component.translatable("cshuicount",
                                                                    Component.text(data.concentratedShuiCount).color(NamedTextColor.AQUA)
                                                            )
                                                    )
                                    );
                                    return;
                                }
                                data.concentratedShuiCount -= amount;
                                player.sendMessage(
                                        Component.translatable("cshuicount",
                                                Component.text(data.concentratedShuiCount).color(NamedTextColor.AQUA)
                                        )
                                );
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        ItemStack concentratedShui = YuanSu.concentrated_shui;
                                        concentratedShui.setAmount(amount);
                                        player.getInventory().addItem(concentratedShui);
                                    }
                                }.runTask(Yuehua.instance);
                            }
                            case "浓缩火" -> {
                                if (amount > data.concentratedHuoCount) {
                                    player.sendMessage(
                                            Component.translatable("lackyuansu").appendNewline()
                                                    .append(Component.translatable("chuocount",
                                                                    Component.text(data.concentratedHuoCount).color(NamedTextColor.AQUA)
                                                            )
                                                    )
                                    );
                                    return;
                                }
                                data.concentratedHuoCount -= amount;
                                player.sendMessage(
                                        Component.translatable("chuocount",
                                                Component.text(data.concentratedHuoCount).color(NamedTextColor.AQUA)
                                        )
                                );
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        ItemStack concentratedHuo = YuanSu.concentrated_huo;
                                        concentratedHuo.setAmount(amount);
                                        player.getInventory().addItem(concentratedHuo);
                                    }
                                }.runTask(Yuehua.instance);
                            }
                            case "浓缩土" -> {
                                if (amount > data.concentratedTuCount) {
                                    player.sendMessage(
                                            Component.translatable("lackyuansu").appendNewline()
                                                    .append(Component.translatable("ctucount",
                                                                    Component.text(data.concentratedTuCount).color(NamedTextColor.AQUA)
                                                            )
                                                    )
                                    );
                                    return;
                                }
                                data.concentratedTuCount -= amount;
                                player.sendMessage(
                                        Component.translatable("ctucount",
                                                Component.text(data.concentratedTuCount).color(NamedTextColor.AQUA)
                                        )
                                );
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        ItemStack concentratedTu = YuanSu.concentrated_tu;
                                        concentratedTu.setAmount(amount);
                                        player.getInventory().addItem(concentratedTu);
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
                                    Component.translatable("toomuchyuansu")
                            );
                            return;
                        }
                        switch (args[1]) {
                            case "金" -> {
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
                                    if (itemStack.getType() != Material.KELP) {
                                        continue;
                                    }
                                    if (!Objects.equals(itemStack.getPersistentDataContainer().get(DataContainer.id, PersistentDataType.STRING), "jin")) {
                                        continue;
                                    }
                                    slots.add(i);
                                    count += itemStack.getAmount();
                                }

                                if (count < amount) {
                                    player.sendMessage(
                                            Component.translatable("lessyuansu")
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

                                data.jinCount += amount;
                                player.sendMessage(
                                        Component.translatable("jincount",
                                                Component.text(data.jinCount).color(NamedTextColor.AQUA)
                                        )
                                );
                            }
                            case "木" -> {
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
                                    if (itemStack.getType() != Material.KELP) {
                                        continue;
                                    }
                                    if (!Objects.equals(itemStack.getPersistentDataContainer().get(DataContainer.id, PersistentDataType.STRING), "mu")) {
                                        continue;
                                    }
                                    slots.add(i);
                                    count += itemStack.getAmount();
                                }

                                if (count < amount) {
                                    player.sendMessage(
                                            Component.translatable("lessyuansu")
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
                                data.muCount += amount;
                                player.sendMessage(
                                        Component.translatable("mucount",
                                                Component.text(data.muCount).color(NamedTextColor.AQUA)
                                        )
                                );
                            }
                            case "水" -> {
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
                                    if (itemStack.getType() != Material.KELP) {
                                        continue;
                                    }
                                    if (!Objects.equals(itemStack.getPersistentDataContainer().get(DataContainer.id, PersistentDataType.STRING), "shui")) {
                                        continue;
                                    }
                                    slots.add(i);
                                    count += itemStack.getAmount();
                                }

                                if (count < amount) {
                                    player.sendMessage(
                                            Component.translatable("lessyuansu")
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
                                data.shuiCount += amount;
                                player.sendMessage(
                                        Component.translatable("shuicount",
                                                Component.text(data.shuiCount).color(NamedTextColor.AQUA)
                                        )
                                );
                            }
                            case "火" -> {PlayerInventory playerInventory = player.getInventory();
                                ItemStack[] itemStacks = playerInventory.getContents();
                                int count = 0;
                                int length = itemStacks.length;
                                List<Integer> slots = new ArrayList<>(length);
                                for (int i = 0; i < length; i++) {
                                    ItemStack itemStack = itemStacks[i];
                                    if (itemStack == null) {
                                        continue;
                                    }
                                    if (itemStack.getType() != Material.KELP) {
                                        continue;
                                    }
                                    if (!Objects.equals(itemStack.getPersistentDataContainer().get(DataContainer.id, PersistentDataType.STRING), "huo")) {
                                        continue;
                                    }
                                    slots.add(i);
                                    count += itemStack.getAmount();
                                }

                                if (count < amount) {
                                    player.sendMessage(
                                            Component.translatable("lessyuansu")
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
                                data.huoCount += amount;
                                player.sendMessage(
                                        Component.translatable("huocount",
                                                Component.text(data.huoCount).color(NamedTextColor.AQUA)
                                        )
                                );}
                            case "土" -> {
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
                                    if (itemStack.getType() != Material.KELP) {
                                        continue;
                                    }
                                    if (!Objects.equals(itemStack.getPersistentDataContainer().get(DataContainer.id, PersistentDataType.STRING), "tu")) {
                                        continue;
                                    }
                                    slots.add(i);
                                    count += itemStack.getAmount();
                                }
                                if (count < amount) {
                                    player.sendMessage(
                                            Component.translatable("lessyuansu")
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
                                data.tuCount += amount;
                                player.sendMessage(
                                        Component.translatable("tucount",
                                                Component.text(data.tuCount).color(NamedTextColor.AQUA)
                                        )
                                );
                            }
                            case "精炼金" -> {PlayerInventory playerInventory = player.getInventory();
                                ItemStack[] itemStacks = playerInventory.getContents();
                                int count = 0;
                                int length = itemStacks.length;
                                List<Integer> slots = new ArrayList<>(length);
                                for (int i = 0; i < length; i++) {
                                    ItemStack itemStack = itemStacks[i];
                                    if (itemStack == null) {
                                        continue;
                                    }
                                    if (itemStack.getType() != Material.KELP) {
                                        continue;
                                    }
                                    if (!Objects.equals(itemStack.getPersistentDataContainer().get(DataContainer.id, PersistentDataType.STRING), "refined_jin")) {
                                        continue;
                                    }
                                    slots.add(i);
                                    count += itemStack.getAmount();
                                }
                                if (count < amount) {
                                    player.sendMessage(
                                            Component.translatable("lessyuansu")
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
                                data.refinedJinCount += amount;
                                player.sendMessage(
                                        Component.translatable("rjincount",
                                                Component.text(data.refinedJinCount).color(NamedTextColor.AQUA)
                                        )
                                );}
                            case "精炼木" -> {
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
                                    if (itemStack.getType() != Material.KELP) {
                                        continue;
                                    }
                                    if (!Objects.equals(itemStack.getPersistentDataContainer().get(DataContainer.id, PersistentDataType.STRING), "refined_mu")) {
                                        continue;
                                    }
                                    slots.add(i);
                                    count += itemStack.getAmount();
                                }
                                if (count < amount) {
                                    player.sendMessage(
                                            Component.translatable("lessyuansu")
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
                                data.refinedMuCount += amount;
                                player.sendMessage(
                                        Component.translatable("rmucount",
                                                Component.text(data.refinedMuCount).color(NamedTextColor.AQUA)
                                        )
                                );
                            }
                            case "精炼水" -> {
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
                                    if (itemStack.getType() != Material.KELP) {
                                        continue;
                                    }
                                    if (!Objects.equals(itemStack.getPersistentDataContainer().get(DataContainer.id, PersistentDataType.STRING), "refined_shui")) {
                                        continue;
                                    }
                                    slots.add(i);
                                    count += itemStack.getAmount();
                                }
                                if (count < amount) {
                                    player.sendMessage(
                                            Component.translatable("lessyuansu")
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
                                data.refinedShuiCount += amount;
                                player.sendMessage(
                                        Component.translatable("rshuicount",
                                                Component.text(data.refinedShuiCount).color(NamedTextColor.AQUA)
                                        )
                                );
                            }
                            case "精炼火" -> {
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
                                    if (itemStack.getType() != Material.KELP) {
                                        continue;
                                    }
                                    if (!Objects.equals(itemStack.getPersistentDataContainer().get(DataContainer.id, PersistentDataType.STRING), "refined_huo")) {
                                        continue;
                                    }
                                    slots.add(i);
                                    count += itemStack.getAmount();
                                }
                                if (count < amount) {
                                    player.sendMessage(
                                            Component.translatable("lessyuansu")
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
                                data.refinedHuoCount += amount;
                                player.sendMessage(
                                        Component.translatable("rhuocount",
                                                Component.text(data.refinedHuoCount).color(NamedTextColor.AQUA)
                                        )
                                );
                            }
                            case "精炼土" -> {
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
                                    if (itemStack.getType() != Material.KELP) {
                                        continue;
                                    }
                                    if (!Objects.equals(itemStack.getPersistentDataContainer().get(DataContainer.id, PersistentDataType.STRING), "refined_tu")) {
                                        continue;
                                    }
                                    slots.add(i);
                                    count += itemStack.getAmount();
                                }
                                if (count < amount) {
                                    player.sendMessage(
                                            Component.translatable("lessyuansu")
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
                                data.refinedTuCount += amount;
                                player.sendMessage(
                                        Component.translatable("rtucount",
                                                Component.text(data.refinedTuCount).color(NamedTextColor.AQUA)
                                        )
                                );
                            }
                            case "浓缩金" -> {
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
                                    if (itemStack.getType() != Material.KELP) {
                                        continue;
                                    }
                                    if (!Objects.equals(itemStack.getPersistentDataContainer().get(DataContainer.id, PersistentDataType.STRING), "concentrated_jin")) {
                                        continue;
                                    }
                                    slots.add(i);
                                    count += itemStack.getAmount();
                                }
                                if (count < amount) {
                                    player.sendMessage(
                                            Component.translatable("lessyuansu")
                                    );
                                    return;
                                }
                                int inamount = amount;
                                for (int slot : slots) {
                                    ItemStack itemStack = itemStacks[slot];
                                    int amountNow = itemStack.getAmount();
                                    if (inamount > amountNow) {
                                        inamount -= amountNow;
                                        itemStack.setAmount(0);
                                    } else {
                                        itemStack.setAmount(amountNow - inamount);
                                        break;
                                    }
                                }
                                data.concentratedJinCount += amount;
                                player.sendMessage(
                                        Component.translatable("cjincount",
                                                Component.text(data.concentratedJinCount).color(NamedTextColor.AQUA)
                                        )
                                );
                            }
                            case "浓缩木" -> {
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
                                    if (itemStack.getType() != Material.KELP) {
                                        continue;
                                    }
                                    if (!Objects.equals(itemStack.getPersistentDataContainer().get(DataContainer.id, PersistentDataType.STRING), "concentrated_mu")) {
                                        continue;
                                    }
                                    slots.add(i);
                                    count += itemStack.getAmount();
                                }
                                if (count < amount) {
                                    player.sendMessage(
                                            Component.translatable("lessyuansu")
                                    );
                                    return;
                                }
                                int inamount = amount;
                                for (int slot : slots) {
                                    ItemStack itemStack = itemStacks[slot];
                                    int amountNow = itemStack.getAmount();
                                    if (inamount > amountNow) {
                                        inamount -= amountNow;
                                        itemStack.setAmount(0);
                                    } else {
                                        itemStack.setAmount(amountNow - inamount);
                                        break;
                                    }
                                }
                                data.concentratedMuCount += amount;
                                player.sendMessage(
                                        Component.translatable("cmucount",
                                                Component.text(data.concentratedMuCount).color(NamedTextColor.AQUA)
                                        )
                                );
                            }
                            case "浓缩水" -> {
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
                                    if (itemStack.getType() != Material.KELP) {
                                        continue;
                                    }
                                    if (!Objects.equals(itemStack.getPersistentDataContainer().get(DataContainer.id, PersistentDataType.STRING), "concentrated_shui")) {
                                        continue;
                                    }
                                    slots.add(i);
                                    count += itemStack.getAmount();
                                }
                                if (count < amount) {
                                    player.sendMessage(
                                            Component.translatable("lessyuansu")
                                    );
                                    return;
                                }
                                int inamount = amount;
                                for (int slot : slots) {
                                    ItemStack itemStack = itemStacks[slot];
                                    int amountNow = itemStack.getAmount();
                                    if (inamount > amountNow) {
                                        inamount -= amountNow;
                                        itemStack.setAmount(0);
                                    } else {
                                        itemStack.setAmount(amountNow - inamount);
                                        break;
                                    }
                                }
                                data.concentratedShuiCount += amount;
                                player.sendMessage(
                                        Component.translatable("cshuicount",
                                                Component.text(data.concentratedShuiCount).color(NamedTextColor.AQUA)
                                        )
                                );
                            }
                            case "浓缩火" -> {
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
                                    if (itemStack.getType() != Material.KELP) {
                                        continue;
                                    }
                                    if (!Objects.equals(itemStack.getPersistentDataContainer().get(DataContainer.id, PersistentDataType.STRING), "concentrated_huo")) {
                                        continue;
                                    }
                                    slots.add(i);
                                    count += itemStack.getAmount();
                                }
                                if (count < amount) {
                                    player.sendMessage(
                                            Component.translatable("lessyuansu")
                                    );
                                    return;
                                }
                                int inamount = amount;
                                for (int slot : slots) {
                                    ItemStack itemStack = itemStacks[slot];
                                    int amountNow = itemStack.getAmount();
                                    if (inamount > amountNow) {
                                        inamount -= amountNow;
                                        itemStack.setAmount(0);
                                    } else {
                                        itemStack.setAmount(amountNow - inamount);
                                        break;
                                    }
                                }
                                data.concentratedHuoCount += amount;
                                player.sendMessage(
                                        Component.translatable("chuocount",
                                                Component.text(data.concentratedHuoCount).color(NamedTextColor.AQUA)
                                        )
                                );
                            }
                            case "浓缩土" -> {
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
                                    if (itemStack.getType() != Material.KELP) {
                                        continue;
                                    }
                                    if (!Objects.equals(itemStack.getPersistentDataContainer().get(DataContainer.id, PersistentDataType.STRING), "concentrated_tu")) {
                                        continue;
                                    }
                                    slots.add(i);
                                    count += itemStack.getAmount();
                                }
                                if (count < amount) {
                                    player.sendMessage(
                                            Component.translatable("lessyuansu")
                                    );
                                    return;
                                }
                                int inamount = amount;
                                for (int slot : slots) {
                                    ItemStack itemStack = itemStacks[slot];
                                    int amountNow = itemStack.getAmount();
                                    if (inamount > amountNow) {
                                        inamount -= amountNow;
                                        itemStack.setAmount(0);
                                    } else {
                                        itemStack.setAmount(amountNow - inamount);
                                        break;
                                    }
                                }
                                data.concentratedTuCount += amount;
                                player.sendMessage(
                                        Component.translatable("ctucount",
                                                Component.text(data.concentratedTuCount).color(NamedTextColor.AQUA)
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
                                Component.translatable("jincount", Component.text(data.jinCount).color(NamedTextColor.AQUA)).appendNewline()
                                        .append(Component.translatable("mucount", Component.text(data.muCount).color(NamedTextColor.AQUA)).appendNewline())
                                        .append(Component.translatable("shuicount", Component.text(data.shuiCount).color(NamedTextColor.AQUA)).appendNewline())
                                        .append(Component.translatable("huocount", Component.text(data.huoCount).color(NamedTextColor.AQUA)).appendNewline())
                                        .append(Component.translatable("tucount", Component.text(data.tuCount).color(NamedTextColor.AQUA)).appendNewline())
                                        .append(Component.translatable("rjincount", Component.text(data.refinedJinCount).color(NamedTextColor.AQUA)).appendNewline())
                                        .append(Component.translatable("rmucount", Component.text(data.refinedMuCount).color(NamedTextColor.AQUA)).appendNewline())
                                        .append(Component.translatable("rshuicount", Component.text(data.refinedShuiCount).color(NamedTextColor.AQUA)).appendNewline())
                                        .append(Component.translatable("rhuocount", Component.text(data.refinedHuoCount).color(NamedTextColor.AQUA)).appendNewline())
                                        .append(Component.translatable("rtucount", Component.text(data.refinedTuCount).color(NamedTextColor.AQUA)).appendNewline())
                                        .append(Component.translatable("cjincount", Component.text(data.concentratedJinCount).color(NamedTextColor.AQUA)).appendNewline())
                                        .append(Component.translatable("cmucount", Component.text(data.concentratedMuCount).color(NamedTextColor.AQUA)).appendNewline())
                                        .append(Component.translatable("cshuicount", Component.text(data.concentratedShuiCount).color(NamedTextColor.AQUA)).appendNewline())
                                        .append(Component.translatable("chuocount", Component.text(data.concentratedHuoCount).color(NamedTextColor.AQUA)).appendNewline())
                                        .append(Component.translatable("ctucount", Component.text(data.concentratedTuCount).color(NamedTextColor.AQUA)))
                        );

                    }
                    default -> player.sendMessage(
                            Component.translatable("badarg")
                    );
                }
            }
        }.runTaskAsynchronously(Yuehua.instance);


        return true;
    }
}
