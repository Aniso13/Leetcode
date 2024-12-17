import java.util.*;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        HashSet<Integer> occurrences = new HashSet<>(map.values());

        return map.values().size() == occurrences.size();
    }
}
