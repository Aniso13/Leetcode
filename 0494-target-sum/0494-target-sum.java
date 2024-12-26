class Solution {
    public int f(int[] nums,int target,int i,int sum){
        if(i==nums.length)
            return sum==target?1:0;
        return f(nums,target,i+1,sum+nums[i])+f(nums,target,i+1,sum-nums[i]);
        
    }
    public int findTargetSumWays(int[] nums, int target) {
        return f(nums,target,0,0);
    }
}
