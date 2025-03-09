import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String word : strs) {
            int[] charCount = new int[26];
            for (char c : word.toCharArray()) {
                charCount[c - 'a']++;
            }

            String key = Arrays.toString(charCount);

            anagramGroups.putIfAbsent(key, new ArrayList<>());
            anagramGroups.get(key).add(word);
        }

        return new ArrayList<>(anagramGroups.values());
    }
}
