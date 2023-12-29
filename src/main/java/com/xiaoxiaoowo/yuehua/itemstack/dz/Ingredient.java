package com.xiaoxiaoowo.yuehua.itemstack.dz;

import com.xiaoxiaoowo.yuehua.system.DataContainer;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;

public final class Ingredient {
    /**
     * 武器装备核心区
     */
    //2阶
    public final static ItemStack BI_SHI_SUI = new ItemStack(Material.STRING, 1);
    public final static ItemStack AO_LANG_PI = new ItemStack(Material.STRING, 1);

    //3阶
    public final static ItemStack CHI_TONG_DING = new ItemStack(Material.STRING, 1);
    public final static ItemStack BA_JIAO_YE = new ItemStack(Material.STRING, 1);

    //4阶
    public final static ItemStack XUAN_TIE_DING = new ItemStack(Material.STRING, 1);
    public final static ItemStack LIU_YIN_CHOU = new ItemStack(Material.STRING, 1);

    //5阶
    public final static ItemStack LING_YU_JIAN = new ItemStack(Material.STRING, 1);
    public final static ItemStack NIE_PAN_YU = new ItemStack(Material.STRING, 1);


    //6阶
    public final static ItemStack SHEN_ZAO_TIE = new ItemStack(Material.STRING, 1);
    public final static ItemStack HUANG_TU_SHEN_QIU = new ItemStack(Material.STRING, 1);
    public final static ItemStack YAN_GUI_ZHI_JIN = new ItemStack(Material.STRING, 1);
    public final static ItemStack LIU_GUANG_LIN_JUAN = new ItemStack(Material.STRING, 1);
    public final static ItemStack MING_LEI_YOU_SHA = new ItemStack(Material.STRING, 1);

    //7阶
    public final static ItemStack QI_CAI_XIAN_YU = new ItemStack(Material.STRING, 1);

    /*区域特产区*/

    //东方
    public final static ItemStack DU_ZHU_YA = new ItemStack(Material.STRING, 1);
    public final static ItemStack KU_XIU_GU = new ItemStack(Material.STRING, 1);
    public final static ItemStack BAI_SHE_LIN = new ItemStack(Material.STRING, 1);
    public final static ItemStack HUANG_TONG_KUANG = new ItemStack(Material.STRING, 1);

    //南方
    public final static ItemStack RONG_YAN_SHA = new ItemStack(Material.STRING, 1);
    public final static ItemStack YAN_YANG_HUA = new ItemStack(Material.STRING, 1);
    public final static ItemStack GUI_YOU_HUO = new ItemStack(Material.STRING, 1);
    public final static ItemStack CHI_SHA_MO = new ItemStack(Material.STRING, 1);

    //西方
    public final static ItemStack LIU_LUO_ZHU = new ItemStack(Material.STRING, 1);
    public final static ItemStack YU_HENG_SHI = new ItemStack(Material.STRING, 1);
    public final static ItemStack RONG_LIAN_SHI = new ItemStack(Material.STRING, 1);
    public final static ItemStack TIAN_SHU_SHI = new ItemStack(Material.STRING, 1);

    //北方
    public final static ItemStack CHEN_SHUI_TIE = new ItemStack(Material.STRING, 1);
    public final static ItemStack JI_LANG_LUO = new ItemStack(Material.STRING, 1);
    public final static ItemStack MING_HAI_JIN = new ItemStack(Material.STRING, 1);
    public final static ItemStack BI_BO_JING = new ItemStack(Material.STRING, 1);

    //特殊
    public final static ItemStack QI_CAI_JIN = new ItemStack(Material.STRING, 1);
    public final static ItemStack WAN_YUE_YIN = new ItemStack(Material.STRING, 1);
    public final static ItemStack SHAN_MEI_JIN_TIE = new ItemStack(Material.STRING, 1);
    public final static ItemStack QIAN_NIAN_YU = new ItemStack(Material.STRING, 1);
    public final static ItemStack XUE_SE_SHI = new ItemStack(Material.STRING, 1);

