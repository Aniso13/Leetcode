import java.util.*;

public class Solution {
    static final int MOD = 1_000_000_007;

    public int colorTheGrid(int m, int n) {
        List<Integer> states = new ArrayList<>();
        Map<Integer, List<Integer>> compatible = new HashMap<>();

        // Generate valid column colorings
        generateStates(0, 0, -1, m, states);

        // Precompute compatibility
        for (int a : states) {
            compatible.put(a, new ArrayList<>());
            for (int b : states) {
                if (isCompatible(a, b, m)) {
                    compatible.get(a).add(b);
                }
            }
        }

        // DP map: current column state -> count
        Map<Integer, Integer> dp = new HashMap<>();
        for (int state : states) {
            dp.put(state, 1);
        }

        for (int col = 1; col < n; col++) {
            Map<Integer, Integer> nextDp = new HashMap<>();
            for (int prevState : dp.keySet()) {
                for (int nextState : compatible.get(prevState)) {
                    int count = (int) ((long) dp.get(prevState) + nextDp.getOrDefault(nextState, 0)) % MOD;
                    nextDp.put(nextState, count);
                }
            }
            dp = nextDp;
        }

        int result = 0;
        for (int count : dp.values()) {
            result = (result + count) % MOD;
        }

        return result;
    }

    private void generateStates(int pos, int state, int prevColor, int m, List<Integer> states) {
        if (pos == m) {
            states.add(state);
            return;
        }

        for (int color = 0; color < 3; color++) {
            if (color != prevColor) {
                generateStates(pos + 1, state * 3 + color, color, m, states);
            }
        }
    }

    private boolean isCompatible(int a, int b, int m) {
        for (int i = 0; i < m; i++) {
            int colorA = a % 3;
            int colorB = b % 3;
            if (colorA == colorB) return false;
            a /= 3;
            b /= 3;
        }
        return true;
    }
}
