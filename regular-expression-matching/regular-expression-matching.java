class Solution {
    public boolean isMatch(String s, String p) {
        if(s==null || p==null)
            return false;
        
        boolean[][] matched = new boolean[s.length()+1][p.length()+1];
        
        matched[0][0]= true;
        
        for(int i=0;i<p.length();i++){
           if(p.charAt(i) =='*' && matched[0][i-1])
               matched[0][i+1]= true;
        }
        
    
        for(int i=1;i<s.length()+1;i++){
            for(int j=1;j<p.length()+1;j++){
                
                char currS = s.charAt(i-1);
                char currP = p.charAt(j-1);
                if(currP == '.' || currS == currP){
                    matched[i][j] = matched[i-1][j-1];
                }
                
                else if(currP =='*'){
                char charB4currP = p.charAt(j-2);
                    if(charB4currP != '.' && charB4currP != currS)
                        matched[i][j]= matched[i][j-2];
                    else
                         matched[i][j] =
                        (matched[i][j - 2] || matched[i - 1][j - 2] || matched[i - 1][j]);
                }
            }
        }
        return matched[s.length()][p.length()];
    }
}