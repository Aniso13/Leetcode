class Solution {
    public int removeDuplicates(int[] nums) {
        int x=1;
        
        
        for(int i=1; i<nums.length;i++)
        {
            if (i==nums.length-1)
            {
                nums[x++]=nums[i];
                break;
            }
                
            if(nums[i-1]!=nums[i+1])
                nums[x++]=nums[i];
            
        }
        return x;
    }
}