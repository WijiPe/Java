package com.wiji.dllassignment;

public class DLLTest {
    public static void main(String[] args) {
        DLL dll = new DLL();
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(50);
        Node n4 = new Node(60);
        Node n5 = new Node(80);
        Node n6 = new Node(100);
        
//        dll.push(n1);
//        dll.push(n2);
//        dll.push(n3);
//        dll.push(n4);
//        dll.push(n5);
//        dll.push(n6);
        
        dll.push(new Node(10));
        dll.push(new Node(20));
        dll.push(new Node(30));
        dll.push(new Node(30));
        dll.push(new Node(20));
        dll.push(new Node(10));
        
        
//        dll.printValuesBackward();
//        dll.pop();
//        dll.printValuesForward();
//        dll.contains(50);
//        System.out.println(dll.contains(50));
//        dll.contains(1);
//        System.out.println(dll.contains(1));
//        dll.size();
//        System.out.println(dll.size());
        
//        dll.insertAt(new Node(900), 1);
//        dll.printValuesForward();
//        dll.removeAt(2);
        dll.printValuesForward();
//        dll.printValuesBackward();
        System.out.println(dll.isPalindrome());
    }
}

