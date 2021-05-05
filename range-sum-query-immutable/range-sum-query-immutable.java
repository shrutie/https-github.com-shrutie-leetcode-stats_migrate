class NumArray {
    int[] cumSum;
    public NumArray(int[] nums) {
        cumSum = new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            cumSum[i+1] = cumSum[i] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return cumSum[right+1] - cumSum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */