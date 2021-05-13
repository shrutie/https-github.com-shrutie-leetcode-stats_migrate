class Solution {
    int count =0;
    public int findTargetSumWays(int[] nums, int target) {
        calcSum(nums, 0, 0, target);
        return count;
    }
    public void calcSum(int[] arr, int i, int sum, int target){
        if(i ==arr.length){
            if(sum == target){
                count++;
            }
        }   
        else{
            calcSum(arr, i+1, sum+ arr[i], target);
            calcSum(arr, i+1, sum-arr[i], target);
        }
    }
}