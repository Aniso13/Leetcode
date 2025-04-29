public class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int[] freq = new int[100001]; 
        long sum = 0, maxSum = 0;
        int left = 0;
        int uniqueCount = 0;

        for (int right = 0; right < nums.length; right++) {
            int num = nums[right];
            
            if (freq[num] == 0) uniqueCount++;
            freq[num]++;
            sum += num;

            if (right - left + 1 > k) {
                int leftNum = nums[left];
                freq[leftNum]--;
                if (freq[leftNum] == 0) uniqueCount--;
                sum -= leftNum;
                left++;
            }

            if (right - left + 1 == k && uniqueCount == k) {
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}
