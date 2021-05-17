class Solution {
    Boolean[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new Boolean[s.length()];
        return dfs(s, wordDict, 0);
    }
    
    public boolean dfs(String s, List<String> wordDict, int i){
        if(i == s.length()){
            return true;
        }
        
        if(memo[i]!= null){
            return memo[i];
        }
        String curr = s.substring(i);
        boolean isValid = false;
        
        for(String word : wordDict){
            if(curr.startsWith(word)){
                isValid |= dfs(s, wordDict, i+word.length());
            }
        }
        memo[i] = isValid;
        return memo[i];
    }
}