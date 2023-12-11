package com.xiaoxiaoowo.yuehua.commands.blockcommand;

import com.xiaoxiaoowo.yuehua.Yuehua;
import com.xiaoxiaoowo.yuehua.system.DataContainer;
import com.xiaoxiaoowo.yuehua.system.Team;
import com.xiaoxiaoowo.yuehua.utils.GetEntity;
import org.bukkit.Location;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

public final class Select implements CommandExecutor {

    private static final Location TP = new Location(GetEntity.world, 1316, 63, 42, 90, 0);
    private static final Location TO_FINAL = new Location(GetEntity.world, 1202, 27, -380, -90, 0);
    private static final Location RE_SELECT = new Location(GetEntity.world, 1312, 76, 43);
    private static final Location BACK_TO_SELECT_JOB = new Location(GetEntity.world, 1316, 65, 42, 90, 0);

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            player.sendPlainMessage("§c你没有权限执行此命令！");
            return true;
        }
        if (args.length != 2) {
            return true;
        }


        BlockCommandSender blockCommandSender = (BlockCommandSender) sender;
        Location location = blockCommandSender.getBlock().getLocation();
        Player player = GetEntity.getNearestPlayer(location, 3, 3, 3);
        if(player == null){
            return true;
        }
        PersistentDataContainer persistentDataContainer = player.getPersistentDataContainer();

        new BukkitRunnable() {
            @Override
            public void run() {
                switch (args[0]) {
                    case "race" -> {
                        persistentDataContainer.set(DataContainer.job, PersistentDataType.INTEGER, 0);
                        persistentDataContainer.remove(DataContainer.arrow);
                        persistentDataContainer.remove(DataContainer.arrow_add);
                        persistentDataContainer.remove(DataContainer.arrow_count);
                        persistentDataContainer.remove(DataContainer.arrow_mul);
                        persistentDataContainer.remove(DataContainer.zhenfa);
                        persistentDataContainer.remove(DataContainer.zhenfa_add);
                        persistentDataContainer.remove(DataContainer.zhenfa_mul);
                        persistentDataContainer.remove(DataContainer.zhenfa_test);
                        Team.playerTeam.addPlayer(player);
                        switch (args[1]) {
                            //初始化
                            case "shen" -> {
                                persistentDataContainer.set(DataContainer.race, PersistentDataType.INTEGER, 1);
                                persistentDataContainer.set(DataContainer.racefriend_shen, PersistentDataType.BOOLEAN, true);
                                persistentDataContainer.set(DataContainer.racefriend_xian, PersistentDataType.BOOLEAN, true);
                                persistentDataContainer.set(DataContainer.racefriend_ren, PersistentDataType.BOOLEAN, true);
                                persistentDataContainer.set(DataContainer.racefriend_yao, PersistentDataType.BOOLEAN, true);
                                persistentDataContainer.set(DataContainer.racefriend_zhan, PersistentDataType.BOOLEAN, false);
                            }
                            case "xian" -> {
                                persistentDataContainer.set(DataContainer.race, PersistentDataType.INTEGER, 2);
                                persistentDataContainer.set(DataContainer.racefriend_shen, PersistentDataType.BOOLEAN, true);
                                persistentDataContainer.set(DataContainer.racefriend_xian, PersistentDataType.BOOLEAN, true);
                                persistentDataContainer.set(DataContainer.racefriend_ren, PersistentDataType.BOOLEAN, true);
                                persistentDataContainer.set(DataContainer.racefriend_yao, PersistentDataType.BOOLEAN, false);
                                persistentDataContainer.set(DataContainer.racefriend_zhan, PersistentDataType.BOOLEAN, true);
                            }
                            case "ren" -> {
                                persistentDataContainer.set(DataContainer.race, PersistentDataType.INTEGER, 3);
                                persistentDataContainer.set(DataContainer.racefriend_shen, PersistentDataType.BOOLEAN, true);
                                persistentDataContainer.set(DataContainer.racefriend_xian, PersistentDataType.BOOLEAN, true);
                                persistentDataContainer.set(DataContainer.racefriend_ren, PersistentDataType.BOOLEAN, true);
                                persistentDataContainer.set(DataContainer.racefriend_yao, PersistentDataType.BOOLEAN, false);
                                persistentDataContainer.set(DataContainer.racefriend_zhan, PersistentDataType.BOOLEAN, true);
                            }
                            case "yao" -> {
                                persistentDataContainer.set(DataContainer.race, PersistentDataType.INTEGER, 4);
                                persistentDataContainer.set(DataContainer.racefriend_shen, PersistentDataType.BOOLEAN, true);
                                persistentDataContainer.set(DataContainer.racefriend_xian, PersistentDataType.BOOLEAN, false);
                                persistentDataContainer.set(DataContainer.racefriend_ren, PersistentDataType.BOOLEAN, false);
                                persistentDataContainer.set(DataContainer.racefriend_yao, PersistentDataType.BOOLEAN, true);
                                persistentDataContainer.set(DataContainer.racefriend_zhan, PersistentDataType.BOOLEAN, true);
                            }
                            case "zhan" -> {
                                persistentDataContainer.set(DataContainer.race, PersistentDataType.INTEGER, 5);
                                persistentDataContainer.set(DataContainer.racefriend_shen, PersistentDataType.BOOLEAN, false);
                                persistentDataContainer.set(DataContainer.racefriend_xian, PersistentDataType.BOOLEAN, true);
                                persistentDataContainer.set(DataContainer.racefriend_ren, PersistentDataType.BOOLEAN, true);
                                persistentDataContainer.set(DataContainer.racefriend_yao, PersistentDataType.BOOLEAN, true);
                                persistentDataContainer.set(DataContainer.racefriend_zhan, PersistentDataType.BOOLEAN, true);
                            }
                        }
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                player.teleport(TP);
                            }
                        }.runTask(Yuehua.instance);

                    }
                    case "job" -> {

                        switch (args[1]) {
                            case "zhan" -> {
                                persistentDataContainer.set(DataContainer.job, PersistentDataType.INTEGER, 1);
                            }
                            case "gong" -> {
                                persistentDataContainer.set(DataContainer.job, PersistentDataType.INTEGER, 2);
                                persistentDataContainer.set(DataContainer.arrow, PersistentDataType.INTEGER, 0);
                                persistentDataContainer.set(DataContainer.arrow_add, PersistentDataType.INTEGER, 0);
                                persistentDataContainer.set(DataContainer.arrow_mul, PersistentDataType.INTEGER, 100);
                                persistentDataContainer.set(DataContainer.arrow_count, PersistentDataType.INTEGER, 0);
                            }
                            case "dan" -> {
                                persistentDataContainer.set(DataContainer.job, PersistentDataType.INTEGER, 3);
                                persistentDataContainer.set(DataContainer.zhenfa, PersistentDataType.INTEGER, 0);
                                persistentDataContainer.set(DataContainer.zhenfa_add, PersistentDataType.INTEGER, 0);
                                persistentDataContainer.set(DataContainer.zhenfa_mul, PersistentDataType.INTEGER, 100);
                                persistentDataContainer.set(DataContainer.zhenfa_test, PersistentDataType.BOOLEAN, false);
                            }
                        }
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                player.teleport(TO_FINAL);
                            }
                        }.runTask(Yuehua.instance);
                    }
                    case "other" -> {
                        switch (args[1]) {
                            case "backToSelectJob" -> {
                                persistentDataContainer.set(DataContainer.job, PersistentDataType.INTEGER, 0);
                                persistentDataContainer.remove(DataContainer.arrow);
                                persistentDataContainer.remove(DataContainer.arrow_add);
                                persistentDataContainer.remove(DataContainer.arrow_count);
                                persistentDataContainer.remove(DataContainer.arrow_mul);
                                persistentDataContainer.remove(DataContainer.zhenfa);
                                persistentDataContainer.remove(DataContainer.zhenfa_add);
                                persistentDataContainer.remove(DataContainer.zhenfa_mul);
                                persistentDataContainer.remove(DataContainer.zhenfa_test);
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        player.teleport(BACK_TO_SELECT_JOB);
                                    }
                                }.runTask(Yuehua.instance);
                            }
                            case "reSelect" -> {
                                persistentDataContainer.set(DataContainer.job, PersistentDataType.INTEGER, 0);
                                persistentDataContainer.set(DataContainer.race, PersistentDataType.INTEGER, 0);
                                persistentDataContainer.remove(DataContainer.arrow);
                                persistentDataContainer.remove(DataContainer.arrow_add);
                                persistentDataContainer.remove(DataContainer.arrow_count);
                                persistentDataContainer.remove(DataContainer.arrow_mul);
                                persistentDataContainer.remove(DataContainer.zhenfa);
                                persistentDataContainer.remove(DataContainer.zhenfa_add);
                                persistentDataContainer.remove(DataContainer.zhenfa_mul);
                                persistentDataContainer.remove(DataContainer.zhenfa_test);
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        player.teleport(RE_SELECT);
                                    }
                                }.runTask(Yuehua.instance);
                            }
                            case "toFinal" -> {
                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        player.teleport(TO_FINAL);
                                    }
                                }.runTask(Yuehua.instance);
                            }
                        }
                    }
                }


            }
        }.runTaskAsynchronously(Yuehua.instance);


        return true;
    }
}
