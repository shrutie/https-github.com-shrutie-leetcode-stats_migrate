class Solution {
    //????
     private static final List<String> letters = IntStream.range(1, 27).mapToObj(Integer::toString).collect(Collectors.toList());
    int[] memo;
    public int numDecodings(String s) {
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
       return dfs(s,0);
    }
    
    public int dfs(String s, int i){
        if(i==s.length())
            return 1;
        
        if(memo[i]!=-1)
            return memo[i];
        
        int ways=0;
        String  remStr = s.substring(i);
        for(String alpha: letters){
            if(remStr.startsWith(alpha))
                ways+= dfs(s, i+alpha.length());
        }
        memo[i]=ways;
        return memo[i];
    }
}