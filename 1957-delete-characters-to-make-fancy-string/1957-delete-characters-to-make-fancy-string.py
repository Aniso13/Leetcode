class Solution:
    def makeFancyString(self, s: str) -> str:
        s = list(s)  # Convert string to list for in-place modifications
        length, i = 0, 0
        prev = '@'  # Placeholder to compare with the first character
        
        for c in s:
            if prev != c:  # Reset count if the character is new
                length = 1
            else:
                length += 1  # Increment count for consecutive characters
            
            # Only add to result if it's not more than two in a row
            if length <= 2:
                s[i] = c
                i += 1
            
            prev = c  # Update previous character
        
        return "".join(s[:i])  # Join only the relevant part of list as final string
