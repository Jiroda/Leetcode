//T:O(n)
//S:O(n)

class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(map.containsKey(c)){
                if(stack.isEmpty() || stack.peek()!=map.get(c)){
                    return false;
                }else{
                    stack.pop();
                }
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}