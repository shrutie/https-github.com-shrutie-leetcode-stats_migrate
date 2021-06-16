class Solution {
    public void wallsAndGates(int[][] rooms) {
        int[][] dirs = { {1,0}, {0,1}, {-1,0}, {0,-1}};
        int EMPTY = Integer.MAX_VALUE;
        int GATE = 0;
        int m = rooms.length;
        int n = rooms[0].length;
        
        LinkedList<int[]> que = new LinkedList<>();
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(rooms[i][j] == GATE){
                    que.add(new int[] {i, j});
                }
            }
        }
        
        while(!que.isEmpty()){
            int[] curr = que.poll();
            int i = curr[0];
            int j = curr[1];
            
            for(int[] d : dirs){
                int x = i + d[0];
                int y = j + d[1];
                
                if(x<0 || x>= m || y<0 || y>=n || rooms[x][y] != EMPTY){
                    continue;
                }
                rooms[x][y] = rooms[i][j] + 1;
                que.add(new int[] { x, y});
            }
        }
    }
}