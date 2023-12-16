package com.xiaoxiaoowo.yuehua.commands.playercommand.completer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

public final class YuanSuCom implements TabCompleter {
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        switch (args.length) {
            case 0, 1 -> {
                return List.of("store", "get","check");
            }
            case 2 -> {
                return List.of("金","木","水","火","土","精炼金","精炼木","精炼水","精炼火","精炼土","浓缩金","浓缩木","浓缩水","浓缩火","浓缩土");
            }
            case 3 -> {
                return Collections.singletonList("输入1-2560");
            }
        }

        return null;
    }
}
