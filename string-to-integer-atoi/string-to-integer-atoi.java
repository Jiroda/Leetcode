//T:O(n)
//S:O(1)

class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.length()==0) return 0;
        
        int index = 0;
        boolean isNegative = false;
        char sign = s.charAt(index);
        
        if(s.charAt(index)=='+'){
            isNegative = false;
            index++;
        }else if(s.charAt(index)=='-'){
            isNegative = true;
            index++;
        }
        
        int number = 0;
        while(index<s.length()){
            char c = s.charAt(index);
            if(Character.isDigit(c)){
                int digit = c-'0';
                if(number>(Integer.MAX_VALUE-digit)/10){
                    if(isNegative){
                        return Integer.MIN_VALUE;
                    }else{
                        return Integer.MAX_VALUE;
                    }                    
                }
                number = number*10+digit;
            }else{
                break;
            }
            index++;
        }
        
        if(isNegative){
            return -1*number;
        }else{
            return number;   
        }
    }
    
}