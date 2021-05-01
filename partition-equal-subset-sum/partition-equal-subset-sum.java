class Solution {
    public boolean canPartition(int[] nums) {
        int sum =0;
        for(int i:nums){
            sum+=i;
        }
        if(sum%2 != 0){
            return false;
        }
        
        Boolean dp[][] = new Boolean[nums.length+1][sum/2 +1];
        
      return canPartition(dp,nums, sum/2, 0);
    }
    
    public boolean canPartition(Boolean[][] dp,int[] nums, int sum, int idx){
        if(sum==0){
            return true;
        }
        if(idx>=nums.length || sum<=0){
            return false;
        }
        
        boolean can =false;
        if(dp[idx][sum] != null){
            return dp[idx][sum];
        }
        
        if(sum>=nums[idx]){
            can |= canPartition(dp, nums, sum-nums[idx], idx+1);
            if(can){
                dp[idx][sum] = can;
                return dp[idx][sum];
            }
        }
        dp[idx][sum] = canPartition(dp, nums, sum, idx+1);
        return dp[idx][sum];
    }
}