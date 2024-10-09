class Solution {
    public int removeDuplicates(int[] nums) {
        int x=1, val=nums[0];
        
        for(int i=1;i<nums.length;i++)
        {
            val=nums[i-1];
            if(nums[i]!=val)
            {
                nums[x++]=nums[i];
            }
        }
        return x;
    }
}

