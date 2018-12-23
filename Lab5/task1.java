package com.company;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

/*linked list, array list, treeset, hashset. add. find, delete*/
public class task1 {
    public static void main(String[] args) {
        LinkedList<String> list_one = new LinkedList<String>();
        list_one.add("Germany");
        System.out.println(list_one.get(0));
        list_one.remove(0);

        ArrayList<String> list_two = new ArrayList<>();
        list_two.add("France");
        System.out.println(list_two.get(0));
        list_two.remove(0);

        TreeSet<String> set_one = new TreeSet<>();
        set_one.add("USA");
        System.out.println(set_one.first());
        set_one.remove("USA");

        HashSet<String> set_two = new HashSet<>();
        set_two.add("Ukraine");
        for (String i : set_two)
            System.out.println(i);
        set_one.remove("Ukraine");
    }
}
