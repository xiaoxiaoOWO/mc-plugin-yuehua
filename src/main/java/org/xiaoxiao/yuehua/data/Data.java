package org.xiaoxiao.yuehua.data;


import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;
import org.xiaoxiao.yuehua.system.Scores;

public class Data {
    //时效性的属性存储于这里，玩家退出后将会消失，为了避免对正常游戏造成影响，尽量少使用长时效的BUFF，DEBUFF不可存储这里以防玩家利用退出卡BUG
    //队伍
    public Team team;

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


    public int cool_reduce;
    public int cool_reduce_score;
    public int cool_reduce_add;

    public int branch;


    public int job;
    public int race;
    public int mainland;

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
        race = Scores.getRace(name);
        mainland = Scores.getMainland(name);

        branch = Scores.getBranch(name);

        ready = false;

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


        cool_reduce = cool_reduce_score;
        cool_reduce_add = 0;


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

    public void updateBaoJiXiaoGuoScore(int value) {
        baojixiaoguo_score = value;
        updateBaoji();
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
}