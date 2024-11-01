class Solution {
    public String makeFancyString(String s) {
        if (s.length() == 0) return s;  // Edge case for an empty string
        
        StringBuilder result = new StringBuilder();
        result.append(s.charAt(0)); // Append the first character
        int count = 1; // Start the count with 1 for the first character

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++; // Increment count if the current character is the same as the previous one
            } else {
                count = 1; // Reset count for a new character
            }
            
            // Append the current character if it does not appear more than twice consecutively
            if (count <= 2) {
                result.append(s.charAt(i));
            }
        }
        
        return result.toString(); // Convert StringBuilder to String and return
    }
}
