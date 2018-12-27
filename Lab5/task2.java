package com.company;
import java.util.ArrayList;
import java.util.Collections;
public class task2 {
    public static void main(String[] args){
        ArrayList alpha = new ArrayList();
        for(int i=0;i<150;i++) {
            int k = (int) Math.floor(Math.random() * 200);
            alpha.add(k);
        }
        Collections.sort(alpha);
        Collections.reverse(alpha);
        ArrayList beta = new ArrayList();
        for(int i = 0; i<15;i++){
            int k = alpha.get(i);
             beta.add(k);
        }
        System.out.println(beta);
    }
}
