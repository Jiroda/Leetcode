class Solution {
    public int compress(char[] chars) {
        int count = 1;
        int length = chars.length;
        int index = 1;
        for(int i=1; i<length; i++){
            char prevChar = chars[i-1];
            char currChar = chars[i];
            if(prevChar==currChar){
                count+=1;
            }else{
                if(count>1){
                    for(char c: Integer.toString(count).toCharArray()){
                        chars[index++] = c;
                    }
                    count =1;//reset the count for the next group
                    chars[index++] = currChar;//update to the next unique char
                }else{
                    count =1;//reset the count for the next group
                    chars[index++] = currChar;//update to the next unique char
                }
            }
        }
        
        //At the end of the for loop we will still have the count for the last group
        if(count>1){
            for(char c: Integer.toString(count).toCharArray()){
                chars[index++] = c;
            }
        }
        return index;
    }
}