import java.util.HashMap;
import java.util.Map;

public class WordDict {
	private Dict dict = new Dict('1');

    // Adds a word into the data structure.
    public void addWord(String word) {
    	Dict cur_dict = dict;
        for (int i = 0; i < word.length(); i++) {
        	char cur = word.charAt(i);
    		if (cur_dict.map.containsKey(cur)) {
    			cur_dict = cur_dict.map.get(cur);
    		} else { // create a new node
    			Dict new_node = new Dict(cur);
    			cur_dict.map.put(cur, new_node);
    			cur_dict = cur_dict.map.get(cur);
    		}  	
        }
        // represent the 
        cur_dict.map.put('0', new Dict('0'));
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return searchHelper(word, 0, dict.map);
    }
    
    private boolean searchHelper(String word, int start_idx, 
    		Map<Character, Dict> dictionary) {
    	if (start_idx == word.length()) {
    		return dictionary.containsKey('0');
    	}
    	char cur = word.charAt(start_idx);
    	if (cur == '.') {
    		for (Character key : dictionary.keySet()) {
    			System.out.println(key);
    			int next_idx = start_idx+1;
    			if (searchHelper(word, next_idx, dictionary.get(key).map) == true) {
    				return true;
    			}
    		}
    		return false;
    	}
    	if (dictionary.containsKey(cur)) {
			int next_idx = start_idx+1;
    		return searchHelper(word, next_idx, dictionary.get(cur).map);
    	} else {
    		return false;
    	}
    }

}

class Dict {
	char val;
	Map<Character, Dict> map;
	Dict(char value) {
		val = value;
		map = new HashMap<Character, Dict>();
	}
}