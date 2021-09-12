//T:O(1)
//S:O(capacity)

class Node {
    int key;
    int val;
    Node next;
    Node prev;
    public Node(int key, int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    
    public DoublyLinkedList(){
        head.next = tail;
        tail.prev = head;
    }
    
    public Node getFirst(){
        if(head.next==tail){
            return null;
        }
        
        return head.next;
    }
    
    public Node getLast(){
        if(head.next==tail){
            return null;
        }
        
        return tail.prev;
    }
    
    public void addNode(Node node){
        if(node==null){
            return;
        }
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }
    
    public void removeNode(Node node){
        if(node==null){
            return;
        }
        
        Node next = node.next;
        Node prev = node.prev;
        prev.next = next;
        next.prev = prev;
        
    }
}


class LRUCache {
    private HashMap<Integer, Node> map = null;
    private DoublyLinkedList dll = null;
    private int capacity =1;
    
    public LRUCache(int capacity) {
        map = new HashMap<>();
        dll = new DoublyLinkedList();
        if(capacity>0){
            this.capacity = capacity;
        }
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        
        Node node = map.get(key);
        //Whenever we get a key, we need to refresh the cache, remove the node from dll and the map and add it to the first of the dll and back to the map
        remove(key);
        dll.addNode(node);
        map.put(key, node);
        
        return node.val;
    }
    
    public void put(int key, int value) {
        //if(key already exists then we remove it both from the map and the dll)
        if(map.containsKey(key)){
            remove(key);
        }
        Node node = new Node(key,value);
        
        if(map.size()>=capacity){
            //remove the least recently used key
            Node leastUsedNode  = dll.getLast();
            map.remove(leastUsedNode.key);
            dll.removeNode(leastUsedNode);
        }
        //Add the node to the map and to the first of the dll
        map.put(key,node);
        dll.addNode(node);
        
    }
    
    
    private void remove(int key){
        //Remove from both hashmap and the dll
        Node node = map.get(key);
        map.remove(key);
        dll.removeNode(node);
    }
}
