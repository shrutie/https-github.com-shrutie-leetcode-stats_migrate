class Solution {
    public int kthSmallest(int[][] matrix, int k) {
     
        PriorityQueue<Integer> minHeap = new PriorityQueue<>( (a,b) -> a-b);
        
        for(int i =0;i< matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                minHeap.add(matrix[i][j]);
            }
        }
        
        while(k-1 > 0){
            minHeap.poll();
            k--;
        }
        return minHeap.peek();
    }
}