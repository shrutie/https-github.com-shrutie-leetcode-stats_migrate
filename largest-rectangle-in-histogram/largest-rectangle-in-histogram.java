class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int area =0;
        int maxArea = -1;
        int i =0;
        for(i =0;i<heights.length;){
            if(st.isEmpty() || heights[st.peek()] <= heights[i]){
                st.push(i++);
            }
            else{
                int top = st.pop();
                if(st.isEmpty()){
                    area = heights[top] * i;
                }
                else{
                    area = heights[top] * (i-st.peek() -1);
                }
                
                maxArea = Math.max(area, maxArea);
            }
        }
        
        while(!st.isEmpty()){
            int top = st.pop();
            if(st.isEmpty()){
                area = heights[top] * i;
            }
            else{
                area = heights[top] * (i-st.peek() -1);
            }
                
            maxArea = Math.max(area, maxArea);
        }
        
        return maxArea;
    
    }
}