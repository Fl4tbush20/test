package com.company;
import java.util.Scanner;
import java.lang.Math;


public class task4 {

    public static void main(String[] args) {

                int UnknownNumber, UserNumber, TriesCount = 0;
                Scanner input = new Scanner(System.in);

                System.out.println("input 1 to 100.");

                UnknownNumber = (int)Math.floor(Math.random() * 100);

                do {
                    TriesCount++;

                    System.out.print("Answer: ");

                    UserNumber = input.nextInt();

                    if (UserNumber > UnknownNumber)
                        System.out.println("Less");

                    else if (UserNumber < UnknownNumber)
                        System.out.println("More");

                    else
                        System.out.println("Correct");

                } while (UserNumber != UnknownNumber);

                System.out.println("N tries: " + TriesCount);

            }
}


