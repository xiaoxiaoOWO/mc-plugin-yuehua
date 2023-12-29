package com.xiaoxiaoowo.yuehua.itemstack.other;

import com.xiaoxiaoowo.yuehua.system.DataContainer;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;

public final class MoneyLoot {
    //稀有度1
    public static final ItemStack ZHI_ZHU_YAN = new ItemStack(Material.DIAMOND, 1);
    public static final ItemStack PI_GE = new ItemStack(Material.DIAMOND, 1);
    public static final ItemStack TU_ZI_PI = new ItemStack(Material.DIAMOND, 1);


    //稀有度2
    public static final ItemStack MEI_TAN = new ItemStack(Material.DIAMOND, 1);
    public static final ItemStack XIAO_MAI = new ItemStack(Material.DIAMOND, 1);
    public static final ItemStack FU_ZHU = new ItemStack(Material.DIAMOND, 1);

    //稀有度3
    public static final ItemStack XI_RANG = new ItemStack(Material.DIAMOND, 1);
    public static final ItemStack TAO_CI_SUI = new ItemStack(Material.DIAMOND, 1);
    public static final ItemStack CU_TIE = new ItemStack(Material.DIAMOND, 1);

    //稀有度4
    public static final ItemStack YAO_NIAO_YU = new ItemStack(Material.DIAMOND, 1);
    public static final ItemStack YAO_NIAO_LEI = new ItemStack(Material.DIAMOND, 1);
    public static final ItemStack SHAN_HU_SHI = new ItemStack(Material.DIAMOND, 1);

    //稀有度5
    public static final ItemStack ZHANG_QI_TOU_LU = new ItemStack(Material.DIAMOND, 1);
    public static final ItemStack GOU_YU_BAI = new ItemStack(Material.DIAMOND, 1);
    public static final ItemStack GOU_YU_HEI = new ItemStack(Material.DIAMOND, 1);

    //稀有度6
    public static final ItemStack HU_PO = new ItemStack(Material.DIAMOND, 1);
    public static final ItemStack BIN_TIE = new ItemStack(Material.DIAMOND, 1);


    static {
        ZHI_ZHU_YAN.setCustomModelData(1);
        PI_GE.setCustomModelData(2);
        TU_ZI_PI.setCustomModelData(3);
        MEI_TAN.setCustomModelData(4);
        XIAO_MAI.setCustomModelData(5);
        FU_ZHU.setCustomModelData(6);
        XI_RANG.setCustomModelData(7);
        TAO_CI_SUI.setCustomModelData(8);
        CU_TIE.setCustomModelData(9);
        YAO_NIAO_YU.setCustomModelData(10);
        YAO_NIAO_LEI.setCustomModelData(11);
        SHAN_HU_SHI.setCustomModelData(12);
        ZHANG_QI_TOU_LU.setCustomModelData(13);
        GOU_YU_BAI.setCustomModelData(14);
        GOU_YU_HEI.setCustomModelData(15);
        HU_PO.setCustomModelData(16);
        BIN_TIE.setCustomModelData(17);

        ItemMeta zhizhuyan = ZHI_ZHU_YAN.getItemMeta();
        zhizhuyan.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"zhizhuyan");
        zhizhuyan.displayName(Component.translatable("zhizhuyan"));
        zhizhuyan.lore(
                List.of(Component.translatable("rare1"),Component.translatable("ml"))
        );
        ZHI_ZHU_YAN.setItemMeta(zhizhuyan);

