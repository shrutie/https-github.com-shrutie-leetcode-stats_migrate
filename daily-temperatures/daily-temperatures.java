class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int[] distances = new int[temperatures.length];
        
        for(int i=0;i<temperatures.length;i++){
            
            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]){
                int stack_val = st.pop();
                distances[stack_val] = i - stack_val;
            }
            st.push(i);
        }
        return distances;
    }
}