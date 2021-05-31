class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        int maxmLIS = Integer.MIN_VALUE;
        lis[0] = 1;
        for(int i=0;i<nums.length;i++){
            int lis_i = 0;
            for(int j=0;j<i;j++){
                if(nums[j] < nums[i]){
                    lis_i = Math.max(lis_i, lis[j]);
                }
            }
            lis[i] = lis_i + 1;
            maxmLIS = Math.max(maxmLIS, lis[i]);
        }
        return maxmLIS;
    }
}