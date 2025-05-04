class Solution {
    public int maxProduct(int[] nums) {
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];

            int tempMax = Math.max(current, Math.max(current * maxSoFar, current * minSoFar));
            minSoFar = Math.min(current, Math.min(current * maxSoFar, current * minSoFar));

            maxSoFar = tempMax;
            result = Math.max(result, maxSoFar);
        }

        return result;
    }
}
