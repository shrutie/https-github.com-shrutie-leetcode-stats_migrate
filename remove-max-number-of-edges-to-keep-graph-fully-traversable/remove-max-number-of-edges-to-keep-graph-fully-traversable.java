class Solution {

    public int maxNumEdgesToRemove(int n, int[][] edges) {
               
        UnionFind alice = new UnionFind(n);
        UnionFind bob = new UnionFind(n);
        int count =0;
        
        Arrays.sort(edges, (a,b) -> b[0]-a[0]);
        for(int[] edge: edges){
           int type = edge[0];
            int u = edge[1];
            int v = edge[2];
            switch(type){
                case 3 :
                    if(alice.union(u,v) | bob.union(u,v)){
                        count++;
                    }
                    break;
                case 2:
                    if(bob.union(u,v)){
                        count++;
                    }
                    break;
                case 1: 
                    if(alice.union(u,v)){
                        count++;
                    }
                    break;
            } 
        }
       return (alice.getCount() && bob.getCount()) ? edges.length-count : -1;
       
    }
}

class UnionFind{
    int[] parent;
    int count;
    
    public UnionFind(int n){
        
        parent = new int[n+1];
        count = n;
        for(int i=0;i<=n;i++){
            parent[i] = i;
        }
    }
    public boolean union(int x, int y){
        int parX = find(x);
        int parY = find(y);
        if(parX != parY){
            parent[parX] = y;
            count--;
            return true;
        }
        return false;
    }
    
    public int find(int x){
        //System.out.println(parent[0]);
        if(parent[x] != x){
           parent[x] = find(parent[x]);
        }

        return parent[x];
    }
    
    public boolean getCount(){
        return count ==1;
    }
}