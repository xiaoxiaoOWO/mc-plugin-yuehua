package com.xiaoxiaoowo.yuehua.commands.opcommand;

import com.xiaoxiaoowo.yuehua.entity.monster.TestDamageSkeleton;
import com.xiaoxiaoowo.yuehua.entity.test.TestIronMan;
import com.xiaoxiaoowo.yuehua.entity.test.TestSkeleton;
import com.xiaoxiaoowo.yuehua.entity.test.TestSlime;
import com.xiaoxiaoowo.yuehua.entity.test.TestNPC;
import com.xiaoxiaoowo.yuehua.entity.npc.middle.QianZhuang;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public final class Summon implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        if (!player.isOp()) {
            player.sendMessage(
                    Component.translatable("notpermit")
            );
            return true;
        }
        if(args.length == 0){
            player.sendMessage(
                    Component.translatable("badarg")
            );
            return true;
        }
        Location location = player.getLocation();
        switch (args[0]){
            case "test" -> TestSkeleton.spawn(location);
            case "testn" -> TestNPC.spawn(location);
            case "testi" -> TestIronMan.spawn(location);
            case "tests1" -> TestSlime.spawn1(location);
            case "tests2" -> TestSlime.spawn2(location);
            case "tests3" -> TestSlime.spawn3(location);
            case "tests4" -> TestSlime.spawn4(location);
            case "tests5" -> TestSlime.spawn5(location);
            case "tests100" -> TestSlime.spawn100(location);
            case "钱庄老板" -> QianZhuang.spawn();
            case "人偶" -> TestDamageSkeleton.spawn();
        }
        return true;
    }
}
