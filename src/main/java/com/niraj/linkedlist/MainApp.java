/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niraj.linkedlist;

import java.util.Scanner;

/**
 *
 * @author Niraj Khadka
 */
public class MainApp {
    static Node head;
    public static void main(String[] args) {
        
        int choice;
        do{
            showMenu();
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    insertItem();
                    break;
                case 2:
                    displayAll();
                    break;
                case 3:
                    int num = sc.nextInt();
                    Node found = searchItem(num);
                    if(found != null){
                        System.out.println("Found item on the list." );
                    }
                    else{
                        System.out.println("Item is not on the list.");
                    }
                    break;
                case 4:
                    deleteItem();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter correct choice from 0 to 3. ");
            }
            
            
        }while(true);
    }
    
    static Node searchItem(int n){
        Node cur = head;
        while(cur != null){
            if(cur.data == n)
                return cur;
            cur = cur.next;
        }
        return null;
    }
    
    static void deleteItem(){
        if(head != null){
            System.out.println("Enter a node to delete: ");
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            
            Node cur = head;
            Node prevCur = head;
            
            if(head.next == null){
                if(head.data == num){
                    head = null;
                    System.out.println("Successfully deleted the node.");
                    return;
                }else{
                    System.out.println("Cannot find the num specified in the list.");
                }
            }else{
                while(cur != null){
                    if(cur.data == num){
                        prevCur.next = cur.next;
                        System.out.println("Node successfully deleted.");
                        return;
                    }
                    prevCur = cur;
                    cur = cur.next;
                }
                System.out.println("Cannot find the node specified.");
            }
        }else{
            System.out.println("List doesnt exist.");
    }
    }
    static void showMenu(){
        System.out.println("\nWelcome to Linked List Program");
        System.out.println("1. Insert an item in the Linked list.");
        System.out.println("2. Display List.");
        System.out.println("3. Search for a particular item.");
        System.out.println("4. Delete an item from the Linked List.");
        System.out.println("0. Exit");
        System.out.println("");
    }
    
    static void displayAll(){
        Node cur = head;
        while(cur != null){
            System.out.print(cur.data +" -> ");
            cur = cur.next;
        }
    }
    static void insertItem(){
        System.out.println("Enter a new number to add into the list:");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Node n1 = new Node(num);
        System.out.println("");
        System.out.println("1. Insert at the end of the list.");
        System.out.println("2. Insert at the begining of the list.");
        System.out.println("3. Insert at the middle of the list.");
                
        int ch = sc.nextInt();
        switch(ch){
            case 1:
                if(head == null){
                    head  = n1;
                }
                else{
                    Node cur = head;
                    while(cur.next != null){
                        cur = cur.next;
                    }
                    cur.next = n1;
                }
                System.out.println("Insertion at the end -- SUCCESS!!!");
                break;
            case 2:
                if(head == null){
                    head = n1;
                }
                else{
                    n1.next = head;
                    head = n1;
                }
                System.out.println("Insertion at the begining -- SUCCESS!!!");
                break;
            case 3:
                System.out.println("\n Current List is: ");
                displayAll();
                System.out.println("");
                System.out.println("After which element you want to insert this node:");
                int listNum = sc.nextInt();
                Node foundNode = searchItem(listNum);
                
                if(foundNode != null){
                    n1.next = foundNode.next;
                    foundNode.next = n1;
                    System.out.println("List after new item inserted is:");
                    displayAll();
                    System.out.println("Insertion at the middle -- SUCCESS!!!");
                }
                else{
                    System.out.println("Item not found!");
                }
                
                break;
            default:
                System.out.println("Bad selection.");       
        } 
    }
}
