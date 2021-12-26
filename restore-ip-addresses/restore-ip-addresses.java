//T:O(3^n)
//S:O(3^n)
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(result, s, 0, 0, sb);
        return result;
    }
    
    private void backtrack(List<String> result, String s, int curr, int count, StringBuilder sb){
        if(curr==s.length() && count==3){
            result.add(sb.toString());
            return;
        }
        
        // count of dot more than 3 so we need to stop
        if (count > 3){
            return;
        }
        
        for(int i=curr; i<s.length(); i++){
            String segment = s.substring(curr, i+1);
            if(isValid(segment)){
                //store current sb length
                int length = sb.length();
                //choose
                sb.append(segment);
                //explore
                if(i+1==s.length()){
                    //this is the last segment
                    backtrack(result, s, i+1, count, sb);
                }else{
                    //Add a . as there can be more segments
                    sb.append(".");
                    backtrack(result, s, i+1, count+1, sb);
                }
                //unchoose
                sb.setLength(length);
            }
        }
    }
    
    private boolean isValid(String segment){
        if(segment.length()>3){
            return false;
        }
        
        if(segment.length()==0 || segment.length()>1 && segment.charAt(0)=='0'){
            return false;
        }
        
        return Integer.parseInt(segment)<=255;
    }
}