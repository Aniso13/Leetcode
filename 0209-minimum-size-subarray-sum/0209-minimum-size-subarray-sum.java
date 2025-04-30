class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum =0 , minsize=Integer.MAX_VALUE , left =0;

        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            while( sum>= target)
            {
                minsize = Math.min(minsize,i-left+1);
                sum-=nums[left];
                left++;
            }
        }

        return minsize == Integer.MAX_VALUE ? 0 : minsize;
    }
}