class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count =0;
        int start =0;
        int prod = 1;
        for(int i =0;i<nums.length;i++) {
            prod *= nums[i];
            while(start <= i && prod >= k) {
                prod = prod / nums[start++];
            }
            count += i-start+1;
            
        }
        return count;
    }
}