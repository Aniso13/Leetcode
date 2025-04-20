
class Solution {
    public int numRabbits(int[] answers) {
        Arrays.sort(answers);
        int total = 0;
        int i = 0;
        
        while (i < answers.length) {
            int x = answers[i]; 
            int groupSize = x + 1;
            int count = 0;

            while (i < answers.length && answers[i] == x && count < groupSize) {
                count++;
                i++;
            }

            total += groupSize;
        }

        return total;
    }
}
