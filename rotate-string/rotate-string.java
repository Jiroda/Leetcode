// T: O(n)
// S: O(1)

class Solution {
    public boolean rotateString(String s, String goal) {
        char firstLetterOfGoal = goal.charAt(0);
        int len = s.length();
        for (int i = 0; i < len; i++) {
            //Keep moving till we find the char in 's' that is equal to the first character of the goal
            if (s.charAt(i) != firstLetterOfGoal) {
                continue;
            }
            var suffix = s.substring(i);
            var prefix = s.substring(0, i);
            if (goal.equals(suffix + prefix)) {
                return true;
            }
        }
        return false;
        
    }
}