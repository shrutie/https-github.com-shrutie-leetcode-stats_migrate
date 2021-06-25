class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(char ch: word.toCharArray()){
            if(curr.children[ch-'a'] == null){
                curr.children[ch-'a'] = new TrieNode();
                
            }
            curr = curr.children[ch-'a'];
            curr.count ++;
        }
        curr.isWordEnd ++;
    }
    
    public int countWordsEqualTo(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            if(curr.children[ch-'a'] == null){
                return 0;
            }
            curr = curr.children[ch-'a'];
        }
        return curr.isWordEnd;
    }
    
    public int countWordsStartingWith(String prefix) {
        TrieNode curr = root;
        
        for(char ch : prefix.toCharArray()){
            if(curr.children[ch-'a'] == null){
                return 0;
            }
            curr = curr.children[ch-'a'];
        }
        return (curr == null) ? 0 : curr.count;
    }
    
    public void erase(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            curr = curr.children[ch-'a'];
            curr.count --;
        }
        curr.isWordEnd --;
    }
    
    class TrieNode{
        TrieNode[] children;
        int isWordEnd;
        int count;
        
        public TrieNode(){
            children = new TrieNode[26];
            isWordEnd = 0;
            count = 0;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */