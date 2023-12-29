package com.xiaoxiaoowo.yuehua.data;

import java.util.ArrayList;

public final class MonsterData {
    public int fakang;
    public int renxing;
    public int shengji;
    public ArrayList<Integer> taskIds;

    public String id;

    public MonsterData(int fakang, int renxing,int shengji,String id) {
        this.fakang = fakang;
        this.renxing = renxing;
        this.shengji = shengji;
        this.id = id;
        this.taskIds = new ArrayList<>(5);
    }
}
