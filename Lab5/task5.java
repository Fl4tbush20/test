package com.company;
import java.io.*;
import java.util.*;
public class task5{
    private static final Comparator<String> comparator=new Comparator<String>() {
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    };
    public static void main(String[] args){
        LinkedList<String> list1=new LinkedList<>();
        BufferedReader file=null;
        try {
            file = new BufferedReader(new FileReader("C:\\Users\\qpoha\\Documents\\Alpha.txt"));
            String s=new String();
            while((s=file.readLine()) !=null)
                list1.add(s);
        }catch(IOException e){
            e.printStackTrace();
        }
        Collections.sort(list1, comparator);
        for(String text:list1){
            System.out.println(text);}
    }
}