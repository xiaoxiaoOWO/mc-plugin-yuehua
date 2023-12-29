package com.xiaoxiaoowo.yuehua.data;


import com.xiaoxiaoowo.yuehua.data.slot.EnderChestSlot;
import com.xiaoxiaoowo.yuehua.data.slot.Slot;
import com.xiaoxiaoowo.yuehua.data.slot.SlotBuilder;
import com.xiaoxiaoowo.yuehua.system.Act;
import com.xiaoxiaoowo.yuehua.system.DataContainer;
import com.xiaoxiaoowo.yuehua.utils.SQL;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;


public class Data {
    public Player player;

    public List<Integer> taskIds;

    //打开容器时设置为true
    public boolean open = false;
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
    public int race;

    public int money;
    public int jinCount;
    public int muCount;
    public int shuiCount;
    public int huoCount;
    public int tuCount;

    public int refinedJinCount;
    public int refinedMuCount;
    public int refinedShuiCount;
    public int refinedHuoCount;
    public int refinedTuCount;

    public int concentratedJinCount;
    public int concentratedMuCount;
    public int concentratedShuiCount;
    public int concentratedHuoCount;
    public int concentratedTuCount;

    public Slot slot0;
    public Slot slot1;
    public Slot slot2;
    public Slot slot36;
    public Slot slot37;
    public Slot slot38;
    public Slot slot39;
    public Slot slot40;

    public Slot slot8;


    public EnderChestSlot eSlot0;
    public EnderChestSlot eSlot1;
    public EnderChestSlot eSlot2;
    public EnderChestSlot eSlot3;
    public EnderChestSlot eSlot4;
    public EnderChestSlot eSlot5;
    public EnderChestSlot eSlot6;
    public EnderChestSlot eSlot7;


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

    //饰品槽
    public Inventory shipinBar;


    public Data(Player player) {

        this.player = player;

        taskIds = new ArrayList<>(50);


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
        race = pck.get(DataContainer.race, PersistentDataType.INTEGER);

        money = pck.get(DataContainer.money,PersistentDataType.INTEGER);
        jinCount = pck.get(DataContainer.JinCount, PersistentDataType.INTEGER);
        muCount = pck.get(DataContainer.MuCount, PersistentDataType.INTEGER);
        shuiCount = pck.get(DataContainer.ShuiCount, PersistentDataType.INTEGER);
        huoCount = pck.get(DataContainer.HuoCount, PersistentDataType.INTEGER);
        tuCount = pck.get(DataContainer.TuCount, PersistentDataType.INTEGER);
        refinedJinCount = pck.get(DataContainer.RefinedJinCount, PersistentDataType.INTEGER);
        refinedMuCount = pck.get(DataContainer.RefinedMuCount, PersistentDataType.INTEGER);
        refinedShuiCount = pck.get(DataContainer.RefinedShuiCount, PersistentDataType.INTEGER);
        refinedHuoCount = pck.get(DataContainer.RefinedHuoCount, PersistentDataType.INTEGER);
        refinedTuCount = pck.get(DataContainer.RefinedTuCount, PersistentDataType.INTEGER);
        concentratedJinCount = pck.get(DataContainer.ConcentratedJinCount, PersistentDataType.INTEGER);
        concentratedMuCount = pck.get(DataContainer.ConcentratedMuCount, PersistentDataType.INTEGER);
        concentratedShuiCount = pck.get(DataContainer.ConcentratedShuiCount, PersistentDataType.INTEGER);
        concentratedHuoCount = pck.get(DataContainer.ConcentratedHuoCount, PersistentDataType.INTEGER);
        concentratedTuCount = pck.get(DataContainer.ConcentratedTuCount, PersistentDataType.INTEGER);

        String slot8Id = pck.get(DataContainer.slot8, PersistentDataType.STRING);
        String eSlot0Id = pck.get(DataContainer.eslot0, PersistentDataType.STRING);
        String eSlot1Id = pck.get(DataContainer.eslot1, PersistentDataType.STRING);
        String eSlot2Id = pck.get(DataContainer.eslot2, PersistentDataType.STRING);
        String eSlot3Id = pck.get(DataContainer.eslot3, PersistentDataType.STRING);
        String eSlot4Id = pck.get(DataContainer.eslot4, PersistentDataType.STRING);
        String eSlot5Id = pck.get(DataContainer.eslot5, PersistentDataType.STRING);
        String eSlot6Id = pck.get(DataContainer.eslot6, PersistentDataType.STRING);
        String eSlot7Id = pck.get(DataContainer.eslot7, PersistentDataType.STRING);

        String slot0ID = pck.get(DataContainer.slot0, PersistentDataType.STRING);
        String slot1ID = pck.get(DataContainer.slot1, PersistentDataType.STRING);
        String slot2ID = pck.get(DataContainer.slot2, PersistentDataType.STRING);
        String slot36ID = pck.get(DataContainer.slot36, PersistentDataType.STRING);
        String slot37ID = pck.get(DataContainer.slot37, PersistentDataType.STRING);
        String slot38ID = pck.get(DataContainer.slot38, PersistentDataType.STRING);
        String slot39ID = pck.get(DataContainer.slot39, PersistentDataType.STRING);
        String slot40ID = pck.get(DataContainer.slot40, PersistentDataType.STRING);




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


        //初始化slot
        slot8 = SlotBuilder.slot8Builder(slot8Id);
        eSlot0 = SlotBuilder.enderChestSlotBuilder(eSlot0Id);
        eSlot1 = SlotBuilder.enderChestSlotBuilder(eSlot1Id);
        eSlot2 = SlotBuilder.enderChestSlotBuilder(eSlot2Id);
        eSlot3 = SlotBuilder.enderChestSlotBuilder(eSlot3Id);
        eSlot4 = SlotBuilder.enderChestSlotBuilder(eSlot4Id);
        eSlot5 = SlotBuilder.enderChestSlotBuilder(eSlot5Id);
        eSlot6 = SlotBuilder.enderChestSlotBuilder(eSlot6Id);
        eSlot7 = SlotBuilder.enderChestSlotBuilder(eSlot7Id);

        slot0 = SlotBuilder.slot0Builder(slot0ID);
        slot1 = SlotBuilder.slot1Builder(slot1ID);
        slot2 = SlotBuilder.slot2Builder(slot2ID);
        slot36 = SlotBuilder.slot36Builder(slot36ID);
        slot37 = SlotBuilder.slot37Builder(slot37ID);
        slot38 = SlotBuilder.slot38Builder(slot38ID);
        slot39 = SlotBuilder.slot39Builder(slot39ID);
        slot40 = SlotBuilder.slot40Builder(slot40ID);


        Act.initAll(this,slot8Id);
        Act.initAllEnderChest(this, eSlot0Id);
        Act.initAllEnderChest(this, eSlot1Id);
        Act.initAllEnderChest(this, eSlot2Id);
        Act.initAllEnderChest(this, eSlot3Id);
        Act.initAllEnderChest(this, eSlot4Id);
        Act.initAllEnderChest(this, eSlot5Id);
        Act.initAllEnderChest(this, eSlot6Id);
        Act.initAllEnderChest(this, eSlot7Id);

        updateAttack();
        updateBaoji();
        updateBaojixiaoguo();
        updateFakang();
        updatePofa();
        updateCoolReduce();
        updateRenxing();
        updateShengji();


    }

