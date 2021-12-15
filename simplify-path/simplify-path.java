//T:O(n)
//S:O(n)
class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        String[] tokens = path.split("/");
        for(String val : tokens){
            if(val.equals(".") || val.isEmpty()){
                continue;
            }
            else if(val.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(val);
            }
        }
        
        StringBuilder res = new StringBuilder();
        for(String dir : stack){
            res.append("/");
            res.append(dir);
        } 
        
        return res.length()!=0? res.toString() : "/";
    }
}