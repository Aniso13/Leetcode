import java.util.*;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        
        if (pattern.length() != words.length) {
            return false;
        }
        
        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();
        
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];
            
            if (charToWord.containsKey(ch)) {
                if (!charToWord.get(ch).equals(word)) {
                    return false; // Pattern mismatch
                }
            } else {
                charToWord.put(ch, word);
            }
            
            if (wordToChar.containsKey(word)) {
                if (wordToChar.get(word) != ch) {
                    return false; // Pattern mismatch
                }
            } else {
                wordToChar.put(word, ch);
            }
        }
        
        return true; 
    }
}
