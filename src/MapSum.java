
public class MapSum {

	TrieNode root;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MapSum mapSum = new MapSum();
		mapSum.insert("apple", 3);
		System.out.println(mapSum.sum("a"));
		mapSum.insert("ap", 2);
		System.out.println(mapSum.sum("a"));
	}


    /** Initialize your data structure here. */
    public MapSum() {
    	root = new TrieNode();
    }
    
    public void insert(String key, int val) {
    	TrieNode cur = root;
        for (int i = 0; i < key.length(); i++) {
        	char c = key.charAt(i);
        	
        	if (cur.children[c-'a'] == null) {
        		cur.children[c-'a'] = new TrieNode(c);
        	}
        	cur = cur.children[c-'a'];
        	
        	if (i == key.length() - 1) {
        		cur.val = val;
        	}
        }
    }
    
    public int sum(String prefix) {
    	if (prefix == null || prefix.length() == 0) {
    		return 0;
    	}
    	
        return sumHelper(prefix, 0, root.children[prefix.charAt(0) - 'a']);
    }
    
    public int sumHelper(String prefix, int i, TrieNode cur) {
    	int sum = 0;
    	
    	if (cur == null) {
    		return sum;
    	}

    	if (i+1 < prefix.length()) {
    		sum += sumHelper(prefix, i+1, cur.children[prefix.charAt(i+1) - 'a']);
    	} else {
    		sum += cur.val;
    		for (int j = 0; j < 26; j++) {
        		sum += sumHelper(prefix, i+1, cur.children[j]);
        	}
    	}
    	
    	return sum;
    }
    
    class TrieNode {
    	char c;
    	int val;
    	TrieNode[] children;
    	
    	public TrieNode() {
    		this.children = new TrieNode[26];
    	}
    	
    	public TrieNode(char c) {
    		this.c = c;
    		this.val = 0;
    		this.children = new TrieNode[26];
    	}
    	
    	public TrieNode(char c, int v) {
    		this.c = c;
    		this.val = v;
    		this.children = new TrieNode[26];
    	}
    }
}
