package com.xiaoxiaoowo.yuehua.event.player;

import com.xiaoxiaoowo.yuehua.Yuehua;
import com.xiaoxiaoowo.yuehua.data.Data;
import com.xiaoxiaoowo.yuehua.system.DataContainer;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.title.Title;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public final class Death implements Listener {
    public final static Title title = Title.title(Component.translatable("si"), Component.text(""));

    public final static PotionEffect shen = new PotionEffect(PotionEffectType.HEALTH_BOOST, -1, 4, false, false, true);
    public final static PotionEffect xian = new PotionEffect(PotionEffectType.JUMP, -1, 1, false, false, true);
    public final static PotionEffect ren = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, -1, 0, false, false, true);
    public final static PotionEffect yao = new PotionEffect(PotionEffectType.SPEED, -1, 0, false, false, true);
    public final static PotionEffect zhan = new PotionEffect(PotionEffectType.FIRE_RESISTANCE, -1, 0, false, false, true);


    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player player = e.getPlayer();
        PersistentDataContainer pdc = player.getPersistentDataContainer();
        switch (pdc.get(DataContainer.fuben, PersistentDataType.INTEGER)) {

        }
        Yuehua.async(()-> player.showTitle(title));
        Yuehua.scheduler.runTask(Yuehua.instance, () -> {
            Data data = Yuehua.playerData.get(player.getUniqueId());
            //种族BUFF
            switch (data.race) {
                case 1 -> player.addPotionEffect(shen);
                case 2 -> player.addPotionEffect(xian);
                case 3 -> player.addPotionEffect(ren);
                case 4 -> player.addPotionEffect(yao);
                case 5 -> player.addPotionEffect(zhan);
            }
        });
    }
}
