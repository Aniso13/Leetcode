class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        
        for (String op : operations) {
            if (op.equals("+")) {
                int top = stack.pop();
                int newTop = stack.peek();
                stack.push(top);
                stack.push(top + newTop);
            } else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            } else if (op.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(op));
            }
        }

        int sum = 0;
        for (int score : stack) {
            sum += score;
        }
        return sum;
    }
}
