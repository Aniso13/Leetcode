class Solution {
public:
    bool rotateString(string s, string goal) {
        // If the lengths are different, they cannot be rotations of each other
        if (s.size() != goal.size()) {
            return false;
        }

        // Check if goal is a substring of s + s
        return (s + s).find(goal) != string::npos;
    }
};
