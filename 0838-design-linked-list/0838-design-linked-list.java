class MyLinkedList {
    class Node{
        int val;
        Node next;
        public Node(int val){
            this.val=val;
            this.next=null;
        }
    }
   Node head;
   int size;
    public MyLinkedList() {
        // MyLinkedList list=new MyLinkedList();
        head=null;
        size=0;
    }
    
    public int get(int index) {
        Node temp=head;
         if(index<0||index>=size){
            return -1;
        }
       
            for(int i=0;i<index;i++){
                temp=temp.next;
            
        }
        return temp.val;

    }
    
    public void addAtHead(int val) {
        Node newnode=new Node(val);
        newnode.next=head;
        head=newnode;
        size++;
    }
    
    public void addAtTail(int val) {
       Node newnode=new Node(val);
       if(head==null){
        head=newnode;
       }
       else{
       Node temp=head;
       while(temp.next!=null){
        temp=temp.next;
        }
       temp.next=newnode;
       newnode.next=null;

       }
       size++;
    }

    
    public void addAtIndex(int index, int val) {
        if(index<0||index>size){
            return;
        }
        if(index==0){
            addAtHead( val);
            return;
        }
        if(index==size)
        {
            addAtTail( val);
            return;
        }
        Node temp=head;
        int c=0;
        while(temp!=null){
           
            if(c==index-1){
            Node newnode=new Node(val);
            newnode.next=temp.next;
            temp.next=newnode;
            break;
            }
             c++;
            temp=temp.next;
         }
            size++;
    }
    
    public void deleteAtIndex(int index) {
          if(index<0||index>=size){
            return;
        }
        if(index==0){
           head = head.next;
        }
        else{
            Node temp=head;
            for(int i=0;i<index-1;i++){
                temp=temp.next;
            }
            temp.next=temp.next.next;
        }
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */