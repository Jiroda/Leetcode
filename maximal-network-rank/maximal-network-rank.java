//T:O(n^2)
//S:O(n)
class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        if(roads==null || roads.length==0 || roads[0].length==0) return 0;
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashMap<String, Boolean> directlyConnected = new HashMap<>();
        for(int[] edge : roads){
            int src = edge[0];
            int des = edge[1];
            if(!graph.containsKey(src)){
                graph.put(src, new ArrayList<>());
                graph.get(src).add(des);
            }else{
                graph.get(src).add(des);
            }
            
            if(!graph.containsKey(des)){
                graph.put(des, new ArrayList<>());
                graph.get(des).add(src);
            }else{
                graph.get(des).add(src);
            }
            
            directlyConnected.put(src+"-"+des, true);
            directlyConnected.put(des+"-"+src, true);
        }
        
        int networkRank = 0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int count = (graph.containsKey(i) ? graph.get(i).size() : 0) + (graph.containsKey(j) ? graph.get(j).size() : 0) - ( isDirectlyConnected(i, j, directlyConnected) ? 1 : 0 );
                networkRank = Math.max(count, networkRank);
            }
        }
        
        return networkRank;
    }
    
    private boolean isDirectlyConnected(int src, int des, HashMap<String, Boolean> directlyConnected){
        if(directlyConnected.containsKey(src+"-"+des)){
            return true;
        }
        return false;
    }
}