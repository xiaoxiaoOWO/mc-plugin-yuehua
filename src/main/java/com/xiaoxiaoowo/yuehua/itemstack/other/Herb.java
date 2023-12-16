package com.xiaoxiaoowo.yuehua.itemstack.other;

import com.xiaoxiaoowo.yuehua.system.DataContainer;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;

public final class Herb {

    //3阶
    public static final ItemStack RenShen = new ItemStack(Material.FEATHER, 1);
    public static final ItemStack LingZhi = new ItemStack(Material.FEATHER, 1);
    public static final ItemStack HeShouWu = new ItemStack(Material.FEATHER, 1);

    //4阶,其中河豚不是怪物掉落
    public static final ItemStack GouQi = new ItemStack(Material.FEATHER, 1);
    public static final ItemStack HeTun = new ItemStack(Material.FEATHER, 1);
    public static final ItemStack HaiMa = new ItemStack(Material.FEATHER, 1);

    //5阶，其中阿胶不少怪物掉落
    public static final ItemStack ZhenZhu = new ItemStack(Material.FEATHER, 1);
    public static final ItemStack LuRong = new ItemStack(Material.FEATHER, 1);
    public static final ItemStack EJiao = new ItemStack(Material.FEATHER, 1);

    //6阶，全都不是怪物掉落
    public static final ItemStack DongChongXiaCao = new ItemStack(Material.FEATHER, 1);
    public static final ItemStack TiePiShiHu = new ItemStack(Material.FEATHER, 1);
    public static final ItemStack TianRanNiuHuang = new ItemStack(Material.FEATHER, 1);

    static {
        RenShen.setCustomModelData(1);
        LingZhi.setCustomModelData(2);
        HeShouWu.setCustomModelData(3);
        ZhenZhu.setCustomModelData(4);
        GouQi.setCustomModelData(5);
        HeTun.setCustomModelData(6);
        HaiMa.setCustomModelData(7);
        LuRong.setCustomModelData(8);
        EJiao.setCustomModelData(9);
        DongChongXiaCao.setCustomModelData(10);
        TiePiShiHu.setCustomModelData(11);
        TianRanNiuHuang.setCustomModelData(12);

        ItemMeta itemMeta1 = RenShen.getItemMeta();
        ItemMeta itemMeta2 = LingZhi.getItemMeta();
        ItemMeta itemMeta3 = HeShouWu.getItemMeta();
        ItemMeta itemMeta4 = ZhenZhu.getItemMeta();
        ItemMeta itemMeta5 = GouQi.getItemMeta();
        ItemMeta itemMeta6 = HeTun.getItemMeta();
        ItemMeta itemMeta7 = HaiMa.getItemMeta();
        ItemMeta itemMeta8 = LuRong.getItemMeta();
        ItemMeta itemMeta9 = EJiao.getItemMeta();
        ItemMeta itemMeta10 = DongChongXiaCao.getItemMeta();
        ItemMeta itemMeta11 = TiePiShiHu.getItemMeta();
        ItemMeta itemMeta12 = TianRanNiuHuang.getItemMeta();

        itemMeta1.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "renshen");
        itemMeta2.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "lingzhi");
        itemMeta3.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "heshouwu");
        itemMeta4.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "zhenzhu");
        itemMeta5.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "gouqi");
        itemMeta6.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "hetun");
        itemMeta7.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "haima");
        itemMeta8.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "lurong");
        itemMeta9.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "ejiao");
        itemMeta10.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "dongchongxiacao");
        itemMeta11.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "tiepishihu");
        itemMeta12.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "tianranniuhaung");
        itemMeta1.displayName(
                Component
                        .translatable("renshen")
        );

        itemMeta2.displayName(
                Component
                        .translatable("lingzhi")
        );

        itemMeta3.displayName(
                Component
                        .translatable("heshouwu")
        );

        itemMeta4.displayName(
                Component
                        .translatable("zhenzhu")
        );

        itemMeta5.displayName(
                Component
                        .translatable("gouqi")
        );

        itemMeta6.displayName(
                Component
                        .translatable("hetun")
        );

        itemMeta7.displayName(
                Component
                        .translatable("haima")
        );

        itemMeta8.displayName(
                Component
                        .translatable("lurong")
        );
        itemMeta9.displayName(
                Component
                        .translatable("ejiao")
        );
        itemMeta10.displayName(
                Component
                        .translatable("dongchongxiacao")
        );
        itemMeta11.displayName(
                Component
                        .translatable("tiepishihu")
        );
        itemMeta12.displayName(
                Component
                        .translatable("tianranniuhaung")
        );

        itemMeta1.lore(
                List.of(Component.translatable("rare3"))
        );

        itemMeta2.lore(
                List.of(Component.translatable("rare3"))
        );
        itemMeta3.lore(
                List.of(Component.translatable("rare3"))
        );
        itemMeta4.lore(
                List.of(Component.translatable("rare5"))
        );
        itemMeta5.lore(
                List.of(Component.translatable("rare4"))
        );
        itemMeta6.lore(
                List.of(Component.translatable("rare4"))
        );
        itemMeta7.lore(
                List.of(Component.translatable("rare4"))
        );
        itemMeta8.lore(
                List.of(Component.translatable("rare5"))
        );
        itemMeta9.lore(
                List.of(Component.translatable("rare5"))
        );
        itemMeta10.lore(
                List.of(Component.translatable("rare6"))
        );
        itemMeta11.lore(
                List.of(Component.translatable("rare6"))
        );
        itemMeta12.lore(
                List.of(Component.translatable("rare6"))
        );

        RenShen.setItemMeta(itemMeta1);
        LingZhi.setItemMeta(itemMeta2);
        HeShouWu.setItemMeta(itemMeta3);
        ZhenZhu.setItemMeta(itemMeta4);
        GouQi.setItemMeta(itemMeta5);
        HeTun.setItemMeta(itemMeta6);
        HaiMa.setItemMeta(itemMeta7);
        LuRong.setItemMeta(itemMeta8);
        EJiao.setItemMeta(itemMeta9);
        DongChongXiaCao.setItemMeta(itemMeta10);
        TiePiShiHu.setItemMeta(itemMeta11);
        TianRanNiuHuang.setItemMeta(itemMeta12);
    }
}
