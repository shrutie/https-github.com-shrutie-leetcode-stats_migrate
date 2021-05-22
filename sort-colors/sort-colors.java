class Solution {
    public void sortColors(int[] nums) {
        int low=0;
        int high= nums.length-1;
        
        for(int i=0;i<=high;){
            if(nums[i] == 0){
                int tmp = nums[i];
                nums[i]= nums[low];
                nums[low] = tmp;
                i++; low++;
            }
            else if(nums[i] == 1){
                i++;
            }
            else {
                int tmp = nums[i];
                nums[i] = nums[high];
                nums[high] = tmp;
                high --;
            }
        }
    }
}