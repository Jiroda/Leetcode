//T:O(nums1.length + nums2.length)
//S:O(nums1.length + nums2.length)

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=nums2.length-1; i>=0; i--){
            int currElement = nums2[i];
            while(!stack.isEmpty() && stack.peek()<currElement){
                stack.pop();
            }
            map.put(currElement, stack.size()==0 ? -1 :stack.peek());
            stack.push(currElement);
        }
        
        int[] res = new int[nums1.length];
        for(int i=0; i<nums1.length; i++){
            res[i] = map.get(nums1[i]);
        }
        
        return res;
    }
}