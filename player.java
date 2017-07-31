package com.untitled;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/7/29.
 */
public class player {
    public int id;
    public String name;
    public List<cards> myCards=new ArrayList<>();
    public player(int id,String name){
        this.id=id;
        this.name=name;
    }
    public player(){

    }
}
