class Solution {
    public int maxProfit(int[] prices) {
        int minn = Integer.MAX_VALUE;
        int maxx = 0;
        for (int price : prices)
        {
            minn = Math.min(price, minn);
            maxx = Math.max(maxx , price - minn);
        }
        return maxx;
    }
}