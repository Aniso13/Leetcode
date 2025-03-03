class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] result = new int[n];

        int left = 0, right = n - 1;
        int equalCount = 0;

        for (int num : nums) {
            if (num == pivot) equalCount++;
        }

        int index = 0;
        for (int num : nums) {
            if (num < pivot) result[index++] = num;
        }
        for (int i = 0; i < equalCount; i++) {
            result[index++] = pivot;
        }
        for (int num : nums) {
            if (num > pivot) result[index++] = num;
        }

        return result;
    }
}