    static {
        BI_SHI_SUI.setCustomModelData(1);
        AO_LANG_PI.setCustomModelData(2);
        CHI_TONG_DING.setCustomModelData(3);
        BA_JIAO_YE.setCustomModelData(4);
        XUAN_TIE_DING.setCustomModelData(5);
        LIU_YIN_CHOU.setCustomModelData(6);
        LING_YU_JIAN.setCustomModelData(7);
        NIE_PAN_YU.setCustomModelData(8);
        SHEN_ZAO_TIE.setCustomModelData(9);
        HUANG_TU_SHEN_QIU.setCustomModelData(10);
        YAN_GUI_ZHI_JIN.setCustomModelData(11);
        LIU_GUANG_LIN_JUAN.setCustomModelData(12);
        MING_LEI_YOU_SHA.setCustomModelData(13);
        QI_CAI_XIAN_YU.setCustomModelData(14);
        DU_ZHU_YA.setCustomModelData(15);
        KU_XIU_GU.setCustomModelData(16);
        BAI_SHE_LIN.setCustomModelData(17);
        HUANG_TONG_KUANG.setCustomModelData(18);
        RONG_YAN_SHA.setCustomModelData(19);
        YAN_YANG_HUA.setCustomModelData(20);
        GUI_YOU_HUO.setCustomModelData(21);
        CHI_SHA_MO.setCustomModelData(22);
        LIU_LUO_ZHU.setCustomModelData(23);
        YU_HENG_SHI.setCustomModelData(24);
        RONG_LIAN_SHI.setCustomModelData(25);
        TIAN_SHU_SHI.setCustomModelData(26);
        CHEN_SHUI_TIE.setCustomModelData(27);
        JI_LANG_LUO.setCustomModelData(28);
        MING_HAI_JIN.setCustomModelData(29);
        BI_BO_JING.setCustomModelData(30);
        QI_CAI_JIN.setCustomModelData(31);
        WAN_YUE_YIN.setCustomModelData(32);
        QIAN_NIAN_YU.setCustomModelData(33);
        XUE_SE_SHI.setCustomModelData(34);
        SHAN_MEI_JIN_TIE.setCustomModelData(35);

        ItemMeta bishisui = BI_SHI_SUI.getItemMeta();
        bishisui.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"bishisui");
        bishisui.displayName(
                Component.translatable("bishisui")
        );
        bishisui.lore(
                List.of(Component.translatable("rare2"), Component.translatable("dzcl"))
        );
        BI_SHI_SUI.setItemMeta(bishisui);

