//T:O(N^k*k*logN)
//S:O(N)

class City {
    int id;
    int distanceFromSrc;
    int costFromSrc;
    public City(int id, int distanceFromSrc, int costFromSrc) {
        this.id = id;
        this.distanceFromSrc = distanceFromSrc;
        this.costFromSrc = costFromSrc;
    }
}

class Pair {
    int destinationCityId;
    int price;
    public Pair(int destinationCityId, int price) {
        this.destinationCityId = destinationCityId;
        this.price = price;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if (flights == null || flights.length == 0 || n <= 0 || k < 0){
            return -1;
        }
        HashMap<Integer,List<Pair>> graph = buildGraph(flights, n);
        PriorityQueue<City> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.costFromSrc, b.costFromSrc));
        minHeap.offer(new City(src, 0, 0));
        //Key:City Value: Number of stops from src
        Map<Integer, Integer> visited = new HashMap<>();
        while (!minHeap.isEmpty()) {
            City currentCity = minHeap.poll();
            if (currentCity.id == dst){
                return currentCity.costFromSrc;
            }
            if (currentCity.distanceFromSrc > k){
                continue;
            }
            if (visited.containsKey(currentCity.id) 
                && 
                visited.get(currentCity.id) <= currentCity.distanceFromSrc){
                continue;
            }
            visited.put(currentCity.id, currentCity.distanceFromSrc);
            List<Pair> neighbors = graph.get(currentCity.id);
            for (Pair pair : neighbors) {
                minHeap.offer(new City(pair.destinationCityId, currentCity.distanceFromSrc + 1, currentCity.costFromSrc + pair.price));
            }
        }
        return -1;
    }
    
    public HashMap<Integer, List<Pair>> buildGraph(int [][] flights, int n) {
        HashMap<Integer, List<Pair>> graph = new HashMap<>();
        for (int i=0; i<n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int [] flight : flights) {
            int sourceCityId = flight[0];
            int destinationCityId = flight[1];
            int price = flight[2];
            graph.get(sourceCityId).add(new Pair(destinationCityId, price));
        }
        return graph;
    }
}
