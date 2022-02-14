package com.wiji.singlylinkedlist;

public class SinglyLinkedList {
    public Node head;
    
    public SinglyLinkedList() {

    }
    // SLL methods go here. As a starter, we will show you how to add a node to the list.
    public void add(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
        } else {
            Node runner = head;
            while(runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
        
        
    }
    public void remove(){
        if(this.head != null){
        	Node runner = head;
        	if(runner.next == null){
        		head=null;
        	}
        	while(runner.next.next != null){
        		runner = runner.next;
        	}
        	runner.next = null;
        }
    }
    
    public void printValues(){
    	if(head == null){
            System.out.println("Emthy List");
        }else {
        	Node runner = head;
        	while(runner != null){
        		System.out.println(runner.value);
        		runner = runner.next;
        	}		
        }
    }
    
    public void find(int value) {
        	Node runner = head;
        	 if(runner.value == value) {
        		 System.out.println(runner.value);
        	 }
        	 while(runner.next != null){
        		 if(runner.next.value == value) {
        			 System.out.println(runner.next.value);
        		 }runner = runner.next;
        	 }
    }
    
    public void removeAt(int index){
        if(this.head != null){
        	Node runner = head;
        	if(index == 0) {
        		head = head.next;
        		return;
        	}
        	Node previous = null;
        	for(var i = 0; i <index; i++) {
        		previous = runner;
        		runner = runner.next;
        		if(runner == null) {
        			return;
        		}
        	}
        		previous.next = runner.next;
        	}
    }
}


