class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> perms = new ArrayList<>();
        
        Queue<List<Integer>> que = new LinkedList<>();
        que.add(new ArrayList<Integer>());
        
        //for all numbers, in the whole queue, for each ListItem size in the que
        
        for(int num : nums){
            
            int size = que.size();
            
            for(int i=0;i<size;i++){
                List<Integer> currPerm = que.poll();
                
                for(int j =0;j<=currPerm.size();j++){
                    List<Integer> newPerm = new ArrayList<>(currPerm);
                    newPerm.add(j, num);
                    
                    if(newPerm.size() == nums.length){
                        perms.add(newPerm);
                    }
                    else{
                        que.add(newPerm);
                    }
                }
                
            }
        }
        
        return perms;
    }
}