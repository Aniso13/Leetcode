class Solution {
    public int minOperations(int[] nums) {
        int flips = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((flips & 1) == nums[i]) { 
                flips++; 
            }
        }
        return flips;
    }
}
