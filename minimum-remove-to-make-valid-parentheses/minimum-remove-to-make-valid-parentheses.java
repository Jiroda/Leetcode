//T:O(n)
//S:O(n)
class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder ans = new StringBuilder(s);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            } else if(s.charAt(i) == ')'){
                if(!stack.isEmpty() && s.charAt(stack.peek()) == '('){
                    stack.pop();
                } else {
                    stack.push(i);
                }
            }
        }
        
        //Remove the remaining open parenthesis that dont have corresponding pairs 
        while(!stack.isEmpty()){
            ans.deleteCharAt(stack.pop());
        }
        
        return ans.toString();
    }
}