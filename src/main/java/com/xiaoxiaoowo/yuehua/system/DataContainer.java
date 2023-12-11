package com.xiaoxiaoowo.yuehua.system;

import org.bukkit.NamespacedKey;
import org.checkerframework.checker.units.qual.N;

public final class DataContainer {

    //乾坤袋
    public static final NamespacedKey qkd1;
    public static final NamespacedKey qkd2;
    public static final NamespacedKey qkd3;
    public static final NamespacedKey qkd4;
    public static final NamespacedKey qkd5;
    public static final NamespacedKey qkd6;
    public static final NamespacedKey qkd7;
    public static final NamespacedKey qkd8;
    public static final NamespacedKey qkd9;



    //物品数据
    public static final NamespacedKey slot;
    public static final NamespacedKey id;
    public static final NamespacedKey enchantid;
    public static final NamespacedKey insertid;

    //实体数据
    //基础数据
    //1->神族,2->仙族,3->人族,4->妖族,5->战神族
    public static final NamespacedKey race;

    //1->战士,2->弓箭手,3->炼丹师
    public static final NamespacedKey job;

    //-1 ->不在大陆，1->在大陆
    public static final NamespacedKey mainland;
    //冷却缩减百分比
    public static final NamespacedKey cool_reduce;




    //五种族好感
    public static final NamespacedKey racefriend_shen;
    public static final NamespacedKey racefriend_xian;
    public static final NamespacedKey racefriend_ren;
    public static final NamespacedKey racefriend_yao;
    public static final NamespacedKey racefriend_zhan;

    //DLC数据

    public static final NamespacedKey baoji;
    public static final NamespacedKey baojixiaoguo;
    public static final NamespacedKey fakang;
    public static final NamespacedKey pofa;
    public static final NamespacedKey renxing;
    public static final NamespacedKey shengji;
    public static final NamespacedKey branch;

    //战士数据
    public static final NamespacedKey attack;
    public static final NamespacedKey attack_add;
    public static final NamespacedKey attack_mul;


    //弓箭手数据
    public static final NamespacedKey arrow;
    public static final NamespacedKey arrow_add;
    public static final NamespacedKey arrow_mul;
    public static final NamespacedKey arrow_count;

    //丹师数据
    public static final NamespacedKey zhenfa;
    public static final NamespacedKey zhenfa_add;
    public static final NamespacedKey zhenfa_mul;
    public static final NamespacedKey zhenfa_test;

    static {
        String namespace = "yh";
        qkd1 = new NamespacedKey(namespace,"qkd1");
        qkd2 = new NamespacedKey(namespace,"qkd2");
        qkd3 = new NamespacedKey(namespace,"qkd3");
        qkd4 = new NamespacedKey(namespace,"qkd4");
        qkd5 = new NamespacedKey(namespace,"qkd5");
        qkd6 = new NamespacedKey(namespace,"qkd6");
        qkd7 = new NamespacedKey(namespace,"qkd7");
        qkd8 = new NamespacedKey(namespace,"qkd8");
        qkd9 = new NamespacedKey(namespace,"qkd9");


        slot = new NamespacedKey(namespace, "slot");
        id = new NamespacedKey(namespace, "id");
        enchantid = new NamespacedKey(namespace,"enchantid");
        insertid = new NamespacedKey(namespace,"insertid");

        race = new NamespacedKey(namespace, "race");
        job = new NamespacedKey(namespace, "job");
        mainland = new NamespacedKey(namespace, "mainland");
        cool_reduce = new NamespacedKey(namespace, "cool_reduce");
        racefriend_shen = new NamespacedKey(namespace, "racefriend_shen");
        racefriend_xian = new NamespacedKey(namespace, "racefriend_xian");
        racefriend_ren = new NamespacedKey(namespace, "racefriend_ren");
        racefriend_yao = new NamespacedKey(namespace, "racefriend_yao");
        racefriend_zhan = new NamespacedKey(namespace, "racefriend_zhan");

        baoji = new NamespacedKey(namespace, "baoji");
        baojixiaoguo = new NamespacedKey(namespace, "baojixiaoguo");
        fakang = new NamespacedKey(namespace, "fakang");
        pofa = new NamespacedKey(namespace, "pofa");
        renxing = new NamespacedKey(namespace, "renxing");
        shengji = new NamespacedKey(namespace, "shengji");
        branch = new NamespacedKey(namespace, "branch");

        attack = new NamespacedKey(namespace, "attack");
        attack_add = new NamespacedKey(namespace, "attack_add");
        attack_mul = new NamespacedKey(namespace, "attack_mul");

        arrow = new NamespacedKey(namespace, "arrow");
        arrow_add = new NamespacedKey(namespace, "arrow_add");
        arrow_mul = new NamespacedKey(namespace, "arrow_mul");
        arrow_count = new NamespacedKey(namespace, "arrow_count");

        zhenfa = new NamespacedKey(namespace, "zhenfa");
        zhenfa_add = new NamespacedKey(namespace, "zhenfa_add");
        zhenfa_mul = new NamespacedKey(namespace, "zhenfa_mul");
        zhenfa_test = new NamespacedKey(namespace, "zhenfa_test");

    }
}
