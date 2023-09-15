package org.xiaoxiao.yuehua.commands.data;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.xiaoxiao.yuehua.Yuehua;
import org.xiaoxiao.yuehua.data.DanData;
import org.xiaoxiao.yuehua.data.Data;
import org.xiaoxiao.yuehua.data.GongData;

import java.util.Objects;

public final class DataSet implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player){
            if(!player.isOp()){
                player.sendPlainMessage("§c你没有权限");
                return true;
            }
            if(args.length !=2){
                return true;
            }
            String name = "xiaoxiaoOWO";
            String type = args[0];
            int value = Integer.parseInt(args[1]);
            Data data = Yuehua.playerData.get(Objects.requireNonNull(Bukkit.getPlayer(name)).getUniqueId());
            switch (type){
                case "attack" -> data.attack = value;
                case "arrow" -> {
                    GongData gongData = (GongData) data;
                    gongData.arrow = value;
                }
                case "zhenfa" -> {
                    DanData danData = (DanData) data;
                    danData.zhenfa = value;
                }
                case "baoji" -> data.baoji = value;
                case "baojixiaoguo" -> data.baojixiaoguo = value;
                case "pofa" -> data.pofa = value;
                case "fakang" -> data.fakang = value;
                case "cool_reduce" -> data.cool_reduce = value;
            }


        }
        return true;
    }
}
















