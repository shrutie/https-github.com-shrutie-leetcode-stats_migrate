class Solution {
    public int minimumCost(int n, int[][] connections) {
        
        UnionFind uf = new UnionFind(n);
        int sum =0;
        Arrays.sort(connections, (a,b) -> a[2]-b[2]);
        
        for(int[] con : connections){
            int x = con[0];
            int y = con[1];
            int cost = con[2];
            int parX = uf.find(x);
            int parY = uf.find(y);
            if(parX != parY){
                uf.union(x,y);
                sum+= cost;
            }
        }
        
        return (uf.getCount() == 1) ? sum : -1;
    }
    
    class UnionFind{
        int[] parent;
        int count;
        
        public UnionFind(int n){
            this.parent = new int[n+1];
            this.count =n;
            for(int i=0;i<=n;i++){
                parent[i] = i;
            }
        }
        
        int find(int x){
            if(x != parent[x]){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        
        void union(int x, int y){
            int parX = find(x);
            int parY = find(y);
            
            if(parX != parY){
                parent[parX] = parY;
                count --;
            }
        }
        
        int getCount(){
            return this.count;
        }
    }
}