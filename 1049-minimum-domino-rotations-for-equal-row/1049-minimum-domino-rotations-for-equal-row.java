class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int result = check(tops[0], tops, bottoms);
        if (result != -1) return result;
        return check(bottoms[0], tops, bottoms);
    }

    private int check(int target, int[] tops, int[] bottoms) {
        int topSwaps = 0;
        int bottomSwaps = 0;

        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != target && bottoms[i] != target) return -1;

            if (tops[i] != target) topSwaps++;
            if (bottoms[i] != target) bottomSwaps++;
        }

        return Math.min(topSwaps, bottomSwaps);
    }
}
