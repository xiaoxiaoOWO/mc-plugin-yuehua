package com.xiaoxiaoowo.yuehua.event.player;

import com.xiaoxiaoowo.yuehua.Yuehua;
import com.xiaoxiaoowo.yuehua.system.DataContainer;
import com.xiaoxiaoowo.yuehua.system.Team;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.title.Title;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;


public final class Death implements Listener {
    public final static Title title = Title.title(Component.text("寄").color(NamedTextColor.DARK_RED), Component.text(""));

    public final static PotionEffect shen = new PotionEffect(PotionEffectType.HEALTH_BOOST, -1, 5, false, false, true);
    public final static PotionEffect xian = new PotionEffect(PotionEffectType.JUMP, -1, 2, false, false, true);
    public final static PotionEffect ren = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, -1, 0, false, false, true);
    public final static PotionEffect yao = new PotionEffect(PotionEffectType.SPEED, -1, 1, false, false, true);
    public final static PotionEffect zhan = new PotionEffect(PotionEffectType.FIRE_RESISTANCE, -1, 0, false, false, true);


    @EventHandler
    public void onDeath(PlayerDeathEvent e) {

        new BukkitRunnable() {
            @Override
            public void run() {
                Player player = e.getPlayer();
                PersistentDataContainer dataContainer = player.getPersistentDataContainer();
                //死亡后重置队伍为玩家,并且设置为大陆
                Team.playerTeam.addPlayer(player);
                dataContainer.set(DataContainer.mainland, PersistentDataType.BOOLEAN,true);
                //种族BUFF
                switch (dataContainer.get(DataContainer.race,PersistentDataType.INTEGER)) {
                    case 1 -> player.addPotionEffect(shen);
                    case 2 -> player.addPotionEffect(xian);
                    case 3 -> player.addPotionEffect(ren);
                    case 4 -> player.addPotionEffect(yao);
                    case 5 -> player.addPotionEffect(zhan);
                }
                player.showTitle(title);
            }
        }.runTask(Yuehua.instance);


    }
}
