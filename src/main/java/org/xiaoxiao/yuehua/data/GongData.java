package org.xiaoxiao.yuehua.data;

import org.xiaoxiao.yuehua.util.Scores;

import java.util.HashMap;

public final class GongData extends Data {
    public int arrow;
    public int arrow_score;
    public int arrow_mul;
    public HashMap<String, Integer> arrow_mul_buff;

    public GongData(String name) {
        super(name);
        arrow_score = Scores.getArrow(name);
        arrow = arrow_score;
        arrow_mul = 100;
        arrow_mul_buff = new HashMap<>(16);
    }

    public void updateArrow() {
        arrow = Math.max(0, arrow_score * arrow_mul / 100);
    }

    public void updateArrowScore(int value){
        arrow_score = value;
        updateArrow();
    }

    public void updateArrowMul(){
        arrow_mul = 100;
        for (Integer value : arrow_mul_buff.values()) {
            arrow_mul += value;
        }
        updateArrow();
    }

    public void addArrowMulBuff(String key,int value){
        arrow_mul_buff.put(key,value);
        updateArrowMul();
    }

    public void removeArrowMulBuff(String key){
        arrow_mul_buff.remove(key);
        updateArrowMul();
    }
}
