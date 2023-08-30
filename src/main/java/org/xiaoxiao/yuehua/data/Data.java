package org.xiaoxiao.yuehua.data;


import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;
import org.xiaoxiao.yuehua.system.Scores;

import java.util.HashMap;

public class Data {
    //队伍
    public Team team;

    public int attack;
    public int attack_score;
    public int attack_mul;
    public HashMap<String, Integer> attack_mul_buff;

    public int baoji;
    public int baoji_score;
    public int baoji_add;
    public HashMap<String, Integer> baoji_add_buff;

    public int baojixiaoguo;
    public int baojixiaoguo_score;
    public int baojixiaoguo_add;
    public HashMap<String, Integer> baojixiaoguo_add_buff;

    public int fakang;
    public int fakang_score;
    public int fakang_add;
    public HashMap<String, Integer> fakang_add_buff;

    public int pofa;
    public int pofa_score;
    public int pofa_add;
    public HashMap<String, Integer> pofa_add_buff;

    public int cool_reduce;
    public int cool_reduce_score;
    public int cool_reduce_add;
    public HashMap<String, Integer> cool_reduce_add_buff;

    public int job;

    //完全登入后准备完成
    public boolean ready;


    public Data(Player player) {
        String name = player.getName();

        //队伍
        team = Scores.scoreboard.getPlayerTeam(player);

        //计分板数据
        attack_score = Scores.getAttack(name);
        baoji_score = Scores.getBaoji(name);
        baojixiaoguo_score = Scores.getBaojixiaoguo(name);
        fakang_score = Scores.getFakang(name);
        pofa_score = Scores.getPofa(name);
        cool_reduce_score = Scores.getCoolReduce(name);

        job = Scores.getJob(name);

        ready = false;

        //其它数据
        attack = attack_score;
        attack_mul = 100;
        attack_mul_buff = new HashMap<>(16);

        baoji = baoji_score;
        baoji_add = 0;
        baoji_add_buff = new HashMap<>(8);

        baojixiaoguo = baojixiaoguo_score;
        baojixiaoguo_add = 0;
        baojixiaoguo_add_buff = new HashMap<>(8);

        fakang = fakang_score;
        fakang_add = 0;
        fakang_add_buff = new HashMap<>(8);

        pofa = pofa_score;
        pofa_add = 0;
        pofa_add_buff = new HashMap<>(8);

        cool_reduce = cool_reduce_score;
        cool_reduce_add = 0;
        cool_reduce_add_buff = new HashMap<>(8);

    }

    public String toString() {
        return "attack: " + attack + "\nbaoji: " + baoji + "\nbaojixiaoguo: " + baojixiaoguo + "\nfakang: " + fakang + "\npofa: " + pofa + "\ncool_reduce: " + cool_reduce;
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

    public void updateAttackScore(int value) {
        attack_score = value;
        updateAttack();
    }

    public void updateBaojiScore(int value) {
        baoji_score = value;
        updateBaoji();
    }

    public void updateBaojixiaoguoScore(int value) {
        baojixiaoguo_score = value;
        updateBaojixiaoguo();
    }

    public void updateFakangScore(int value) {
        fakang_score = value;
        updateFakang();
    }

    public void updatePofaScore(int value) {
        pofa_score = value;
        updatePofa();
    }

    public void updateCoolReduceScore(int value) {
        cool_reduce_score = value;
        updateCoolReduce();
    }

    public void updateAttackMul() {
        attack_mul = 100;
        for (Integer value : attack_mul_buff.values()) {
            attack_mul += value;
        }
        updateAttack();
    }

    public void updateBaojiAdd() {
        baoji_add = 0;
        for (Integer value : baoji_add_buff.values()) {
            baoji_add += value;
        }
        updateBaoji();
    }

    public void updateBaojixiaoguoAdd() {
        baojixiaoguo_add = 0;
        for (Integer value : baojixiaoguo_add_buff.values()) {
            baojixiaoguo_add += value;
        }
        updateBaojixiaoguo();
    }

    public void updateFakangAdd() {
        fakang_add = 0;
        for (Integer value : fakang_add_buff.values()) {
            fakang_add += value;
        }
        updateFakang();
    }

    public void updatePofaAdd() {
        pofa_add = 0;
        for (Integer value : pofa_add_buff.values()) {
            pofa_add += value;
        }
        updatePofa();
    }

    public void updateCoolReduceAdd() {
        cool_reduce_add = 0;
        for (Integer value : cool_reduce_add_buff.values()) {
            cool_reduce_add += value;
        }
        updateCoolReduce();
    }

    public void addAttackMulBuff(String key, int value) {
        attack_mul_buff.put(key, value);
        updateAttackMul();
    }

    public void addBaojiAddBuff(String key, int value) {
        baoji_add_buff.put(key, value);
        updateBaojiAdd();
    }

    public void addBaojixiaoguoAddBuff(String key, int value) {
        baojixiaoguo_add_buff.put(key, value);
        updateBaojixiaoguoAdd();
    }

    public void addFakangAddBuff(String key, int value) {
        fakang_add_buff.put(key, value);
        updateFakangAdd();
    }

    public void addPofaAddBuff(String key, int value) {
        pofa_add_buff.put(key, value);
        updatePofaAdd();
    }

    public void addCoolReduceAddBuff(String key, int value) {
        cool_reduce_add_buff.put(key, value);
        updateCoolReduceAdd();
    }

    public void removeAttackMulBuff(String key) {
        attack_mul_buff.remove(key);
        updateAttackMul();
    }

    public void removeBaojiAddBuff(String key) {
        baoji_add_buff.remove(key);
        updateBaojiAdd();
    }

    public void removeBaojixiaoguoAddBuff(String key) {
        baojixiaoguo_add_buff.remove(key);
        updateBaojixiaoguoAdd();
    }

    public void removeFakangAddBuff(String key) {
        fakang_add_buff.remove(key);
        updateFakangAdd();
    }

    public void removePofaAddBuff(String key) {
        pofa_add_buff.remove(key);
        updatePofaAdd();
    }

    public void removeCoolReduceAddBuff(String key) {
        cool_reduce_add_buff.remove(key);
        updateCoolReduceAdd();
    }

}