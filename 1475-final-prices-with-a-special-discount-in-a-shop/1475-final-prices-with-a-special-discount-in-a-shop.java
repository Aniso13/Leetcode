class Solution {
    public int[] finalPrices(int[] prices) {
        int[] result = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < prices.length; i++) {
            // Maintain a decreasing stack
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int index = stack.pop();
                result[index] = prices[index] - prices[i];
            }
            stack.push(i); // Push the current index onto the stack
        }
        
        // For remaining elements, no discount applies
        while (!stack.isEmpty()) {
            int index = stack.pop();
            result[index] = prices[index];
        }
        
        return result;
    }
}
