package com.company;
import java.lang.*;

    class task6
    {
        public static void main(String[] args)
        {
            String input = "abcdef123ABCD.!?";
            System.out.print(input + "\n");

            char[] reversed = input.toCharArray();

            for (int i = reversed.length-1; i>=0; i--)
                System.out.print(reversed[i]);
        }
    }

