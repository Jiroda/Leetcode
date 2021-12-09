//T:O(m+n)
//s:O(m+n)
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if(firstList.length==0 || secondList.length==0){
            return new int[0][0];
        }
        List<int[]> ans = new ArrayList<>();
        int i=0;
        int j=0;
        while(i<firstList.length && j<secondList.length){
            int startMax = Math.max(firstList[i][0], secondList[j][0]);
            int endMin = Math.min(firstList[i][1], secondList[j][1]);
            
            if(startMax<=endMin){
                ans.add(new int[]{startMax, endMin});
            }
            
            if(firstList[i][1] == endMin) {
                i++;
            }
            
            if(secondList[j][1] == endMin) {
                j++;
            }
        }
        
        return ans.toArray(new int[ans.size()][2]);
    }
}