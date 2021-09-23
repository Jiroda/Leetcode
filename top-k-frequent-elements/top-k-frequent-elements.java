class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>(){
            @Override
            public int compare(Map.Entry<Integer, Integer> a , Map.Entry<Integer, Integer> b){
                return a.getValue()-b.getValue();
            }
        });
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            minHeap.offer(entry);
            if(minHeap.size()> k){
                minHeap.poll();
            }
        }
        
        int[] result = new int[minHeap.size()];
        int index =0;
        while(!minHeap.isEmpty()){
            Map.Entry<Integer, Integer> polledEntry = minHeap.poll();
            result[index++] = polledEntry.getKey();
        }
        
        return result;
    }
}