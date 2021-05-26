class Solution {
    int[][] dir = { {1,0}, {0,1}, {-1,0}, {0,-1}};
    
    public int largestIsland(int[][] grid) {
        /*Whenever we are at 0, count the number of 1s it can have connected to it.
        */
        int max = 1;
        int color =5;
        Map<Integer, Integer> islandMap = new HashMap<>();
        islandMap.put(0,0);
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    int island = dfs(grid, i, j, color);
                    islandMap.put(color,island);
                    color++;
                }
            }
        }
        
        max = islandMap.getOrDefault(5,0);
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                int count_area = 1;
                if(grid[i][j] == 0){
                    HashSet<Integer> seenIslands = new HashSet<>();
                    for(int[] d : dir){
                        int x = i + d[0];
                        int y = j + d[1];
                        if(x<0 || x>= grid.length || y<0 || y>= grid[0].length){
                         continue;
                        }
                        seenIslands.add(grid[x][y]);
                    }
                   
                    for(int curr: seenIslands){
                        System.out.println(curr);
                        count_area += islandMap.get(curr);
                    }
                    max = Math.max(max, count_area);
                }
            }
        }
        return max;
    }
    
    public int dfs(int[][] grid, int i, int j, int color){
        
        if(i<0 || i>= grid.length || j<0 || j>= grid[0].length || grid[i][j] != 1){ 
            return 0;
        }
        grid[i][j] = color;
        int count =1;
        for(int[] d : dir){
            count+= dfs(grid, i + d[0], j+d[1], color);
        }
        return count;
    }
}