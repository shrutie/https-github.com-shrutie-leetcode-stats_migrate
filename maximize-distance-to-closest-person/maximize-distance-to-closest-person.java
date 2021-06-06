class Solution {
    public int maxDistToClosest(int[] seats) {
        int leftPtr =-1;
        int n = seats.length;
        int maxm =0;
        
        for(int i=0;i<n;i++){
            if(seats[i] == 0){
                continue;
            }
            if(leftPtr == -1){
                maxm = Math.max(maxm, i);
            }
            else{
                maxm = Math.max(maxm, (i-leftPtr)/2);
            }
            leftPtr =i;
        }
        return (seats[n-1] == 0)? Math.max(maxm, n-1-leftPtr) : maxm;
    }
}