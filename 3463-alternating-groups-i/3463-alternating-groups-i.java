class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int n = colors.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int prev = colors[(i - 1 + n) % n]; // Circular previous element
            int curr = colors[i];
            int next = colors[(i + 1) % n]; // Circular next element

            if (curr != prev && curr != next) {
                count++;
            }
        }

        return count;
    }
}