class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res = new double[queries.size()];
        HashMap<String, List<Pair>> graph = new HashMap<>();
        buildGraph(equations, values, graph);
        for(int index=0; index<queries.size(); index++){
            String src = queries.get(index).get(0);
            String des = queries.get(index).get(1);
            
            if(!graph.containsKey(src) || !graph.containsKey(des)){
                res[index] = -1.0;
            }else if(src.equalsIgnoreCase(des)){
                res[index] = 1.0;
            }else{
                res[index] = dfs(graph, src, des, new HashSet<String>());
            }
        }
        return res;
    }
    
    private void buildGraph(List<List<String>> equations, double[] values, HashMap<String, List<Pair>> graph){
        for(int index=0; index<equations.size(); index++){
            String src = equations.get(index).get(0);
            String des = equations.get(index).get(1);
            double val = values[index];
            graph.putIfAbsent(src, new ArrayList<>());
            graph.putIfAbsent(des, new ArrayList<>());
            graph.get(src).add(new Pair(des, val));
            graph.get(des).add(new Pair(src, 1/val));
        }
    }
    
    private double dfs(HashMap<String, List<Pair>> graph, String curr, String des, HashSet<String> visited){
        //Base case if we have reached the destination
        if(des.equalsIgnoreCase(curr)){
            return 1;
        }
        visited.add(curr);
        List<Pair> neighbors = graph.get(curr);
        for(int i=0; i<neighbors.size(); i++){
            String neighbor = neighbors.get(i).destination;
            double val = neighbors.get(i).val;
            if(!visited.contains(neighbor)){
                double res = dfs(graph, neighbor, des, visited);
                if(res!=-1){
                    return val*res;
                }
            }
        }
        return -1.0;
    }
}

class Pair{
    String destination;
    double val;
    
    public Pair(String destination, double val){
        this.destination = destination;
        this.val = val;
    }
}