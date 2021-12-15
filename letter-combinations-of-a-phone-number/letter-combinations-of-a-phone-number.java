//T:O(n*4^n) n->length of the digits string
//s:O(4^n)
class Solution {
    private Map<Character, String> letters = Map.of(
        '2', "abc", '3', "def", '4', "ghi", '5', "jkl", 
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    public List<String> letterCombinations(String digits) {
        if(digits==null || digits.length()==0){
            return new ArrayList<String>();
        }
        List<String> result = new ArrayList<>();
        helper(digits, result, new StringBuilder(), 0);
        return result;
    }
    
    private void helper(String digits, List<String> result, StringBuilder sb, int index){
        if(index==digits.length()){
            result.add(sb.toString());
            return;
        }
        char currentChar = digits.charAt(index);
        String representations = letters.get(currentChar);
        for(char c: representations.toCharArray()){
            sb.append(c);
            helper(digits, result, sb, index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}