        ItemMeta pige = PI_GE.getItemMeta();
        pige.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"pige");
        pige.displayName(Component.translatable("pige"));
        pige.lore(
                List.of(Component.translatable("rare1"),Component.translatable("ml"))
        );
        PI_GE.setItemMeta(pige);

        ItemMeta tuzipi = TU_ZI_PI.getItemMeta();
        tuzipi.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"tuzipi");
        tuzipi.displayName(Component.translatable("tuzipi"));
        tuzipi.lore(
                List.of(Component.translatable("rare1"),Component.translatable("ml"))
        );
        TU_ZI_PI.setItemMeta(tuzipi);

        ItemMeta meitan = MEI_TAN.getItemMeta();
        meitan.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"meitan");
        meitan.displayName(Component.translatable("meitan"));
        meitan.lore(
                List.of(Component.translatable("rare2"),Component.translatable("ml"))
        );
        MEI_TAN.setItemMeta(meitan);

        ItemMeta xiaomai = XIAO_MAI.getItemMeta();
        xiaomai.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"xiaomai");
        xiaomai.displayName(Component.translatable("xiaomai"));
        xiaomai.lore(
                List.of(Component.translatable("rare2"),Component.translatable("ml"))
        );
        XIAO_MAI.setItemMeta(xiaomai);

        ItemMeta fuzhu = FU_ZHU.getItemMeta();
        fuzhu.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"fuzhu");
        fuzhu.displayName(Component.translatable("fuzhu"));
        fuzhu.lore(
                List.of(Component.translatable("rare2"),Component.translatable("ml"))
        );
        FU_ZHU.setItemMeta(fuzhu);

        ItemMeta taocisui = TAO_CI_SUI.getItemMeta();
        taocisui.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"taocisui");
        taocisui.displayName(Component.translatable("taocisui"));
        taocisui.lore(
                List.of(Component.translatable("rare3"),Component.translatable("ml"))
        );
        TAO_CI_SUI.setItemMeta(taocisui);

        ItemMeta cutie = CU_TIE.getItemMeta();
        cutie.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"cutie");
        cutie.displayName(Component.translatable("cutie"));
        cutie.lore(
                List.of(Component.translatable("rare3"),Component.translatable("ml"))
        );
        CU_TIE.setItemMeta(cutie);

        ItemMeta yaoniaolei = YAO_NIAO_LEI.getItemMeta();
        yaoniaolei.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"yaoniaolei");
        yaoniaolei.displayName(Component.translatable("yaoniaolei"));
        yaoniaolei.lore(
                List.of(Component.translatable("rare4"),Component.translatable("ml"))
        );
        YAO_NIAO_LEI.setItemMeta(yaoniaolei);

        ItemMeta shanhushi = SHAN_HU_SHI.getItemMeta();
        shanhushi.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"shanhushi");
        shanhushi.displayName(Component.translatable("shanhushi"));
        shanhushi.lore(
                List.of(Component.translatable("rare4"),Component.translatable("ml"))
        );
        SHAN_HU_SHI.setItemMeta(shanhushi);

        ItemMeta yaoniaoyu = YAO_NIAO_YU.getItemMeta();
        yaoniaoyu.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"yaoniaoyu");
        yaoniaoyu.displayName(Component.translatable("yaoniaoyu"));
        yaoniaoyu.lore(
                List.of(Component.translatable("rare4"),Component.translatable("ml"))
        );
        YAO_NIAO_YU.setItemMeta(yaoniaoyu);

        ItemMeta gouyubai = GOU_YU_BAI.getItemMeta();
        gouyubai.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"gouyubai");
        gouyubai.displayName(Component.translatable("gouyubai"));
        gouyubai.lore(
                List.of(Component.translatable("rare4=5"),Component.translatable("ml"))
        );
        GOU_YU_BAI.setItemMeta(gouyubai);

        ItemMeta gouyuhei = GOU_YU_HEI.getItemMeta();
        gouyuhei.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"gouyuhei");
        gouyuhei.displayName(Component.translatable("gouyuhei"));
        gouyuhei.lore(
                List.of(Component.translatable("rare5"),Component.translatable("ml"))
        );
        GOU_YU_HEI.setItemMeta(gouyuhei);

        ItemMeta zhangqitoulu = ZHANG_QI_TOU_LU.getItemMeta();
        zhangqitoulu.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"zhangqitoulu");
        zhangqitoulu.displayName(Component.translatable("zhangqitoulu"));
        zhangqitoulu.lore(
                List.of(Component.translatable("rare5"),Component.translatable("ml"))
        );
        ZHANG_QI_TOU_LU.setItemMeta(zhangqitoulu);

        ItemMeta hupo = HU_PO.getItemMeta();
        hupo.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"hupo");
        hupo.displayName(Component.translatable("hupo"));
        hupo.lore(
                List.of(Component.translatable("rare6"),Component.translatable("ml"))
        );
        HU_PO.setItemMeta(hupo);

        ItemMeta bintie = BIN_TIE.getItemMeta();
        bintie.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"bintie");
        bintie.displayName(Component.translatable("bintie"));
        bintie.lore(
                List.of(Component.translatable("rare6"),Component.translatable("ml"))
        );
        BIN_TIE.setItemMeta(bintie);























    }
}
