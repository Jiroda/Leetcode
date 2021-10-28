//T:O(N)
//S:O(1)

class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }
        //use fast and slow pointer to get to the middle
        ListNode prev = null;
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode reversedHead = reverse(slow);
        
        ListNode ptr1 = head;
        ListNode ptr2 = reversedHead;
        while(ptr1!=null && ptr2!=null){
            if(ptr1.val!=ptr2.val) return false;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return true;
    }
    
    private ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;       
    }
    
}