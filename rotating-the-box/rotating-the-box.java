class Solution {
    public char[][] rotateTheBox(char[][] box) {
        
        for(int i=0;i<box.length;i++){
            int lastSeen=-1;
            for(int j = box[0].length-1;j>=0;j--){
                if(box[i][j] == '.' && lastSeen == -1){
                    lastSeen =j;
                }
                else if(lastSeen != -1 && box[i][j] =='#'){
                    box[i][j] ='.';
                    box[i][lastSeen]= '#';
                    lastSeen--;
                }
                else if(box[i][j] == '*'){
                    lastSeen = -1;
                }
            }
        }
        
        return flip(box);
    }
    
    public char[][] flip(char[][] box){
        int m = box[0].length;
        int n = box.length;
        char[][] res = new char[m][n];
        for(int i=0;i<n;i++){
            for(int j = m-1;j>=0;j--){
                res[j][n-i-1] = box[i][j];
            }
        }
        
        return res;
    }
}