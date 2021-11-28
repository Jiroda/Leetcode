class Solution {
    public String alienOrder(String[] words) {
        HashMap<Character, List<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> indegreeMap = new HashMap<>();
        boolean flag = buildGraph(words, graph, indegreeMap);
        if(!flag){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if(topologicalSort(graph, indegreeMap, sb)){
            return sb.toString();
        }
        
        return "";
    }
    
    private boolean topologicalSort(HashMap<Character, List<Character>> graph, HashMap<Character, Integer> indegreeMap, StringBuilder sb){
        //Add all the zero indegree nodes to the queue
        Queue<Character> queue = new LinkedList<>();
        for(Character node : indegreeMap.keySet()){
            if(indegreeMap.get(node)==0){
                queue.offer(node);
            }
        }
        
        if(queue.isEmpty()) return false;
        int count = graph.size();
        while(!queue.isEmpty()){
            Character currNode = queue.poll();
            sb.append(currNode);
            count--;
            List<Character> neighbors = graph.get(currNode);
            for(Character neighbor : neighbors){
                int indegree = indegreeMap.get(neighbor);
                int updtIndegree = indegree-1;
                indegreeMap.put(neighbor, updtIndegree);
                if(updtIndegree==0){
                    queue.offer(neighbor);
                }
            }
        }
        if(count==0){
            return true;
        }
        
        return false;
    }
    
    
    private boolean buildGraph(String[] words, HashMap<Character, List<Character>> graph, HashMap<Character, Integer> indegreeMap){
        for(String word : words){
            for(char c : word.toCharArray()){
                graph.put(c, new ArrayList<>());
                indegreeMap.put(c,0);
            }
        }
        
        for(int i=0; i<words.length-1; i++){
            String word1 = words[i];
            String word2 = words[i+1];
            int minLength = Math.min(word1.length(), word2.length());
            
            //Edge case
            if(word1.length() >word2.length() && word1.startsWith(word2)){
                return false;
            }
            
            for(int index =0; index<minLength; index++){
                if(word1.charAt(index)!=word2.charAt(index)){
                    Character sourceNode = word1.charAt(index);
                    Character destinationNode = word2.charAt(index);
                    if(!graph.get(sourceNode).contains(destinationNode)){
                        graph.putIfAbsent(sourceNode, new ArrayList<>());
                        graph.get(sourceNode).add(destinationNode);
                        indegreeMap.put(destinationNode, indegreeMap.getOrDefault(destinationNode, 0)+1);
                    }
                    break;
                }
            }
        }
        
        return true;
    }
}