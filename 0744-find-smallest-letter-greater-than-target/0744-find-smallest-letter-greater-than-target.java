class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int high = letters.length - 1;
        int low = 0;

        // Binary search for the next greatest letter
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Move the high pointer if letters[mid] is greater than target
            if (letters[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        // Since letters is circular, if we don't find a letter greater than target, return the first one
        return letters[low % letters.length];
    }
}
