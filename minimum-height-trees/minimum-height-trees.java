class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1) return Arrays.asList(0);
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        buildGraph(n, edges, graph);
        List<Integer> leaves = new ArrayList<>();
        for(int node: graph.keySet()){
            if(graph.get(node).size()==1){
                leaves.add(node);
            }
        }
        int remainingNodes = n;
        while(remainingNodes>2){
            remainingNodes = remainingNodes-leaves.size();
            ArrayList<Integer> newLeaves = new ArrayList<>();
            for(int leaf: leaves){
                Integer neighbor = graph.get(leaf).get(0);
                graph.get(neighbor).remove(Integer.valueOf(leaf));
                
                if(graph.get(neighbor).size()==1){
                    newLeaves.add(neighbor);
                }
            }
            leaves = newLeaves;
        }
        
        return leaves;
    }
    
    private void buildGraph(int n, int[][] edges, HashMap<Integer, List<Integer>> graph){
        for(int i=0; i<n; i++){
            graph.put(i, new ArrayList<>());
        }
        for(int[] edge: edges){
            int src = edge[0];
            int des = edge[1];
            graph.get(src).add(des);
            graph.get(des).add(src);
        }
    }
}