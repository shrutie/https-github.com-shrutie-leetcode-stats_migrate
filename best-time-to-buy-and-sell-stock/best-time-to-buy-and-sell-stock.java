class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for(int currPrice: prices){
            if(minPrice > currPrice){
                minPrice = currPrice;
            }
            else if(currPrice - minPrice > maxProfit){
                maxProfit = currPrice-minPrice;
            }
        }
        return maxProfit;
    }
}