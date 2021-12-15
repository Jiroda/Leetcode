//T:O(m*n)
//S:O(m*n)
class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = m == 0 ? 0 : rooms[0].length;
        int[][] dirs = {{-1,0}, {0,1}, {0,-1}, {1,0}};
        Queue<int[]> queue = new LinkedList<>();
        // add all gates to the queue
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[] {i,j});
                }
            }
        }
        // update distance from gates
        while (!queue.isEmpty()) {
            int[] curPos = queue.poll();
            for (int[] dir: dirs) {
                int x = curPos[0] + dir[0];
                int y = curPos[1] + dir[1];
                if(!isValid(x, y, rooms)) continue;
                rooms[x][y] = rooms[curPos[0]][curPos[1]]+1;
                queue.offer(new int[] {x, y});
            }
        }
    }
    private boolean isValid(int x, int y, int[][] rooms){
        if (x<0 || y <0 || x >= rooms.length || y >= rooms[0].length || rooms[x][y] != Integer.MAX_VALUE) {
            return false;
        }
        return true;
    }
}