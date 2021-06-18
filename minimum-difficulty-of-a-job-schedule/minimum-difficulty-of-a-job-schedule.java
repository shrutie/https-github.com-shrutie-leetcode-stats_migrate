class Solution {
    public int minDifficulty(int[] jobs, int d) {
        
        /*Basically find the partition where we can get min of each day
        1. on day 1, we can always do the most difficult jobs so far occured till that day
        2. From Day1 : We find the minDifficult job 
        based on the previous day's executed jobs dp[i-1][j-1]
        3. Along with, we can also find the mostDiffJob today, which would be maxn of aal jobs from j to i that have execued, 
        4. From this maxmDiff and the current day's diff (job[curr] + dp[i-1][k-1]), we can find out min diff required for that day and those jobs occured
        5. Finally, return the last value in 2D DP arr*/
        int n = jobs.length;
        int [][] dp = new int[d][n];
        
        if(d>n){
            return -1;
        }
        int maxm = 0;
        for(int i=0;i<n;i++){
            maxm = Math.max(jobs[i],maxm);
            dp[0][i] = maxm;
        }
        
        for(int i=1;i<d;i++){
            for(int j=i;j<n;j++){
                int minDiff = jobs[j] + dp[i-1][j-1];
                int mostDiffJobToday = jobs[j];
                
                for(int k=j; k>=i;k--){
                    mostDiffJobToday = Math.max(mostDiffJobToday, jobs[k]);
                    minDiff = Math.min(minDiff, dp[i-1][k-1] + mostDiffJobToday);
                }
                dp[i][j] = minDiff;
            }
        }
        return dp[d-1][n-1];
    }
}