package com.xiaoxiaoowo.yuehua.system;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.scoreboard.Scoreboard;

@SuppressWarnings("deprecation")
public final class Team {
    public static Scoreboard scoreboard;

    public static org.bukkit.scoreboard.Team playerTeam;
    public static org.bukkit.scoreboard.Team monsterTeam;
//    public static Objective test;

    public static void init() {
        scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();

        CommandSender console = Bukkit.getConsoleSender();

        //队伍
        playerTeam = scoreboard.getTeam("player");
        if (playerTeam == null) {
            playerTeam = scoreboard.registerNewTeam("player");
            playerTeam.setColor(ChatColor.YELLOW);
            Bukkit.dispatchCommand(console, "team modify player deathMessageVisibility always");
        }

        monsterTeam = scoreboard.getTeam("enemy");
        if (monsterTeam == null) {
            monsterTeam = scoreboard.registerNewTeam("enemy");
            monsterTeam.setColor(ChatColor.DARK_RED);
            Bukkit.dispatchCommand(console, "team modify enemy deathMessageVisibility never");
        }

//        if(scoreboard.getObjective("test")==null){
//            scoreboard.registerNewObjective("test","dummy");
//        }
//        test = scoreboard.getObjective("test");

    }
}
