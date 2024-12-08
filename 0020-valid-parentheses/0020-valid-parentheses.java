class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char p : s.toCharArray()) {
            if (p == '(' || p == '{' || p == '[') {
                stack.push(p);
            } else {
                if (p == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                } else if (p == '}') {
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                } else if (p == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
