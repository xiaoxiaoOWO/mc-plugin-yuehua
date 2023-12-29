package com.xiaoxiaoowo.yuehua.itemstack.dz;

import com.xiaoxiaoowo.yuehua.system.DataContainer;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;

public final class YuShi {
    //近战攻击，血色石
    public final static ItemStack XUE_SE_SHI1 = new ItemStack(Material.EMERALD);
    public final static ItemStack XUE_SE_SHI2 = new ItemStack(Material.EMERALD);
    public final static ItemStack XUE_SE_SHI3 = new ItemStack(Material.EMERALD);
    public final static ItemStack XUE_SE_SHI4 = new ItemStack(Material.EMERALD);
    public final static ItemStack XUE_SE_SHI5 = new ItemStack(Material.EMERALD);
    public final static ItemStack XUE_SE_SHI6 = new ItemStack(Material.EMERALD);
    public final static ItemStack XUE_SE_SHI7 = new ItemStack(Material.EMERALD);
    public final static ItemStack XUE_SE_SHI8 = new ItemStack(Material.EMERALD);

    //箭强，翠绿石
    public final static ItemStack CUI_LV_SHI1 = new ItemStack(Material.EMERALD);
    public final static ItemStack CUI_LV_SHI2 = new ItemStack(Material.EMERALD);
    public final static ItemStack CUI_LV_SHI3 = new ItemStack(Material.EMERALD);
    public final static ItemStack CUI_LV_SHI4 = new ItemStack(Material.EMERALD);
    public final static ItemStack CUI_LV_SHI5 = new ItemStack(Material.EMERALD);
    public final static ItemStack CUI_LV_SHI6 = new ItemStack(Material.EMERALD);
    public final static ItemStack CUI_LV_SHI7 = new ItemStack(Material.EMERALD);
    public final static ItemStack CUI_LV_SHI8 = new ItemStack(Material.EMERALD);

    //法强，靛蓝石
    public final static ItemStack DIAN_LAN_SHI1 = new ItemStack(Material.EMERALD);
    public final static ItemStack DIAN_LAN_SHI2 = new ItemStack(Material.EMERALD);
    public final static ItemStack DIAN_LAN_SHI3 = new ItemStack(Material.EMERALD);
    public final static ItemStack DIAN_LAN_SHI4 = new ItemStack(Material.EMERALD);
    public final static ItemStack DIAN_LAN_SHI5 = new ItemStack(Material.EMERALD);
    public final static ItemStack DIAN_LAN_SHI6 = new ItemStack(Material.EMERALD);
    public final static ItemStack DIAN_LAN_SHI7 = new ItemStack(Material.EMERALD);
    public final static ItemStack DIAN_LAN_SHI8 = new ItemStack(Material.EMERALD);

    //护甲，金黄石
    public final static ItemStack JIN_HUANG_SHI1 = new ItemStack(Material.EMERALD);
    public final static ItemStack JIN_HUANG_SHI2 = new ItemStack(Material.EMERALD);
    public final static ItemStack JIN_HUANG_SHI3 = new ItemStack(Material.EMERALD);
    public final static ItemStack JIN_HUANG_SHI4 = new ItemStack(Material.EMERALD);
    public final static ItemStack JIN_HUANG_SHI5 = new ItemStack(Material.EMERALD);
    public final static ItemStack JIN_HUANG_SHI6 = new ItemStack(Material.EMERALD);
    public final static ItemStack JIN_HUANG_SHI7 = new ItemStack(Material.EMERALD);
    public final static ItemStack JIN_HUANG_SHI8 = new ItemStack(Material.EMERALD);

    //护具韧性，厚土石
    public final static ItemStack HOU_TU_SHI1 = new ItemStack(Material.EMERALD);
    public final static ItemStack HOU_TU_SHI2 = new ItemStack(Material.EMERALD);
    public final static ItemStack HOU_TU_SHI3 = new ItemStack(Material.EMERALD);
    public final static ItemStack HOU_TU_SHI4 = new ItemStack(Material.EMERALD);
    public final static ItemStack HOU_TU_SHI5 = new ItemStack(Material.EMERALD);
    public final static ItemStack HOU_TU_SHI6 = new ItemStack(Material.EMERALD);
    public final static ItemStack HOU_TU_SHI7 = new ItemStack(Material.EMERALD);
    public final static ItemStack HOU_TU_SHI8 = new ItemStack(Material.EMERALD);

    //生命，紫晶石
    public final static ItemStack ZI_JING_SHI1 = new ItemStack(Material.EMERALD);
    public final static ItemStack ZI_JING_SHI2 = new ItemStack(Material.EMERALD);
    public final static ItemStack ZI_JING_SHI3 = new ItemStack(Material.EMERALD);
    public final static ItemStack ZI_JING_SHI4 = new ItemStack(Material.EMERALD);
    public final static ItemStack ZI_JING_SHI5 = new ItemStack(Material.EMERALD);
    public final static ItemStack ZI_JING_SHI6 = new ItemStack(Material.EMERALD);
    public final static ItemStack ZI_JING_SHI7 = new ItemStack(Material.EMERALD);
    public final static ItemStack ZI_JING_SHI8 = new ItemStack(Material.EMERALD);

    //暴击率，屠戮石
    public final static ItemStack TU_LU_SHI1 = new ItemStack(Material.EMERALD);
    public final static ItemStack TU_LU_SHI2 = new ItemStack(Material.EMERALD);
    public final static ItemStack TU_LU_SHI3 = new ItemStack(Material.EMERALD);
    public final static ItemStack TU_LU_SHI4 = new ItemStack(Material.EMERALD);
    public final static ItemStack TU_LU_SHI5 = new ItemStack(Material.EMERALD);
    public final static ItemStack TU_LU_SHI6 = new ItemStack(Material.EMERALD);
    public final static ItemStack TU_LU_SHI7 = new ItemStack(Material.EMERALD);
    public final static ItemStack TU_LU_SHI8 = new ItemStack(Material.EMERALD);

    //暴击效果，红月石
    public final static ItemStack HONG_YUE_SHI1 = new ItemStack(Material.EMERALD);
    public final static ItemStack HONG_YUE_SHI2 = new ItemStack(Material.EMERALD);
    public final static ItemStack HONG_YUE_SHI3 = new ItemStack(Material.EMERALD);
    public final static ItemStack HONG_YUE_SHI4 = new ItemStack(Material.EMERALD);
    public final static ItemStack HONG_YUE_SHI5 = new ItemStack(Material.EMERALD);
    public final static ItemStack HONG_YUE_SHI6 = new ItemStack(Material.EMERALD);
    public final static ItemStack HONG_YUE_SHI7 = new ItemStack(Material.EMERALD);
    public final static ItemStack HONG_YUE_SHI8 = new ItemStack(Material.EMERALD);

