package com.xiaoxiaoowo.yuehua.commands.opcommand;


import com.xiaoxiaoowo.yuehua.itemstack.liandan.Dan;
import com.xiaoxiaoowo.yuehua.itemstack.liandan.Herb;
import com.xiaoxiaoowo.yuehua.itemstack.other.*;
import com.xiaoxiaoowo.yuehua.itemstack.dz.Ingredient;
import com.xiaoxiaoowo.yuehua.itemstack.dz.YuanSu;
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
                case "烤地瓜" -> Food.kaoDiGua;
                case "喜饼" -> Food.xiBing;
                case "佛跳墙" -> Food.foTiaoQiang;
                case "烤鱼" -> Food.kaoYu;
                case "烤鲑鱼" -> Food.kaoGuiYu;
                case "烤鸡" -> Food.kaoJi;
                case "牛排" -> Food.niuPai;
                case "猪排" -> Food.zhuPai;
                case "羊腿" -> Food.yangTui;
                case "兔肉" -> Food.tuRou;
                case "粽子" -> Food.zongZi;
                case "年糕" -> Food.nianGao;
                case "月饼" -> Food.yueBin;
                case "汤圆" -> Food.tangYuan;
                case "苹果" -> Food.pinGuo;


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


                case "重生石" -> Other.CHONG_SHENG_STONE;


                case "碧石碎" -> Ingredient.BI_SHI_SUI;
                case "赤铜锭" -> Ingredient.CHI_TONG_DING;
                case "玄铁锭" -> Ingredient.XUAN_TIE_DING;
                case "灵玉简" -> Ingredient.LING_YU_JIAN;
                case "神造铁" -> Ingredient.SHEN_ZAO_TIE;
                case "七彩仙玉" -> Ingredient.QI_CAI_XIAN_YU;


                case "獒狼皮" -> Ingredient.AO_LANG_PI;
                case "芭蕉叶" -> Ingredient.BA_JIAO_YE;
                case "流音绸" -> Ingredient.LIU_YIN_CHOU;
                case "涅槃羽" -> Ingredient.NIE_PAN_YU;
                case "皇图神裘" -> Ingredient.HUANG_TU_SHEN_QIU;
                case "炎鬼织锦" -> Ingredient.YAN_GUI_ZHI_JIN;
                case "流光灵绢" -> Ingredient.LIU_GUANG_LIN_JUAN;
                case "鸣泪幽纱" -> Ingredient.MING_LEI_YOU_SHA;

                case "白蛇鳞" -> Ingredient.BAI_SHE_LIN;
                case "枯朽骨" -> Ingredient.KU_XIU_GU;
                case "黄铜矿" -> Ingredient.HUANG_TONG_KUANG;
                case "毒蛛牙" -> Ingredient.DU_ZHU_YA;

                case "熔岩砂" -> Ingredient.RONG_YAN_SHA;
                case "炎阳花" -> Ingredient.YAN_YANG_HUA;
                case "鬼幽火" -> Ingredient.GUI_YOU_HUO;
                case "炽砂沫" -> Ingredient.CHI_SHA_MO;

                case "琉洛珠" -> Ingredient.LIU_LUO_ZHU;
                case "天枢石" -> Ingredient.TIAN_SHU_SHI;
                case "玉衡石" -> Ingredient.YU_HENG_SHI;
                case "熔炼石" -> Ingredient.RONG_LIAN_SHI;

                case "沉水铁" -> Ingredient.CHEN_SHUI_TIE;
                case "激浪螺" -> Ingredient.JI_LANG_LUO;
                case "冥海晶" -> Ingredient.MING_HAI_JIN;
                case "碧波镜" -> Ingredient.BI_BO_JING;

                case "七彩晶" -> Ingredient.QI_CAI_JIN;
                case "挽月银" -> Ingredient.WAN_YUE_YIN;
                case "千炼玉" -> Ingredient.QIAN_NIAN_YU;







                default -> new ItemStack(Material.AIR);
            };

            Inventory inventory = player.getInventory();
            inventory.addItem(itemStack);


        }
        return true;
    }
}
