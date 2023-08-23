package org.xiaoxiao.yuehua.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.xiaoxiao.yuehua.Yuehua;
import org.xiaoxiao.yuehua.util.Scores;

public final class Death implements Listener {
    private static BukkitRunnable[] bukkitRunnables;
    private final static PotionEffect shen = new PotionEffect(PotionEffectType.HEALTH_BOOST,-1,3,false,false,true);
    private final static PotionEffect xian = new PotionEffect(PotionEffectType.JUMP,-1,1,false,false,true);
    private final static PotionEffect ren = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,-1,0,false,false,true);
    private final static PotionEffect yao = new PotionEffect(PotionEffectType.SPEED,-1,1,false,false,true);
    private final static PotionEffect zhan = new PotionEffect(PotionEffectType.FIRE_RESISTANCE,-1,0,false,false,true);

    public static void init() {
        bukkitRunnables = new BukkitRunnable[5];
        bukkitRunnables[0] = new BukkitRunnable() {
            @Override
            public void run() {

            }
        };
        bukkitRunnables[1] = new BukkitRunnable() {
            @Override
            public void run() {

            }
        };
        bukkitRunnables[2] = new BukkitRunnable() {
            @Override
            public void run() {

            }
        };
        bukkitRunnables[3] = new BukkitRunnable() {
            @Override
            public void run() {

            }
        };
        bukkitRunnables[4] = new BukkitRunnable() {
            @Override
            public void run() {

            }
        };


    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player player = e.getPlayer();
        String name = player.getName();
        //种族BUFF
        int race = Scores.getRace(name);
        bukkitRunnables[race-1].runTask(Yuehua.instance);
    }
}
