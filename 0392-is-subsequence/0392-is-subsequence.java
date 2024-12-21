class Solution {
    public boolean isSubsequence(String s, String t) {
        int k=0 , i=0, j=0;
        
        while (i<s.length() && j<t.length())
        {
            if(s.charAt(i)==t.charAt(j))
            {
                i++;
                k++;
            }
            
            j++;
        }
        return k==s.length();
    }
}