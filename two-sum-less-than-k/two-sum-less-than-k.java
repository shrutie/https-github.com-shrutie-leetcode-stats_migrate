class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int low =0;
        int high = nums.length-1;
        int maxm = -1;
        while(low<high){
            int sum = nums[low]+nums[high];
            if(sum<k){
                maxm = Math.max(maxm, sum);
                low ++;
            }
            else{
                high --;
            }
        }
        return maxm;
    }
}