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
    public static final ItemStack kaoDiGua = new ItemStack(Material.BREAD, 1);
    public static final ItemStack xiBing = new ItemStack(Material.BREAD, 1);
    public static final ItemStack foTiaoQiang = new ItemStack(Material.BREAD, 1);


    public static final ItemStack kaoYu = new ItemStack(Material.BREAD, 1);
    public static final ItemStack kaoGuiYu = new ItemStack(Material.BREAD, 1);


    public static final ItemStack kaoJi = new ItemStack(Material.BREAD, 1);
    public static final ItemStack zhuPai = new ItemStack(Material.BREAD, 1);
    public static final ItemStack niuPai = new ItemStack(Material.BREAD, 1);
    public static final ItemStack yangTui = new ItemStack(Material.BREAD, 1);
    public static final ItemStack tuRou = new ItemStack(Material.BREAD, 1);


    public static final ItemStack zongZi = new ItemStack(Material.BREAD, 1);
    public static final ItemStack nianGao = new ItemStack(Material.BREAD, 1);
    public static final ItemStack yueBin = new ItemStack(Material.BREAD, 1);
    public static final ItemStack tangYuan = new ItemStack(Material.BREAD, 1);

    //食品类别二（食用需要16tick,无法在饥饿满时食用），APPLE
    public static final ItemStack pinGuo = new ItemStack(Material.APPLE, 1);

    //食品类别三（食用需要32tick，可以在饥饿满时食用，主要为丹药）,CARROT

    //食品类别四（食用需要16tick,可以在饥饿满时食用，主要为丹药）,COOKIE


    static {
        baoZi.setCustomModelData(1);

        ItemMeta itemMeta = baoZi.getItemMeta();

        itemMeta.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "baozi");
        itemMeta.displayName(
                Component
                        .translatable("baozi")
        );
        baoZi.setItemMeta(itemMeta);

        kaoDiGua.setCustomModelData(2);
        ItemMeta itemMeta2 = kaoDiGua.getItemMeta();
        itemMeta2.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "kaodigua");
        itemMeta2.displayName(
                Component
                        .translatable("kaodigua")
        );
        kaoDiGua.setItemMeta(itemMeta2);

        xiBing.setCustomModelData(3);
        ItemMeta itemMeta3 = xiBing.getItemMeta();
        itemMeta3.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "xibing");
        itemMeta3.displayName(
                Component
                        .translatable("xibing")
        );
        xiBing.setItemMeta(itemMeta3);

        foTiaoQiang.setCustomModelData(4);
        ItemMeta itemMeta4 = foTiaoQiang.getItemMeta();
        itemMeta4.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "fotiaoqiang");

        itemMeta4.displayName(
                Component
                        .translatable("fotiaoqiang")
        );
        foTiaoQiang.setItemMeta(itemMeta4);

        kaoYu.setCustomModelData(5);
        ItemMeta itemMeta5 = kaoYu.getItemMeta();
        itemMeta5.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "kaoyu");
        itemMeta5.displayName(
                Component
                        .translatable("kaoyu")
        );
        kaoYu.setItemMeta(itemMeta5);

        kaoGuiYu.setCustomModelData(6);
        ItemMeta itemMeta6 = kaoGuiYu.getItemMeta();
        itemMeta6.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "kaoguiyu");
        itemMeta6.displayName(
                Component
                        .translatable("kaoguiyu")
        );
        kaoGuiYu.setItemMeta(itemMeta6);

        kaoJi.setCustomModelData(7);
        ItemMeta itemMeta7 = kaoJi.getItemMeta();
        itemMeta7.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "kaoji");
        itemMeta7.displayName(
                Component
                        .translatable("kaoji")
        );
        kaoJi.setItemMeta(itemMeta7);

        zhuPai.setCustomModelData(8);
        ItemMeta itemMeta8 = zhuPai.getItemMeta();
        itemMeta8.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "zhupai");
        itemMeta8.displayName(
                Component
                        .translatable("zhupai")
        );

        zhuPai.setItemMeta(itemMeta8);

        niuPai.setCustomModelData(9);
        ItemMeta itemMeta9 = niuPai.getItemMeta();
        itemMeta9.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "niupai");
        itemMeta9.displayName(
                Component
                        .translatable("niupai")
        );
        niuPai.setItemMeta(itemMeta9);

        yangTui.setCustomModelData(10);
        ItemMeta itemMeta10 = yangTui.getItemMeta();
        itemMeta10.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "yangtui");
        itemMeta10.displayName(
                Component
                        .translatable("yangtui")
        );
        yangTui.setItemMeta(itemMeta10);

        tuRou.setCustomModelData(11);
        ItemMeta itemMeta11 = tuRou.getItemMeta();
        itemMeta11.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "turou");
        itemMeta11.displayName(
                Component
                       .translatable("turou")
        );
        tuRou.setItemMeta(itemMeta11);

        zongZi.setCustomModelData(12);
        ItemMeta itemMeta12 = zongZi.getItemMeta();
        itemMeta12.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "zongzi");
        itemMeta12.displayName(
                Component
                       .translatable("zongzi")
        );
        zongZi.setItemMeta(itemMeta12);

        nianGao.setCustomModelData(13);
        ItemMeta itemMeta13 = nianGao.getItemMeta();
        itemMeta13.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "niangao");
        itemMeta13.displayName(
                Component
                      .translatable("niangao")
        );
        nianGao.setItemMeta(itemMeta13);

        yueBin.setCustomModelData(14);
        ItemMeta itemMeta14 = yueBin.getItemMeta();
        itemMeta14.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "yuebin");
        itemMeta14.displayName(
                Component
                      .translatable("yuebin")
        );
        yueBin.setItemMeta(itemMeta14);

        tangYuan.setCustomModelData(15);
        ItemMeta itemMeta15 = tangYuan.getItemMeta();
        itemMeta15.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "tangyuan");
        itemMeta15.displayName(
                Component
                     .translatable("tangyuan")
        );
        tangYuan.setItemMeta(itemMeta15);

        pinGuo.setCustomModelData(1);
        ItemMeta itemMeta16 = pinGuo.getItemMeta();
        itemMeta16.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "pinguo");
        itemMeta16.displayName(
                Component
                       .translatable("pinguo")
        );
        pinGuo.setItemMeta(itemMeta16);


    }


}
