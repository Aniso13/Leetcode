class Solution {
    public int trap(int[] height) {
        int total = 0; // Initialize total water trapped
        int l = 0, r = height.length - 1; // Two pointers, left (l) and right (r)
        int lmax = 0, rmax = height[r]; // Initialize max heights for left and right
        
        while (l < r) {
            if (height[l] <= height[r]) {
                // If left height is less than or equal to right height
                if (height[l] < lmax) {
                    total += lmax - height[l]; // Water trapped on the left
                } else {
                    lmax = height[l]; // Update left max height
                }
                l++; // Move left pointer
            } else {
                // If right height is less than left height
                if (height[r] < rmax) {
                    total += rmax - height[r]; // Water trapped on the right
                } else {
                    rmax = height[r]; // Update right max height
                }
                r--; // Move right pointer
            }
        }
        return total; // Return total water trapped
    }
}