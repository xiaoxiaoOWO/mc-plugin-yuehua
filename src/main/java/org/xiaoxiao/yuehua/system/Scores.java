package org.xiaoxiao.yuehua.system;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;


public final class Scores {
    public static Scoreboard scoreboard;

    //基础数据
    public static Objective race;
    public static Objective job;
    public static Objective mainland;
    public static Objective cool_reduce;

    //五种族好感
    public static Objective racefriend_shen;
    public static Objective racefriend_xian;
    public static Objective racefriend_ren;
    public static Objective racefriend_yao;
    public static Objective racefriend_zhan;

    //DLC数据
    public static Objective baoji;
    public static Objective baojixiaoguo;
    public static Objective fakang;
    public static Objective pofa;

    //战士数据
    public static Objective attack;
    public static Objective attack_add;
    public static Objective attack_mul;

    //弓箭手数据
    public static Objective arrow;
    public static Objective arrow_add;
    public static Objective arrow_mul;
    public static Objective arrow_count;

    //丹师数据
    public static Objective zhenfa;
    public static Objective zhenfa_add;
    public static Objective zhenfa_mul;
    public static Objective zhenfa_test;

    public static void init() {
        scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        //基础数据
        race = scoreboard.getObjective("race");
        job = scoreboard.getObjective("job");
        mainland = scoreboard.getObjective("mainland");
        cool_reduce = scoreboard.getObjective("cool_reduce");
        //DLC数据
        baoji = scoreboard.getObjective("baoji");
        baojixiaoguo = scoreboard.getObjective("baojixiaoguo");
        fakang = scoreboard.getObjective("fakang");
        pofa = scoreboard.getObjective("pofa");
        //战士
        attack = scoreboard.getObjective("attack");
        attack_add = scoreboard.getObjective("attack_add");
        attack_mul = scoreboard.getObjective("attack_mul");
        //弓箭手
        arrow = scoreboard.getObjective("arrow");
        arrow_add = scoreboard.getObjective("arrow_add");
        arrow_mul = scoreboard.getObjective("arrow_mul");
        //丹师
        zhenfa = scoreboard.getObjective("zhenfa");
        zhenfa_add = scoreboard.getObjective("zhenfa_add");
        zhenfa_mul = scoreboard.getObjective("zhenfa_mul");
    }

    //关联数据自动更新
    public static void updateAttack(String name) {
        attack.getScore(name).setScore(getAttackAdd(name) * getAttackMul(name) / 100);
    }

    public static void updateArrow(String name) {
        arrow.getScore(name).setScore(getArrowAdd(name) * getArrowMul(name) / 100);
    }

    public static void updateZhenfa(String name) {
        zhenfa.getScore(name).setScore(getZhenfaAdd(name) * getZhenfaMul(name) / 100);
    }

    public static int getRaceFriendShen(String name) {
        return racefriend_shen.getScore(name).getScore();
    }

    public static void setRaceFriendShen(String name, int value) {
        racefriend_shen.getScore(name).setScore(value);
    }

    public static int getRaceFriendXian(String name) {
        return racefriend_xian.getScore(name).getScore();
    }

    public static void setRaceFriendXian(String name, int value) {
        racefriend_xian.getScore(name).setScore(value);
    }

    public static int getRaceFriendRen(String name) {
        return racefriend_ren.getScore(name).getScore();
    }

    public static void setRaceFriendRen(String name, int value) {
        racefriend_ren.getScore(name).setScore(value);
    }

    public static int getRaceFriendYao(String name) {
        return racefriend_yao.getScore(name).getScore();
    }

    public static void setRaceFriendYao(String name, int value) {
        racefriend_yao.getScore(name).setScore(value);
    }

    public static int getRaceFriendZhan(String name) {
        return racefriend_zhan.getScore(name).getScore();
    }

    public static void setRaceFriendZhan(String name, int value) {
        racefriend_zhan.getScore(name).setScore(value);
    }

    public static int getZhenfaTest(String name) {
        return zhenfa_test.getScore(name).getScore();
    }

    public static void setZhenfaTest(String name, int value) {
        zhenfa_test.getScore(name).setScore(value);
    }

    public static int getArrowCount(String name){
        return arrow_count.getScore(name).getScore();
    }

    public static void setArrow_count(String name,int value){
        arrow_count.getScore(name).setScore(value);
    }

    public static void updateArrowCount(String name,int value){
        Score score = arrow_count.getScore(name);
        score.setScore(score.getScore() + value);
    }

    //只取只设数据

    public static int getRace(String name) {
        return race.getScore(name).getScore();
    }

    public static void setRace(String name, int value) {
        race.getScore(name).setScore(value);
    }

    public static int getJob(String name) {
        return job.getScore(name).getScore();
    }

    public static void setJob(String name, int value) {
        job.getScore(name).setScore(value);
    }

