import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resultStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0'); // حساب العدد الكامل (في حالة الأرقام المتعددة)
            } else if (c == '[') {
                countStack.push(k);
                resultStack.push(currentString.toString());
                currentString = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                StringBuilder decodedString = new StringBuilder(resultStack.pop());
                int currentCount = countStack.pop();
                for (int i = 0; i < currentCount; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                currentString.append(c);
            }
        }

        return currentString.toString();
    }
}
