package com.xiaoxiaoowo.yuehua.entity.test;

import com.xiaoxiaoowo.yuehua.Yuehua;
import com.xiaoxiaoowo.yuehua.itemstack.other.Money;
import com.xiaoxiaoowo.yuehua.utils.GetEntity;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class TestNPC {

    public static void spawn(Location location) {
       Villager villager  = GetEntity.world.spawn(location, Villager.class, false, it -> {
            //村民基础，无AI，静音，不自然移除，无敌,年龄
            it.setAI(false);
            it.setSilent(true);
            it.setRemoveWhenFarAway(false);
            it.setInvulnerable(true);
            it.setAge(100000000);
            //村民种类
//            it.setVillagerType(Villager.Type.PLAINS);
//            it.setProfession(Villager.Profession.WEAPONSMITH);
            //名字
            it.customName(Component.translatable("testNPC"));
            it.setCustomNameVisible(true);

            //交易项目
            List<MerchantRecipe> recipes = new ArrayList<>();
            ItemStack tongQian = Money.tongQian;
            ItemStack jinYuanBao = Money.jinYuanBao;
            ItemStack yinPiao = Money.yinPiao;
            ItemStack feiCui = Money.feiCui;


            tongQian.setAmount(10);
            jinYuanBao.setAmount(1);
            MerchantRecipe recipe = new MerchantRecipe(jinYuanBao, -2147483648, 2147483647,false,0,0,0,0,true);
            recipe.addIngredient(tongQian);



            recipes.add(recipe);
            it.setRecipes(recipes);

        });
       //村民数据
        UUID uuid = villager.getUniqueId();
        Bukkit.dispatchCommand(Yuehua.console,"data modify entity "+uuid+" VillagerData set value {profession:\"minecraft:weaponsmith\",level:100,type:\"minecraft:plains\"}");
    }
}
