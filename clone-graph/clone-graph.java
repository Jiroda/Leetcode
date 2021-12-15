/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

//T:O(v+e)
//S:O(v)
class Solution {
    HashMap<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        return helper(node);
    }
    
    private Node helper(Node node){
        //base case if we reach null
        if(node==null){
            return null;
        }
        
        //if map already has the clone base case 
        if(map.containsKey(node)){
            return map.get(node);
        }
        
        //create a clone and map it to the original node
        Node clone = new Node(node.val);
        map.put(node, clone);
        
        //traverse through the neighbors and recursively clone the neighbors of the clone 
        for(Node neighbor: node.neighbors){
            clone.neighbors.add(helper(neighbor));
        }
        
        return clone;
    }
}