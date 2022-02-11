// class Node 
class Node{
    constructor(data){
      this.data = data;
      this.next = null;
    }  
  }
  
  // class SLL - Singly Linked List
  class SLL{
    constructor(){
      this.head = null;
    }
  
    insertAtBack(data){
      var newNode = new Node(data);
      if(this.head){
        var runner = this.head;
        while(runner.next){
          runner = runner.next;
        }
        runner.next = newNode;
      }else{
        this.head = newNode;
      }
    }
    //given
    printList(){
      if(!this.head){
        console.log("Empty list");
        return
      }
      var runner = this.head;
      while(runner){
        console.log(runner.data);
        runner = runner.next;
      }
    }
  
      secondToLast(){

        var newNode = new Node(data);
      if(this.head && this.head.next){
        var runner = this.head;
        while(runner.next.next != null){
          runner = runner.next;
        }
        return runner.next;
      }else{
        this.head = newNode;
      }
          //return the value of the second to last node in the list.
    }
   
      removeData(data){
          //Remove the node that has the matching given value
          //HINT: The list is constructed by connecting nodes with pointers
          // Play with the pointers so that you can remove that node from the list. 
      }
  
      // BONUS
      prepend(newVal, targetVal){
          //Insert a new node before a node that has the given target value
      }
  
  }
  
  
  
  
  var list1 = new SLL();
  
  var list2 = new SLL();
  list2.insertAtBack(1);
  list2.insertAtBack(2);
  list2.insertAtBack(3);
  list2.insertAtBack(4);
  list2.insertAtBack(5);
  //       HEAD
  // list2: (1) --> (2) --> (3) --> null
  
  
  list1.printList();
  list2.printList();
  list2.printList(secondToLast());
  
  