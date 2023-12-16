package com.xiaoxiaoowo.yuehua.commands.opcommand;

import com.xiaoxiaoowo.yuehua.utils.GetEntity;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public final class MyTp implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
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
        }

        switch (args[0]) {
            case "森林入口" -> player.teleport(new Location(GetEntity.world, 413, 51, 6));
            case "龙须镇" -> player.teleport(new Location(GetEntity.world, 552, 34, 43));
            case "女王祭坛" -> player.teleport(new Location(GetEntity.world, 659, 45, 25));
            case "始皇入口" -> player.teleport(new Location(GetEntity.world, 611, 10, -136));
            case "兔子仙境" -> player.teleport(new Location(GetEntity.world, 818, 31, -75));
            case "山神庙" -> player.teleport(new Location(GetEntity.world, 833, 40, 109));
            case "神木妖精" -> player.teleport(new Location(GetEntity.world, 633, 53, 379));
            case "废弃村庄" -> player.teleport(new Location(GetEntity.world, 521, 38, 344));
            case "公孙小少爷" -> player.teleport(new Location(GetEntity.world, -51, 51, 323));
            case "王员外" -> player.teleport(new Location(GetEntity.world, -280, 54, 396));
            case "温泉客栈" -> player.teleport(new Location(GetEntity.world, -443, 95, 346));
            case "沙漠客栈" -> player.teleport(new Location(GetEntity.world, -326, 58, 591));
            case "火魔入口" -> player.teleport(new Location(GetEntity.world, -313, 11, 801));
            case "沙漠村庄" -> player.teleport(new Location(GetEntity.world, 0, 47, 816));
            case "马贼窝" -> player.teleport(new Location(GetEntity.world, -177, 53, 495));
            case "沙漠石碑" -> player.teleport(new Location(GetEntity.world, 118, 49, 805));
            case "沙漠废弃村庄" -> player.teleport(new Location(GetEntity.world, 368, 49, 755));
            case "朱雀入口" -> player.teleport(new Location(GetEntity.world, 239, 18, 685));
            case "欢乐果园" -> player.teleport(new Location(GetEntity.world, -98, 67, 46));
            case "陈大夫" -> player.teleport(new Location(GetEntity.world, -132, 45, 141));
            case "山洞村庄" -> player.teleport(new Location(GetEntity.world, -407, 111, 146));
            case "山洞水池" -> player.teleport(new Location(GetEntity.world, -840, 146, -131));
            case "白虎入口" -> player.teleport(new Location(GetEntity.world, -581, 161, -233));
            case "大世界镇妖塔" -> player.teleport(new Location(GetEntity.world, -191, 65, -179));
            case "雨竹" -> player.teleport(new Location(GetEntity.world, -314, 115, -423));
            case "哭谷入口" -> player.teleport(new Location(GetEntity.world, -691, -108, -636));
            case "水族村庄" -> player.teleport(new Location(GetEntity.world, -295, 22, -663));
            case "李大夫" -> player.teleport(new Location(GetEntity.world, -7, 53, -603));
            case "白骨精" -> player.teleport(new Location(GetEntity.world, 157, 54, -545));
            case "玄武入口" -> player.teleport(new Location(GetEntity.world, -84, 34, -521));
            case "蓬莱渡口" -> player.teleport(new Location(GetEntity.world, 346, 34, -524));
            case "圣山入口" -> player.teleport(new Location(GetEntity.world, 309, 33, -732));
            case "假盘入口" -> player.teleport(new Location(GetEntity.world, -183, 99, -832));
            case "皇城中心" -> player.teleport(new Location(GetEntity.world, 179, 43, 63));
            case "皇宫" -> player.teleport(new Location(GetEntity.world, 179, 66, -155));
            case "炼丹房" -> player.teleport(new Location(GetEntity.world, 259, 48, 34));
            case "炼丹室" -> player.teleport(new Location(GetEntity.world, 277, 31, 42));
            case "铁匠铺" -> player.teleport(new Location(GetEntity.world, 84, 46, 143));
            case "风华楼" -> player.teleport(new Location(GetEntity.world, 61, 48, 36));
            case "皇城东门" -> player.teleport(new Location(GetEntity.world, 333, 44, 62));
            case "皇城南门" -> player.teleport(new Location(GetEntity.world, 179, 47, 201));
            case "皇城西门" -> player.teleport(new Location(GetEntity.world, 20, 46, 124));
            case "皇城北门" -> player.teleport(new Location(GetEntity.world, 177, 74, -320));
            case "神族出生点" -> player.teleport(new Location(GetEntity.world, 3209, 73, 381));
            case "仙族出生点" -> player.teleport(new Location(GetEntity.world, 3179, 119, 782));
            case "人族出生点" -> player.teleport(new Location(GetEntity.world, 1685, 132, 138));
            case "妖族出生点" -> player.teleport(new Location(GetEntity.world, 2845, 48, 899));
            case "战神出生点" -> player.teleport(new Location(GetEntity.world, 3299, 22, -138));
            case "蚩尤试炼" -> player.teleport(new Location(GetEntity.world, 2871, 25, -184));
            case "女娲试炼" -> player.teleport(new Location(GetEntity.world, 1685, 25, -231));
            case "盘古试炼" -> player.teleport(new Location(GetEntity.world, 2871, 25, 335));
            case "始皇" -> player.teleport(new Location(GetEntity.world, 2878, 23, -485));
            case "火魔" -> player.teleport(new Location(GetEntity.world, 1296, 17, 870));
            case "镇妖塔" -> player.teleport(new Location(GetEntity.world, 2716, 69, -982));
            case "哭谷" -> player.teleport(new Location(GetEntity.world, 1199, 72, 1447));
            case "圣山" -> player.teleport(new Location(GetEntity.world, 3175, 132, -1839));
            case "青龙祭坛" -> player.teleport(new Location(GetEntity.world, 1696, 116, 726));
            case "朱雀祭坛" -> player.teleport(new Location(GetEntity.world, 3267, 151, -799));
            case "白虎祭坛" -> player.teleport(new Location(GetEntity.world, 2206, 93, -821));
            case "玄武祭坛" -> player.teleport(new Location(GetEntity.world, 2238, 91, 958));
            case "千思谷入口" -> player.teleport(new Location(GetEntity.world, -564, 99, 452));
            case "忘尘" -> player.teleport(new Location(GetEntity.world, -675, 139, 354));
            case "千思谷集市" -> player.teleport(new Location(GetEntity.world, -727, 102, 517));
            case "老战士" -> player.teleport(new Location(GetEntity.world, -835, 83, 437));
            case "元素商人" -> player.teleport(new Location(GetEntity.world, -846, 192, 475));
            case "奈何桥" -> player.teleport(new Location(GetEntity.world, 205, 54, -1768));
            case "忠烈祠" -> player.teleport(new Location(GetEntity.world, 1351, 38, 538));
            case "出生点" -> player.teleport(new Location(GetEntity.world, 1312, 76, 43));
        }

        return true;
    }
}
