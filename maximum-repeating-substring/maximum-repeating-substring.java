//T:O(n)
//S:O(1)
class Solution {
    public int maxRepeating(String sequence, String word) {
        int repeatingVal = 0;
        String temp = word;
        while(sequence.contains(temp)){
            repeatingVal++;
            temp+=word;
        }
        return repeatingVal;
    }
}