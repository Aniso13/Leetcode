class Solution {
    public int numTilings(int n) {
        int MOD = 1_000_000_007;
        
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        long[] dp = new long[n + 1];
        dp[0] = 1; 
        dp[1] = 1;  
        dp[2] = 2;  
        
        long sum = dp[0]; 
        
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + 2 * sum) % MOD;
            sum = (sum + dp[i - 2]) % MOD;
        }
        
        return (int) dp[n];
    }
}
