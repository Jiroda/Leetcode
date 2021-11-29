class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        HashMap<Integer, List<Integer>> busStopToBusRoutes = new HashMap<>();
        buildMap(routes, busStopToBusRoutes);
        
        //Modified BFS with 2 visited sets and the queue will only have bus stops
        HashSet<Integer> visitedBusRoutes = new HashSet<>();
        HashSet<Integer> visitedBusStops = new HashSet<>();
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        int numStops = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int busStop = queue.poll();
                //base case
                if(busStop==target){
                    return numStops;
                }
                //skip already visited bus stops
                if(visitedBusStops.contains(busStop)){
                    continue;
                }
                visitedBusStops.add(busStop);
                List<Integer> busRoutes = busStopToBusRoutes.get(busStop);
                for(int busRoute: busRoutes){
                    if(!visitedBusRoutes.contains(busRoute)){
                        visitedBusRoutes.add(busRoute);
                        int[] route = routes[busRoute];
                        for(int stop : route){
                            if(!visitedBusStops.contains(stop)){
                                queue.offer(stop);
                            }
                        }
                    }
                }
            }
            numStops++;
        }
        
        return -1;
    }
    
    private void buildMap(int[][] routes, HashMap<Integer, List<Integer>> busStopToBusRoutes){
        for(int routeNumber =0; routeNumber<routes.length; routeNumber++){
            int[] route = routes[routeNumber];
            for(int busStop: route){
                busStopToBusRoutes.putIfAbsent(busStop, new ArrayList<>());
                busStopToBusRoutes.get(busStop).add(routeNumber);
            }
        }
    }
}