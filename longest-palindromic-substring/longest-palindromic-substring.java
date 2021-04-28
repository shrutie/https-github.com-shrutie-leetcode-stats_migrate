class Solution {
    public String longestPalindrome(String s) {
        if(s.length() <=1)
            return s;
        
        int n = s.length();
        boolean[][] isPall = new boolean[n][n];
        int startIdx =0;
        int maxm =0;
        
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                isPall[i][j] = (s.charAt(i) == s.charAt(j)) &&
                                ( (j-i <3) || 
                                 isPall[i+1][j-1]
                                );
            if(isPall[i][j] && j-i+1 > maxm){
                startIdx = i;
                maxm = j-i+1;
            }
            }
        }
        
        return s.substring(startIdx, startIdx+maxm);
        
    }
}