package com.xiaoxiaoowo.yuehua.data;


import com.xiaoxiaoowo.yuehua.data.slot.EnderChestSlot;
import com.xiaoxiaoowo.yuehua.data.slot.Slot;
import com.xiaoxiaoowo.yuehua.data.slot.SlotBuilder;
import com.xiaoxiaoowo.yuehua.system.Act;
import com.xiaoxiaoowo.yuehua.system.DataContainer;
import de.tr7zw.nbtapi.NBTContainer;
import de.tr7zw.nbtapi.NBTReflectionUtil;
import de.tr7zw.nbtapi.utils.nmsmappings.ReflectionMethod;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;


public class Data {
    //时效性的属性存储于这里，玩家退出后将会消失，为了避免对正常游戏造成影响，尽量少使用长时效的BUFF
    public int attack;
    public int attack_score;
    public int attack_mul;


    public int baoji;
    public int baoji_score;
    public int baoji_add;


    public int baojixiaoguo;
    public int baojixiaoguo_score;
    public int baojixiaoguo_add;


    public int fakang;
    public int fakang_score;
    public int fakang_add;


    public int pofa;
    public int pofa_score;
    public int pofa_add;

    public int renxing;
    public int renxing_score;
    public int renxing_add;

    public int shengji;
    public int shengji_score;
    public int shengji_add;


    public int cool_reduce;
    public int cool_reduce_score;
    public int cool_reduce_add;

    public int branch;
    public int job;

    public Slot slot8;

    //兽魂
    public EnderChestSlot eSlot0;
    public EnderChestSlot eSlot1;
    public EnderChestSlot eSlot2;
    public EnderChestSlot eSlot3;
    //饰品
    public EnderChestSlot eSlot4;
    //太古
    public EnderChestSlot eSlot5;
    public EnderChestSlot eSlot6;
    public EnderChestSlot eSlot7;
    public EnderChestSlot eSlot8;
    public EnderChestSlot eSlot9;
    public EnderChestSlot eSlot10;

    //乾坤袋
    public Inventory inventory1;
    public Inventory inventory2;
    public Inventory inventory3;
    public Inventory inventory4;
    public Inventory inventory5;
    public Inventory inventory6;
    public Inventory inventory7;
    public Inventory inventory8;
    public Inventory inventory9;


