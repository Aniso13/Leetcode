class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Map<Integer,Integer> numCounts = new HashMap<>();
        for (int num : nums) {
            numCounts.put(num, (numCounts.getOrDefault(num, 0)+1));
        }
        List<Integer> duplicates = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry : numCounts.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }
        return duplicates;
    }
}