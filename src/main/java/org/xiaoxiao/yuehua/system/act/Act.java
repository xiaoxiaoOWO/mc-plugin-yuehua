package org.xiaoxiao.yuehua.system.act;

import de.tr7zw.nbtapi.NBT;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.xiaoxiao.yuehua.data.DanData;
import org.xiaoxiao.yuehua.data.GongData;
import org.xiaoxiao.yuehua.data.ZhanData;
import org.xiaoxiao.yuehua.system.act.zhan.weapon.r1.TaomujianAct;
import org.xiaoxiao.yuehua.system.act.zhan.weapon.r1.TaomujianDeAct;

import java.util.HashMap;

public final class Act {
    private static final HashMap<String, ActTaskZhan> actTasksZhan = new HashMap<>(400);
    private static final HashMap<String, ActTaskZhan> deActTasksZhan = new HashMap<>(400);
    private static final HashMap<String, ActTaskGong> actTasksGong = new HashMap<>(400);
    private static final HashMap<String, ActTaskGong> deActTasksGong = new HashMap<>(400);
    private static final HashMap<String, ActTaskDan> actTasksDan = new HashMap<>(400);
    private static final HashMap<String, ActTaskDan> deActTasksDan = new HashMap<>(400);

    public static void init() {
        //战士
        actTasksZhan.put("taomujian", new TaomujianAct());
        deActTasksZhan.put("taomujian", new TaomujianDeAct());
    }

    public static void ActZhan(Player player, ZhanData data, ItemStack itemStack) {
        actTasksZhan.get(NBT.get(itemStack, nbt -> nbt.getString("id"))).run(player, data);
    }

    public static void DeActZhan(Player player, ZhanData data, ItemStack itemStack) {
        deActTasksZhan.get(NBT.get(itemStack, nbt -> nbt.getString("id"))).run(player, data);
    }

    public static void ActGong(Player player, GongData data, ItemStack itemStack) {
        actTasksGong.get(NBT.get(itemStack, nbt -> nbt.getString("id"))).run(player, data);
    }

    public static void DeActGong(Player player, GongData data, ItemStack itemStack) {
        deActTasksGong.get(NBT.get(itemStack, nbt -> nbt.getString("id"))).run(player, data);
    }

    public static void ActDan(Player player, DanData data, ItemStack itemStack) {
        actTasksDan.get(NBT.get(itemStack, nbt -> nbt.getString("id"))).run(player, data);
    }

    public static void DeActDan(Player player, DanData data, ItemStack itemStack) {
        deActTasksDan.get(NBT.get(itemStack, nbt -> nbt.getString("id"))).run(player, data);
    }


}
