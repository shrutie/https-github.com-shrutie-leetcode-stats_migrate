class Solution {
    public int maxSubArray(int[] nums) {
        //dp[i] : this is the max sum of the subarray till i
        int[] maxSum = new int[nums.length];
        if(nums.length == 1){
            return nums[0];
        }
        int maxm = nums[0];
        maxSum[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            maxSum[i] = nums[i] + (maxSum[i-1] >0 ? maxSum[i-1] : 0);
            maxm = Math.max(maxm, maxSum[i]);
        }
        return maxm;
    }
}