package com.xiaoxiaoowo.yuehua.commands.blockcommand;

import com.xiaoxiaoowo.yuehua.Yuehua;
import com.xiaoxiaoowo.yuehua.data.DanData;
import com.xiaoxiaoowo.yuehua.data.GongData;
import com.xiaoxiaoowo.yuehua.data.ZhanData;
import com.xiaoxiaoowo.yuehua.event.player.Death;
import com.xiaoxiaoowo.yuehua.itemstack.liandan.Dan;
import com.xiaoxiaoowo.yuehua.itemstack.other.*;
import com.xiaoxiaoowo.yuehua.itemstack.dz.YuanSu;
import com.xiaoxiaoowo.yuehua.system.DataContainer;
import com.xiaoxiaoowo.yuehua.utils.GetEntity;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

@SuppressWarnings("deprecation")
public final class IntoGame implements CommandExecutor {
    public static final Location TP_SHEN = new Location(GetEntity.world, 3208, 73, 381, 90, 0);
    public static final Location TP_XIAN = new Location(GetEntity.world, 3179, 127, 783, -90, 0);
    public static final Location TP_REN = new Location(GetEntity.world, 1689, 140, 138, 90, 0);
    public static final Location TP_YAO = new Location(GetEntity.world, 2845, 48, 899, 180, -20);
    public static final Location TP_ZHAN = new Location(GetEntity.world, 3299, 22, -138, 90, 0);
    private static final Location SPAWN = new Location(GetEntity.world, 205, 54, -1771);

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            Yuehua.scheduler.runTaskAsynchronously(Yuehua.instance,()->{
                player.sendMessage(
                        Component.translatable("notpermit")
                );
            });
            return true;
        }
        BlockCommandSender blockCommandSender = (BlockCommandSender) sender;
        Location location = blockCommandSender.getBlock().getLocation();

        Player player = GetEntity.getNearestPlayer(location, 5, 5, 5);
        if (player == null) {
            return true;
        }
        UUID uuid = player.getUniqueId();
        Yuehua.playerData.remove(uuid);

        //设置tpsBar与ramBar


        String name = player.getName();
        Bukkit.dispatchCommand(Yuehua.console, "tpsbar " + name);
        Bukkit.dispatchCommand(Yuehua.console, "rambar " + name);

        PersistentDataContainer pdc = player.getPersistentDataContainer();
        int race = pdc.get(DataContainer.race, PersistentDataType.INTEGER);
        int job = pdc.get(DataContainer.job, PersistentDataType.INTEGER);

        //给予物品
        //包子64个
        ItemStack baozi = Food.baoZi;
        baozi.setAmount(64);
        //铜钱64枚
        ItemStack tongqian = Money.tongQian;
        tongqian.setAmount(64);
        //NPC对话泡泡
        ItemStack npc_paopao = Other.NPC_PAOPAO;
        //弓箭手特供道具 十组箭
        ItemStack arrow = Other.ARROW;
        arrow.setAmount(640);
        //炼丹师特供道具 初级药引五枚、木元素三十枚、金元素三十枚
        ItemStack yaoyin1 = Dan.YAOYIN1;
        yaoyin1.setAmount(5);
        ItemStack muyuansu = YuanSu.mu;
        muyuansu.setAmount(30);
        ItemStack jinyuansu = YuanSu.jin;
        jinyuansu.setAmount(30);
        //种族证明
        ItemStack race_province = switch (race) {
            case 1 -> RaceProvince.shen;
            case 2 -> RaceProvince.xian;
            case 3 -> RaceProvince.ren;
            case 4 -> RaceProvince.yao;
            case 5 -> RaceProvince.zhanShen;
            default -> null;
        };
        //给予物品
        PlayerInventory inventory = player.getInventory();
        switch (job) {
            case 1 ->{
                baozi.setAmount(192);
                inventory.addItem(baozi, tongqian, npc_paopao, race_province);
            }

            case 2 ->
                inventory.addItem(baozi, tongqian, npc_paopao, race_province, arrow);


            case 3 ->
                inventory.addItem(baozi, tongqian, npc_paopao, race_province, yaoyin1, muyuansu, jinyuansu);

        }

        //设置重生点
        player.setBedSpawnLocation(SPAWN, true);

        //回满血回满饱和度
        player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
        player.setFoodLevel(20);
        player.setSaturation(20);
        player.setTitleTimes(15, 80, 20);

        //种族BUFF与TP到种族点
        player.getActivePotionEffects().forEach(it -> player.removePotionEffect(it.getType()));
        switch (race) {
            case 1 -> {
                player.addPotionEffect(Death.shen);
                player.teleportAsync(TP_SHEN);
            }
            case 2 -> {
                player.addPotionEffect(Death.xian);
                player.teleportAsync(TP_XIAN);
            }
            case 3 -> {
                player.addPotionEffect(Death.ren);
                player.teleportAsync(TP_REN);
            }
            case 4 -> {
                player.addPotionEffect(Death.yao);
                player.teleportAsync(TP_YAO);
            }
            case 5 -> {
                player.addPotionEffect(Death.zhan);
                player.teleportAsync(TP_ZHAN);
            }
        }

        switch (job) {
            case 1 -> Yuehua.playerData.put(uuid, new ZhanData(player));
            case 2 -> Yuehua.playerData.put(uuid, new GongData(player));
            case 3 -> Yuehua.playerData.put(uuid, new DanData(player));
        }

        return true;
    }
}
