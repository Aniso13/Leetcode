class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // If target is found
            if (nums[mid] == target) {
                return mid;
            }
            
            // Check if the left half is sorted
            if (nums[low] <= nums[mid]) {
                // Check if the target lies within the sorted left half
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;  // Focus on the left half
                } else {
                    low = mid + 1;  // Focus on the right half
                }
            }
            // Else the right half must be sorted
            else {
                // Check if the target lies within the sorted right half
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;  // Focus on the right half
                } else {
                    high = mid - 1;  // Focus on the left half
                }
            }
        }
        
        return -1; // If the target is not found
    }
}
