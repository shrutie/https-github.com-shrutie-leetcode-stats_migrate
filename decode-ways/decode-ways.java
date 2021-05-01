class Solution {
    //flexing streams
     private static final List<String> letters = IntStream.range(1, 27)
                                            .mapToObj(Integer::toString)
                                            .collect(Collectors.toList());
    int[] memo;
    public int numDecodings(String s) {
        memo = new int[s.length()];
        Arrays.fill(memo, -101);
       return findWays(s,0);
    }
    
    public int findWays(String s, int i){
        if(i==s.length())
            return 1;
        
        if(memo[i]!=-101)
            return memo[i];
        
        int ways=0;
        String  remStr = s.substring(i);
        for(String alpha: letters){
            if(remStr.startsWith(alpha))
                ways+= findWays(s, i+alpha.length());
        }
        memo[i]=ways;
        return memo[i];
    }
}