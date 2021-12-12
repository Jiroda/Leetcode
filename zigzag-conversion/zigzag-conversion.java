//T:O(n)
//S:O(n)
class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        HashMap<Integer, StringBuilder> map = new HashMap<>();
        boolean goDown = true;
        int currRow = 0;
        int index = 0;
        while(index<s.length()){
            while(index<s.length() && currRow<numRows && goDown){
                if(!map.containsKey(currRow)){
                    map.put(currRow, new StringBuilder());
                }
                map.get(currRow).append(s.charAt(index++));
                currRow++;
            }
            currRow = currRow-2;
            goDown = false;
            while(index<s.length() && !goDown && currRow>=0){
                map.get(currRow).append(s.charAt(index++));
                currRow--;
            }
            currRow = currRow+2;
            goDown = true;
        }
        
        StringBuilder result = new StringBuilder();
        for(StringBuilder sb : map.values()){
            result.append(sb.toString());
        }
        
        return result.toString();
    }
}