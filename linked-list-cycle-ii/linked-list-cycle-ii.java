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
                while(head!=slow){
                    head = head.next;
                    slow = slow.next;
                }
                return head;
            }
        }
        return null;
    }
}