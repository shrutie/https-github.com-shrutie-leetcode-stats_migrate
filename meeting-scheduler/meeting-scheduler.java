class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
       PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>
                                        ( (a,b) -> a[0]-b[0]);
        
        List<Integer> list = new ArrayList<>();
        for(int[] slot : slots1){
            if(duration <= slot[1]-slot[0]){
                minHeap.offer(slot);
            }
        }
        
         for(int[] slot : slots2){
            if(duration <= slot[1]-slot[0]){
                minHeap.offer(slot);
            }
        }
        
        while(minHeap.size()>1){
            int[] slot1 = minHeap.poll();
            int[] slot2 = minHeap.peek();
            //end of slot1 beg of slot2
            if(slot1[1]-slot2[0] >=duration){
                list.add(slot2[0]);list.add(slot2[0]+duration);
                return list;
            }
        }
     return list;   
    }
}