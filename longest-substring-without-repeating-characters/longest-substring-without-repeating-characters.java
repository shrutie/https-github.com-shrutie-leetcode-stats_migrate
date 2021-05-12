class Solution {
    public int lengthOfLongestSubstring(String s) {
        int count =0;
        int left =0;
        //Map to keep the last seen index of each char
        HashMap<Character, Integer> freq = new HashMap<>();
        int maxm=0;
        int maxmm = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(freq.containsKey(ch)){
                maxm = Math.max(maxm, freq.get(ch)+1);
            }
            freq.put(ch,i);
          maxmm = Math.max(maxmm, i-maxm+1);  
        }
        return maxmm;
    }
}