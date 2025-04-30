class Solution {
    public int longestOnes(int[] nums, int k) {
        int left =0 , maxLen=0 , countZero=0;

        for(int i=0;i< nums.length;i++)
        {
            if(nums[i]==0)
                countZero++;
            
            while(countZero>k)
            {
                if(nums[left]==0)
                    countZero--;
                left++;
            }

            maxLen = Math.max(maxLen, i-left+1);

        }
        return maxLen;
    }
}