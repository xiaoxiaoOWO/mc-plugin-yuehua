package com.xiaoxiaoowo.yuehua.utils;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.loot.LootTable;

public final class MyLootTable {
    public static LootTable empty;

    public static void init() {
        empty = Bukkit.getLootTable(NamespacedKey.fromString("yh:empty"));
    }
}
