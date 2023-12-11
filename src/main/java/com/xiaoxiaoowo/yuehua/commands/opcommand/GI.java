package com.xiaoxiaoowo.yuehua.commands.opcommand;

import com.xiaoxiaoowo.yuehua.itemstack.Air;
import com.xiaoxiaoowo.yuehua.itemstack.other.Food;
import com.xiaoxiaoowo.yuehua.itemstack.other.Money;
import com.xiaoxiaoowo.yuehua.itemstack.other.Other;
import com.xiaoxiaoowo.yuehua.itemstack.other.RaceProvince;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public final class GI implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            if (!player.isOp()) {
                player.sendPlainMessage("§c你没有权限执行此命令");
                return true;
            }
            if (args.length != 1) {
                player.sendPlainMessage("§c参数错误");
                return true;
            }


            Inventory inventory = player.getInventory();

            ItemStack itemStack = switch (args[0]) {
                case "神族证明" -> RaceProvince.shen;
                case "仙族证明" -> RaceProvince.xian;
                case "人族证明" -> RaceProvince.ren;
                case "妖族证明" -> RaceProvince.yao;
                case "战神族证明" -> RaceProvince.zhanShen;
                case "铜钱" -> Money.tongQian;
                case "金元宝" -> Money.jinYuanBao;
                case "银票" -> Money.yinPiao;
                case "翡翠" -> Money.feiCui;
                case "神族钱" -> Money.MONEY_SHEN;
                case "仙族钱" -> Money.MONEY_XIAN;
                case "人族钱" -> Money.MONEY_REN;
                case "妖族钱" -> Money.MONEY_YAO;
                case "战神族钱" -> Money.MONEY_ZHANSHEN;
                case "NPC泡泡" -> Other.NPC_PAOPAO;
                case "包子" -> Food.baoZi;
                default -> Air.air;
            };


            inventory.addItem(itemStack);


        }
        return true;
    }
}
