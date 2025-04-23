public class Solution {
    public int countLargestGroup(int n) {
        int[] count = new int[37]; 
        for (int i = 1; i <= n; i++) {
            int sum = digitSum(i);
            count[sum]++;
        }
        int max = 0;
        for (int c : count) {
            if (c > max) {
                max = c;
            }
        }
        int res = 0;
        for (int c : count) {
            if (c == max) {
                res++;
            }
        }
        return res;
    }

    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
