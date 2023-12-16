package com.xiaoxiaoowo.yuehua.task.test;

import com.xiaoxiaoowo.yuehua.entity.monster.TestSkeleton;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;


public final class TestTask extends BukkitRunnable {
    private int num;
    private final Player player;

    public TestTask(int num, Player player) {
        this.num = num;
        this.player = player;
    }

    @Override
    public void run() {
        if (num == 0) {
            this.cancel();
        }
        TestSkeleton.spawn(player.getLocation());
        num--;
    }
}
