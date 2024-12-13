class NumArray {
    public int nums[];
    

    public NumArray(int[] nums) {
        this.nums=nums; // as it is a constructor
        
    }
    
    public int sumRange(int left, int right) {
        int ans=0;
        for(int i=left;i<=right;i++){
            ans+=nums[i];
        }
        return ans;

        
    }
}
