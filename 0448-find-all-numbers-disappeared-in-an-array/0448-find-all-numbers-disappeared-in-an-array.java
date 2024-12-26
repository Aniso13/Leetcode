class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            int x=Math.abs(nums[i])-1;
            if(nums[x]>0)
                nums[x]=-nums[x];
        }
        for(int i=0;i<nums.length;i++){
           if(nums[i]>0)
                ans.add(i+1);

        }
        return ans;
    }
}