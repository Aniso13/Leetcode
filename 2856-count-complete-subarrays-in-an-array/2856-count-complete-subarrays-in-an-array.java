class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        for(int num : nums)
            unique.add(num);
        
        int totalunique = unique.size();
        int counter=0;
        for(int i=0;i<nums.length ;i++)
        {
            Set<Integer> seen = new HashSet<>();
            for(int j = i ;j<nums.length;j++)
            {
                seen.add(nums[j]);
                if(seen.size()==unique.size())
                    counter++;
            }
        }
        return counter;
    }
}