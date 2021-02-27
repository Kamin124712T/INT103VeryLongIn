package main;

import model.VeryLongInt;
import model.VeryLongIntLink;


public class TestVeryLongInt {
    public static void main(String[] args) {
        try {
            VeryLongInt t1 =new VeryLongInt("0000013256");
            VeryLongInt t2 =new VeryLongInt("005684");
            
            System.out.println(t1+"\n"+t2);
            t1.add(t2);
            System.out.println(t1+"\n"+t2);
            
            VeryLongInt t3 =new VeryLongInt("");
            VeryLongInt t4 =new VeryLongInt("1,255,684");
            System.out.println(t3+"\n"+t4+"\n");
//            VeryLongInt t5 =new VeryLongInt(null);
//            System.out.println(t5);
            
            VeryLongIntLink tl1 =new VeryLongIntLink("0000013256");
            VeryLongIntLink tl2 =new VeryLongIntLink("005684");
            
            System.out.println(tl1+"\n"+tl2);
            tl1.add(tl2);
            System.out.println(tl1+"\n"+tl2);
            tl1.add(tl2);
            System.out.println(tl1+"\n"+tl2);
            
            //VeryLongIntLink tl3 =new VeryLongIntLink("");
            //System.out.println(tl3);
            VeryLongIntLink tl4 =new VeryLongIntLink("1,255,684");
            System.out.println(tl4);
            VeryLongIntLink tl5 =new VeryLongIntLink(null);
            System.out.println(tl5);
        } catch (NullPointerException e) {
            System.out.println("String null ");
        }
    }
}
