//T:O(n)
//S:O(1)
class Solution {
    public int calculate(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        return helper(s, 0);
    }
    private int helper(String s, int i){
        int result = 0;
        int num = 0;
        int temp = 0;
        char op ='+';
        
        while(i<s.length()){
            char ch = s.charAt(i++);
            if(Character.isDigit(ch)){
                temp = temp*10 + ch-'0';
            }else if(ch!=' '){
                num = calculate(op, num, temp);
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