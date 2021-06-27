class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int size =0;
        int start =0;
        
        for(int r=0 ;r<s.length() ;r++){
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch,0) + 1);
            while(map.size() > k){
                char stChar = s.charAt(start);
                map.put(stChar, map.getOrDefault(stChar,0)-1);
                if(map.get(stChar) == 0){
                    map.remove(stChar);
                }
                start++;
            }
            size = Math.max(size, r-start+1);
        }
        return size;
    }
}