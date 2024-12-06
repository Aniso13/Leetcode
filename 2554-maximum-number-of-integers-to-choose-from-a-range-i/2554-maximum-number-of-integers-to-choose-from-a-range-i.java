import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int max = 0; // Tracks the sum of selected numbers
        int count = 0; // Tracks the count of selected numbers
        Set<Integer> bannedSet = new HashSet<>();

        // Add banned numbers to the set for quick lookup
        for (int num : banned) {
            bannedSet.add(num);
        }

        // Iterate over numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            // Skip if the number is banned
            if (bannedSet.contains(i)) {
                continue;
            }

            // Check if adding this number exceeds maxSum
            if (max + i > maxSum) {
                break;
            }

            // Add the number to the sum and increment count
            max += i;
            count++;
        }

        return count;
    }
}
