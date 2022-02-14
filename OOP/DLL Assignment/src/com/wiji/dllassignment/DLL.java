package com.wiji.dllassignment;


public class DLL {
    public Node head;
    public Node tail;
    
    public DLL() {
        this.head = null;
        this.tail = null;
    }
    

    public void push(Node newNode) {

        if(this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            return;
        }
        
        Node lastNode = this.tail;
        lastNode.next = newNode;
        newNode.previous = lastNode;
        this.tail = newNode;
    }
    
    public void printValuesForward() {
        Node current = this.head;
        while(current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }
    
    public void printValuesBackward() {
    	Node current = this.tail;
    	while(current != null) {
    		System.out.println(current.value);
    		current= current.previous ;
    	}
    }
    
    public Integer pop(){
        if(this.tail != null){
        	Node runner = tail;
        	if(runner.previous == null){
        		tail=null;
        		head=null;
        		return runner.value;
        	}else {
        		runner.previous.next = null;
        		tail = runner.previous;
        		return runner.value;
        	}
        	
        }
		return null;
    }
    
    public boolean contains(Integer value) {
    	if(this.head != null){
    		Node runner = head;
    		if(runner.value == value) {
    			return true;
    		}else {
    			while(runner.next != null) {
    				if(runner.next.value == value) {
    					return true;
    				}else {
    					runner = runner.next;
    				}
    			}
    		}return false;
    	}return false;
    }
    
    public int size() {
    	var number = 0;
    	if(this.head != null){
    		Node runner = head;
    		number = 1;
    		while(runner.next != null) {
    			number += 1;
    			runner = runner.next;
    		}
    	}return number;
    		
    }
}
