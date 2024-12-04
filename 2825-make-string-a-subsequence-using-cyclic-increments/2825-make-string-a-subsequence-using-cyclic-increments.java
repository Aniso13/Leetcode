class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        if (str2.length() > str1.length()) {
            return false;
        }

        int j = 0;   

        for (int i = 0; i < str1.length() && j < str2.length(); i++) {
            char currentChar = str1.charAt(i);
            char nextChar = currentChar == 'z' ? 'a' : (char) (currentChar + 1);

            if (currentChar == str2.charAt(j) || nextChar == str2.charAt(j)) {
                j++;
            }
        }

        return j == str2.length();
    }
}
