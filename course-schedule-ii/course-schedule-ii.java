class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        int[] courseOrder = new int[numCourses];
        int courseOrderIndex = 0;
        for(int i=0; i<numCourses; i++){
            map.put(i, new ArrayList<>());
        }
        for(int[] prereq : prerequisites){
            int to = prereq[0];
            int from = prereq[1];
            map.get(from).add(to);
            indegree[to]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        
        if(q.size()==0){
            return new int[0]; //graph has a cycle
        }
        
        while(!q.isEmpty()){
            int course = q.poll();
            courseOrder[courseOrderIndex++] = course;
            List<Integer> dependentCourses = map.get(course);
            for(int dependantCourse: dependentCourses){
                indegree[dependantCourse]--;
                if(indegree[dependantCourse]==0){
                    q.offer(dependantCourse);
                }
            }
        }
        
        if(courseOrderIndex==numCourses){
            return courseOrder;
        }
        
         return new int[0];
    }
}