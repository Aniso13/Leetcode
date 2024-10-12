class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        
        while (low < high) {
            int mid = (low + high) / 2;

            // If the element at mid is less than its right neighbor, move right
            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } 
            // Otherwise, move left
            else {
                high = mid;
            }
        }
        
        return low; // low == high is the peak element
    }
}
