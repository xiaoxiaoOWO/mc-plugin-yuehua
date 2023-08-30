package org.xiaoxiao.yuehua.data;

import org.bukkit.entity.Player;
import org.xiaoxiao.yuehua.system.Scores;

import java.util.HashMap;

public final class DanData extends Data{
    public int zhenfa;
    public int zhenfa_score;
    public int zhenfa_mul;
    public HashMap<String, Integer> zhenfa_mul_buff;

    public DanData(Player player) {
        super(player);
        String name = player.getName();
        zhenfa_score = Scores.getZhenfa(name);
        zhenfa = zhenfa_score;
        zhenfa_mul = 100;
        zhenfa_mul_buff = new HashMap<>(16);
    }

    public String toString(){
        return super.toString()+"\nzhenfa: "+zhenfa;
    }

    public void updateZhenfa() {
        zhenfa = Math.max(0, zhenfa_score * zhenfa_mul / 100);
    }

    public void updateZhenfaScore(int value){
        zhenfa_score = value;
        updateZhenfa();
    }

    public void updateZhenfaMul(){
        zhenfa_mul = 100;
        for (Integer value : zhenfa_mul_buff.values()) {
            zhenfa_mul += value;
        }
        updateZhenfa();
    }

    public void addZhenfaMulBuff(String key,int value){
        zhenfa_mul_buff.put(key,value);
        updateZhenfaMul();
    }

    public void removeZhenfaMulBuff(String key){
        zhenfa_mul_buff.remove(key);
        updateZhenfaMul();
    }
}
