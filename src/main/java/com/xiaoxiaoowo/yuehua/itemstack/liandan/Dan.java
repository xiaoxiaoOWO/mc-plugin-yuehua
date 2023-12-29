package com.xiaoxiaoowo.yuehua.itemstack.liandan;

import com.xiaoxiaoowo.yuehua.system.DataContainer;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;

public final class Dan {
    //前两个怪物可掉落
    public static final ItemStack YAOYIN1 = new ItemStack(Material.REDSTONE, 1);
    public static final ItemStack YAOYIN2 = new ItemStack(Material.REDSTONE, 1);
    public static final ItemStack YAOYIN3 = new ItemStack(Material.REDSTONE, 1);
    public static final ItemStack YAOYIN4 = new ItemStack(Material.REDSTONE, 1);


    static {
        YAOYIN1.setCustomModelData(1);
        YAOYIN2.setCustomModelData(2);
        YAOYIN3.setCustomModelData(3);
        YAOYIN4.setCustomModelData(4);

        ItemMeta itemMeta1 = YAOYIN1.getItemMeta();
        ItemMeta itemMeta2 = YAOYIN2.getItemMeta();
        ItemMeta itemMeta3 = YAOYIN3.getItemMeta();
        ItemMeta itemMeta4 = YAOYIN4.getItemMeta();

        itemMeta1.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "yaoyin1");
        itemMeta2.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "yaoyin2");
        itemMeta3.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "yaoyin3");
        itemMeta4.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "yaoyin4");

        itemMeta1.displayName(
                Component.translatable("yaoyin1")
        );

        itemMeta2.displayName(
                Component.translatable("yaoyin2")
        );

        itemMeta3.displayName(
                Component.translatable("yaoyin3")
        );

        itemMeta4.displayName(
                Component.translatable("yaoyin4")
        );

        itemMeta1.lore(
                List.of(Component.translatable("rare2"),
                        Component.translatable("yaoyin1lore")
                )
        );

        itemMeta2.lore(
                List.of(Component.translatable("rare3")
                        , Component.translatable("yaoyin2lore")
                )
        );

        itemMeta3.lore(
                List.of(Component.translatable("rare4")
                        , Component.translatable("yaoyin3lore")
                )
        );

        itemMeta4.lore(
                List.of(Component.translatable("rare5")
                       , Component.translatable("yaoyin4lore")
                )
        );

        YAOYIN1.setItemMeta(itemMeta1);
        YAOYIN2.setItemMeta(itemMeta2);
        YAOYIN3.setItemMeta(itemMeta3);
        YAOYIN4.setItemMeta(itemMeta4);
    }
}
