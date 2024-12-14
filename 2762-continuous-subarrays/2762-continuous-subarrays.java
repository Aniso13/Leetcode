import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        Deque<Integer> minDeque = new LinkedList<>();
        Deque<Integer> maxDeque = new LinkedList<>();
        
        long count = 0; // Total number of valid subarrays
        int left = 0;   // Left pointer for sliding window
        
        for (int right = 0; right < n; right++) {
            // Maintain the minDeque (monotonic increasing)
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] > nums[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(right);
            
            // Maintain the maxDeque (monotonic decreasing)
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] < nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);
            
            // Shrink the window if it becomes invalid
            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > 2) {
                if (minDeque.peekFirst() == left) minDeque.pollFirst();
                if (maxDeque.peekFirst() == left) maxDeque.pollFirst();
                left++;
            }
            
            // Count valid subarrays ending at `right`
            count += (right - left + 1);
        }
        
        return count;
    }
}
