class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] isPall = new boolean[n][n];
        int maxm =0;
        String longest = "";
        int start = 0;
        for(int i = n-1;i>=0;i--){
            for(int j =i ;j<n;j++){
                
                isPall[i][j] = s.charAt(i) == s.charAt(j) 
                  && ( j-i+1 <3 || isPall[i+1][j-1] );
                
                if(j-i+1 > maxm && isPall[i][j]){
                    maxm = j-i+1;
                    start =i;
                }
            }
        }
        return s.substring(start, start+maxm);
    }
}