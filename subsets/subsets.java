class Solution {
    /*
    Using backtracking, its a template*/
    List<List<Integer>> res= new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        backTrack(nums, 0, new ArrayList<Integer>());
        return res;
    }
    
    public void backTrack(int[]nums, int idx, List<Integer> currList){
        res.add(new ArrayList<Integer>(currList));
        for(int i=idx;i<nums.length;i++){
            currList.add(nums[i]);
            backTrack(nums, i+1, currList);
            currList.remove(currList.size()-1);
        }
    }
}