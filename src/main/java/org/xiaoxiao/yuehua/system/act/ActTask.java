package org.xiaoxiao.yuehua.system.act;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class ActTask extends BukkitRunnable {
    private Player player;
    private ItemStack itemStack;

    public ActTask() {
    }

    public void init(Player player,ItemStack itemStack){
        this.player = player;
        this.itemStack = itemStack;
    }

    @Override
    public void run() {

    }
}
