/*
 * Christian Harvey
 * Assignment 5
 * CSCI 3250
 * This program will take in user values and return them in an 
 * open hash table by seperate chaining                                  
 */
package HS;

import HS.HT.HashTableDemo;
import HS.HT.HashTableDemo.LinkedListNode;
import java.util.ArrayList;
import java.util.Scanner;

public class HashSet {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Hash Table Test\n");
        System.out.print("Enter Table Size\n");  
        HashTableDemo list = new HashTableDemo(scan.nextInt());   

        char ch;
        do {
            System.out.println("Hash Table Operations");
            System.out.println("1. Insert ");
            System.out.println("2. Remove element");
            System.out.println("3. Display");
            System.out.println("4. Exit");                                   

            int choice = scan.nextInt();
            ch = 'Y';
            switch (choice) {
                case 1:
                    System.out.println("Enter integer element to insert");
                    list.insert(scan.nextInt());
                    break;
                case 2:
                    System.out.println("Enter integer element to delete");
                    list.delete(scan.nextInt());
                    break;
                case 3:
                    list.display();
                    System.out.print("\n");                                    
                    break;
                case 4:
                    System.out.println("Exit Successful");
                    ch = 'N';
                    break;
                default:
                    System.out.println("Wrong Entry \n ");
                    break;
            }
        } while (ch == 'Y' || ch == 'y');
    }
}
