import java.util.Stack;

class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();

        for (char p : s.toCharArray()) {
            if (p == '*' && !stack.isEmpty()) {
                stack.pop();
            } else if (p != '*') {
                stack.push(p);
            }
        }

        StringBuilder result = new StringBuilder();
        for (char part : stack) {
            result.append(part);
        }

        return result.toString();
    }
}