    public String toString() {
        return "attack: " + attack + "\n"
               + "baoji: " + baoji + "\n"
               + "baojixiaoguo: " + baojixiaoguo + "\n"
               + "fakang: " + fakang + "\n"
               + "pofa: " + pofa + "\n"
               + "renxing: " + renxing + "\n"
               + "shengji: " + shengji + "\n"
               + "cool_reduce: " + cool_reduce + "\n"
               + "job: " + job + "\n"
               + "race: " + race + "\n"
               + "branch: " + branch + "\n"
               + "slot8: " + slot8.id + "\n"
               + "eSlot0: " + eSlot0.id + "\n"
               + "eSlot1: " + eSlot1.id + "\n"
               + "eSlot2: " + eSlot2.id + "\n"
               + "eSlot3: " + eSlot3.id + "\n"
               + "eSlot4: " + eSlot4.id + "\n"
               + "eSlot5: " + eSlot5.id + "\n"
               + "eSlot6: " + eSlot6.id + "\n"
               + "eSlot7: " + eSlot7.id + "\n";
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
        fakang = Math.min(100, fakang);
    }

    public void updatePofa() {
        pofa = Math.max(0, pofa_score + pofa_add);
    }

    public void updateCoolReduce() {
        cool_reduce = Math.max(0, cool_reduce_score + cool_reduce_add);
        cool_reduce = Math.min(100, cool_reduce);
    }

    public void updateShengji() {
        shengji = Math.max(0, shengji_score + shengji_add);
    }

    public void updateRenxing() {
        renxing = Math.max(0, renxing_score + renxing_add);
        renxing = Math.min(100, renxing);
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
        updateBaojixiaoguo();
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

    public void setShengjiScore(int value) {
        shengji_score = value;
        updateShengji();
    }

    public void setRenxingScore(int value) {
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

    public void updateRenxingAdd(int value) {
        renxing_add += value;
        updateRenxing();
    }


}