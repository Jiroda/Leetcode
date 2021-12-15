//T:O(n*logm) n->number of tasks, n->number of unique tasks
//S:O(m)
class Solution {
    public int leastInterval(char[] tasks, int idleTime) {
        //Base case
        if(idleTime==0){
            return tasks.length;
        }
        int time = 0;
        HashMap<Character, Task> map = new HashMap<>();
        for(char c: tasks){
            map.putIfAbsent(c, new Task(0));
            map.get(c).freq++;
        }
        
        PriorityQueue<Task> maxHeap = new PriorityQueue<>((a,b)->b.freq-a.freq);
        maxHeap.addAll(map.values());
        Queue<Task> queue = new LinkedList<>();
        
        while(!queue.isEmpty() || !maxHeap.isEmpty()){
             // if no tasks are available to schedule at current time, go idle until the first cooling task becomes available
            if(maxHeap.isEmpty()) {
                time = queue.peek().lastUsedTime + idleTime + 1;
            }
            
            // Add any tasks in maxheap from queue that just became available for scheduling
            while(!queue.isEmpty() && time > queue.peek().lastUsedTime + idleTime) {
                maxHeap.add(queue.poll());
            }
            
            // Schedule the most frequent occurring task by polling priority queue.
            Task t = maxHeap.poll();
            t.lastUsedTime = time++;
            t.freq--;
            
            // Add the task back into queue if there are more instances of it to schedule.
            if(t.freq != 0) {
                queue.add(t);
            }
        }
        return time;
    }
}
class Task {
    int freq, lastUsedTime = -1;
    public Task(int f) { 
        freq = f; 
    }
}