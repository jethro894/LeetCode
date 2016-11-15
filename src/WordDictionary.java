
public class WordDictionary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WordDictionary dic = new WordDictionary();
		dic.addWord("atom");
		dic.addWord("caterham");
		dic.addWord("bac");
		dic.addWord("mono");
		dic.addWord("ariel");
		dic.addWord("radical");
		
		System.out.println(dic.search("atoms"));
	}

	
	TrieNode root;
    
    public WordDictionary(){
        this.root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        if(word.length() == 0)
            return;
        
        TrieNode cur = this.root;
        for(char c : word.toCharArray()){
            if((cur.children)[charToIndex(c)] == null){
                TrieNode newNode = new TrieNode(c);
                (cur.children)[charToIndex(c)] = newNode;
                cur = newNode;
            }else{
                cur = (cur.children)[charToIndex(c)];
            }
        }
        (cur.children)[26] = new TrieNode();
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
    	if(word.length() == 0)
            return true;
    	
    	return wordHelper(word, 0, root);
    }
    
    public boolean wordHelper(String word, int start, TrieNode curNode){
    	if(curNode == null){
    		return false;
    	}
    	
    	if(start == word.length()){
    		if(curNode.children[26] != null)
    			return true;
    		else
    			return false;
    	}
    	
    	char c = word.charAt(start);
    	if(c == '.'){
    		for(TrieNode child : curNode.children){
    			if(wordHelper(word, start+1, child)){
    				return true;
    			}
    		}
    	}else{
    		if(wordHelper(word, start+1, curNode.children[charToIndex(c)])){
				return true;
			}
    	}
    	return false;
    }
    
    class TrieNode{
        char c;
        TrieNode[] children;
        
        public TrieNode(){this.children = new TrieNode[27];}
        public TrieNode(char c){
            this.c = c;
            this.children = new TrieNode[27];	//one more element for end check
        }
    }
    
    public int charToIndex(char c){
        int res = c-'a';
        if(res >= 0 && res < 26)
        	return res;
        else
        	return 26;
    }
    
    public char indexToChar(int i){
        return (char)(i + 'a');
    }
}
