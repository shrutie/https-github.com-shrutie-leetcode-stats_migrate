class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        int maxmLen = Integer.MIN_VALUE;
        lis[0] = 1;
        for(int i=0;i<nums.length;i++){
            int maxLISsoFar = 0;
            for(int j=0;j<i;j++){
                if(nums[i] > nums[j]){
                    maxLISsoFar = Math.max(maxLISsoFar, lis[j]);
                }
                lis[i] = maxLISsoFar+1;
            }
            maxmLen = Math.max(maxmLen, lis[i]);
        }
        return maxmLen;
    }
}