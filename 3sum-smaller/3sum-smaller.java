class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int count =0;
        if(nums.length == 0){
            return count;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int low = i+1;
            int high = nums.length-1;
            while(low < high){
                int sumOf3 = nums[i] + nums[low] + nums[high];
                if(sumOf3 < target){
                    count += high -low; // because all numbers between 
                                        //low to high can be used to make the triplet
                    low ++;
                }
                
                else{
                    high --;
                }
            }
        }
        return count;
    }
}