package com.xiaoxiaoowo.yuehua.itemstack.other;

import com.xiaoxiaoowo.yuehua.system.DataContainer;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public final class Money {
    public static final ItemStack tongQian = new ItemStack(Material.BRICK, 1);
    public static final ItemStack jinYuanBao = new ItemStack(Material.BRICK, 1);
    public static final ItemStack yinPiao = new ItemStack(Material.BRICK, 1);
    public static final ItemStack feiCui = new ItemStack(Material.BRICK, 1);
    public static final ItemStack MONEY_SHEN = new ItemStack(Material.BRICK, 1);
    public static final ItemStack MONEY_XIAN = new ItemStack(Material.BRICK, 1);
    public static final ItemStack MONEY_REN = new ItemStack(Material.BRICK, 1);
    public static final ItemStack MONEY_YAO = new ItemStack(Material.BRICK, 1);
    public static final ItemStack MONEY_ZHANSHEN = new ItemStack(Material.BRICK, 1);


    static {
        tongQian.setCustomModelData(1);
        jinYuanBao.setCustomModelData(2);
        yinPiao.setCustomModelData(3);
        feiCui.setCustomModelData(4);
        MONEY_SHEN.setCustomModelData(5);
        MONEY_XIAN.setCustomModelData(6);
        MONEY_REN.setCustomModelData(7);
        MONEY_YAO.setCustomModelData(8);
        MONEY_ZHANSHEN.setCustomModelData(9);

        ItemMeta itemMetaTongQian = tongQian.getItemMeta();
        ItemMeta itemMetaJinYuanBao = jinYuanBao.getItemMeta();
        ItemMeta itemMetaYinPiao = yinPiao.getItemMeta();
        ItemMeta itemMetaFeiCui = feiCui.getItemMeta();
        ItemMeta itemMetaMONEY_SHEN = MONEY_SHEN.getItemMeta();
        ItemMeta itemMetaMONEY_XIAN = MONEY_XIAN.getItemMeta();
        ItemMeta itemMetaMONEY_REN = MONEY_REN.getItemMeta();
        ItemMeta itemMetaMONEY_YAO = MONEY_YAO.getItemMeta();
        ItemMeta itemMetaMONEY_ZHANSHEN = MONEY_ZHANSHEN.getItemMeta();

        itemMetaTongQian.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "tongQian");
        itemMetaJinYuanBao.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "jinYuanBao");
        itemMetaYinPiao.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "yinPiao");
        itemMetaFeiCui.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "feiCui");
        itemMetaMONEY_SHEN.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "MONEY_SHEN");
        itemMetaMONEY_XIAN.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "MONEY_XIAN");
        itemMetaMONEY_REN.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "MONEY_REN");
        itemMetaMONEY_YAO.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "MONEY_YAO");
        itemMetaMONEY_ZHANSHEN.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "MONEY_ZHANSHEN");

        itemMetaTongQian.displayName(
                Component
                        .translatable("tongqian")
        );

        itemMetaJinYuanBao.displayName(
                Component
                        .translatable("jinyuanbao")
        );

        itemMetaYinPiao.displayName(
                Component
                        .translatable("yinpiao")
        );

        itemMetaFeiCui.displayName(
                Component
                        .translatable("feicui")
        );

        itemMetaMONEY_SHEN.displayName(
                Component
                        .translatable("moneyshen")
        );

        itemMetaMONEY_XIAN.displayName(
                Component
                        .translatable("moneyxian")
        );

        itemMetaMONEY_REN.displayName(
                Component
                        .translatable("moneyren")
        );

        itemMetaMONEY_YAO.displayName(
                Component
                        .translatable("moneyyao")
        );

        itemMetaMONEY_ZHANSHEN.displayName(
                Component
                        .translatable("moneyzhanshen")
        );

        tongQian.setItemMeta(itemMetaTongQian);
        jinYuanBao.setItemMeta(itemMetaJinYuanBao);
        yinPiao.setItemMeta(itemMetaYinPiao);
        feiCui.setItemMeta(itemMetaFeiCui);
        MONEY_SHEN.setItemMeta(itemMetaMONEY_SHEN);
        MONEY_XIAN.setItemMeta(itemMetaMONEY_XIAN);
        MONEY_REN.setItemMeta(itemMetaMONEY_REN);
        MONEY_YAO.setItemMeta(itemMetaMONEY_YAO);
        MONEY_ZHANSHEN.setItemMeta(itemMetaMONEY_ZHANSHEN);


    }
}