        ItemMeta aolangpi = AO_LANG_PI.getItemMeta();
        aolangpi.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"aolangpi");
        aolangpi.displayName(
                Component.translatable("aolangpi")
        );
        aolangpi.lore(
                List.of(Component.translatable("rare2"), Component.translatable("dzcl"))
        );
        AO_LANG_PI.setItemMeta(aolangpi);

        ItemMeta chitongding = CHI_TONG_DING.getItemMeta();
        chitongding.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"chitongding");
        chitongding.displayName(
                Component.translatable("chitongding")
        );
        chitongding.lore(
                List.of(Component.translatable("rare3"), Component.translatable("dzcl"))
        );
        CHI_TONG_DING.setItemMeta(chitongding);

        ItemMeta bajiaoye = BA_JIAO_YE.getItemMeta();
        bajiaoye.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"bajiaoye");
        bajiaoye.displayName(
                Component.translatable("bajiaoye")
        );
        bajiaoye.lore(
                List.of(Component.translatable("rare3"), Component.translatable("dzcl"))
        );
        BA_JIAO_YE.setItemMeta(bajiaoye);

        ItemMeta xuantieding = XUAN_TIE_DING.getItemMeta();
        xuantieding.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"xuantieding");
        xuantieding.displayName(
                Component.translatable("xuantieding")
        );
        xuantieding.lore(
                List.of(Component.translatable("rare4"), Component.translatable("dzcl"))
        );
        XUAN_TIE_DING.setItemMeta(xuantieding);

        ItemMeta liuyinchou = LIU_YIN_CHOU.getItemMeta();
        liuyinchou.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"liuyinchou");
        liuyinchou.displayName(
                Component.translatable("liuyinchou")
        );
        liuyinchou.lore(
                List.of(Component.translatable("rare4"), Component.translatable("dzcl"))
        );
        LIU_YIN_CHOU.setItemMeta(liuyinchou);

        ItemMeta lingyujian = LING_YU_JIAN.getItemMeta();
        lingyujian.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"lingyujian");
        lingyujian.displayName(
                Component.translatable("lingyujian")
        );
        lingyujian.lore(
                List.of(Component.translatable("rare5"), Component.translatable("dzcl"))
        );
        LING_YU_JIAN.setItemMeta(lingyujian);

        ItemMeta niepanyu = NIE_PAN_YU.getItemMeta();
        niepanyu.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"niepanyu");
        niepanyu.displayName(
                Component.translatable("niepanyu")
        );
        niepanyu.lore(
                List.of(Component.translatable("rare5"), Component.translatable("dzcl"))
        );
        NIE_PAN_YU.setItemMeta(niepanyu);

        ItemMeta shenzaotie = SHEN_ZAO_TIE.getItemMeta();
        shenzaotie.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"shenzaotie");
        shenzaotie.displayName(
                Component.translatable("shenzaotie")
        );
        shenzaotie.lore(
                List.of(Component.translatable("rare6"), Component.translatable("dzcl"))
        );
        SHEN_ZAO_TIE.setItemMeta(shenzaotie);

        ItemMeta huangtushenqiu = HUANG_TU_SHEN_QIU.getItemMeta();
        huangtushenqiu.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"huangtushenqiu");
        huangtushenqiu.displayName(
                Component.translatable("huangtushenqiu")
        );
        huangtushenqiu.lore(
                List.of(Component.translatable("rare6"), Component.translatable("dzcl"))
        );
        HUANG_TU_SHEN_QIU.setItemMeta(huangtushenqiu);

        ItemMeta yanguizhijin = YAN_GUI_ZHI_JIN.getItemMeta();
        yanguizhijin.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"yanguizhijin");
        yanguizhijin.displayName(
                Component.translatable("yanguizhijin")
        );
        yanguizhijin.lore(
                List.of(Component.translatable("rare6"), Component.translatable("dzcl"))
        );
        YAN_GUI_ZHI_JIN.setItemMeta(yanguizhijin);

        ItemMeta liuguanglinjuan = LIU_GUANG_LIN_JUAN.getItemMeta();
        liuguanglinjuan.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"liuguanglinjuan");
        liuguanglinjuan.displayName(
                Component.translatable("liuguanglinjuan")
        );
        liuguanglinjuan.lore(
                List.of(Component.translatable("rare6"), Component.translatable("dzcl"))
        );
        LIU_GUANG_LIN_JUAN.setItemMeta(liuguanglinjuan);

        ItemMeta mingleiyousha = MING_LEI_YOU_SHA.getItemMeta();
        mingleiyousha.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"mingleiyousha");
        mingleiyousha.displayName(
                Component.translatable("mingleiyousha")
        );
        mingleiyousha.lore(
                List.of(Component.translatable("rare6", Component.translatable("dzcl"))
                ));
        MING_LEI_YOU_SHA.setItemMeta(mingleiyousha);

        ItemMeta qicaixianyu = QI_CAI_XIAN_YU.getItemMeta();
        qicaixianyu.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"qicaixianyu");
        qicaixianyu.displayName(
                Component.translatable("qicaixianyu")
        );
        qicaixianyu.lore(
                List.of(Component.translatable("rare7"), Component.translatable("dzcl"))
        );
        QI_CAI_XIAN_YU.setItemMeta(qicaixianyu);

        ItemMeta duzhuya = DU_ZHU_YA.getItemMeta();
        duzhuya.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"duzhuya");
        duzhuya.displayName(
                Component.translatable("duzhuya")
        );
        duzhuya.lore(
                List.of(Component.translatable("rare3"), Component.translatable("dzcl"))
        );
        DU_ZHU_YA.setItemMeta(duzhuya);

        ItemMeta kuxiugu = KU_XIU_GU.getItemMeta();
        kuxiugu.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"kuxiugu");
        kuxiugu.displayName(
                Component.translatable("kuxiugu")
        );
        kuxiugu.lore(
                List.of(Component.translatable("rare3"), Component.translatable("dzcl"))
        );
        KU_XIU_GU.setItemMeta(kuxiugu);

        ItemMeta baishelin = BAI_SHE_LIN.getItemMeta();
        baishelin.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"baishelin");
        baishelin.displayName(
                Component.translatable("baishelin")
        );
        baishelin.lore(
                List.of(Component.translatable("rare3"), Component.translatable("dzcl"))
        );
        BAI_SHE_LIN.setItemMeta(baishelin);

        ItemMeta huangtongkuang = HUANG_TONG_KUANG.getItemMeta();
        huangtongkuang.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"huangtongkuang");
        huangtongkuang.displayName(
                Component.translatable("huangtongkuang")
        );
        huangtongkuang.lore(
                List.of(Component.translatable("rare3"), Component.translatable("dzcl"))
        );
        HUANG_TONG_KUANG.setItemMeta(huangtongkuang);

        ItemMeta rongyansha = RONG_YAN_SHA.getItemMeta();
        rongyansha.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"rongyansha");
        rongyansha.displayName(
                Component.translatable("rongyansha")
        );
        rongyansha.lore(
                List.of(Component.translatable("rare4"), Component.translatable("dzcl"))
        );
        RONG_YAN_SHA.setItemMeta(rongyansha);

        ItemMeta yanyanghua = YAN_YANG_HUA.getItemMeta();
        yanyanghua.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"yanyanghua");
        yanyanghua.displayName(
                Component.translatable("yanyanghua")
        );
        yanyanghua.lore(
                List.of(Component.translatable("rare4"), Component.translatable("dzcl"))
        );
        YAN_YANG_HUA.setItemMeta(yanyanghua);

        ItemMeta guiyouhuo = GUI_YOU_HUO.getItemMeta();
        guiyouhuo.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"guiyouhuo");
        guiyouhuo.displayName(
                Component.translatable("guiyouhuo")
        );
        guiyouhuo.lore(
                List.of(Component.translatable("rare4"), Component.translatable("dzcl"))
        );
        GUI_YOU_HUO.setItemMeta(guiyouhuo);

        ItemMeta chishamo = CHI_SHA_MO.getItemMeta();
        chishamo.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"chishamo");
        chishamo.displayName(
                Component.translatable("chishamo")
        );
        chishamo.lore(
                List.of(Component.translatable("rare4"), Component.translatable("dzcl"))
        );
        CHI_SHA_MO.setItemMeta(chishamo);

        ItemMeta liuluozhu = LIU_LUO_ZHU.getItemMeta();
        liuluozhu.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"liuluozhu");
        liuluozhu.displayName(
                Component.translatable("liuluozhu")
        );
        liuluozhu.lore(
                List.of(Component.translatable("rare5"), Component.translatable("dzcl"))
        );
        LIU_LUO_ZHU.setItemMeta(liuluozhu);

        ItemMeta yuhengshi = YU_HENG_SHI.getItemMeta();
        yuhengshi.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"yuhengshi");
        yuhengshi.displayName(
                Component.translatable("yuhengshi")
        );
        yuhengshi.lore(
                List.of(Component.translatable("rare5"), Component.translatable("dzcl"))
        );
        YU_HENG_SHI.setItemMeta(yuhengshi);

        ItemMeta ronglianshi = RONG_LIAN_SHI.getItemMeta();
        ronglianshi.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"ronglianshi");
        ronglianshi.displayName(
                Component.translatable("ronglianshi")
        );
        ronglianshi.lore(
                List.of(Component.translatable("rare5"), Component.translatable("dzcl"))
        );
        RONG_LIAN_SHI.setItemMeta(ronglianshi);

        ItemMeta tianshushi = TIAN_SHU_SHI.getItemMeta();
        tianshushi.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"tianshushi");
        tianshushi.displayName(
                Component.translatable("tianshushi")
        );
        tianshushi.lore(
                List.of(Component.translatable("rare5"), Component.translatable("dzcl"))
        );
        TIAN_SHU_SHI.setItemMeta(tianshushi);

        ItemMeta chenshuitie = CHEN_SHUI_TIE.getItemMeta();
        chenshuitie.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"chenshuitie");
        chenshuitie.displayName(
                Component.translatable("chenshuitie")
        );
        chenshuitie.lore(
                List.of(Component.translatable("rare5"), Component.translatable("dzcl"))
        );
        CHEN_SHUI_TIE.setItemMeta(chenshuitie);

        ItemMeta jilangluo = JI_LANG_LUO.getItemMeta();
        jilangluo.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"jilangluo");
        jilangluo.displayName(
                Component.translatable("jilangluo")
        );
        jilangluo.lore(
                List.of(Component.translatable("rare5"), Component.translatable("dzcl"))
        );
        JI_LANG_LUO.setItemMeta(jilangluo);

        ItemMeta minghaijin = MING_HAI_JIN.getItemMeta();
        minghaijin.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"minghaijin");
        minghaijin.displayName(
                Component.translatable("minghaijin")
        );
        minghaijin.lore(
                List.of(Component.translatable("rare5"), Component.translatable("dzcl"))
        );
        MING_HAI_JIN.setItemMeta(minghaijin);

        ItemMeta bibojing = BI_BO_JING.getItemMeta();
        bibojing.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"bibojing");
        bibojing.displayName(
                Component.translatable("bibojing")
        );
        bibojing.lore(
                List.of(Component.translatable("rare5"), Component.translatable("dzcl"))
        );
        BI_BO_JING.setItemMeta(bibojing);

        ItemMeta qicaijin = QI_CAI_JIN.getItemMeta();
        qicaijin.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"qicaijin");
        qicaijin.displayName(
                Component.translatable("qicaijin")
        );
        qicaijin.lore(
                List.of(Component.translatable("rare3"), Component.translatable("dzcl"))
        );
        QI_CAI_JIN.setItemMeta(qicaijin);


        ItemMeta wanyueyin = WAN_YUE_YIN.getItemMeta();
        wanyueyin.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"wanyueyin");
        wanyueyin.displayName(
                Component.translatable("wanyueyin")
        );
        wanyueyin.lore(
                List.of(Component.translatable("rare4"), Component.translatable("dzcl"))
        );
        WAN_YUE_YIN.setItemMeta(wanyueyin);

        ItemMeta qiannianyu = QIAN_NIAN_YU.getItemMeta();
        qiannianyu.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"qiannianyu");
        qiannianyu.displayName(
                Component.translatable("qiannianyu")
        );
        qiannianyu.lore(
                List.of(Component.translatable("rare5"), Component.translatable("dzcl"))
        );
        QIAN_NIAN_YU.setItemMeta(qiannianyu);

        ItemMeta shanmeijintie = SHAN_MEI_JIN_TIE.getItemMeta();
        shanmeijintie.getPersistentDataContainer().set(DataContainer.id,PersistentDataType.STRING,"shanmeijintie");
        shanmeijintie.displayName(
                Component.translatable("shanmeijintie")
        );
        shanmeijintie.lore(
                List.of(Component.translatable("rare4"), Component.translatable("dzcl"))
        );
        SHAN_MEI_JIN_TIE.setItemMeta(shanmeijintie);

        ItemMeta xueseshi = XUE_SE_SHI.getItemMeta();
        xueseshi.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING,"xueseshi");
        xueseshi.displayName(
                Component.translatable("xueseshi")
        );
        xueseshi.lore(
                List.of(Component.translatable("rare5"), Component.translatable("dzcl"))
        );
        XUE_SE_SHI.setItemMeta(xueseshi);


    }


}
