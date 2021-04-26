class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums.length==0){
            return res;
        }
        Arrays.sort(nums);
        backTrack(nums, 0, new ArrayList<Integer>());
        return res;
    }
    void backTrack(int[] nums, int idx, ArrayList<Integer> currList){
        res.add(new ArrayList<Integer>(currList));
        
        for(int i=idx;i<nums.length;i++){
            if(i>idx && nums[i-1] == nums[i]){
                continue;
            }
            currList.add(nums[i]);
            backTrack(nums, i+1, currList);
            currList.remove(currList.size()-1);
        }
    }
}