class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n2 = nums2.length;
        int[] ans = new int[n2];  
        Stack<Integer> stack = new Stack<>();

        for (int i = n2 - 1; i >= 0; i--) {
            
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums2[i]);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < n2; j++) {
                if (nums2[j] == nums1[i]) {
                    res[i] = ans[j];
                    break;
                }
            }
        }

        return res;
    }
}