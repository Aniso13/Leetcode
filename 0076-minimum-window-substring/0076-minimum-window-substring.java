import java.util.Arrays;

class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        int[] freqt = new int[128];
        int[] freqs = new int[128];

        // Build frequency map for t
        for (char c : t.toCharArray()) {
            freqt[c]++;
        }

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int required = t.length();
        
        while (right < s.length()) {
            char c = s.charAt(right);
            if (freqt[c] > 0) {
                freqs[c]++;
                if (freqs[c] <= freqt[c]) {
                    required--;
                }
            }
            right++;

            while (required == 0) {
                // Update minimum window
                if (right - left < minLen) {
                    minLen = right - left;
                    minStart = left;
                }

                char lc = s.charAt(left);
                if (freqt[lc] > 0) {
                    freqs[lc]--;
                    if (freqs[lc] < freqt[lc]) {
                        required++;
                    }
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
