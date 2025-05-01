import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.isEmpty() || words == null || words.length == 0) return result;

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        String[] sortedWords = words.clone();
        Arrays.sort(sortedWords);

        for (int i = 0; i <= s.length() - totalLen; i++) {
            String[] currentWords = new String[wordCount];

            for (int j = 0; j < wordCount; j++) {
                int startIdx = i + j * wordLen;
                currentWords[j] = s.substring(startIdx, startIdx + wordLen);
            }

            Arrays.sort(currentWords);

            if (Arrays.equals(currentWords, sortedWords)) {
                result.add(i);
            }
        }

        return result;
    }
}
