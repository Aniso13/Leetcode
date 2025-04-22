class Solution {
    private static final int MOD = 1_000_000_007;
    private static final int MAX = 10000;
    private long[] factorial;
    private long[] invFactorial;

    public int idealArrays(int n, int maxValue) {
        prepareFactorials(n + MAX);

        // dp[len][val] = عدد السلاسل من الطول len وتنتهي بـ val
        int maxLen = 14; // لأن 2^14 > 10000, أكثر من هذا لن نحتاجه
        int[][] dp = new int[maxLen + 1][MAX + 1];
        
        for (int i = 1; i <= maxValue; i++) {
            dp[1][i] = 1;
        }

        for (int len = 2; len <= maxLen; len++) {
            for (int val = 1; val <= maxValue; val++) {
                for (int mult = 2 * val; mult <= maxValue; mult += val) {
                    dp[len][mult] = (dp[len][mult] + dp[len - 1][val]) % MOD;
                }
            }
        }

        long result = 0;
        for (int len = 1; len <= maxLen; len++) {
            long waysToPlace = comb(n - 1, len - 1);
            for (int val = 1; val <= maxValue; val++) {
                result = (result + (dp[len][val] * waysToPlace) % MOD) % MOD;
            }
        }

        return (int) result;
    }

    private long comb(int n, int k) {
        if (k < 0 || k > n) return 0;
        return (factorial[n] * invFactorial[k] % MOD) * invFactorial[n - k] % MOD;
    }

    private void prepareFactorials(int size) {
        factorial = new long[size + 1];
        invFactorial = new long[size + 1];
        factorial[0] = 1;
        for (int i = 1; i <= size; i++) {
            factorial[i] = (factorial[i - 1] * i) % MOD;
        }

        invFactorial[size] = modInverse(factorial[size]);
        for (int i = size - 1; i >= 0; i--) {
            invFactorial[i] = (invFactorial[i + 1] * (i + 1)) % MOD;
        }
    }

    private long modInverse(long x) {
        return pow(x, MOD - 2);
    }

    private long pow(long base, long exp) {
        long result = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;
    }
}
