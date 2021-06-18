class Solution {
    int[][] dir = { {1,0}, {-1,0}, {0,1}, {0,-1} };
    public boolean hasPath(int[][] maze, int[] start, int[] dest) {
        return dfs(maze, start, dest);
    }
    
    boolean dfs(int[][] G , int[]start, int[] dest){
        int i = start[0];
        int j = start [1];
        
        if(G[i][j] == -1){
            return false;
        }
        if(i == dest[0] && j == dest[1]){
            return true;
        }
        
        G[i][j] = -1;
        boolean isReachable = false;
        for(int[] d : dir){
            int x = i + d[0];
            int y = j +d[1];
            while(isValid(x,y,G)){
                x += d[0];
                y += d[1];
            }
            isReachable |= dfs(G, new int[]{x-d[0],y-d[1]}, dest);
        }
        return isReachable;
    }
    
    boolean isValid(int i, int j, int[][]G){
        int m = G.length;
        int n = G[0].length;
        if(i<0 || i>=m ||j<0 ||j>=n || G[i][j] == 1){
            return false;
        }
        return true;
    }
}