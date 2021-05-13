class Solution {
    public int rob(int[] nums) {
        int[] rob = new int[nums.length];
        if(nums.length ==1){
            return nums[0];
        }
        rob[0]= nums[0];
        rob[1] = Math.max(rob[0], nums[1]);
        for(int i=2;i<nums.length;i++){
           rob[i]= Math.max(rob[i-1], rob[i-2]+ nums[i]);
            
        }
        return rob[nums.length-1];
    }
}