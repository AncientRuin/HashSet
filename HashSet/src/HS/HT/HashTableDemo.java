/*
 * Christian Harvey
 * Assignment 5
 * CSCI 3250
 * This program will take in user values and return them in an 
 * open hash table by seperate chaining                                  
 */
package HS.HT;

import java.util.LinkedList;

public class HashTableDemo {

    public int size;
    private LinkedList<LinkedListNode>[] arr;

    public static class LinkedListNode {
        public Integer value;
        // public String key; 
    }

    // Get size from Users     
    // public void setSize (int size) { this.size = size; }    
    // public int getSize () { return size; }
    public HashTableDemo(int size) {
        this.size = size;

        arr = new LinkedList[size];
        // Init vals in array    
        for (int i = 0; i < size; i++) {
            arr[i] = null;
        }
    }

    public void display() {

        for (int i = 0; i < size; i++) {
            LinkedList<LinkedListNode> items = arr[i];
            // If there are no Objects return    
            // Iterating through all array        
            System.out.print("[" + i + "] ");
            
            if (items == null) {
                System.out.println(" is empty");
            } else {
                // Print items of this list
                // System.out.println(items.iterator().toString());
                items.forEach((item) -> {
                    System.out.print( "->" + item.value.toString());
                }); // Index
                //items.get(0);
                System.out.print("\n");
            }
        }
    }

    // Add items
    // First applies hash Function to key 
    // Output indicates index location for key to be stored in hash table array 
    public void insert(Integer value) {
        int index = value.hashCode() % size;
        LinkedList<LinkedListNode> items = arr[index];

        // Check if items already stoed at index of LinkedList
        // If none at index : Create one    
        // Then add new object             
        if (items == null) {
            items = new LinkedList<LinkedListNode>();

            LinkedListNode item = new LinkedListNode();
            //item.key = key;
            item.value = value;

            items.add(item);

            arr[index] = items;
        } else {
            // Create new Object Node 
            LinkedListNode item = new LinkedListNode();
            // Start adding these values into the node   
            //item.key = key;
            item.value = value;

            items.add(item);
        }
        System.out.println("Key Inserted Successfully\n");                      
    }

    public void delete(Integer value) {
        // Location of index that the value lives     
        int index = value.hashCode() % size;

        LinkedList<LinkedListNode> items = arr[index];

        if (items == null) {
            System.out.println(value.toString() + 
                    " does not exist in the table. Search was Unsuccessful\n"); 
            return;                                                           
        }

        // Search specific items in Linked List for the value    
        for (LinkedListNode item : items) {
            // If value searching for equals value in Linked List : True
            if (item.value.equals(value)) {
                items.remove(item); // Remove it 
                return;
            }
        }
    }
}
