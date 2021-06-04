class Solution {
    public void reverseWords(char[] s) {
        
        reverseStr(0, s.length-1, s);
        reverseEachWord(s);
    }
    
    public void reverseEachWord(char[] s){
        int start =0;
        int end =0;
        int n = s.length;
        while (start < n){
            
            while(end< n && s[end] != ' '){
                ++end;
            }
            reverseStr(start, end-1,s);
            
            start = end+1;
            ++end;
        }
    }
        
    public void reverseStr(int start, int end, char[] s){
                
        while(start<end){
            char tmp = s[start];
            s[start++] = s[end];
            s[end--] = tmp;
        }
    }
}