// T: O(n)
// S: O(1)

class Solution {
    public boolean rotateString(String s, String goal) {
        // get the first character from the target string
        char firstLetterOfGoal = goal.charAt(0);
        // length of the given string
        int len = s.length();
        // iterate over given string
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != firstLetterOfGoal) continue;
            // shift the left most character with right most
            var suffix = s.substring(i);
            var prefix = s.substring(0, i);
            // compare string after shift
            if (goal.equals(suffix + prefix)) return true;
        }
        // strings will never match
        return false;
        
    }
}