
//T:O(L) where L is the number of non zero elements 
//S:O(L)
class SparseVector {
    HashMap<Integer, Integer> indexNonZeroValueMap;  
    SparseVector(int[] nums) {
        indexNonZeroValueMap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0){
                indexNonZeroValueMap.put(i, nums[i]);
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int product = 0;
        for(int index : indexNonZeroValueMap.keySet()){
            if(vec.indexNonZeroValueMap.containsKey(index)){
                product += vec.indexNonZeroValueMap.get(index) * indexNonZeroValueMap.get(index);
            }
        }
        return product;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);