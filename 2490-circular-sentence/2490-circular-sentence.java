class Solution {
    public boolean isCircularSentence(String sentence) {
        if (sentence.length() < 2)
            return true;
        
        // Check if the first and last characters are the same
        if (sentence.charAt(0) != sentence.charAt(sentence.length() - 1))
            return false;
        
        // Check each space-separated word
        for (int i = 1; i < sentence.length() - 1; i++) {
            if (sentence.charAt(i) == ' ') {
                // Check if the last character of the previous word is equal to the first character of the next word
                if (sentence.charAt(i - 1) != sentence.charAt(i + 1))
                    return false;
            }
        }
        return true;
    }
}
