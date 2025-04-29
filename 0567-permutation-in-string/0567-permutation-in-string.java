class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;

        int [] freqS1 = new int [26];
        int [] freqS2 = new int [26];

        for(int i=0 ;i<s1.length();i++){
            freqS1[s1.charAt(i) - 'a']++;
            freqS2[s2.charAt(i) - 'a']++;
        }

        if(Arrays.equals(freqS1,freqS2)) return true;

        for(int i = s1.length(); i<s2.length(); i++){
            freqS2[s2.charAt(i-s1.length()) - 'a']--;
            freqS2[s2.charAt(i) - 'a']++;
            if(Arrays.equals(freqS1,freqS2)) return true;
        }

        return false;
    }
}