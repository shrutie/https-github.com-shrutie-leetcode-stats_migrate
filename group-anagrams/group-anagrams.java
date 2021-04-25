class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res= new ArrayList<>();
        HashMap<String,List<String>> seen = new HashMap<>();
        
        for(String st: strs){
            char[] ch = st.toCharArray();
            Arrays.sort(ch);
            String sort_st = String.valueOf(ch);
            if(!seen.containsKey(sort_st)){
                seen.put(sort_st, new ArrayList<String>());
            }
            seen.get(sort_st).add(st);
        }
        for(String key: seen.keySet()){
            res.add(new ArrayList<String>(seen.get(key)));
        }
        return res;
    }
}