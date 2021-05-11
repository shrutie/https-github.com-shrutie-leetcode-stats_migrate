class Solution {
    public int subarraySum(int[] nums, int k) {
        int currSum=0;
        int count=0;
        Map<Integer,Integer> cumSumFreq = new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            currSum+=nums[i];
            
            if(currSum==k){
                count++;
            }
            if(cumSumFreq.containsKey(currSum-k)){
                count+= cumSumFreq.get(currSum-k);
            }
            
            cumSumFreq.put(currSum, cumSumFreq.getOrDefault(currSum,0)+1);
        }
        return count;
    }
}