class Solution {
    public int findPairs(int[] nums, int k) {
        
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int i: nums){
            freq.put(i, freq.getOrDefault(i,0)+1);
        }
        
        int count =0;
        for(Map.Entry<Integer,Integer> e : freq.entrySet()){
           if(k==0){
               //means num[i] = num[j]
               if(e.getValue() >=2){
                   count++;
               } 
           }
            else{
                if(freq.containsKey(e.getKey()+k)){
                    count++;
                }
            }   
        }
    return count;
    }
}