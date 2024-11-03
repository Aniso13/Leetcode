class Solution:
    def rotateString(self, s: str, goal: str) -> bool:
        # If the lengths are different, they cannot be rotations of each other
        if len(s) != len(goal):
            return False
        
        # Check if goal is a substring of s + s
        return goal in (s + s)
