public class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long prefixSum = 0;
        long minPrefix = 0;
        long maxPrefix = 0;

        for (int diff : differences) {
            prefixSum += diff;
            minPrefix = Math.min(minPrefix, prefixSum);
            maxPrefix = Math.max(maxPrefix, prefixSum);
        }

        long lowX = lower - minPrefix;
        long highX = upper - maxPrefix;

        long count = highX - lowX + 1;

        return (int) Math.max(0, count);
    }
}
