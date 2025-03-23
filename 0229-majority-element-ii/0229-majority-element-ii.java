public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        int n = nums.length;

        int i = 0;
        while (i < n) {
            int j = i + 1;
            while (j < n && nums[i] == nums[j]) {
                j++;
            }
            if (j - i > n / 3) {
                res.add(nums[i]);
            }
            i = j;
        }
        
        return res;
    }
}