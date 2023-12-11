package com.xiaoxiaoowo.yuehua.itemstack.other;

import com.xiaoxiaoowo.yuehua.system.DataContainer;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public final class Food {
    //食品类别一（食用需要32tick，无法在饥饿满时食用）,BREAD
    public static final ItemStack baoZi = new ItemStack(Material.BREAD,1);


    public static final ItemStack zongZi = new ItemStack(Material.BREAD, 1);
    public static final ItemStack nianGao = new ItemStack(Material.BREAD, 1);
    public static final ItemStack yueBin = new ItemStack(Material.BREAD, 1);
    public static final ItemStack tangYuan = new ItemStack(Material.BREAD, 1);

    //食品类别二（食用需要16tick,无法在饥饿满时食用），APPLE

    //食品类别三（食用需要32tick，可以在饥饿满时食用，主要为丹药）,CARROT

    //食品类别四（食用需要16tick,可以在饥饿满时食用，主要为丹药）,COOKIE


    static {
        baoZi.setCustomModelData(1);

        ItemMeta itemMeta = baoZi.getItemMeta();

        itemMeta.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "baoZi");
        itemMeta.displayName(
                Component
                        .translatable("baozi")
        );
        baoZi.setItemMeta(itemMeta);

    }


}
