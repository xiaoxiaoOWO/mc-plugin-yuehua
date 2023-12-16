package com.xiaoxiaoowo.yuehua.commands.opcommand;


import com.xiaoxiaoowo.yuehua.itemstack.other.*;
import net.kyori.adventure.text.Component;
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
                player.sendMessage(
                        Component.translatable("notpermit")
                );
                return true;
            }
            if (args.length != 1) {
                player.sendMessage(
                        Component.translatable("badarg")
                );
                return true;
            }


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
                case "金元素" -> YuanSu.jin;
                case "木元素" -> YuanSu.mu;
                case "火元素" -> YuanSu.huo;
                case "水元素" -> YuanSu.shui;
                case "土元素" -> YuanSu.tu;
                case "浓缩金元素" -> YuanSu.concentrated_jin;
                case "浓缩木元素" -> YuanSu.concentrated_mu;
                case "浓缩火元素" -> YuanSu.concentrated_huo;
                case "浓缩水元素" -> YuanSu.concentrated_shui;
                case "浓缩土元素" -> YuanSu.concentrated_tu;
                case "精炼金元素" -> YuanSu.refined_jin;
                case "精炼木元素" -> YuanSu.refined_mu;
                case "精炼火元素" -> YuanSu.refined_huo;
                case "精炼水元素" -> YuanSu.refined_shui;
                case "精炼土元素" -> YuanSu.refined_tu;
                case "袋装金元素" -> YuanSu.bagging_jin;
                case "袋装木元素" -> YuanSu.bagging_mu;
                case "袋装火元素" -> YuanSu.bagging_huo;
                case "袋装水元素" -> YuanSu.bagging_shui;
                case "袋装土元素" -> YuanSu.bagging_tu;
                case "初级药引" -> Dan.YAOYIN1;
                case "中级药引" -> Dan.YAOYIN2;
                case "高级药引" -> Dan.YAOYIN3;
                case "究级药引" -> Dan.YAOYIN4;
                case "枸杞" -> Herb.GouQi;
                case "人参" -> Herb.RenShen;
                case "灵芝" -> Herb.LingZhi;
                case "何首乌" -> Herb.HeShouWu;
                case "珍珠" -> Herb.ZhenZhu;
                case "河豚" -> Herb.HeTun;
                case "海马" -> Herb.HaiMa;
                case "鹿茸" -> Herb.LuRong;
                case "阿胶" -> Herb.EJiao;
                case "冬虫夏草" -> Herb.DongChongXiaCao;
                case "铁皮石斛" -> Herb.TiePiShiHu;
                case "天然牛黄" -> Herb.TianRanNiuHuang;
                case "经验1" -> XP.XP_10;
                case "经验2" -> XP.XP_20;
                case "经验5" -> XP.XP_50;
                case "经验10" -> XP.XP_100;
                case "经验20" -> XP.XP_200;
                case "经验50" -> XP.XP_500;
                default -> new ItemStack(Material.AIR);
            };

            Inventory inventory = player.getInventory();
            inventory.addItem(itemStack);


        }
        return true;
    }
}
