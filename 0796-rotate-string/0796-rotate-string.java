class Solution {
    public boolean rotateString(String s, String goal) {
        // If the lengths are different, they cannot be rotations of each other
        if (s.length() != goal.length()) {
            return false;
        }

        // Check if goal is a substring of s + s
        String doubled = s + s;
        return doubled.contains(goal);
    }
}
