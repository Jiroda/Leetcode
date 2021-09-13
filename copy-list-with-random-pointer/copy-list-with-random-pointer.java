//T:O(n)
//S:O(1)

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){
            return head;
        }
        
        //1.Add cloned nodes right next to each Node
        Node curr = head;
        while(curr!=null){
            Node nextNode = curr.next;
            Node clone = new Node(curr.val);
            curr.next = clone;
            clone.next = nextNode;
            curr = nextNode;
        }
        
        //2.Set the random ptr for each clone
        curr =head;
        while(curr!=null){
            Node randomNode = curr.random;
            Node clone = curr.next;
            if(randomNode!=null){
                clone.random = randomNode.next;
            }
            curr = curr.next.next;
        }
        
        //3.unlink the clone from the original
        Node clonedHead = new Node(0);
        Node ptr = clonedHead;
        curr = head;
        while(curr!=null){
            Node nextOriginalNode = curr.next.next;
            Node clone = curr.next;
            ptr.next = clone;
            ptr = clone;
            curr.next = nextOriginalNode;
            curr = nextOriginalNode;
        }
        
        return clonedHead.next;
    }
}