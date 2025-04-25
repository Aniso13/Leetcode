class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);  
        long counter = 0;
        int sum = 0;

        for (int num : nums) {
           
            int value = (num % modulo == k) ? 1 : 0;

            sum += value;

            int key = (sum - k + modulo) % modulo;
            counter += mp.getOrDefault(key, 0);

            mp.put(sum % modulo, mp.getOrDefault(sum % modulo, 0) + 1);
        }

        return counter;
    }
}
