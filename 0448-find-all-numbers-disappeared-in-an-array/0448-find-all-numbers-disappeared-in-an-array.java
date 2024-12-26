class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            numSet.add(num);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!numSet.contains(i)) {
                result.add(i);
            }
        }

        return result;
    
    }
}