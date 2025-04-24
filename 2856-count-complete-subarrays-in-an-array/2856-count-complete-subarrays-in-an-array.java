class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        for(int num : nums)
            unique.add(num);
        
        int totalunique = unique.size();
        int count=0;
        for (int left = 0; left < nums.length; left++) {
            Map<Integer, Integer> freq = new HashMap<>();
            int uniqueInWindow = 0;

            for (int right = left; right < nums.length; right++) {
                int num = nums[right];
                freq.put(num, freq.getOrDefault(num, 0) + 1);

                if (freq.get(num) == 1) {
                    uniqueInWindow++;
                }

                if (uniqueInWindow == totalunique) {
                    count++;
                }
            }
        }

        return count;
    }
}