package com.untitled;

/**
 * Created by lenovo on 2017/7/29.
 */
public class cards implements  Comparable<cards>{
    public String name;
    public String value;
    public cards(String name){
        this.name=name;
        StringBuilder cardsvalue = new StringBuilder();
        cardsvalue.append(returncards(name.substring(2,name.length())));
        cardsvalue.append(returncards(name.substring(0,2)));
        this.value = cardsvalue.toString();
    }
    public char returncards(String str){
        switch(str){
            case "4": return '0';
            case "5":return '1';
            case "6":return '2';
            case "7":return '3';
            case "8":return '4';
            case "9":return '5';
            case "10":return '6';
            case "J":return '7';
            case "Q":return '8';
            case "K":return '9';
            case "A":return 'a';
            case "2":return 'b';
            case "3":return 'c';
            case "黑桃":return '0';
            case "红心":return '1';
            case "梅花":return '2';
            case "方块":return '3';
        }
        return 0;
    }
    public int compareTo(cards c){
        return this.value.compareTo(c.value);
    }
}
