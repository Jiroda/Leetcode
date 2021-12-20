//T:O(nlogn)
//S:O(1)
class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b)->b[1]-a[1]);
        int maxUnits = 0;
        for(int[] boxType : boxTypes){
            int numberOfBoxes = boxType[0];
            int numberOfUnits = boxType[1];
            if(truckSize==0){
                return maxUnits;
            }else if(truckSize>=numberOfBoxes){
                truckSize-=numberOfBoxes;
                maxUnits+=numberOfBoxes* numberOfUnits;
            }else{
                int minimumBoxesThatCanBeAdded = Math.min(truckSize, numberOfBoxes);
                truckSize-=minimumBoxesThatCanBeAdded;
                maxUnits+=minimumBoxesThatCanBeAdded* numberOfUnits;
            }
        }
        return maxUnits;
    }
}