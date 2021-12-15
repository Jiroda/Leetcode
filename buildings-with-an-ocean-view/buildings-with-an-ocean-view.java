//T:O(n)
//S:O(n)

class Solution {
    public int[] findBuildings(int[] heights) {
        Stack<Pair> stack = new Stack<>();
        int n = heights.length;
        int[] nge = new int[n];
        List<Integer> res = new ArrayList<>();
        for(int i=n-1; i>=0; i--){
            int currHeight = heights[i];
            if(stack.isEmpty()){
                nge[i] = -1;
                stack.push(new Pair(currHeight, i));
                continue;
            }
            
            //remove all entries in the stack whose values are lesser than current
            while(!stack.isEmpty()&& currHeight>stack.peek().height){
                stack.pop();
            }
            
            //if stack is not empty peek else add the curr val
            if(!stack.isEmpty()){
                nge[i] = stack.peek().height;
            }else{
                nge[i] = -1;
                stack.push(new Pair(currHeight, i));
            }
        }
        for(int i=0; i<nge.length; i++){
            if(nge[i]==-1){
                res.add(i);
            }
        }
        
        int[] ans = new int[res.size()];
        int index =0;
        
        for(int i: res){
            ans[index++] = i;
        }
        
        return ans;
    }
}

class Pair{
    int height;
    int index;
    public Pair(int height, int index){
        this.height = height;
        this.index = index;
    }
}