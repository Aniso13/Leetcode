class Solution {
    public int countSubarrays(int[] nums) {
       int counter =0;

       for(int i=1;i<nums.length-1;i++)
       {
            if(nums[i]==(nums[i-1]+nums[i+1])*2)
                counter++;
       } 
       return counter;
    }
}