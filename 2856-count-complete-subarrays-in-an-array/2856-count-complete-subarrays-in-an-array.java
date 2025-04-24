import java.util.*;

public class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        Set<Integer> uniqueSet = new HashSet<>();
        for (int num : nums) {
            uniqueSet.add(num);
        }
        int totalUnique = uniqueSet.size();

        int left = 0, count = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int right = 0; right < n; right++) {
            int num = nums[right];
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

            while (freqMap.size() == totalUnique) {
                count += (n - right);

                int leftNum = nums[left];
                freqMap.put(leftNum, freqMap.get(leftNum) - 1);
                if (freqMap.get(leftNum) == 0) {
                    freqMap.remove(leftNum);
                }
                left++;
            }
        }

        return count;
    }
}