    public Data(Player player) {
        String name = player.getName();

        PersistentDataContainer pck = player.getPersistentDataContainer();
        //数据
        attack_score = pck.get(DataContainer.attack, PersistentDataType.INTEGER);
        baoji_score = pck.get(DataContainer.baoji, PersistentDataType.INTEGER);
        baojixiaoguo_score = pck.get(DataContainer.baojixiaoguo, PersistentDataType.INTEGER);
        fakang_score = pck.get(DataContainer.fakang, PersistentDataType.INTEGER);
        pofa_score = pck.get(DataContainer.pofa, PersistentDataType.INTEGER);
        renxing_score = pck.get(DataContainer.renxing, PersistentDataType.INTEGER);
        shengji_score = pck.get(DataContainer.shengji, PersistentDataType.INTEGER);
        cool_reduce_score = pck.get(DataContainer.cool_reduce, PersistentDataType.INTEGER);
        job = pck.get(DataContainer.job, PersistentDataType.INTEGER);

        branch = pck.get(DataContainer.branch, PersistentDataType.INTEGER);


        //其它数据
        attack = attack_score;
        attack_mul = 100;


        baoji = baoji_score;
        baoji_add = 0;


        baojixiaoguo = baojixiaoguo_score;
        baojixiaoguo_add = 0;


        fakang = fakang_score;
        fakang_add = 0;


        pofa = pofa_score;
        pofa_add = 0;

        renxing = renxing_score;
        renxing_add = 0;

        shengji = shengji_score;
        shengji_add = 0;


        cool_reduce = cool_reduce_score;
        cool_reduce_add = 0;

        PlayerInventory inv = player.getInventory();

        ItemStack item8 = inv.getItem(8);
        if (item8 != null && item8.getType() == Material.IRON_PICKAXE) {
            NBTContainer nbti = NBTReflectionUtil.convertNMSItemtoNBTCompound(ReflectionMethod.ITEMSTACK_NMSCOPY.run((Object) null, new Object[]{item8}));
            slot8 = SlotBuilder.slot8Builder(nbti.getString("id"));
        } else {
            slot8 = new Slot("null");
        }
        Act.initAll(this, slot8.id);

        Inventory enderChest = player.getEnderChest();
        ItemStack eItem0 = enderChest.getItem(0);
        ItemStack eItem1 = enderChest.getItem(1);
        ItemStack eItem2 = enderChest.getItem(2);
        ItemStack eItem3 = enderChest.getItem(3);
        ItemStack eItem4 = enderChest.getItem(4);
        ItemStack eItem5 = enderChest.getItem(5);
        ItemStack eItem6 = enderChest.getItem(6);
        ItemStack eItem7 = enderChest.getItem(7);
        ItemStack eItem8 = enderChest.getItem(8);
        ItemStack eItem9 = enderChest.getItem(9);
        ItemStack eItem10 = enderChest.getItem(10);

        if (eItem0 != null && eItem0.getType() == Material.WOODEN_PICKAXE) {
            PersistentDataContainer pck2 = eItem0.getPersistentDataContainer();
            eSlot0 = SlotBuilder.enderChestSlotBuilder(pck2.get(DataContainer.id, PersistentDataType.STRING));
        } else {
            eSlot0 = new EnderChestSlot("null");
        }

        if (eItem1 != null && eItem1.getType() == Material.WOODEN_PICKAXE) {
            PersistentDataContainer pck2 = eItem1.getPersistentDataContainer();
            eSlot1 = SlotBuilder.enderChestSlotBuilder(pck2.get(DataContainer.id, PersistentDataType.STRING));
        } else {
            eSlot1 = new EnderChestSlot("null");
        }

        if (eItem2 != null && eItem2.getType() == Material.WOODEN_PICKAXE) {
            PersistentDataContainer pck2 = eItem2.getPersistentDataContainer();
            eSlot2 = SlotBuilder.enderChestSlotBuilder(pck2.get(DataContainer.id, PersistentDataType.STRING));
        } else {
            eSlot2 = new EnderChestSlot("null");
        }

        if (eItem3 != null && eItem3.getType() == Material.WOODEN_PICKAXE) {
            PersistentDataContainer pck2 = eItem3.getPersistentDataContainer();
            eSlot3 = SlotBuilder.enderChestSlotBuilder(pck2.get(DataContainer.id, PersistentDataType.STRING));
        } else {
            eSlot3 = new EnderChestSlot("null");
        }

        if (eItem4 != null && eItem4.getType() == Material.WOODEN_PICKAXE) {
            PersistentDataContainer pck2 = eItem4.getPersistentDataContainer();
            eSlot4 = SlotBuilder.enderChestSlotBuilder(pck2.get(DataContainer.id, PersistentDataType.STRING));
        } else {
            eSlot4 = new EnderChestSlot("null");
        }

        if (eItem5 != null && eItem5.getType() == Material.WOODEN_PICKAXE) {
            PersistentDataContainer pck2 = eItem5.getPersistentDataContainer();
            eSlot5 = SlotBuilder.enderChestSlotBuilder(pck2.get(DataContainer.id, PersistentDataType.STRING));
        } else {
            eSlot5 = new EnderChestSlot("null");
        }

        if (eItem6 != null && eItem6.getType() == Material.WOODEN_PICKAXE) {
            PersistentDataContainer pck2 = eItem6.getPersistentDataContainer();
            eSlot6 = SlotBuilder.enderChestSlotBuilder(pck2.get(DataContainer.id, PersistentDataType.STRING));
        } else {
            eSlot6 = new EnderChestSlot("null");
        }

        if (eItem7 != null && eItem7.getType() == Material.WOODEN_PICKAXE) {
            PersistentDataContainer pck2 = eItem7.getPersistentDataContainer();
            eSlot7 = SlotBuilder.enderChestSlotBuilder(pck2.get(DataContainer.id, PersistentDataType.STRING));
        } else {
            eSlot7 = new EnderChestSlot("null");
        }

        if (eItem8 != null && eItem8.getType() == Material.WOODEN_PICKAXE) {
            PersistentDataContainer pck2 = eItem8.getPersistentDataContainer();
            eSlot8 = SlotBuilder.enderChestSlotBuilder(pck2.get(DataContainer.id, PersistentDataType.STRING));
        } else {
            eSlot8 = new EnderChestSlot("null");
        }

        if (eItem9 != null && eItem9.getType() == Material.WOODEN_PICKAXE) {
            PersistentDataContainer pck2 = eItem9.getPersistentDataContainer();
            eSlot9 = SlotBuilder.enderChestSlotBuilder(pck2.get(DataContainer.id, PersistentDataType.STRING));
        } else {
            eSlot9 = new EnderChestSlot("null");
        }

        if (eItem10 != null && eItem10.getType() == Material.WOODEN_PICKAXE) {
            PersistentDataContainer pck2 = eItem10.getPersistentDataContainer();
            eSlot10 = SlotBuilder.enderChestSlotBuilder(pck2.get(DataContainer.id, PersistentDataType.STRING));
        } else {
            eSlot10 = new EnderChestSlot("null");
        }

        Act.initAll(this, eSlot0.id);
        Act.initAll(this, eSlot1.id);
        Act.initAll(this, eSlot2.id);
        Act.initAll(this, eSlot3.id);
        Act.initAll(this, eSlot4.id);
        Act.initAll(this, eSlot5.id);
        Act.initAll(this, eSlot6.id);
        Act.initAll(this, eSlot7.id);
        Act.initAll(this, eSlot8.id);
        Act.initAll(this, eSlot9.id);
        Act.initAll(this, eSlot10.id);


    }

