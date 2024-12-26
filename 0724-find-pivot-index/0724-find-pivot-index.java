class Solution {
    public int pivotIndex(int[] nums) {
        int[] temLeft = new int[nums.length];
        int[] temRight = new int[nums.length];
        int sumLeft = 0;
        int sumRight = 0;

        for (int i = 0; i < nums.length; i++) {
            sumLeft += nums[i];
            temLeft[i] = sumLeft;
        }

        for (int j = nums.length - 1; j >= 0; j--) {
            sumRight += nums[j];
            temRight[j] = sumRight;
        }

        for (int i = 0; i < nums.length; i++) {
            if (temLeft[i] == temRight[i]) {
                return i;
            }
        }

        return -1;
    }
}
