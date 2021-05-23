class Solution {
    public int countSubstrings(String s) {
     /*
     A 2D DP to store the validity of pallindromes
     for each substr there would be a length which can go from 0 to n-1
     if len  0  : single char : isPall
     if len 1 : two chars : simply compare
     for all other len : check if the chars at i and j are same, if yes then check for the substring between i and j which is i+1, j-1*/
        int count =0;
        int n = s.length();
        boolean[][] isPall = new boolean[n][n];
        
        for(int len =0;len<n;len++){
            
            for(int i=0,j=len;j<n;i++,j++){
                if(len == 0){
                    isPall[i][j] = true;
                }
                else if(len == 1){
                    isPall[i][j] = s.charAt(i) == s.charAt(j);
                }
                else{
                    isPall[i][j] = (s.charAt(i) == s.charAt(j) &&
                                   isPall[i+1][j-1]);
                }
                
                if(isPall[i][j]){
                count++;
                }
            }
            
        }       
        return count;
    }
}