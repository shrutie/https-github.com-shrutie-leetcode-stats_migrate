class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
        for(char ch: s.toCharArray()){
            if ( (ch == ')' && !st.isEmpty() && st.peek() == '(') ||
                  (ch == ']' && !st.isEmpty() && st.peek() == '[') ||
                (ch == '}' && !st.isEmpty() && st.peek() == '{')
                  ){
                st.pop();
            }
            else{
                st.push(ch);
            }
        }
        
        return st.isEmpty();
    }
}