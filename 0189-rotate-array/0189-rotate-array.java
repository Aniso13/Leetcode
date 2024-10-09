import java.util.Arrays;

public class Solution {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        // Adjust k to be within the bounds of the array length
        k = k % n; 
        if (k == 0) return; // If k is 0 or a multiple of n, no rotation is needed

        // Step 1: Reverse the entire array
        reverse(nums, 0, n - 1);
        // Step 2: Reverse the first k elements
        reverse(nums, 0, k - 1);
        // Step 3: Reverse the remaining n-k elements
        reverse(nums, k, n - 1);
    }

    // Helper method to reverse a section of the array
    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            // Swap elements
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        rotate(nums1, k1);
        System.out.println("Rotated array 1: " + Arrays.toString(nums1)); // Output: [5, 6, 7, 1, 2, 3, 4]

        // Example 2
        int[] nums2 = {-1, -100, 3, 99};
        int k2 = 2;
        rotate(nums2, k2);
        System.out.println("Rotated array 2: " + Arrays.toString(nums2)); // Output: [3, 99, -1, -100]
    }
}
