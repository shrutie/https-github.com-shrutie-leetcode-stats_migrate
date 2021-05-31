class Solution {
    int parent[];
    int cities;
    
    private void union(int x, int y){
        int parX = find(x);
        int parY = find(y);
        
        if(parX != parY) {
            parent[parX] = parY;
            cities--;
        }
    }
    
    private int find(int x){
        //if the parent is city itself
        if(parent[x] == x){
            return x;
        }
        //if not, find the parent =, when you send parent[x] : path comression
        parent[x] = find(parent[x]);
        return parent[x];
        
    }
    
    public int minimumCost(int n, int[][] connections) {
        parent = new int[n+1];
        cities =n;
        int cost =0; 
        
        //assigning all the parents to itself
        for(int i=0;i<=n;i++){
            parent[i] = i;
        }
        
        //sort by the cost now, and process one by one
        Arrays.sort(connections, (a,b) -> a[2]-b[2]);
        
        for(int[] conn: connections){
            int A = conn[0];
            int B = conn[1];
            int costAB = conn[2];
            
            int parA = find(A);
            int parB = find(B);
            
            //okay if A and B have different parents, they're not connected right, union them and add thier cost to the final result
            if(parA != parB){
                cost += costAB;
                union(A,B);
            }
            
        }
        /*while doing union the number of unreachable cities are reduced, at the end there
        should be one city left which is the parent of all cities, much like the source,
        if not then there cannot be a path honey!
        */
        return (cities == 1) ? cost: -1;
        
    }
}