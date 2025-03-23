public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Set<Integer> res = new HashSet<>();
        for (int num : nums) {
            int count = 0;
            for (int i : nums) {
                if (i == num) count++;
            }
            if (count > nums.length / 3) {
                res.add(num);
            }
        }
        return new ArrayList<>(res);
    }
}