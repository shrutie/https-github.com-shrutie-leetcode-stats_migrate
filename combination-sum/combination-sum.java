class Solution {
    List<List<Integer>> res= new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length==0)
            return res;
        //state: input, targetValue,idx of candidate, currSumSoFar, the list made so far
        findSubsets(candidates, target, 0,0,new ArrayList<Integer>());
        return res;
    }
    
    public void findSubsets(int[] candidates, int target,int idx, int currSum, List<Integer> listSoFar){
        if(currSum==target){
            res.add(new ArrayList<Integer>(listSoFar));
        }
        if(currSum>target){
            return;
        }
        
        for(int i=idx;i<candidates.length;i++){
            listSoFar.add(candidates[i]);
            findSubsets(candidates, target, i,currSum+candidates[i], listSoFar);
            listSoFar.remove(listSoFar.size()-1);
        }
    }
}