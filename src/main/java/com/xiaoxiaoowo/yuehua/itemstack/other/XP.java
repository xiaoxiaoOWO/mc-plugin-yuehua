package com.xiaoxiaoowo.yuehua.itemstack.other;

import com.xiaoxiaoowo.yuehua.system.DataContainer;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;

public final class XP {
    //前4个怪物可掉落
    public static final ItemStack XP_10 = new ItemStack(Material.RAW_GOLD, 1);
    public static final ItemStack XP_20 = new ItemStack(Material.RAW_GOLD, 1);
    public static final ItemStack XP_50 = new ItemStack(Material.RAW_GOLD, 1);
    public static final ItemStack XP_100 = new ItemStack(Material.RAW_GOLD, 1);
    public static final ItemStack XP_200 = new ItemStack(Material.RAW_GOLD, 1);
    public static final ItemStack XP_500 = new ItemStack(Material.RAW_GOLD, 1);

    static {
        XP_10.setCustomModelData(1);
        XP_20.setCustomModelData(2);
        XP_50.setCustomModelData(3);
        XP_100.setCustomModelData(4);
        XP_200.setCustomModelData(5);
        XP_500.setCustomModelData(6);

        ItemMeta itemMeta1 = XP_10.getItemMeta();
        ItemMeta itemMeta2 = XP_20.getItemMeta();
        ItemMeta itemMeta5 = XP_50.getItemMeta();
        ItemMeta itemMeta10 = XP_100.getItemMeta();
        ItemMeta itemMeta20 = XP_200.getItemMeta();
        ItemMeta itemMeta50 = XP_500.getItemMeta();

        itemMeta1.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "xp10");
        itemMeta2.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "xp20");
        itemMeta5.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "xp50");
        itemMeta10.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "xp100");
        itemMeta20.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "xp200");
        itemMeta50.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "xp500");

        itemMeta1.displayName(
                Component.translatable("xp10")
        );

        itemMeta2.displayName(
                Component.translatable("xp20")
        );

        itemMeta5.displayName(
                Component.translatable("xp50")
        );

        itemMeta10.displayName(
                Component.translatable("xp100")
        );

        itemMeta20.displayName(
                Component.translatable("xp200")
        );

        itemMeta50.displayName(
                Component.translatable("xp500")
        );


        itemMeta1.lore(
                List.of(
                        Component.translatable("rare1"),
                        Component.translatable("xp10lore"))
        );

        itemMeta2.lore(
                List.of(
                        Component.translatable("rare2"),
                        Component.translatable("xp20lore"))
        );

        itemMeta5.lore(
                List.of(
                        Component.translatable("rare3"),
                        Component.translatable("xp50lore"))
        );

        itemMeta10.lore(
                List.of(
                        Component.translatable("rare4"),
                        Component.translatable("xp100lore"))
        );
        itemMeta20.lore(
                List.of(
                        Component.translatable("rare5"),
                        Component.translatable("xp200lore"))
        );

        itemMeta50.lore(
                List.of(
                        Component.translatable("rare6"),
                        Component.translatable("xp500lore"))
        );

        XP_10.setItemMeta(itemMeta1);
        XP_20.setItemMeta(itemMeta2);
        XP_50.setItemMeta(itemMeta5);
        XP_100.setItemMeta(itemMeta10);
        XP_200.setItemMeta(itemMeta20);
        XP_500.setItemMeta(itemMeta50);
    }
}
