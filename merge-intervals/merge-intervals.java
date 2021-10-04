class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals==null || intervals.length==0) return new int[][]{{0,0}};
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);//sort by start time
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.addLast(intervals[0]);
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0]<=queue.peekLast()[1]){
                int[] existingInterval = queue.removeLast();
                existingInterval[0] = Math.min(existingInterval[0], intervals[i][0]);
                existingInterval[1] = Math.max(existingInterval[1], intervals[i][1]);
                queue.addLast(existingInterval);
            }else{
                queue.addLast(intervals[i]);   
            }            
        }
    
        int[][] result = new int[queue.size()][2];
        int counter = 0;
        while(!queue.isEmpty()){
            int[] interval = queue.removeFirst();
            result[counter][0] = interval[0];
            result[counter][1] = interval[1];
            counter++;
        }
    
        return result;
    }
}