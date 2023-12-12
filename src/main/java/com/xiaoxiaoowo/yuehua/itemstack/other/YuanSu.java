package com.xiaoxiaoowo.yuehua.itemstack.other;

import com.xiaoxiaoowo.yuehua.system.DataContainer;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public final class YuanSu {
    //普通
    public static final ItemStack jin = new ItemStack(Material.KELP,1);
    public static final ItemStack mu = new ItemStack(Material.KELP,1);
    public static final ItemStack shui = new ItemStack(Material.KELP,1);
    public static final ItemStack huo = new ItemStack(Material.KELP,1);
    public static final ItemStack tu = new ItemStack(Material.KELP,1);

    //精炼
    public static final ItemStack refined_jin = new ItemStack(Material.KELP,1);
    public static final ItemStack refined_mu = new ItemStack(Material.KELP,1);
    public static final ItemStack refined_shui = new ItemStack(Material.KELP,1);
    public static final ItemStack refined_huo = new ItemStack(Material.KELP,1);
    public static final ItemStack refined_tu = new ItemStack(Material.KELP,1);

    //浓缩
    public static final ItemStack concentrated_jin = new ItemStack(Material.KELP,1);
    public static final ItemStack concentrated_mu = new ItemStack(Material.KELP,1);
    public static final ItemStack concentrated_shui = new ItemStack(Material.KELP,1);
    public static final ItemStack concentrated_huo = new ItemStack(Material.KELP,1);
    public static final ItemStack concentrated_tu = new ItemStack(Material.KELP,1);


    //袋装
    public static final ItemStack bagging_jin = new ItemStack(Material.KELP,1);
    public static final ItemStack bagging_mu = new ItemStack(Material.KELP,1);
    public static final ItemStack bagging_shui = new ItemStack(Material.KELP,1);
    public static final ItemStack bagging_huo = new ItemStack(Material.KELP,1);
    public static final ItemStack bagging_tu = new ItemStack(Material.KELP,1);

    static {
        jin.setCustomModelData(1);
        mu.setCustomModelData(2);
        shui.setCustomModelData(3);
        huo.setCustomModelData(4);
        tu.setCustomModelData(5);

        refined_jin.setCustomModelData(6);
        refined_mu.setCustomModelData(7);
        refined_shui.setCustomModelData(8);
        refined_huo.setCustomModelData(9);
        refined_tu.setCustomModelData(10);

        concentrated_jin.setCustomModelData(11);
        concentrated_mu.setCustomModelData(12);
        concentrated_shui.setCustomModelData(13);
        concentrated_huo.setCustomModelData(14);
        concentrated_tu.setCustomModelData(15);

        bagging_jin.setCustomModelData(16);
        bagging_mu.setCustomModelData(17);
        bagging_shui.setCustomModelData(18);
        bagging_huo.setCustomModelData(19);
        bagging_tu.setCustomModelData(20);

        ItemMeta itemMetaJin = jin.getItemMeta();
        ItemMeta itemMetaMu = mu.getItemMeta();
        ItemMeta itemMetaShui = shui.getItemMeta();
        ItemMeta itemMetaHuo = huo.getItemMeta();
        ItemMeta itemMetaTu = tu.getItemMeta();

        ItemMeta itemMetaRefinedJin = refined_jin.getItemMeta();
        ItemMeta itemMetaRefinedMu = refined_mu.getItemMeta();
        ItemMeta itemMetaRefinedShui = refined_shui.getItemMeta();
        ItemMeta itemMetaRefinedHuo = refined_huo.getItemMeta();
        ItemMeta itemMetaRefinedTu = refined_tu.getItemMeta();

        ItemMeta itemMetaConcentratedJin = concentrated_jin.getItemMeta();
        ItemMeta itemMetaConcentratedMu = concentrated_mu.getItemMeta();
        ItemMeta itemMetaConcentratedShui = concentrated_shui.getItemMeta();
        ItemMeta itemMetaConcentratedHuo = concentrated_huo.getItemMeta();
        ItemMeta itemMetaConcentratedTu = concentrated_tu.getItemMeta();

        ItemMeta itemMetaBaggingJin = bagging_jin.getItemMeta();
        ItemMeta itemMetaBaggingMu = bagging_mu.getItemMeta();
        ItemMeta itemMetaBaggingShui = bagging_shui.getItemMeta();
        ItemMeta itemMetaBaggingHuo = bagging_huo.getItemMeta();
        ItemMeta itemMetaBaggingTu = bagging_tu.getItemMeta();

        itemMetaJin.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "jin");
        itemMetaMu.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "mu");
        itemMetaShui.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "shui");
        itemMetaHuo.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "huo");
        itemMetaTu.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "tu");

        itemMetaRefinedJin.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "refined_jin");
        itemMetaRefinedMu.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "refined_mu");
        itemMetaRefinedShui.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "refined_shui");
        itemMetaRefinedHuo.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "refined_huo");
        itemMetaRefinedTu.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "refined_tu");

        itemMetaConcentratedJin.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "concentrated_jin");
        itemMetaConcentratedMu.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "concentrated_mu");
        itemMetaConcentratedShui.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "concentrated_shui");
        itemMetaConcentratedHuo.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "concentrated_huo");
        itemMetaConcentratedTu.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "concentrated_tu");

        itemMetaBaggingJin.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "bagging_jin");
        itemMetaBaggingMu.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "bagging_mu");
        itemMetaBaggingShui.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "bagging_shui");
        itemMetaBaggingHuo.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "bagging_huo");
        itemMetaBaggingTu.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.STRING, "bagging_tu");

        itemMetaJin.displayName(
                Component
                        .translatable("jin")
        );
        itemMetaMu.displayName(
                Component
                        .translatable("mu")
        );
        itemMetaShui.displayName(
                Component
                        .translatable("shui")
        );
        itemMetaHuo.displayName(
                Component
                        .translatable("huo")
        );
        itemMetaTu.displayName(
                Component
                        .translatable("tu")
        );
        itemMetaRefinedJin.displayName(
                Component
                        .translatable("refined_jin")
        );
        itemMetaRefinedMu.displayName(
                Component
                        .translatable("refined_mu")
        );
        itemMetaRefinedShui.displayName(
                Component
                        .translatable("refined_shui")
        );
        itemMetaRefinedHuo.displayName(
                Component
                        .translatable("refined_huo")
        );
        itemMetaRefinedTu.displayName(
                Component
                        .translatable("refined_tu")
        );
        itemMetaConcentratedJin.displayName(
                Component
                        .translatable("concentrated_jin")
        );
        itemMetaConcentratedMu.displayName(
                Component
                        .translatable("concentrated_mu")
        );
        itemMetaConcentratedShui.displayName(
                Component
                        .translatable("concentrated_shui")
        );
        itemMetaConcentratedHuo.displayName(
                Component
                        .translatable("concentrated_huo")
        );
        itemMetaConcentratedTu.displayName(
                Component
                        .translatable("concentrated_tu")
        );
        itemMetaBaggingJin.displayName(
                Component
                        .translatable("bagging_jin")
        );
        itemMetaBaggingMu.displayName(
                Component
                        .translatable("bagging_mu")
        );
        itemMetaBaggingShui.displayName(
                Component
                        .translatable("bagging_shui")
        );
        itemMetaBaggingHuo.displayName(
                Component
                        .translatable("bagging_huo")
        );
        itemMetaBaggingTu.displayName(
                Component
                        .translatable("bagging_tu")
        );
        jin.setItemMeta(itemMetaJin);
        mu.setItemMeta(itemMetaMu);
        shui.setItemMeta(itemMetaShui);
        huo.setItemMeta(itemMetaHuo);
        tu.setItemMeta(itemMetaTu);

        refined_jin.setItemMeta(itemMetaRefinedJin);
        refined_mu.setItemMeta(itemMetaRefinedMu);
        refined_shui.setItemMeta(itemMetaRefinedShui);
        refined_huo.setItemMeta(itemMetaRefinedHuo);
        refined_tu.setItemMeta(itemMetaRefinedTu);

        concentrated_jin.setItemMeta(itemMetaConcentratedJin);
        concentrated_mu.setItemMeta(itemMetaConcentratedMu);
        concentrated_shui.setItemMeta(itemMetaConcentratedShui);
        concentrated_huo.setItemMeta(itemMetaConcentratedHuo);
        concentrated_tu.setItemMeta(itemMetaConcentratedTu);

        bagging_jin.setItemMeta(itemMetaBaggingJin);
        bagging_mu.setItemMeta(itemMetaBaggingMu);
        bagging_shui.setItemMeta(itemMetaBaggingShui);
        bagging_huo.setItemMeta(itemMetaBaggingHuo);
        bagging_tu.setItemMeta(itemMetaBaggingTu);



    }
    

}
