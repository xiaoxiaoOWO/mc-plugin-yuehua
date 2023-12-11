package com.xiaoxiaoowo.yuehua.commands.playercommand;

import com.xiaoxiaoowo.yuehua.system.DataContainer;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public final class Yh implements CommandExecutor {
    public static final Inventory MAIN_MENU = Bukkit.createInventory(null, 54,
            Component.text("§l§b主菜单"));
    public static final Inventory QIAN_KUN_BAG = Bukkit.createInventory(null, 18,
            Component.text("§l§b乾坤袋"));

    public static final ItemStack BACK_BEFORE = new ItemStack(Material.GREEN_DYE,1);


    static {
        ItemStack itemStack1 = new ItemStack(Material.BLUE_DYE);
        itemStack1.setCustomModelData(1);
        ItemMeta itemMeta1 = itemStack1.getItemMeta();
        itemMeta1.displayName(
                Component
                        .translatable("qkd")
        );
        List<Component> lore1 = new ArrayList<>();
        lore1.add(
                Component
                        .translatable("qkdlore")
        );
        itemMeta1.lore(lore1);
        itemStack1.setItemMeta(itemMeta1);
        MAIN_MENU.setItem(0, itemStack1);

        ItemStack itemStack2 = new ItemStack(Material.BLUE_DYE);
        itemStack1.setCustomModelData(2);
        ItemMeta itemMeta2 = itemStack2.getItemMeta();
        itemMeta2.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.INTEGER, 1);
        itemMeta2.displayName(
                Component
                        .translatable("qkd1")
        );
        List<Component> lore2 = new ArrayList<>();
        lore2.add(
                Component
                        .translatable("qkd1lore")
        );
        itemMeta2.lore(lore2);
        itemStack2.setItemMeta(itemMeta2);
        QIAN_KUN_BAG.setItem(0, itemStack2);

        ItemStack itemStack3 = new ItemStack(Material.BLUE_DYE);
        itemStack1.setCustomModelData(3);
        ItemMeta itemMeta3 = itemStack3.getItemMeta();
        itemMeta3.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.INTEGER, 2);
        itemMeta3.displayName(
                Component
                        .translatable("qkd2")
        );
        List<Component> lore3 = new ArrayList<>();
        lore3.add(
                Component
                        .translatable("qkd2lore")
        );
        itemMeta3.lore(lore3);
        itemStack3.setItemMeta(itemMeta3);
        QIAN_KUN_BAG.setItem(1, itemStack3);

        ItemStack itemStack4 = new ItemStack(Material.BLUE_DYE);
        itemStack1.setCustomModelData(4);
        ItemMeta itemMeta4 = itemStack4.getItemMeta();
        itemMeta4.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.INTEGER, 3);
        itemMeta4.displayName(
                Component
                        .translatable("qkd3")
        );
        List<Component> lore4 = new ArrayList<>();
        lore4.add(
                Component
                        .translatable("qkd3lore")
        );
        itemMeta4.lore(lore4);
        itemStack4.setItemMeta(itemMeta4);
        QIAN_KUN_BAG.setItem(2, itemStack4);

        ItemStack itemStack5 = new ItemStack(Material.BLUE_DYE);
        itemStack1.setCustomModelData(5);
        ItemMeta itemMeta5 = itemStack5.getItemMeta();
        itemMeta5.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.INTEGER, 4);
        itemMeta5.displayName(
                Component
                        .translatable("qkd4")
        );
        List<Component> lore5 = new ArrayList<>();
        lore5.add(
                Component
                        .translatable("qkd4lore")
        );
        itemMeta5.lore(lore5);
        itemStack5.setItemMeta(itemMeta5);
        QIAN_KUN_BAG.setItem(3, itemStack5);

        ItemStack itemStack6 = new ItemStack(Material.BLUE_DYE);
        itemStack1.setCustomModelData(6);
        ItemMeta itemMeta6 = itemStack6.getItemMeta();
        itemMeta6.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.INTEGER, 5);
        itemMeta6.displayName(
                Component
                        .translatable("qkd5")
        );
        List<Component> lore6 = new ArrayList<>();
        lore6.add(
                Component
                        .translatable("qkd5lore")
        );
        itemMeta6.lore(lore6);
        itemStack6.setItemMeta(itemMeta6);
        QIAN_KUN_BAG.setItem(4, itemStack6);

        ItemStack itemStack7 = new ItemStack(Material.BLUE_DYE);
        itemStack1.setCustomModelData(7);
        ItemMeta itemMeta7 = itemStack7.getItemMeta();
        itemMeta7.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.INTEGER, 6);
        itemMeta7.displayName(
                Component
                        .translatable("qkd6")
        );
        List<Component> lore7 = new ArrayList<>();
        lore7.add(
                Component
                        .translatable("qkd6lore")
        );
        itemMeta7.lore(lore7);
        itemStack7.setItemMeta(itemMeta7);
        QIAN_KUN_BAG.setItem(5, itemStack7);

        ItemStack itemStack8 = new ItemStack(Material.BLUE_DYE);
        itemStack1.setCustomModelData(8);
        ItemMeta itemMeta8 = itemStack8.getItemMeta();
        itemMeta8.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.INTEGER, 7);
        itemMeta8.displayName(
                Component
                        .translatable("qkd7")
        );
        List<Component> lore8 = new ArrayList<>();
        lore8.add(
                Component
                        .translatable("qkd7lore")
        );
        itemMeta8.lore(lore8);

        itemStack8.setItemMeta(itemMeta8);
        QIAN_KUN_BAG.setItem(6, itemStack8);

        ItemStack itemStack9 = new ItemStack(Material.BLUE_DYE);
        itemStack1.setCustomModelData(9);
        ItemMeta itemMeta9 = itemStack9.getItemMeta();
        itemMeta9.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.INTEGER, 8);
        itemMeta9.displayName(
                Component
                        .translatable("qkd8")
        );
        List<Component> lore9 = new ArrayList<>();
        lore9.add(
                Component
                        .translatable("qkd8lore")
        );
        itemMeta9.lore(lore9);
        itemStack9.setItemMeta(itemMeta9);
        QIAN_KUN_BAG.setItem(7, itemStack9);

        ItemStack itemStack10 = new ItemStack(Material.BLUE_DYE);
        itemStack1.setCustomModelData(10);
        ItemMeta itemMeta10 = itemStack10.getItemMeta();
        itemMeta10.getPersistentDataContainer().set(DataContainer.id, PersistentDataType.INTEGER, 9);
        itemMeta10.displayName(
                Component
                        .translatable("qkd9")
        );
        List<Component> lore10 = new ArrayList<>();
        lore10.add(
                Component
                        .translatable("qkd9lore")
        );
        itemMeta10.lore(lore10);
        itemStack10.setItemMeta(itemMeta10);
        QIAN_KUN_BAG.setItem(8, itemStack10);


        ItemMeta itemMeta11 = BACK_BEFORE.getItemMeta();
        itemMeta11.displayName(
                Component
                        .translatable("toGUIBefore")
        );
        BACK_BEFORE.setItemMeta(itemMeta11);
        QIAN_KUN_BAG.setItem(17,BACK_BEFORE);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        player.openInventory(MAIN_MENU);
        return true;
    }
}
