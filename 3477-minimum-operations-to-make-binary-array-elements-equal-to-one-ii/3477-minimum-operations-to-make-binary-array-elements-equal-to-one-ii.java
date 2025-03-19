class Solution {
    public int minOperations(int[] nums) {
       int ans = nums[0] ^1;
       for(int i =1;i<nums.length;i++){
        ans += nums[i-1]^nums[i];
       }
       return ans;
    }
}