class Solution {
    public String frequencySort(String s) {
        PriorityQueue<Map.Entry<Character, Integer>> minHeap = new PriorityQueue<> 
           ((a,b) ->b.getValue()-a.getValue());
        
        HashMap<Character, Integer> freq = new HashMap<>();
        
        for(char ch:  s.toCharArray()){
            freq.put(ch, freq.getOrDefault(ch,0)+1);
        }
        String st = "";
        for(Map.Entry<Character, Integer> e : freq.entrySet()){
           minHeap.add(e);
        }
        
        while(!minHeap.isEmpty()){
            Map.Entry<Character, Integer> e = minHeap.poll();
             char ch = e.getKey();
            int times = e.getValue();
            
            while(times-- > 0){
                st+=ch;
            }
        }
        
        return st;
    }
}