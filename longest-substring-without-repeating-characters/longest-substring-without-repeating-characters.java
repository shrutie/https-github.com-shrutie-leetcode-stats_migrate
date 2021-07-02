class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        int start = 0;
        int len = 0;
        for(int r =0;r<s.length();r++){
            char ch = s.charAt(r);
            if(freq.containsKey(ch)){
                start = Math.max(start, freq.get(ch)+1);
            }
            freq.put(ch,r);
            len = Math.max(len, r-start+1);
        }
        return len;
    }
}