    public String toString() {
        return "attack: " + attack + "\nbaoji: " + baoji + "\nbaojixiaoguo: " + baojixiaoguo + "\nfakang: "
                + fakang + "\npofa: " + pofa + "\ncool_reduce: " + cool_reduce + "\nslot8id: " + slot8.id;
    }

    public void updateAttack() {
        attack = Math.max(0, attack_score * attack_mul / 100);
    }

    public void updateBaoji() {
        baoji = Math.max(0, baoji_score + baoji_add);
    }

    public void updateBaojixiaoguo() {
        baojixiaoguo = Math.max(0, baojixiaoguo_score + baojixiaoguo_add);
    }

    public void updateFakang() {
        fakang = Math.max(0, fakang_score + fakang_add);
    }

    public void updatePofa() {
        pofa = Math.max(0, pofa_score + pofa_add);
    }

    public void updateCoolReduce() {
        cool_reduce = Math.max(0, cool_reduce_score + cool_reduce_add);
    }

    public void updateShengji() {
        shengji = Math.max(0, shengji_score + shengji_add);
    }

    public void updateRenxing() {
        renxing = Math.max(0, renxing_score + renxing_add);
    }

    public void setAttackScore(int value) {
        attack_score = value;
        updateAttack();
    }

    public void setBaojiScore(int value) {
        baoji_score = value;
        updateBaoji();
    }

    public void setBaoJiXiaoGuoScore(int value) {
        baojixiaoguo_score = value;
        updateBaoji();
    }

    public void setFakangScore(int value) {
        fakang_score = value;
        updateFakang();
    }

    public void setPofaScore(int value) {
        pofa_score = value;
        updatePofa();
    }

    public void setCoolReduceScore(int value) {
        cool_reduce_score = value;
        updateCoolReduce();
    }

    public void setShengjiScore(int value){
        shengji_score = value;
        updateShengji();
    }

    public void setRenxingScore(int value){
        renxing_score = value;
        updateRenxing();
    }

    public void updateAttackMul(int value) {
        attack_mul += value;
        updateAttack();
    }

    public void updateBaojiAdd(int value) {
        baoji_add += value;
        updateBaoji();
    }

    public void updateBaojixiaoguoAdd(int value) {
        baojixiaoguo_add += value;
        updateBaojixiaoguo();
    }

    public void updateFakangAdd(int value) {
        fakang_add += value;
        updateFakang();
    }

    public void updatePofaAdd(int value) {
        pofa_add += value;
        updatePofa();
    }

    public void updateCoolReduceAdd(int value) {
        cool_reduce_add += value;
        updateCoolReduce();
    }

    public void updateShengjiAdd(int value) {
        shengji_add += value;
        updateShengji();
    }

    public void updateRenxingAdd(int value){
        renxing_add += value;
        updateRenxing();
    }


}