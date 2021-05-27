class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int i =0;
        while(i<nums.length){
            if(nums[i]< nums.length && nums[i]!= nums[nums[i]]){
                swap(i, nums[i], nums);
            }
            else{
                i++;
            }
        }
        
        for( i=0;i<nums.length;i++){
            if(i!=nums[i]){
                return i;
            }
        }
        return nums.length;
    }
    
    public void swap(int i, int j, int[]  nums){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j]=tmp;
    }
}