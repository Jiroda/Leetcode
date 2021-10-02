// T:O(n)
// S:O(1)

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            //if slow and fast meet we know cycle exists
            if(slow==fast){
                //inorder to find the entry point of the cycle move head and slow one by one till they meet
                slow = head;//reset the slow to the beginning of the list
                while(slow!=fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}