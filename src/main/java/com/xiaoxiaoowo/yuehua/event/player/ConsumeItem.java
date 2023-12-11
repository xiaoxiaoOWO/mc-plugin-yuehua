package com.xiaoxiaoowo.yuehua.event.player;

import com.xiaoxiaoowo.yuehua.system.DataContainer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.persistence.PersistentDataType;

public final class ConsumeItem implements Listener {
    @EventHandler
    public void onConsumeItem(PlayerItemConsumeEvent e) {

        Player player = e.getPlayer();
        switch (e.getItem().getPersistentDataContainer().get(DataContainer.id, PersistentDataType.STRING)) {

        }

    }
}
