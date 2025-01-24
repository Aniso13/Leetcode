class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder str = new StringBuilder();
        int length = Math.min(word1.length(),word2.length());

        for(int i = 0; i <= length-1; i++){
            str.append(word1.charAt(i));
            str.append(word2.charAt(i));
        }

        if(word1.length() != word2.length()) {
            String refStr = word1.length() > word2.length() ? word1 : word2;
            String subString = refStr.substring(length, refStr.length());
            str.append(subString);
        }


        return str.toString();
    }
}