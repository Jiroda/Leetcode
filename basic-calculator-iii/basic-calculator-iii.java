//T:O(n)
//S:O(n)
class Solution {
    int i=0;
    public int calculate(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        return helper(s);
    }
    private int helper(String s){
        if (s == null || s.length() == 0) return 0;
        int result = 0;
        int num = 0;
        int temp = 0;
        char op ='+';
        
        while(i<s.length()){
            char ch = s.charAt(i++);
            if(Character.isDigit(ch)){
                temp = temp*10 + ch-'0';
            }else if(ch == '('){
               temp = helper(s);
               //System.out.println(temp);
            }else if(ch == ')'){
                break;
            }else if(ch!=' '){
                //process the numerical value in temp with the operator val and move that into the num variable
                num = calculate(op, num, temp);
                //only if we have a + or - we move the number found so far and add it to the result
                if(ch=='+' || ch=='-'){
                    result+=num;
                    num=0;
                }
                temp =0;
                op = ch;
            }
        }
        
        return result + calculate(op, num, temp);
    }
    
    private int calculate(char op, int num, int temp){
        if(op=='+') return num+temp;
        else if(op=='-') return num-temp;
        else if(op=='*') return num*temp;
        else return num/temp;
    }
}