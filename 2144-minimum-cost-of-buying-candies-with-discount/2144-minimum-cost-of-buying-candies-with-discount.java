import java.util.Arrays;

class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);

        int total = 0;
        int counter = 1;

        for (int i = cost.length - 1; i >= 0; i--) {
            if (counter % 3 != 0) {
                total += cost[i];
            }
            counter++;
        }

        return total;
    }
}