    //韧性，秘银石
    public final static ItemStack MI_YIN_SHI1 = new ItemStack(Material.EMERALD);
    public final static ItemStack MI_YIN_SHI2 = new ItemStack(Material.EMERALD);
    public final static ItemStack MI_YIN_SHI3 = new ItemStack(Material.EMERALD);
    public final static ItemStack MI_YIN_SHI4 = new ItemStack(Material.EMERALD);
    public final static ItemStack MI_YIN_SHI5 = new ItemStack(Material.EMERALD);
    public final static ItemStack MI_YIN_SHI6 = new ItemStack(Material.EMERALD);
    public final static ItemStack MI_YIN_SHI7 = new ItemStack(Material.EMERALD);
    public final static ItemStack MI_YIN_SHI8 = new ItemStack(Material.EMERALD);

    //生机，雨露石
    public final static ItemStack YU_LU_SHI1 = new ItemStack(Material.EMERALD);
    public final static ItemStack YU_LU_SHI2 = new ItemStack(Material.EMERALD);
    public final static ItemStack YU_LU_SHI3 = new ItemStack(Material.EMERALD);
    public final static ItemStack YU_LU_SHI4 = new ItemStack(Material.EMERALD);
    public final static ItemStack YU_LU_SHI5 = new ItemStack(Material.EMERALD);
    public final static ItemStack YU_LU_SHI6 = new ItemStack(Material.EMERALD);
    public final static ItemStack YU_LU_SHI7 = new ItemStack(Material.EMERALD);
    public final static ItemStack YU_LU_SHI8 = new ItemStack(Material.EMERALD);

    //法抗，冰霜石
    public final static ItemStack BING_SHUANG_SHI1 = new ItemStack(Material.EMERALD);
    public final static ItemStack BING_SHUANG_SHI2 = new ItemStack(Material.EMERALD);
    public final static ItemStack BING_SHUANG_SHI3 = new ItemStack(Material.EMERALD);
    public final static ItemStack BING_SHUANG_SHI4 = new ItemStack(Material.EMERALD);
    public final static ItemStack BING_SHUANG_SHI5 = new ItemStack(Material.EMERALD);
    public final static ItemStack BING_SHUANG_SHI6 = new ItemStack(Material.EMERALD);
    public final static ItemStack BING_SHUANG_SHI7 = new ItemStack(Material.EMERALD);
    public final static ItemStack BING_SHUANG_SHI8 = new ItemStack(Material.EMERALD);

    //破法，炎阳石
    public final static ItemStack YAN_YANG_SHI1 = new ItemStack(Material.EMERALD);
    public final static ItemStack YAN_YANG_SHI2 = new ItemStack(Material.EMERALD);
    public final static ItemStack YAN_YANG_SHI3 = new ItemStack(Material.EMERALD);
    public final static ItemStack YAN_YANG_SHI4 = new ItemStack(Material.EMERALD);
    public final static ItemStack YAN_YANG_SHI5 = new ItemStack(Material.EMERALD);
    public final static ItemStack YAN_YANG_SHI6 = new ItemStack(Material.EMERALD);
    public final static ItemStack YAN_YANG_SHI7 = new ItemStack(Material.EMERALD);
    public final static ItemStack YAN_YANG_SHI8 = new ItemStack(Material.EMERALD);


