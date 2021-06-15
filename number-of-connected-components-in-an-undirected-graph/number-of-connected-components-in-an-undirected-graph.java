class Solution {
    public int countComponents(int n, int[][] edges) {
        
        UnionFind uf = new UnionFind(n);
        for(int[] edge : edges){
            uf.union(edge[0] , edge[1]);
        } 
        return uf.getCount();
    }
    class UnionFind{
        
        int[] parent;
        int count;
        
        public UnionFind(int n){
            parent = new int[n];
            for(int i=0;i<n;i++){
                parent[i] =i;
            }
            count = n;
        }
        
        public int find(int a){
            if(parent[a] != a){
                parent[a] = find(parent[a]);
            }
            return parent[a];
        }
        
        public void union(int a, int b){
            int parA = find(a);
            int parB = find(b);
            
            if(parA != parB){
                parent[parA] = parB;
                count--;
            }
        }
        
        int getCount(){
            return this.count;
        }
    }
}