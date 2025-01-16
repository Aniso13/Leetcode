public class Solution {
    public int reverseBits(int n) {
        // Swap adjacent pairs
        n = ((n >>> 1) & 0x55555555) | ((n & 0x55555555) << 1);
        // Swap nibbles
        n = ((n >>> 2) & 0x33333333) | ((n & 0x33333333) << 2);
        // Swap bytes
        n = ((n >>> 4) & 0x0F0F0F0F) | ((n & 0x0F0F0F0F) << 4);
        // Swap two-byte long pairs
        n = ((n >>> 8) & 0x00FF00FF) | ((n & 0x00FF00FF) << 8);
        // Swap halves
        n = ((n >>> 16) & 0x0000FFFF) | ((n & 0x0000FFFF) << 16);
        return n;
    }
}