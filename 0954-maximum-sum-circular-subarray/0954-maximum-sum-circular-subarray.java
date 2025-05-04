class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int maxSum = nums[0];
        int currMax = 0;
        int minSum = nums[0];
        int currMin = 0;

        for (int num : nums) {
            totalSum += num;

            currMax = Math.max(num, currMax + num);
            maxSum = Math.max(maxSum, currMax);

            currMin = Math.min(num, currMin + num);
            minSum = Math.min(minSum, currMin);
        }

        if (maxSum < 0) {
            return maxSum;
        }

        return Math.max(maxSum, totalSum - minSum);
    }
}
