class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Arrays.sort(arr);
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>( (a,b) ->map.get(a) - map.get(b));
        
        for(int a : arr){
            map.put(a, map.getOrDefault(a,0)+1);
        }
        
        for(int key : map.keySet()){
            pq.offer(key);
        }
        
        while(k >0 && !pq.isEmpty()){
            k-= map.get(pq.poll());
        }
        return (k<0) ? pq.size()+1 : pq.size();
    }
}