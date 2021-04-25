class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        
        for(int n: nums){
            freq.put(n, freq.getOrDefault(n,0)+1);
        }
        
      /* return Arrays.stream(nums).boxed() //.boxed to convert int to Integer
			.sorted((a,b) ->
                    map.get(a) != map.get(b)  //if freq are not equal
                    ? map.get(a) - map.get(b) // sort by asc order
                    : b - a // sort by dec order if freq are same
                   )
			.mapToInt(n -> n) // map to Integer 
			.toArray();
            */
    
    int[] res = Arrays.stream(nums).boxed()
                .sorted(
                        (a,b) -> freq.get(a) != freq.get(b) 
                                ? freq.get(a)-freq.get(b)
                                :   b-a
                        )
                .mapToInt(n->n)
                .toArray();
    return res;
    }
}