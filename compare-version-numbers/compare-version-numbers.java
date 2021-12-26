//T:O(Math.max(m,n))
//S:O(1)
class Solution {
    public int compareVersion(String version1, String version2) {
        int length1 = version1.length();
        int length2 = version2.length();
        int ptr1 = 0;
        int ptr2=0;
        
        while(ptr1<length1 || ptr2<length2){
            int number1 = 0;
            while(ptr1<length1 && Character.isDigit(version1.charAt(ptr1))){
                number1 = number1*10 + version1.charAt(ptr1++)-'0';
            }
            int number2 = 0;
            while(ptr2<length2 && Character.isDigit(version2.charAt(ptr2))){
                number2 = number2*10 + version2.charAt(ptr2++)-'0';
            }
            
            if(number1>number2){
                return 1;
            }
            
            if(number1<number2){
                return -1;
            }
            
            ptr1++;
            ptr2++;
        }
        
        return 0;
    }
}