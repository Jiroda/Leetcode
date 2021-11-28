class Solution {
    public int minimumCost(int n, int[][] connections) {
        HashMap<Integer, List<Node>> graph = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        HashSet<Integer> visited = new HashSet<>();
        buildGraph(n, connections, graph);
        int numCities = n;
        int minCost = 0;
        pq.offer(new Pair(1, -1, 0));
        
        while(!pq.isEmpty()){
            Pair curr = pq.poll();

            //Edge case
            if(visited.contains(curr.currNode)){
                continue;
            }
            visited.add(curr.currNode);
            minCost += curr.weight;
            numCities--;
            List<Node> neighbors = graph.get(curr.currNode);
            for(Node neighbor : neighbors){
                if(!visited.contains(neighbor.node)){
                    pq.offer(new Pair(neighbor.node, curr.currNode, neighbor.weight));
                }
            }
        }
        if(numCities!=0){
            return -1;
        }
        return minCost;
    }
    
    private void buildGraph(int n, int[][] connections, HashMap<Integer, List<Node>> graph){
        for(int i=1;i<=n;i++){
            graph.put(i, new ArrayList<>());
        }
        for(int[] edge: connections){
            int source = edge[0];
            int destination = edge[1];
            int weight = edge[2];
            graph.get(source).add(new Node(destination, weight));
            graph.get(destination).add(new Node(source, weight));
        }
    }
}


class Node{
    int node;
    int weight;
    Node(int node, int weight){
        this.node = node;
        this.weight = weight;
    }
}

class Pair implements Comparable<Pair>{
    int prevNode;
    int currNode;
    int weight;
    
    Pair(int currNode, int prevNode, int weight){
        this.prevNode = prevNode;
        this.currNode = currNode;
        this.weight = weight;
    }
    
    public int compareTo(Pair other){
        return this.weight - other.weight;
    }
}