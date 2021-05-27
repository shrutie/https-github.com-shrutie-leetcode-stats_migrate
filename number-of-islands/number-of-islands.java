class Solution {
    char[][] g;
    public int numIslands(char[][] grid) {
        int islands =0;
        int m = grid.length;
        int n = grid[0].length;
        g = grid;
        boolean[][] vis = new boolean[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1'){
                    dfs(i,j, m, n, vis);
                    islands++;
                }
            }
        }
        return islands;
    }
    
    public void dfs(int i, int j, int m, int n, boolean[][] vis){
        int[][] dir = { {0,1}, {0,-1}, {1,0}, {-1,0}};
         
        if(i<0 || i>=m || j<0 || j>=n || vis[i][j] || g[i][j] == '0'){
               return;
        }
        g[i][j] = '0';
        vis[i][j] = true;
        
        for(int[] d : dir){
            int x = i+ d[0];
            int y = j+ d[1];
           
            
            dfs(x,y,m,n, vis);
        }
        
    }
}