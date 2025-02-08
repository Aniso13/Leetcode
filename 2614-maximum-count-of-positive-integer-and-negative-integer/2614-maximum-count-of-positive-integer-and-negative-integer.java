class Solution {
    public int maximumCount(int[] nums) {

        int lastpositive =  LastNegative(nums) + 1;
        int firstnegative = nums.length - FirstPositive(nums);

        return Math.max(lastpositive , firstnegative);
        
    }

    public int LastNegative(int [] nums){

        int start = 0;
        int end = nums.length - 1;
        int ans = -1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(nums[mid] < 0){
                ans = mid;
                start = mid + 1;
            } else{
                end = mid - 1;
            }
        }
        return ans;
    }

    public int FirstPositive(int [] nums){
        
        int start = 0;
        int end = nums.length - 1;
        int ans = nums.length;

        while(start <= end){
        int mid = start + (end - start) / 2;
        
        if(nums[mid] > 0){
                ans = mid;
                end = mid - 1;
            } else{
                start = mid + 1;
            }
        }
        return ans;
    }
}