class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<List<Integer>> que = new LinkedList<>();
        Set<List<Integer>> seen = new HashSet<>();
        if(nums.length == 0){
            return res;
        }
        que.add(new ArrayList<Integer>());
        
        for(int num: nums){
            int size = que.size();
            
            for(int i=0;i<size;i++){
                List<Integer> curr = que.poll();
                
                for(int j =0 ;j<=curr.size();j++){
                    List<Integer> newPerm = new ArrayList<>(curr);
                    newPerm.add(j, num);
                    
                    if(newPerm.size() == nums.length && !seen.contains(newPerm)){
                        seen.add(newPerm);
                        res.add(newPerm);
                    }
                    else{
                        que.add(newPerm);
                    }
                }
            }
        }
        
        return res;
        
    }
}