package com.xiaoxiaoowo.yuehua.task.test;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public final class TestTask3 extends BukkitRunnable {
    private int num = 0;

    @Override
    public void run() {
        Bukkit.broadcast(
                Component.text(num)
        );
        num++;
    }
}
