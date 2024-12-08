import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            // Handle collisions
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                int top = stack.pop();
                if (Math.abs(top) > Math.abs(asteroid)) {
                    asteroid = top; // The right-moving asteroid survives
                } else if (Math.abs(top) == Math.abs(asteroid)) {
                    asteroid = 0; // Both asteroids destroy each other
                    break;
                }
            }

            // Push the current asteroid if it survives
            if (asteroid != 0) {
                stack.push(asteroid);
            }
        }

        // Convert stack to array
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
