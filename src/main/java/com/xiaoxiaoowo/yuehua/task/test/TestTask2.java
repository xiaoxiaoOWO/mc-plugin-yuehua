package com.xiaoxiaoowo.yuehua.task.test;

import com.xiaoxiaoowo.yuehua.Yuehua;
import com.xiaoxiaoowo.yuehua.data.Data;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;

public final class TestTask2 extends BukkitRunnable {
    private int num;
    private final Data data;


    public TestTask2(int num, Data data) {
        this.num = num;
        this.data = data;
    }

    @Override
    public void run() {
        if (num == 0) {
            this.cancel();
        }
        Yuehua.playerData.put(UUID.randomUUID(), data);
        num--;
    }
}

