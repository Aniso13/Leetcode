class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[128]; 
        int left = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            while (freq[s.charAt(i)] > 0) {
                freq[s.charAt(left)] = 0;
                left++;
            }
            freq[s.charAt(i)]++;
            max = Math.max(max, i - left + 1);
        }

        return max;
    }
}


/*
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, max = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            
            set.add(c);
            max = Math.max(max, right - left + 1);
        }
        
        return max;
    }
}
*/ 