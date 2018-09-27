package com.zyp.gcz;

import java.util.ArrayList;
import java.util.List;

public class Kkpojo {
    private List<Gcz> list=new ArrayList<Gcz>();

    public void regist(Gcz gcz){
        list.add(gcz);
    }

    public void unRegist(Gcz gcz){
        list.remove(gcz);
    }

    public void look(String name){
        System.out.println("ddddd" + name);
        for (Gcz gcz : list) {
            gcz.jianting(name);
        }
    }
}
