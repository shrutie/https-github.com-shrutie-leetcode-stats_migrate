class Solution {
    public String removeDuplicateLetters(String s) {
        //calc freq of each letter and maintain a stack to push eleemnts in the lexicographical order
        HashMap<Character, Integer> freq = new HashMap<>();
        Stack<Character> st = new Stack<>();
        
        for(char ch : s.toCharArray()){
            freq.put(ch, freq.getOrDefault(ch,0)+1);
        }
        
        for(char ch: s.toCharArray()){
            
            if(!st.isEmpty() && st.contains(ch)){
                freq.put(ch, freq.get(ch)-1);
                continue;
            }
            
            while(!st.isEmpty() 
                  &&st.peek() > ch 
                  && freq.get(st.peek()) > 1){
                char pop = st.pop();
                freq.put(pop, freq.get(pop)-1);
            }
            st.push(ch);
        }
        
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        
        return sb.reverse().toString();
    }
}