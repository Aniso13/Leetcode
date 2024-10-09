class Solution {
    public int minAddToMakeValid(String s) {
        int openB = 0; // Count of open parentheses
        int minAdd = 0; // Count of additions needed

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == '(') {
                openB++; // Increment for each open parenthesis
            } else {
                if (openB > 0) {
                    openB--; // Pair the current ')' with a previous '('
                } else {
                    minAdd++; // Need an additional '(' for this ')'
                }
            }
        }

        // Add remaining unmatched '(' to minAdd
        minAdd += openB; // Remaining open parentheses need to be closed

        return minAdd;
    }
    }