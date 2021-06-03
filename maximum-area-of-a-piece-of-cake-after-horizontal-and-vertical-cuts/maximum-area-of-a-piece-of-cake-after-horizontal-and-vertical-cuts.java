class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        int largestHorizontal = getLargestPiece(horizontalCuts, h);
        int largestVertical = getLargestPiece(verticalCuts, w);
        
        return (int)(largestHorizontal % (1e9 + 7) * largestVertical % (1e9 + 7));
    }
    
    private int getLargestPiece(int[] cuts, int total){
        int prevCut = 0;
        int largestPiece = 0;
        
        for(int cut : cuts){
            int currentPiece = cut - prevCut;
            largestPiece = Math.max(largestPiece, currentPiece);
            prevCut = cut;
        }
        largestPiece = Math.max(largestPiece, total - prevCut);
        
        return largestPiece;
    }   
}