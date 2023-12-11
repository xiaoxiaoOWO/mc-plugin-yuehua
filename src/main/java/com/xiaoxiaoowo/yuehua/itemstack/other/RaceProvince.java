package com.xiaoxiaoowo.yuehua.itemstack.other;

import com.xiaoxiaoowo.yuehua.system.DataContainer;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

public final class RaceProvince {
    public final static ItemStack shen = new ItemStack(Material.PUMPKIN_SEEDS, 1);
    public final static ItemStack xian = new ItemStack(Material.PUMPKIN_SEEDS, 1);
    public final static ItemStack ren = new ItemStack(Material.PUMPKIN_SEEDS, 1);
    public final static ItemStack yao = new ItemStack(Material.PUMPKIN_SEEDS, 1);
    public final static ItemStack zhanShen = new ItemStack(Material.PUMPKIN_SEEDS, 1);

    static {
        shen.setCustomModelData(1);
        xian.setCustomModelData(2);
        ren.setCustomModelData(3);
        yao.setCustomModelData(4);
        zhanShen.setCustomModelData(5);

        ItemMeta itemMetaShen = shen.getItemMeta();
        ItemMeta itemMetaXian = xian.getItemMeta();
        ItemMeta itemMetaRen = ren.getItemMeta();
        ItemMeta itemMetaYao = yao.getItemMeta();
        ItemMeta itemMetaZhanShen = zhanShen.getItemMeta();

        itemMetaShen.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "shen");
        itemMetaXian.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "xian");
        itemMetaRen.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "ren");
        itemMetaYao.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "yao");
        itemMetaZhanShen.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "zhanShen");


        itemMetaShen.displayName(
                Component
                        .translatable("raceshen")

        );

        itemMetaXian.displayName(
                Component
                        .translatable("racexian")
        );

        itemMetaRen.displayName(
                Component
                        .translatable("raceren")

        );

        itemMetaYao.displayName(
                Component
                        .translatable("raceyao")
        );

        itemMetaZhanShen.displayName(
                Component
                        .translatable("racezhan")
        );


        List<Component> loreShen = new ArrayList<>();
        List<Component> loreXian = new ArrayList<>();
        List<Component> loreRen = new ArrayList<>();
        List<Component> loreYao = new ArrayList<>();
        List<Component> loreZhanShen = new ArrayList<>();


        loreShen.add(Component
                .translatable("raceshenlore")
        );
        loreXian.add(Component
                .translatable("racexianlore")
        );
        loreRen.add(Component
                .translatable("racerenlore")
        );
        loreYao.add(Component
                .translatable("raceyaolore")
        );
        loreZhanShen.add(Component
                .translatable("racezhanlore")
        );


        itemMetaShen.lore(loreShen);
        itemMetaXian.lore(loreXian);
        itemMetaRen.lore(loreRen);
        itemMetaYao.lore(loreYao);
        itemMetaZhanShen.lore(loreZhanShen);

        shen.setItemMeta(itemMetaShen);
        xian.setItemMeta(itemMetaXian);
        ren.setItemMeta(itemMetaRen);
        yao.setItemMeta(itemMetaYao);
        zhanShen.setItemMeta(itemMetaZhanShen);


    }

}
