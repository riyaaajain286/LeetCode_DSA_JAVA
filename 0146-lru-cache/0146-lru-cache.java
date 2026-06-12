class LRUCache {
    class Node{
        int key,value;
        Node next,prev;
        public Node(int k,int v){
          this.key=k;
          this.value=v;
        }
    }
    private Map<Integer,Node> map;
    private Node head,tail;
    private int capacity;
    public LRUCache(int capacity) {
        map=new HashMap<>();
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
        this.capacity=capacity;
    }
    
    private void insert(Node node){
      node.next=head.next;
      node.prev=head;
      head.next.prev=node;
      head.next=node;
    }

    private void remove(Node node){
        node.next.prev=node.prev;
        node.prev.next=node.next;
    }
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node=map.get(key);
        remove(node);
        insert(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node oldnode=map.get(key);
            remove(oldnode);
        }
        Node node=new Node(key,value);
        insert(node);
        map.put(key,node);
        if(map.size()>capacity){
            Node lru=tail.prev;
            remove(lru);
            map.remove(lru.key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */