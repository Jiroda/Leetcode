/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        int n=0;
        if(head==null || head.next==null){
            return new int[]{0};
        }
        ListNode reversedHead = reverse(head, null);
        ListNode ptr = reversedHead;
        while(reversedHead!=null){
            n++;
            reversedHead = reversedHead.next;
        }
        int[] res = new int[n];
        n = n-1;
        while(ptr!=null){
            ListNode next = ptr.next;
            if(!stack.isEmpty()){
                while(!stack.isEmpty() && ptr.val>=stack.peek().val){
                    stack.pop();
                }
                
                if(!stack.isEmpty()){
                    res[n--] = stack.peek().val;
                    stack.push(ptr);
                }else{
                    res[n--] = 0;
                    stack.push(ptr);
                }
                
            }else{
                res[n--] = 0;
                stack.push(ptr);
            }
            ptr = next;
        }
        return res;
    }
    
    private ListNode reverse(ListNode head, ListNode reversedHead){
        if(head==null){
            return reversedHead;
        }
        
        ListNode next = head.next;
        head.next = reversedHead;
        reversedHead = head;
        head = next;
        return reverse(head, reversedHead);
    }
}