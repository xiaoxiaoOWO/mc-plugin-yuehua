package org.xiaoxiao.yuehua.system.act;

import de.tr7zw.nbtapi.NBT;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.xiaoxiao.yuehua.Yuehua;

import java.util.HashMap;

public final class Act {
    private static final HashMap<String, ActTask> actTasksZhan = new HashMap<>();
    private static final HashMap<String, ActTask> deActTasksZhan = new HashMap<>();
    private static final HashMap<String, ActTask> actTasksGong = new HashMap<>();
    private static final HashMap<String, ActTask> deActTasksGong = new HashMap<>();
    private static final HashMap<String, ActTask> actTasksDan = new HashMap<>();
    private static final HashMap<String, ActTask> deActTasksDan = new HashMap<>();

    public static void init() {
    }

    public static void ActZhan(Player player, ItemStack itemStack) {
        actTasksZhan.get(NBT.get(itemStack, nbt -> nbt.getString("id"))).runTask(Yuehua.instance);
    }

    public static void DeActZhan(Player player, ItemStack itemStack) {
        deActTasksZhan.get(NBT.get(itemStack, nbt -> nbt.getString("id"))).runTask(Yuehua.instance);
    }

    public static void ActGong(Player player, ItemStack itemStack) {
        actTasksGong.get(NBT.get(itemStack, nbt -> nbt.getString("id"))).runTask(Yuehua.instance);
    }

    public static void DeActGong(Player player, ItemStack itemStack) {
        deActTasksGong.get(NBT.get(itemStack, nbt -> nbt.getString("id"))).runTask(Yuehua.instance);
    }

    public static void ActDan(Player player, ItemStack itemStack) {
        actTasksDan.get(NBT.get(itemStack, nbt -> nbt.getString("id"))).runTask(Yuehua.instance);
    }

    public static void DeActDan(Player player, ItemStack itemStack) {
        deActTasksDan.get(NBT.get(itemStack, nbt -> nbt.getString("id"))).runTask(Yuehua.instance);
    }

}
