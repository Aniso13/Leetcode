import java.util.HashMap;

class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> charCount = new HashMap<>();
        
        for (char c : text.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> balloonMap = new HashMap<>();
        balloonMap.put('b', 1);
        balloonMap.put('a', 1);
        balloonMap.put('l', 2);
        balloonMap.put('o', 2);
        balloonMap.put('n', 1);

        int minCount = Integer.MAX_VALUE;
        for (char c : balloonMap.keySet()) {
            int countInText = charCount.getOrDefault(c, 0);
            int requiredCount = balloonMap.get(c);

            minCount = Math.min(minCount, countInText / requiredCount);
        }

        return minCount;
    }
}
