package com.xiaoxiaoowo.yuehua.itemstack.other;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public final class Book {
    public final ItemStack QIAN_ZHUANG = new ItemStack(Material.WRITTEN_BOOK);

    public Book(){
        BookMeta bookMeta = (BookMeta) QIAN_ZHUANG.getItemMeta();
        bookMeta.title(
                Component.text("§bOnline钱庄使用说明书")
        );
        bookMeta.author(
                Component.text("§7§o钱庄老板")
        );

        bookMeta.addPages(
                Component.translatable("qzbp1"),
                Component.translatable("qzbp2"),
                Component.translatable("qzbp3")

        );

        QIAN_ZHUANG.setItemMeta(bookMeta);
    }
}

