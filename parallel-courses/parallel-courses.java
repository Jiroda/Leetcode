class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> indegreeMap = new HashMap<>();
        buildGraph(n, relations, graph, indegreeMap);
        int minSemesters = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int node : graph.keySet()){
            if(indegreeMap.get(node)==0){
                queue.offer(node);
            }
        }
        
        if(queue.isEmpty()) return -1;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int course = queue.poll();
                n--;
                List<Integer> dependentCourses = graph.get(course);
                for(int dependentCourse : dependentCourses){
                    int currIndegree = indegreeMap.get(dependentCourse);
                    int updatedIndegree = currIndegree-1;
                    indegreeMap.put(dependentCourse, updatedIndegree);
                    if(updatedIndegree==0){
                        queue.offer(dependentCourse);
                    }
                }
            }
            minSemesters++;
        }
        
        if(n==0){
            return minSemesters;
        }
        
        return -1;
    }
    
    private void buildGraph(int n, int[][] relations, HashMap<Integer, List<Integer>> graph, HashMap<Integer, Integer> indegreeMap){
        for(int i=1; i<=n; i++){
            graph.put(i, new ArrayList<>());
            indegreeMap.put(i, 0);
        }
        
        for(int[] edge: relations){
            int src = edge[0];
            int des = edge[1];
            graph.get(src).add(des);
            indegreeMap.put(des, indegreeMap.getOrDefault(des, 0)+1);
        }
    }
    
}