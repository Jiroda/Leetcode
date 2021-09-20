class Solution {
    public boolean rotateString(String s, String goal) {
        if(goal.length() < s.length()){
            return false;
        }
        String newString = s+s;
        if(newString.contains(goal)){
            return true;
        }
        return false;
    }
}