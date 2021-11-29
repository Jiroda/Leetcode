class Solution {
    public boolean hasPath(int[][] maze, int[] s, int[] d) {        
        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        return visit(maze, s, d, visited, m, n, dirs);
    }
    private boolean visit(int[][] maze, int[] s, int[] d, boolean[][] visited, int m, int n, int[][] dirs){
        if(s[0]==d[0] && s[1]==d[1]){
            return true;
        }
        visited[s[0]][s[1]]=true;
        for(int[] dir: dirs){
            int x = s[0], y = s[1];
            while(x+dir[0]<m && y+dir[1]<n && x+dir[0]>=0 && y+dir[1]>=0 && maze[x+dir[0]][y+dir[1]]==0){
                x += dir[0];
                y += dir[1];
            }
            if(!visited[x][y]){
                boolean outcome = visit(maze, new int[]{x,y}, d, visited, m, n, dirs);
                if(outcome==true){
                    return true;
                }
            }
        }
        return false;
    }
}