    public static int getMainland(String name) {
        return mainland.getScore(name).getScore();
    }

    public static void setMainland(String name, int value) {
        mainland.getScore(name).setScore(value);
    }


    //计算类型数据
    public static int getCoolReduce(String name) {
        return cool_reduce.getScore(name).getScore();
    }

    public static void setCoolReduce(String name, int value) {
        cool_reduce.getScore(name).setScore(value);
    }

    public static void updateCoolReduce(String name,int value) {
        Score score = cool_reduce.getScore(name);
        score.setScore(score.getScore() + value);
    }

    public static int getBaoji(String name) {
        return baoji.getScore(name).getScore();
    }

    public static void setBaoji(String name, int value) {
        baoji.getScore(name).setScore(value);
    }

    public static void updateBaoji(String name,int value){
        Score score = baoji.getScore(name);
        score.setScore(score.getScore() + value);
    }

    public static int getBaojixiaoguo(String name) {
        return baojixiaoguo.getScore(name).getScore();
    }

    public static void setBaojixiaoguo(String name, int value) {
        baojixiaoguo.getScore(name).setScore(value);
    }

    public static void updateBaojixiaoguo(String name,int value){
        Score score = baojixiaoguo.getScore(name);
        score.setScore(score.getScore() + value);
    }

    public static int getFakang(String name) {
        return fakang.getScore(name).getScore();
    }

    public static void setFakang(String name, int value) {
        fakang.getScore(name).setScore(value);
    }

    public static void updateFakang(String name,int value){
        Score score = fakang.getScore(name);
        score.setScore(score.getScore() + value);
    }

    //特殊方法
    public static int getFakang(Entity entity) {
        return fakang.getScoreFor(entity).getScore();
    }

    public static void setFakang(Entity entity, int value) {
        fakang.getScoreFor(entity).setScore(value);
    }

    public static int getPofa(String name) {
        return pofa.getScore(name).getScore();
    }

    public static void setPofa(String name, int value) {
        pofa.getScore(name).setScore(value);
    }

    public static void updatePofa(String name,int value){
        Score score = pofa.getScore(name);
        score.setScore(score.getScore() + value);
    }

    public static int getAttack(String name) {
        return attack.getScore(name).getScore();
    }


    public static int getAttackAdd(String name) {
        return attack_add.getScore(name).getScore();
    }

    public static void setAttackAdd(String name, int value) {
        attack_add.getScore(name).setScore(value);
        updateAttack(name);
    }

    public static void updateAttackAdd(String name,int value){
        Score score = attack_add.getScore(name);
        score.setScore(score.getScore() + value);
        updateAttack(name);
    }

    public static int getAttackMul(String name) {
        return attack_mul.getScore(name).getScore();
    }

    public static void setAttackMul(String name, int value) {
        attack_mul.getScore(name).setScore(value);
        updateAttack(name);
    }

    public static void updateAttackMul(String name,int value){
        Score score = attack_mul.getScore(name);
        score.setScore(score.getScore() + value);
        updateAttack(name);
    }

    public static int getArrow(String name) {
        return arrow.getScore(name).getScore();
    }

    public static int getArrowAdd(String name) {
        return arrow_add.getScore(name).getScore();
    }

    public static void setArrowAdd(String name, int value) {
        arrow_add.getScore(name).setScore(value);
        updateArrow(name);
    }

    public static void updateArrowAdd(String name,int value){
        Score score = arrow_add.getScore(name);
        score.setScore(score.getScore() + value);
        updateArrow(name);
    }

    public static int getArrowMul(String name) {
        return arrow_mul.getScore(name).getScore();
    }

    public static void setArrowMul(String name, int value) {
        arrow_mul.getScore(name).setScore(value);
        updateArrow(name);
    }

    public static void updateArrowMul(String name,int value){
        Score score = arrow_mul.getScore(name);
        score.setScore(score.getScore() + value);
        updateArrow(name);
    }

    public static int getZhenfa(String name) {
        return zhenfa.getScore(name).getScore();
    }

    public static int getZhenfaAdd(String name) {
        return zhenfa_add.getScore(name).getScore();
    }

    public static void setZhenfaAdd(String name, int value) {
        zhenfa_add.getScore(name).setScore(value);
        updateZhenfa(name);
    }

    public static void updateZhenfaAdd(String name,int value){
        Score score = zhenfa_add.getScore(name);
        score.setScore(score.getScore() + value);
        updateZhenfa(name);
    }

    public static int getZhenfaMul(String name) {
        return zhenfa_mul.getScore(name).getScore();
    }

    public static void setZhenfaMul(String name, int value) {
        zhenfa_mul.getScore(name).setScore(value);
        updateZhenfa(name);
    }

    public static void updateZhenfaMul(String name,int value){
        Score score = zhenfa_mul.getScore(name);
        score.setScore(score.getScore() + value);
        updateZhenfa(name);
    }


}
