package com.xiaoxiaoowo.yuehua.commands.opcommand;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public final class MyTpTab implements TabCompleter {
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        switch (args.length) {
            case 0, 1 -> {
                return List.of("森林入口", "龙须镇", "女王祭坛", "始皇入口", "兔子仙境", "山神庙", "神木妖精", "废弃村庄",
                        "公孙小少爷", "王员外", "温泉客栈", "沙漠客栈", "火魔入口", "沙漠村庄", "马贼窝", "沙漠石碑", "沙漠废弃村庄",
                        "朱雀入口", "欢乐果园", "陈大夫", "山洞村庄", "山洞水池", "白虎入口", "大世界镇妖塔", "雨竹", "哭谷入口",
                        "水族村庄", "李大夫", "白骨精", "玄武入口", "蓬莱渡口", "圣山入口", "假盘入口", "皇城中心", "皇宫", "炼丹房",
                        "炼丹室", "铁匠铺", "风华楼", "皇城东门", "皇城南门", "皇城西门", "皇城北门", "神族出生点", "仙族出生点",
                        "人族出生点", "妖族出生点", "战神出生点", "蚩尤试炼", "女娲试炼", "盘古试炼", "始皇", "火魔", "镇妖塔", "哭谷",
                        "圣山", "青龙祭坛", "朱雀祭坛", "白虎祭坛", "玄武祭坛", "千思谷入口", "忘尘", "千思谷集市", "老战士", "元素商人",
                        "奈何桥", "忠烈祠", "出生点"
                );
            }
        }
        return null;


    }
}
