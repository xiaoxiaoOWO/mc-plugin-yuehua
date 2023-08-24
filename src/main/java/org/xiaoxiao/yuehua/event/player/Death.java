package org.xiaoxiao.yuehua.event.player;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.title.Title;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.xiaoxiao.yuehua.util.Scores;


public final class Death implements Listener {
    public final static Title title = Title.title(Component.text("寄").color(NamedTextColor.DARK_RED), Component.text(""));

    public final static PotionEffect shen = new PotionEffect(PotionEffectType.HEALTH_BOOST, -1, 3, false, false, true);
    public final static PotionEffect xian = new PotionEffect(PotionEffectType.JUMP, -1, 1, false, false, true);
    public final static PotionEffect ren = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, -1, 0, false, false, true);
    public final static PotionEffect yao = new PotionEffect(PotionEffectType.SPEED, -1, 1, false, false, true);
    public final static PotionEffect zhan = new PotionEffect(PotionEffectType.FIRE_RESISTANCE, -1, 0, false, false, true);


    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player player = e.getPlayer();
        //种族BUFF
        int race = Scores.getRace(player.getName());
        switch (race) {
            case 1 -> player.addPotionEffect(shen);
            case 2 -> player.addPotionEffect(xian);
            case 3 -> player.addPotionEffect(ren);
            case 4 -> player.addPotionEffect(yao);
            case 5 -> player.addPotionEffect(zhan);
        }
        player.showTitle(title);
    }
}
