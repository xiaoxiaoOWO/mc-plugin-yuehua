package com.xiaoxiaoowo.yuehua.commands.blockcommand;

import com.xiaoxiaoowo.yuehua.Yuehua;
import com.xiaoxiaoowo.yuehua.data.DanData;
import com.xiaoxiaoowo.yuehua.data.GongData;
import com.xiaoxiaoowo.yuehua.data.ZhanData;
import com.xiaoxiaoowo.yuehua.event.player.Death;
import com.xiaoxiaoowo.yuehua.itemstack.other.Food;
import com.xiaoxiaoowo.yuehua.system.DataContainer;
import com.xiaoxiaoowo.yuehua.utils.GetEntity;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.CommandBlock;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

@SuppressWarnings("deprecation")
public final class IntoGame implements CommandExecutor {
    private static final Location TP_SHEN = new Location(GetEntity.world, 3208, 73, 381, 90, 0);
    private static final Location TP_XIAN = new Location(GetEntity.world, 3179, 127, 783, -90, 0);
    private static final Location TP_REN = new Location(GetEntity.world, 1689, 140, 138, 90, 0);
    private static final Location TP_YAO = new Location(GetEntity.world, 2845, 48, 899, 180, -20);
    private static final Location TP_ZHAN = new Location(GetEntity.world, 3299, 22, -138, 90, 0);
    private static final Location SPAWN = new Location(GetEntity.world, 205, 54, -1771);

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            player.sendMessage(
                    Component.translatable("notpermit")
            );
            return true;
        }
        BlockCommandSender blockCommandSender = (BlockCommandSender) sender;
        Location location = blockCommandSender.getBlock().getLocation();

        Player player = GetEntity.getNearestPlayer(location, 5, 5, 5);
        if(player == null){
            return true;
        }
        UUID uuid = player.getUniqueId();
        Yuehua.playerData.remove(uuid);

        //设置tpsBar与ramBar

        CommandSender commandSender = Bukkit.getConsoleSender();
        String name = player.getName();
        Bukkit.dispatchCommand(commandSender,"tpsbar "+name);
        Bukkit.dispatchCommand(commandSender,"rambar "+name);


        //给予物品
        //包子64个
        ItemStack baozi = Food.baoZi;

        //铜钱64枚
        //NPC对话泡泡
        //战士特供道具 额外120个包子
        //弓箭手特供道具 十组箭
        //炼丹师特供道具 初级药引五枚、木元素三十枚、金元素三十枚


        //设置重生点
        player.setBedSpawnLocation(SPAWN, true);

        //回满血回满饱和度
        player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
        player.setFoodLevel(20);
        player.setSaturation(20);
        player.setTitleTimes(15, 80, 20);

        //种族BUFF与TP到种族点
        player.getActivePotionEffects().forEach(it -> player.removePotionEffect(it.getType()));
        PersistentDataContainer pdc = player.getPersistentDataContainer();
        int race = pdc.get(DataContainer.race, PersistentDataType.INTEGER);
        switch (race) {
            case 1 -> {
                player.addPotionEffect(Death.shen);
                player.teleport(TP_SHEN);
            }
            case 2 -> {
                player.addPotionEffect(Death.xian);
                player.teleport(TP_XIAN);
            }
            case 3 -> {
                player.addPotionEffect(Death.ren);
                player.teleport(TP_REN);
            }
            case 4 -> {
                player.addPotionEffect(Death.yao);
                player.teleport(TP_YAO);
            }
            case 5 -> {
                player.addPotionEffect(Death.zhan);
                player.teleport(TP_ZHAN);
            }
        }


        int job = pdc.get(DataContainer.job, PersistentDataType.INTEGER);
        new BukkitRunnable() {
            @Override
            public void run() {
                switch (job) {
                    case 1 -> Yuehua.playerData.put(uuid, new ZhanData(player));
                    case 2 -> Yuehua.playerData.put(uuid, new GongData(player));
                    case 3 -> Yuehua.playerData.put(uuid, new DanData(player));
                }
            }
        }.runTaskLaterAsynchronously(Yuehua.instance, 1);


        return true;
    }
}
