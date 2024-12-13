import java.util.HashMap;

class Solution {
    public int findMaxLength(int[] nums) {
        // Map to store the first occurrence of each prefix sum
        HashMap<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, -1); // Base case: prefix sum 0 at index -1
        
        int maxLength = 0;
        int prefixSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // Update prefix sum: +1 for 1, -1 for 0
            prefixSum += (nums[i] == 1 ? 1 : -1);
            
            if (prefixMap.containsKey(prefixSum)) {
                // Calculate length of subarray
                maxLength = Math.max(maxLength, i - prefixMap.get(prefixSum));
            } else {
                // Store the first occurrence of the prefix sum
                prefixMap.put(prefixSum, i);
            }
        }
        
        return maxLength;
    }
}
