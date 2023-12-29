package com.xiaoxiaoowo.yuehua.itemstack.other;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public final class Other {
    public static final ItemStack ARROW = new ItemStack(Material.ARROW, 1);
    public static final ItemStack NPC_PAOPAO = new ItemStack(Material.WHEAT_SEEDS, 1);
    public static final ItemStack CHONG_SHENG_STONE = new ItemStack(Material.NETHER_STAR, 1);

    static {
        ItemMeta itemMeta1 = NPC_PAOPAO.getItemMeta();
        itemMeta1.displayName(
                Component.translatable("npc_paopao")
        );
        List<Component> lore1 = List.of(
                Component.translatable("npc_paopaolore")
        );
        itemMeta1.lore(lore1);
        NPC_PAOPAO.setItemMeta(itemMeta1);

        ItemMeta itemMeta2 = CHONG_SHENG_STONE.getItemMeta();
        itemMeta2.displayName(
                Component.translatable("chongshengstone")
        );
        CHONG_SHENG_STONE.setItemMeta(itemMeta2);
    }
}