    static {
        XUE_SE_SHI1.setCustomModelData(1);
        XUE_SE_SHI2.setCustomModelData(2);
        XUE_SE_SHI3.setCustomModelData(3);
        XUE_SE_SHI4.setCustomModelData(4);
        XUE_SE_SHI5.setCustomModelData(5);
        XUE_SE_SHI6.setCustomModelData(6);
        XUE_SE_SHI7.setCustomModelData(7);
        XUE_SE_SHI8.setCustomModelData(8);

        CUI_LV_SHI1.setCustomModelData(9);
        CUI_LV_SHI2.setCustomModelData(10);
        CUI_LV_SHI3.setCustomModelData(11);
        CUI_LV_SHI4.setCustomModelData(12);
        CUI_LV_SHI5.setCustomModelData(13);
        CUI_LV_SHI6.setCustomModelData(14);
        CUI_LV_SHI7.setCustomModelData(15);
        CUI_LV_SHI8.setCustomModelData(16);

        DIAN_LAN_SHI1.setCustomModelData(17);
        DIAN_LAN_SHI2.setCustomModelData(18);
        DIAN_LAN_SHI3.setCustomModelData(19);
        DIAN_LAN_SHI4.setCustomModelData(20);
        DIAN_LAN_SHI5.setCustomModelData(21);
        DIAN_LAN_SHI6.setCustomModelData(22);
        DIAN_LAN_SHI7.setCustomModelData(23);
        DIAN_LAN_SHI8.setCustomModelData(24);

        JIN_HUANG_SHI1.setCustomModelData(25);
        JIN_HUANG_SHI2.setCustomModelData(26);
        JIN_HUANG_SHI3.setCustomModelData(27);
        JIN_HUANG_SHI4.setCustomModelData(28);
        JIN_HUANG_SHI5.setCustomModelData(29);
        JIN_HUANG_SHI6.setCustomModelData(30);
        JIN_HUANG_SHI7.setCustomModelData(31);
        JIN_HUANG_SHI8.setCustomModelData(32);

        HOU_TU_SHI1.setCustomModelData(33);
        HOU_TU_SHI2.setCustomModelData(34);
        HOU_TU_SHI3.setCustomModelData(35);
        HOU_TU_SHI4.setCustomModelData(36);
        HOU_TU_SHI5.setCustomModelData(37);
        HOU_TU_SHI6.setCustomModelData(38);
        HOU_TU_SHI7.setCustomModelData(39);
        HOU_TU_SHI8.setCustomModelData(40);

        ZI_JING_SHI1.setCustomModelData(41);
        ZI_JING_SHI2.setCustomModelData(42);
        ZI_JING_SHI3.setCustomModelData(43);
        ZI_JING_SHI4.setCustomModelData(44);
        ZI_JING_SHI5.setCustomModelData(45);
        ZI_JING_SHI6.setCustomModelData(46);
        ZI_JING_SHI7.setCustomModelData(47);
        ZI_JING_SHI8.setCustomModelData(48);

        TU_LU_SHI1.setCustomModelData(49);
        TU_LU_SHI2.setCustomModelData(50);
        TU_LU_SHI3.setCustomModelData(51);
        TU_LU_SHI4.setCustomModelData(52);
        TU_LU_SHI5.setCustomModelData(53);
        TU_LU_SHI6.setCustomModelData(54);
        TU_LU_SHI7.setCustomModelData(55);
        TU_LU_SHI8.setCustomModelData(56);

        HONG_YUE_SHI1.setCustomModelData(57);
        HONG_YUE_SHI2.setCustomModelData(58);
        HONG_YUE_SHI3.setCustomModelData(59);
        HONG_YUE_SHI4.setCustomModelData(60);
        HONG_YUE_SHI5.setCustomModelData(61);
        HONG_YUE_SHI6.setCustomModelData(62);
        HONG_YUE_SHI7.setCustomModelData(63);
        HONG_YUE_SHI8.setCustomModelData(64);

        MI_YIN_SHI1.setCustomModelData(65);
        MI_YIN_SHI2.setCustomModelData(66);
        MI_YIN_SHI3.setCustomModelData(67);
        MI_YIN_SHI4.setCustomModelData(68);
        MI_YIN_SHI5.setCustomModelData(69);
        MI_YIN_SHI6.setCustomModelData(70);
        MI_YIN_SHI7.setCustomModelData(71);
        MI_YIN_SHI8.setCustomModelData(72);

        YU_LU_SHI1.setCustomModelData(73);
        YU_LU_SHI2.setCustomModelData(74);
        YU_LU_SHI3.setCustomModelData(75);
        YU_LU_SHI4.setCustomModelData(76);
        YU_LU_SHI5.setCustomModelData(77);
        YU_LU_SHI6.setCustomModelData(78);
        YU_LU_SHI7.setCustomModelData(79);
        YU_LU_SHI8.setCustomModelData(80);

        BING_SHUANG_SHI1.setCustomModelData(81);
        BING_SHUANG_SHI2.setCustomModelData(82);
        BING_SHUANG_SHI3.setCustomModelData(83);
        BING_SHUANG_SHI4.setCustomModelData(84);
        BING_SHUANG_SHI5.setCustomModelData(85);
        BING_SHUANG_SHI6.setCustomModelData(86);
        BING_SHUANG_SHI7.setCustomModelData(87);
        BING_SHUANG_SHI8.setCustomModelData(88);

        YAN_YANG_SHI1.setCustomModelData(89);
        YAN_YANG_SHI2.setCustomModelData(90);
        YAN_YANG_SHI3.setCustomModelData(91);
        YAN_YANG_SHI4.setCustomModelData(92);
        YAN_YANG_SHI5.setCustomModelData(93);
        YAN_YANG_SHI6.setCustomModelData(94);
        YAN_YANG_SHI7.setCustomModelData(95);
        YAN_YANG_SHI8.setCustomModelData(96);

        ItemMeta xueseshi1 = XUE_SE_SHI1.getItemMeta();
        xueseshi1.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"xueseshi1");
        xueseshi1.displayName(
                Component.translatable("xueseshi1")
        );
        xueseshi1.lore(
                List.of(Component.translatable("rare1"),
                        Component.translatable("attackadd",Component.text("1").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                )
        );
        XUE_SE_SHI1.setItemMeta(xueseshi1);

        ItemMeta xueseshi2 = XUE_SE_SHI2.getItemMeta();
        xueseshi2.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"xueseshi2");
        xueseshi2.displayName(
                Component.translatable("xueseshi2")
        );
        xueseshi2.lore(
                List.of(Component.translatable("rare2"),
                        Component.translatable("attackadd",Component.text("2").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                )
        );
        XUE_SE_SHI2.setItemMeta(xueseshi2);

        ItemMeta xueseshi3 = XUE_SE_SHI3.getItemMeta();
        xueseshi3.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"xueseshi3");
        xueseshi3.displayName(
                Component.translatable("xueseshi3")
        );
        xueseshi3.lore(
                List.of(Component.translatable("rare3"),
                        Component.translatable("attackadd",Component.text("4").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                )
        );
        XUE_SE_SHI3.setItemMeta(xueseshi3);

        ItemMeta xueseshi4 = XUE_SE_SHI4.getItemMeta();
        xueseshi4.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"xueseshi4");
        xueseshi4.displayName(
                Component.translatable("xueseshi4")
        );
        xueseshi4.lore(
                List.of(Component.translatable("rare4"),
                        Component.translatable("attackadd",Component.text("7").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                )
        );
        XUE_SE_SHI4.setItemMeta(xueseshi4);

        ItemMeta xueseshi5 = XUE_SE_SHI5.getItemMeta();
        xueseshi5.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"xueseshi5");
        xueseshi5.displayName(
                Component.translatable("xueseshi5")
        );
        xueseshi5.lore(
                List.of(Component.translatable("rare5"),
                        Component.translatable("attackadd",Component.text("11").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                )
        );
        XUE_SE_SHI5.setItemMeta(xueseshi5);

        ItemMeta xueseshi6 = XUE_SE_SHI6.getItemMeta();
        xueseshi6.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"xueseshi6");
        xueseshi6.displayName(
                Component.translatable("xueseshi6")
        );
        xueseshi6.lore(
                List.of(Component.translatable("rare6"),
                        Component.translatable("attackadd",Component.text("16").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                )
        );
        XUE_SE_SHI6.setItemMeta(xueseshi6);

        ItemMeta xueseshi7 = XUE_SE_SHI7.getItemMeta();
        xueseshi7.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"xueseshi7");
        xueseshi7.displayName(
                Component.translatable("xueseshi7")
        );
        xueseshi7.lore(
                List.of(Component.translatable("rare7"),
                        Component.translatable("attackadd",Component.text("22").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                )
        );
        XUE_SE_SHI7.setItemMeta(xueseshi7);

        ItemMeta xueseshi8 = XUE_SE_SHI8.getItemMeta();
        xueseshi8.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"xueseshi8");
        xueseshi8.displayName(
                Component.translatable("xueseshi8")
        );
        xueseshi8.lore(
                List.of(Component.translatable("rare8"),
                        Component.translatable("attackadd",Component.text("29").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                )
        );
        XUE_SE_SHI8.setItemMeta(xueseshi8);

        ItemMeta cuilvshi1 = CUI_LV_SHI1.getItemMeta();
        cuilvshi1.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"cuilvshi1");
        cuilvshi1.displayName(
                Component.translatable("cuilvshi1")
        );
        cuilvshi1.lore(
                List.of(Component.translatable("rare1"),
                        Component.translatable("arrowadd",Component.text("1").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                )
        );
        CUI_LV_SHI1.setItemMeta(cuilvshi1);

        ItemMeta cuilvshi2 = CUI_LV_SHI2.getItemMeta();
        cuilvshi2.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"cuilvshi2");
        cuilvshi2.displayName(
                Component.translatable("cuilvshi2")
        );
        cuilvshi2.lore(
                List.of(Component.translatable("rare2"),
                        Component.translatable("arrowadd",Component.text("2").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                )
        );
        CUI_LV_SHI2.setItemMeta(cuilvshi2);

        ItemMeta cuilvshi3 = CUI_LV_SHI3.getItemMeta();
        cuilvshi3.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"cuilvshi3");
        cuilvshi3.displayName(
                Component.translatable("cuilvshi3")
        );
        cuilvshi3.lore(
                List.of(Component.translatable("rare3"),
                        Component.translatable("arrowadd",Component.text("4").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                )
        );
        CUI_LV_SHI3.setItemMeta(cuilvshi3);

        ItemMeta cuilvshi4 = CUI_LV_SHI4.getItemMeta();
        cuilvshi4.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"cuilvshi4");
        cuilvshi4.displayName(
                Component.translatable("cuilvshi4")
        );
        cuilvshi4.lore(
                List.of(Component.translatable("rare4"),
                        Component.translatable("arrowadd",Component.text("7").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                )
        );
        CUI_LV_SHI4.setItemMeta(cuilvshi4);

        ItemMeta cuilvshi5 = CUI_LV_SHI5.getItemMeta();
        cuilvshi5.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"cuilvshi5");
        cuilvshi5.displayName(
                Component.translatable("cuilvshi5")
        );
        cuilvshi5.lore(
                List.of(Component.translatable("rare5"),
                        Component.translatable("arrowadd",Component.text("11").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                )
        );
        CUI_LV_SHI5.setItemMeta(cuilvshi5);

        ItemMeta cuilvshi6 = CUI_LV_SHI6.getItemMeta();
        cuilvshi6.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"cuilvshi6");
        cuilvshi6.displayName(
                Component.translatable("cuilvshi6")
        );
        cuilvshi6.lore(
                List.of(Component.translatable("rare6"),
                        Component.translatable("arrowadd",Component.text("16").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                )
        );
        CUI_LV_SHI6.setItemMeta(cuilvshi6);

        ItemMeta cuilvshi7 = CUI_LV_SHI7.getItemMeta();
        cuilvshi7.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"cuilvshi7");
        cuilvshi7.displayName(
                Component.translatable("cuilvshi7")
        );
        cuilvshi7.lore(
                List.of(Component.translatable("rare7"),
                        Component.translatable("arrowadd",Component.text("22").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                )
        );
        CUI_LV_SHI7.setItemMeta(cuilvshi7);

        ItemMeta cuilvshi8 = CUI_LV_SHI8.getItemMeta();
        cuilvshi8.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"cuilvshi8");
        cuilvshi8.displayName(
                Component.translatable("cuilvshi8")
        );
        cuilvshi8.lore(
                List.of(Component.translatable("rare8"),
                        Component.translatable("arrowadd",Component.text("29").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                )
        );
        CUI_LV_SHI8.setItemMeta(cuilvshi8);

        ItemMeta dianlanshi1 = DIAN_LAN_SHI1.getItemMeta();
        dianlanshi1.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"dianlanshi1");
        dianlanshi1.displayName(
                Component.translatable("dianlanshi1")
        );
        dianlanshi1.lore(
                List.of(Component.translatable("rare1"),
                        Component.translatable("zfadd",Component.text("1").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                )
        );
        DIAN_LAN_SHI1.setItemMeta(dianlanshi1);

        ItemMeta dianlanshi2 = DIAN_LAN_SHI2.getItemMeta();
        dianlanshi2.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"dianlanshi2");
        dianlanshi2.displayName(
                Component.translatable("dianlanshi2")
        );
        dianlanshi2.lore(
                List.of(Component.translatable("rare2"),
                        Component.translatable("zfadd",Component.text("2").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                )
        );
        DIAN_LAN_SHI2.setItemMeta(dianlanshi2);

        ItemMeta dianlanshi3 = DIAN_LAN_SHI3.getItemMeta();
        dianlanshi3.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"dianlanshi3");
        dianlanshi3.displayName(
                Component.translatable("dianlanshi3")
        );
        dianlanshi3.lore(
                List.of(Component.translatable("rare3"),
                        Component.translatable("zfadd",Component.text("4").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        DIAN_LAN_SHI3.setItemMeta(dianlanshi3);

        ItemMeta dianlanshi4 = DIAN_LAN_SHI4.getItemMeta();
        dianlanshi4.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"dianlanshi4");
        dianlanshi4.displayName(
                Component.translatable("dianlanshi4")
        );
        dianlanshi4.lore(
                List.of(Component.translatable("rare4"),
                        Component.translatable("zfadd",Component.text(7).color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                )
        );
        DIAN_LAN_SHI4.setItemMeta(dianlanshi4);

        ItemMeta dianlanshi5 = DIAN_LAN_SHI5.getItemMeta();
        dianlanshi5.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"dianlanshi5");
        dianlanshi5.displayName(
                Component.translatable("dianlanshi5")
        );
        dianlanshi5.lore(
                List.of(Component.translatable("rare5"),
                        Component.translatable("zfadd",Component.text("11").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                )
        );
        DIAN_LAN_SHI5.setItemMeta(dianlanshi5);

        ItemMeta dianlanshi6 = DIAN_LAN_SHI6.getItemMeta();
        dianlanshi6.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"dianlanshi6");
        dianlanshi6.displayName(
                Component.translatable("dianlanshi6")
        );
        dianlanshi6.lore(
                List.of(Component.translatable("rare6"),
                        Component.translatable("zfadd",Component.text("16").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                )
        );
        DIAN_LAN_SHI6.setItemMeta(dianlanshi6);

        ItemMeta dianlanshi7 = DIAN_LAN_SHI7.getItemMeta();
        dianlanshi7.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"dianlanshi7");
        dianlanshi7.displayName(
                Component.translatable("dianlanshi7")
        );
        dianlanshi7.lore(
                List.of(Component.translatable("rare7"),
                        Component.translatable("zfadd",Component.text("22").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                )
        );
        DIAN_LAN_SHI7.setItemMeta(dianlanshi7);

        ItemMeta dianlanshi8 = DIAN_LAN_SHI8.getItemMeta();
        dianlanshi8.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"dianlanshi8");
        dianlanshi8.displayName(
                Component.translatable("dianlanshi8")
        );
        dianlanshi8.lore(
                List.of(Component.translatable("rare8"),
                        Component.translatable("zfadd",Component.text("29").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                )
        );
        DIAN_LAN_SHI8.setItemMeta(dianlanshi8);

        ItemMeta jinhuangshi1 = JIN_HUANG_SHI1.getItemMeta();
        jinhuangshi1.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"jinhuangshi1");
        jinhuangshi1.displayName(
                Component.translatable("jinhuangshi1")
        );
        jinhuangshi1.lore(
                List.of(Component.translatable("rare1"),
                        Component.translatable("armoradd",Component.text("0.5").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                )
        );
        JIN_HUANG_SHI1.setItemMeta(jinhuangshi1);

        ItemMeta jinhuangshi2 = JIN_HUANG_SHI2.getItemMeta();
        jinhuangshi2.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"jinhuangshi2");
        jinhuangshi2.displayName(
                Component.translatable("jinhuangshi2")
        );
        jinhuangshi2.lore(
                List.of(Component.translatable("rare2"),
                        Component.translatable("armoradd",Component.text("1").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                )
        );
        JIN_HUANG_SHI2.setItemMeta(jinhuangshi2);

        ItemMeta jinhuangshi3 = JIN_HUANG_SHI3.getItemMeta();
        jinhuangshi3.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"jinhuangshi3");
        jinhuangshi3.displayName(
                Component.translatable("jinhuangshi3")
        );
        jinhuangshi3.lore(
                List.of(Component.translatable("rare3"),
                        Component.translatable("armoradd",Component.text("2").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                )
        );
        JIN_HUANG_SHI3.setItemMeta(jinhuangshi3);

        ItemMeta jinhuangshi4 = JIN_HUANG_SHI4.getItemMeta();
        jinhuangshi4.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"jinhuangshi4");
        jinhuangshi4.displayName(
                Component.translatable("jinhuangshi4")
        );
        jinhuangshi4.lore(
                List.of(Component.translatable("rare4"),
                        Component.translatable("armoradd",Component.text("3.5").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                )
        );
        JIN_HUANG_SHI4.setItemMeta(jinhuangshi4);

        ItemMeta jinhuangshi5 = JIN_HUANG_SHI5.getItemMeta();
        jinhuangshi5.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"jinhuangshi5");
        jinhuangshi5.displayName(
                Component.translatable("jinhuangshi5")
        );
        jinhuangshi5.lore(
                List.of(Component.translatable("rare5"),
                        Component.translatable("armoradd",Component.text("5.5").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                )
        );
        JIN_HUANG_SHI5.setItemMeta(jinhuangshi5);

        ItemMeta jinhuangshi6 = JIN_HUANG_SHI6.getItemMeta();
        jinhuangshi6.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"jinhuangshi6");
        jinhuangshi6.displayName(
                Component.translatable("jinhuangshi6")
        );
        jinhuangshi6.lore(
                List.of(Component.translatable("rare6"),
                        Component.translatable("armoradd",Component.text("8").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                )
        );
        JIN_HUANG_SHI6.setItemMeta(jinhuangshi6);

        ItemMeta jinhuangshi7 = JIN_HUANG_SHI7.getItemMeta();
        jinhuangshi7.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"jinhuangshi7");
        jinhuangshi7.displayName(
                Component.translatable("jinhuangshi7")
        );
        jinhuangshi7.lore(
                List.of(Component.translatable("rare7"),
                        Component.translatable("armoradd",Component.text("11").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                )
        );
        JIN_HUANG_SHI7.setItemMeta(jinhuangshi7);


        ItemMeta jinhuangshi8 = JIN_HUANG_SHI8.getItemMeta();
        jinhuangshi8.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"jinhuangshi8");
        jinhuangshi8.displayName(
                Component.translatable("jinhuangshi8")
        );
        jinhuangshi8.lore(
                List.of(Component.translatable("rare8"),
                        Component.translatable("armoradd",Component.text("14.5").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                )
        );
        JIN_HUANG_SHI8.setItemMeta(jinhuangshi8);

        ItemMeta houtushi1 = HOU_TU_SHI1.getItemMeta();
        houtushi1.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"houtushi1");
        houtushi1.displayName(
                Component.translatable("houtushi1")
        );
        houtushi1.lore(
                List.of(Component.translatable("rare1"),
                        Component.translatable("toughadd",Component.text("0.5").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                )
        );
        HOU_TU_SHI1.setItemMeta(houtushi1);

        ItemMeta houtushi2 = HOU_TU_SHI2.getItemMeta();
        houtushi2.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"houtushi2");
        houtushi2.displayName(
                Component.translatable("houtushi2")
        );
        houtushi2.lore(
                List.of(Component.translatable("rare2"),
                        Component.translatable("toughadd",Component.text("1").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                )
        );
        HOU_TU_SHI2.setItemMeta(houtushi2);

        ItemMeta houtushi3 = HOU_TU_SHI3.getItemMeta();
        houtushi3.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"houtushi3");
        houtushi3.displayName(
                Component.translatable("houtushi3")
        );
        houtushi3.lore(
                List.of(Component.translatable("rare3"),
                        Component.translatable("toughadd",Component.text("1.5").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        HOU_TU_SHI3.setItemMeta(houtushi3);

        ItemMeta houtushi4 = HOU_TU_SHI4.getItemMeta();
        houtushi4.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"houtushi4");
        houtushi4.displayName(
                Component.translatable("houtushi4")
        );
        houtushi4.lore(
                List.of(Component.translatable("rare4"),
                        Component.translatable("toughadd",Component.text("2").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        HOU_TU_SHI4.setItemMeta(houtushi4);

        ItemMeta houtushi5 = HOU_TU_SHI5.getItemMeta();
        houtushi5.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"houtushi5");
        houtushi5.displayName(
                Component.translatable("houtushi5")
        );
        houtushi5.lore(
                List.of(Component.translatable("rare5"),
                        Component.translatable("toughadd",Component.text("3").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        HOU_TU_SHI5.setItemMeta(houtushi5);

        ItemMeta houtushi6 = HOU_TU_SHI6.getItemMeta();
        houtushi6.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"houtushi6");
        houtushi6.displayName(
                Component.translatable("houtushi6")
        );
        houtushi6.lore(
                List.of(Component.translatable("rare6"),
                        Component.translatable("toughadd",Component.text("4").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        HOU_TU_SHI6.setItemMeta(houtushi6);

        ItemMeta houtushi7 = HOU_TU_SHI7.getItemMeta();
        houtushi7.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"houtushi7");
        houtushi7.displayName(
                Component.translatable("houtushi7")
        );
        houtushi7.lore(
                List.of(Component.translatable("rare7"),
                        Component.translatable("toughadd",Component.text("5").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        HOU_TU_SHI7.setItemMeta(houtushi7);

        ItemMeta houtushi8 = HOU_TU_SHI8.getItemMeta();
        houtushi8.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"houtushi8");
        houtushi8.displayName(
                Component.translatable("houtushi8")
        );
        houtushi8.lore(
                List.of(Component.translatable("rare8"),
                        Component.translatable("toughadd",Component.text("7").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        HOU_TU_SHI8.setItemMeta(houtushi8);

        ItemMeta zijingshi1 = ZI_JING_SHI1.getItemMeta();
        zijingshi1.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"zijingshi1");
        zijingshi1.displayName(
                Component.translatable("zijingshi1")
        );
        zijingshi1.lore(
                List.of(Component.translatable("rare1"),
                        Component.translatable("hpadd",Component.text("2").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        ZI_JING_SHI1.setItemMeta(zijingshi1);

        ItemMeta zijingshi2 = ZI_JING_SHI2.getItemMeta();
        zijingshi2.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"zijingshi2");
        zijingshi2.displayName(
                Component.translatable("zijingshi2")
        );
        zijingshi2.lore(
                List.of(Component.translatable("rare2"),
                        Component.translatable("hpadd",Component.text("4").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        ZI_JING_SHI2.setItemMeta(zijingshi2);

        ItemMeta zijingshi3 = ZI_JING_SHI3.getItemMeta();
        zijingshi3.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"zijingshi3");
        zijingshi3.displayName(
                Component.translatable("zijingshi3")
        );
        zijingshi3.lore(
                List.of(Component.translatable("rare3"),
                        Component.translatable("hpadd",Component.text("8").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        ZI_JING_SHI3.setItemMeta(zijingshi3);

        ItemMeta zijingshi4 = ZI_JING_SHI4.getItemMeta();
        zijingshi4.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"zijingshi4");
        zijingshi4.displayName(
                Component.translatable("zijingshi4")
        );
        zijingshi4.lore(
                List.of(Component.translatable("rare4"),
                        Component.translatable("hpadd",Component.text("14").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        ZI_JING_SHI4.setItemMeta(zijingshi4);

        ItemMeta zijingshi5 = ZI_JING_SHI5.getItemMeta();
        zijingshi5.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"zijingshi5");
        zijingshi5.displayName(
                Component.translatable("zijingshi5")
        );
        zijingshi5.lore(
                List.of(Component.translatable("rare5"),
                        Component.translatable("hpadd",Component.text("22").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        ZI_JING_SHI5.setItemMeta(zijingshi5);

        ItemMeta zijingshi6 = ZI_JING_SHI6.getItemMeta();
        zijingshi6.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"zijingshi6");
        zijingshi6.displayName(
                Component.translatable("zijingshi6")
        );
        zijingshi6.lore(
                List.of(Component.translatable("rare6"),
                        Component.translatable("hpadd",Component.text("32").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        ZI_JING_SHI6.setItemMeta(zijingshi6);

        ItemMeta zijingshi7 = ZI_JING_SHI7.getItemMeta();
        zijingshi7.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"zijingshi7");
        zijingshi7.displayName(
                Component.translatable("zijingshi7")
        );
        zijingshi7.lore(
                List.of(Component.translatable("rare7"),
                        Component.translatable("hpadd",Component.text("44").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        ZI_JING_SHI7.setItemMeta(zijingshi7);

        ItemMeta zijingshi8 = ZI_JING_SHI8.getItemMeta();
        zijingshi8.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"zijingshi8");
        zijingshi8.displayName(
                Component.translatable("zijingshi8")
        );
        zijingshi8.lore(
                List.of(Component.translatable("rare8"),
                        Component.translatable("hpadd",Component.text("58").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );

        ItemMeta tulushi1 = TU_LU_SHI1.getItemMeta();
        tulushi1.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"tulushi1");
        tulushi1.displayName(
                Component.translatable("tulushi1")
        );
        tulushi1.lore(
                List.of(Component.translatable("rare1"),
                        Component.translatable("baojiadd",Component.text("0.5").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        TU_LU_SHI1.setItemMeta(tulushi1);

        ItemMeta tulushi2 = TU_LU_SHI2.getItemMeta();
        tulushi2.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"tulushi2");
        tulushi2.displayName(
                Component.translatable("tulushi2")
        );
        tulushi2.lore(
                List.of(Component.translatable("rare2"),
                        Component.translatable("baojiadd",Component.text("1").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        TU_LU_SHI2.setItemMeta(tulushi2);

        ItemMeta tulushi3 = TU_LU_SHI3.getItemMeta();
        tulushi3.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"tulushi3");
        tulushi3.displayName(
                Component.translatable("tulushi3")
        );
        tulushi3.lore(
                List.of(Component.translatable("rare3"),
                        Component.translatable("baojiadd",Component.text("2").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        TU_LU_SHI3.setItemMeta(tulushi3);

        ItemMeta tulushi4 = TU_LU_SHI4.getItemMeta();
        tulushi4.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"tulushi4");
        tulushi4.displayName(
                Component.translatable("tulushi4")
        );
        tulushi4.lore(
                List.of(Component.translatable("rare4"),
                        Component.translatable("baojiadd",Component.text("3.5").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        TU_LU_SHI4.setItemMeta(tulushi4);

        ItemMeta tulushi5 = TU_LU_SHI5.getItemMeta();
        tulushi5.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"tulushi5");
        tulushi5.displayName(
                Component.translatable("tulushi5")
        );
        tulushi5.lore(
                List.of(Component.translatable("rare5"),
                        Component.translatable("baojiadd",Component.text("5.5").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        TU_LU_SHI5.setItemMeta(tulushi5);

        ItemMeta tulushi6 = TU_LU_SHI6.getItemMeta();
        tulushi6.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"tulushi6");
        tulushi6.displayName(
                Component.translatable("tulushi6")
        );
        tulushi6.lore(
                List.of(Component.translatable("rare6"),
                        Component.translatable("baojiadd",Component.text("8").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        TU_LU_SHI6.setItemMeta(tulushi6);

        ItemMeta tulushi7 = TU_LU_SHI7.getItemMeta();
        tulushi7.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"tulushi7");
        tulushi7.displayName(
                Component.translatable("tulushi7")
        );
        tulushi7.lore(
                List.of(Component.translatable("rare7"),
                        Component.translatable("baojiadd",Component.text("11").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        TU_LU_SHI7.setItemMeta(tulushi7);

        ItemMeta tulushi8 = TU_LU_SHI8.getItemMeta();
        tulushi8.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"tulushi8");
        tulushi8.displayName(
                Component.translatable("tulushi8")
        );
        tulushi8.lore(
                List.of(Component.translatable("rare8"),
                        Component.translatable("baojiadd",Component.text("14.5").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        TU_LU_SHI8.setItemMeta(tulushi8);

        ItemMeta hongyueshi1 = HONG_YUE_SHI1.getItemMeta();
        hongyueshi1.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"hongyueshi1");
        hongyueshi1.displayName(
                Component.translatable("hongyueshi1")
        );
        hongyueshi1.lore(
                List.of(Component.translatable("rare1"),
                        Component.translatable("baojipoweradd",Component.text("1").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        HONG_YUE_SHI1.setItemMeta(hongyueshi1);

        ItemMeta hongyueshi2 = HONG_YUE_SHI2.getItemMeta();
        hongyueshi2.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"hongyueshi2");
        hongyueshi2.displayName(
                Component.translatable("hongyueshi2")
        );
        hongyueshi2.lore(
                List.of(Component.translatable("rare2"),
                        Component.translatable("baojipoweradd",Component.text("2").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        HONG_YUE_SHI2.setItemMeta(hongyueshi2);

        ItemMeta hongyueshi3 = HONG_YUE_SHI3.getItemMeta();
        hongyueshi3.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"hongyueshi3");
        hongyueshi3.displayName(
                Component.translatable("hongyueshi3")
        );
        hongyueshi3.lore(
                List.of(Component.translatable("rare3"),
                        Component.translatable("baojipoweradd",Component.text("4").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        HONG_YUE_SHI3.setItemMeta(hongyueshi3);

        ItemMeta hongyueshi4 = HONG_YUE_SHI4.getItemMeta();
        hongyueshi4.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"hongyueshi4");
        hongyueshi4.displayName(
                Component.translatable("hongyueshi4")
        );
        hongyueshi4.lore(
                List.of(Component.translatable("rare4"),
                        Component.translatable("baojipoweradd",Component.text("7").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        HONG_YUE_SHI4.setItemMeta(hongyueshi4);

        ItemMeta hongyueshi5 = HONG_YUE_SHI5.getItemMeta();
        hongyueshi5.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"hongyueshi5");
        hongyueshi5.displayName(
                Component.translatable("hongyueshi5")
        );
        hongyueshi5.lore(
                List.of(Component.translatable("rare5"),
                        Component.translatable("baojipoweradd",Component.text("11").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        HONG_YUE_SHI5.setItemMeta(hongyueshi5);

        ItemMeta hongyueshi6 = HONG_YUE_SHI6.getItemMeta();
        hongyueshi6.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"hongyueshi6");
        hongyueshi6.displayName(
                Component.translatable("hongyueshi6")
        );
        hongyueshi6.lore(
                List.of(Component.translatable("rare6"),
                        Component.translatable("baojipoweradd",Component.text("16").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        HONG_YUE_SHI6.setItemMeta(hongyueshi6);

        ItemMeta hongyueshi7 = HONG_YUE_SHI7.getItemMeta();
        hongyueshi7.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"hongyueshi7");
        hongyueshi7.displayName(
                Component.translatable("hongyueshi7")
        );
        hongyueshi7.lore(
                List.of(Component.translatable("rare7"),
                        Component.translatable("baojipoweradd",Component.text("22").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        HONG_YUE_SHI7.setItemMeta(hongyueshi7);

        ItemMeta hongyueshi8 = HONG_YUE_SHI8.getItemMeta();
        hongyueshi8.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"hongyueshi8");
        hongyueshi8.displayName(
                Component.translatable("hongyueshi8")
        );
        hongyueshi8.lore(
                List.of(Component.translatable("rare8"),
                        Component.translatable("baojipoweradd",Component.text("29").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );

        ItemMeta miyinshi1 = MI_YIN_SHI1.getItemMeta();
        miyinshi1.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"miyinshi1");
        miyinshi1.displayName(
                Component.translatable("miyinshi1")
        );
        miyinshi1.lore(
                List.of(Component.translatable("rare1"),
                        Component.translatable("rxadd",Component.text("1").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        MI_YIN_SHI1.setItemMeta(miyinshi1);

        ItemMeta miyinshi2 = MI_YIN_SHI2.getItemMeta();
        miyinshi2.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"miyinshi2");
        miyinshi2.displayName(
                Component.translatable("miyinshi2")
        );
        miyinshi2.lore(
                List.of(Component.translatable("rare2"),
                        Component.translatable("rxadd",Component.text("2").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        MI_YIN_SHI2.setItemMeta(miyinshi2);

        ItemMeta miyinshi3 = MI_YIN_SHI3.getItemMeta();
        miyinshi3.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"miyinshi3");
        miyinshi3.displayName(
                Component.translatable("miyinshi3")
        );
        miyinshi3.lore(
                List.of(Component.translatable("rare3"),
                        Component.translatable("rxadd",Component.text("4").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        MI_YIN_SHI3.setItemMeta(miyinshi3);

        ItemMeta miyinshi4 = MI_YIN_SHI4.getItemMeta();
        miyinshi4.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"miyinshi4");
        miyinshi4.displayName(
                Component.translatable("miyinshi4")
        );
        miyinshi4.lore(
                List.of(Component.translatable("rare4"),
                        Component.translatable("rxadd",Component.text("7").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        MI_YIN_SHI4.setItemMeta(miyinshi4);

        ItemMeta miyinshi5 = MI_YIN_SHI5.getItemMeta();
        miyinshi5.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"miyinshi5");
        miyinshi5.displayName(
                Component.translatable("miyinshi5")
        );
        miyinshi5.lore(
                List.of(Component.translatable("rare5"),
                        Component.translatable("rxadd",Component.text("11").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        MI_YIN_SHI5.setItemMeta(miyinshi5);


        ItemMeta miyinshi6 = MI_YIN_SHI6.getItemMeta();
        miyinshi6.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"miyinshi6");
        miyinshi6.displayName(
                Component.translatable("miyinshi6")
        );
        miyinshi6.lore(
                List.of(Component.translatable("rare6"),
                        Component.translatable("rxadd",Component.text("16").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        MI_YIN_SHI6.setItemMeta(miyinshi6);

        ItemMeta miyinshi7 = MI_YIN_SHI7.getItemMeta();
        miyinshi7.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"miyinshi7");
        miyinshi7.displayName(
                Component.translatable("miyinshi7")
        );
        miyinshi7.lore(
                List.of(Component.translatable("rare7"),
                        Component.translatable("rxadd",Component.text("22").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        MI_YIN_SHI7.setItemMeta(miyinshi7);

        ItemMeta miyinshi8 = MI_YIN_SHI8.getItemMeta();
        miyinshi8.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"miyinshi8");
        miyinshi8.displayName(
                Component.translatable("miyinshi8")
        );
        miyinshi8.lore(
                List.of(Component.translatable("rare8"),
                        Component.translatable("rxadd",Component.text("29").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );

        ItemMeta yulushi1 = YU_LU_SHI1.getItemMeta();
        yulushi1.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"yulushi1");
        yulushi1.displayName(
                Component.translatable("yulushi1")
        );
        yulushi1.lore(
                List.of(Component.translatable("rare1"),
                        Component.translatable("sjadd",Component.text("1").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        YU_LU_SHI1.setItemMeta(yulushi1);

        ItemMeta yulushi2 = YU_LU_SHI2.getItemMeta();
        yulushi2.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"yulushi2");
        yulushi2.displayName(
                Component.translatable("yulushi2")
        );
        yulushi2.lore(
                List.of(Component.translatable("rare2"),
                        Component.translatable("sjadd",Component.text("2").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        YU_LU_SHI2.setItemMeta(yulushi2);

        ItemMeta yulushi3 = YU_LU_SHI3.getItemMeta();
        yulushi3.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"yulushi3");
        yulushi3.displayName(
                Component.translatable("yulushi3")
        );
        yulushi3.lore(
                List.of(Component.translatable("rare3"),
                        Component.translatable("sjadd",Component.text("4").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        YU_LU_SHI3.setItemMeta(yulushi3);

        ItemMeta yulushi4 = YU_LU_SHI4.getItemMeta();
        yulushi4.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"yulushi4");
        yulushi4.displayName(
                Component.translatable("yulushi4")
        );
        yulushi4.lore(
                List.of(Component.translatable("rare4"),
                        Component.translatable("sjadd",Component.text("7").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        YU_LU_SHI4.setItemMeta(yulushi4);

        ItemMeta yulushi5 = YU_LU_SHI5.getItemMeta();
        yulushi5.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"yulushi5");
        yulushi5.displayName(
                Component.translatable("yulushi5")
        );
        yulushi5.lore(
                List.of(Component.translatable("rare5"),
                        Component.translatable("sjadd",Component.text("11").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        YU_LU_SHI5.setItemMeta(yulushi5);

        ItemMeta yulushi6 = YU_LU_SHI6.getItemMeta();
        yulushi6.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"yulushi6");
        yulushi6.displayName(
                Component.translatable("yulushi6")
        );
        yulushi6.lore(
                List.of(Component.translatable("rare6"),
                        Component.translatable("sjadd",Component.text("16").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        YU_LU_SHI6.setItemMeta(yulushi6);

        ItemMeta yulushi7 = YU_LU_SHI7.getItemMeta();
        yulushi7.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"yulushi7");
        yulushi7.displayName(
                Component.translatable("yulushi7")
        );
        yulushi7.lore(
                List.of(Component.translatable("rare7"),
                        Component.translatable("sjadd",Component.text("22").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        YU_LU_SHI7.setItemMeta(yulushi7);

        ItemMeta yulushi8 = YU_LU_SHI8.getItemMeta();
        yulushi8.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"yulushi8");
        yulushi8.displayName(
                Component.translatable("yulushi8")
        );
        yulushi8.lore(
                List.of(Component.translatable("rare8"),
                        Component.translatable("sjadd",Component.text("29").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        YU_LU_SHI8.setItemMeta(yulushi8);


        ItemMeta bingshuangshi1 = BING_SHUANG_SHI1.getItemMeta();
        bingshuangshi1.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"bingshuangshi1");
        bingshuangshi1.displayName(
                Component.translatable("bingshuangshi1")
        );
        bingshuangshi1.lore(
                List.of(Component.translatable("rare1"),
                        Component.translatable("fkadd",Component.text("0.5").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        BING_SHUANG_SHI1.setItemMeta(bingshuangshi1);

        ItemMeta bingshuangshi2 = BING_SHUANG_SHI2.getItemMeta();
        bingshuangshi2.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"bingshuangshi2");
        bingshuangshi2.displayName(
                Component.translatable("bingshuangshi2")
        );
        bingshuangshi2.lore(
                List.of(Component.translatable("rare2"),
                        Component.translatable("fkadd",Component.text("1").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        BING_SHUANG_SHI2.setItemMeta(bingshuangshi2);

        ItemMeta bingshuangshi3 = BING_SHUANG_SHI3.getItemMeta();
        bingshuangshi3.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"bingshuangshi3");
        bingshuangshi3.displayName(
                Component.translatable("bingshuangshi3")
        );
        bingshuangshi3.lore(
                List.of(Component.translatable("rare3"),
                        Component.translatable("fkadd",Component.text("2").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        BING_SHUANG_SHI3.setItemMeta(bingshuangshi3);

        ItemMeta bingshuangshi4 = BING_SHUANG_SHI4.getItemMeta();
        bingshuangshi4.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"bingshuangshi4");
        bingshuangshi4.displayName(
                Component.translatable("bingshuangshi4")
        );
        bingshuangshi4.lore(
                List.of(Component.translatable("rare4"),
                        Component.translatable("fkadd",Component.text("3.5").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        BING_SHUANG_SHI4.setItemMeta(bingshuangshi4);

        ItemMeta bingshuangshi5 = BING_SHUANG_SHI5.getItemMeta();
        bingshuangshi5.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"bingshuangshi5");
        bingshuangshi5.displayName(
                Component.translatable("bingshuangshi5")
        );
        bingshuangshi5.lore(
                List.of(Component.translatable("rare5"),
                        Component.translatable("fkadd",Component.text("5.5").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        BING_SHUANG_SHI5.setItemMeta(bingshuangshi5);

        ItemMeta bingshuangshi6 = BING_SHUANG_SHI6.getItemMeta();
        bingshuangshi6.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"bingshuangshi6");
        bingshuangshi6.displayName(
                Component.translatable("bingshuangshi6")
        );
        bingshuangshi6.lore(
                List.of(Component.translatable("rare6"),
                        Component.translatable("fkadd",Component.text("8").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        BING_SHUANG_SHI6.setItemMeta(bingshuangshi6);

        ItemMeta bingshuangshi7 = BING_SHUANG_SHI7.getItemMeta();
        bingshuangshi7.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"bingshuangshi7");
        bingshuangshi7.displayName(
                Component.translatable("bingshuangshi7")
        );
        bingshuangshi7.lore(
                List.of(Component.translatable("rare7"),
                        Component.translatable("fkadd",Component.text("11").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        BING_SHUANG_SHI7.setItemMeta(bingshuangshi7);


        ItemMeta bingshuangshi8 = BING_SHUANG_SHI8.getItemMeta();
        bingshuangshi8.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"bingshuangshi8");
        bingshuangshi8.displayName(
                Component.translatable("bingshuangshi8")
        );
        bingshuangshi8.lore(
                List.of(Component.translatable("rare8"),
                        Component.translatable("fkadd",Component.text("14").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        BING_SHUANG_SHI8.setItemMeta(bingshuangshi8);

        ItemMeta yanyangshi1 = YAN_YANG_SHI1.getItemMeta();
        yanyangshi1.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"yanyangshi1");
        yanyangshi1.displayName(
                Component.translatable("yanyangshi1")
        );
        yanyangshi1.lore(
                List.of(Component.translatable("rare1"),
                        Component.translatable("pfadd",Component.text("1").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        YAN_YANG_SHI1.setItemMeta(yanyangshi1);

        ItemMeta yanyangshi2 = YAN_YANG_SHI2.getItemMeta();
        yanyangshi2.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"yanyangshi2");
        yanyangshi2.displayName(
                Component.translatable("yanyangshi2")
        );
        yanyangshi2.lore(
                List.of(Component.translatable("rare2"),
                        Component.translatable("pfadd",Component.text("2").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        YAN_YANG_SHI2.setItemMeta(yanyangshi2);

        ItemMeta yanyangshi3 = YAN_YANG_SHI3.getItemMeta();
        yanyangshi3.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"yanyangshi3");
        yanyangshi3.displayName(
                Component.translatable("yanyangshi3")
        );
        yanyangshi3.lore(
                List.of(Component.translatable("rare3"),
                        Component.translatable("pfadd",Component.text("4").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        YAN_YANG_SHI3.setItemMeta(yanyangshi3);

        ItemMeta yanyangshi4 = YAN_YANG_SHI4.getItemMeta();
        yanyangshi4.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"yanyangshi4");
        yanyangshi4.displayName(
                Component.translatable("yanyangshi4")
        );
        yanyangshi4.lore(
                List.of(Component.translatable("rare4"),
                        Component.translatable("pfadd",Component.text("7").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        YAN_YANG_SHI4.setItemMeta(yanyangshi4);

        ItemMeta yanyangshi5 = YAN_YANG_SHI5.getItemMeta();
        yanyangshi5.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"yanyangshi5");
        yanyangshi5.displayName(
                Component.translatable("yanyangshi5")
        );
        yanyangshi5.lore(
                List.of(Component.translatable("rare5"),
                        Component.translatable("pfadd",Component.text("11").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        YAN_YANG_SHI5.setItemMeta(yanyangshi5);

        ItemMeta yanyangshi6 = YAN_YANG_SHI6.getItemMeta();
        yanyangshi6.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"yanyangshi6");
        yanyangshi6.displayName(
                Component.translatable("yanyangshi6")
        );
        yanyangshi6.lore(
                List.of(Component.translatable("rare6"),
                        Component.translatable("pfadd",Component.text("16").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        YAN_YANG_SHI6.setItemMeta(yanyangshi6);

        ItemMeta yanyangshi7 = YAN_YANG_SHI7.getItemMeta();
        yanyangshi7.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"yanyangshi7");
        yanyangshi7.displayName(
                Component.translatable("yanyangshi7")
        );
        yanyangshi7.lore(
                List.of(Component.translatable("rare7"),
                        Component.translatable("pfadd",Component.text("22").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        YAN_YANG_SHI7.setItemMeta(yanyangshi7);

        ItemMeta yanyangshi8 = YAN_YANG_SHI8.getItemMeta();
        yanyangshi8.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"yanyangshi8");
        yanyangshi8.displayName(
                Component.translatable("yanyangshi8")
        );
        yanyangshi8.lore(
                List.of(Component.translatable("rare8"),
                        Component.translatable("pfadd",Component.text("29").color(NamedTextColor.AQUA)),
                        Component.translatable("yushi")
                        )
        );
        YAN_YANG_SHI8.setItemMeta(yanyangshi8);



    }


}
