class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = Integer.MIN_VALUE, right =0;
        for(int w: weights){
            left = Math.max(left, w);
            right += w;
        }
        
        while(left < right){
            int mid = left+ (right-left )/2;
            if(canShip(weights, mid, days)){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    }
    
    public boolean canShip(int[] weights, int capacity, int maxDays){
        int days =1;
        int shipped =0;
        for(int wt : weights){
            shipped += wt;
            if(shipped > capacity){
                shipped = wt;
                days++;
            }
        }
        if(days> maxDays){
            return false;
        }
        return true;
    }
}