//T:O(n)
//S:O(1)

class Solution{
    public int thirdMax(int[] nums) {
        
        /*
        Approach: Create a minHeap of size 3  with PriorityQueue. For each element, first check if the item is not
                  already there in pq. [Note: The "contains()" method is O(n), where n is the size of pq. Since in our
                  case the max size will be 3, it is essentially same as O(1), thus not affecting the overall O(n) time
                  complexity of the whole program]. 
                  If the item is not already there in pq, insert it to pq, then check if size of pq exceeds 3.
                  If pq.size()>3 , remove first (smallest) element of pq. Thus, after we go through all the items,
                  we'll have 3 maximum items in pq.
                  If size of pq is 2, it means 3rd maximum doesn't exist. So poll() pq (removing the minumum item, leaving
                  the maximum item).
                  Now, poll pq, and return the popped value. If size of pq is less than 3, it'll have the maximum item,
                  otherwise it'll have the 3rd maximum item, which is the requirement of this problem.
                  
        Complexity analysis: Time: O(n); Space: O(1), because max size of pq is 3
        */
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(3);
        for(int num: nums){
            if(!pq.contains(num)){
                pq.add(num);
                if(pq.size()>3){
                    pq.poll();
                }
            }
        }
        
        if(pq.size()==2){
            pq.poll();
        }

        return pq.poll();
    }
}