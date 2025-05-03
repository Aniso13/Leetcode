class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int [] res = new int [heights.length];

        Stack<Integer> stack = new Stack<>();
        
        for(int i = heights.length-1; i>=0;i--)
        {
            
            while(!stack.isEmpty() && heights[i]> stack.peek())
            {
                stack.pop();
                res[i]++;
            }
            if (!stack.isEmpty()) res[i]++;
            stack.push(heights[i]);
        }

        return res;
    }
}