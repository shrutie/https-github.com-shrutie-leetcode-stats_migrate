class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int stick: sticks){
            minHeap.add(stick);
        }
        int res =0;
        while(minHeap.size() > 1){
           int a = minHeap.poll();
            int b = minHeap.poll();
            res += a + b;
            minHeap.add(a+b);
        }
        return res;
    }
}