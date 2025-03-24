class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        int l=0 , r=0 , maxi = 0 , adjPair=0;
        Set<Integer> set = new HashSet<>();

        while(r<s.length())
        {
            if( r>0&&s.charAt(r)==s.charAt(r-1) )
            {
                adjPair++;
                set.add(r-1);
            }
            while(adjPair>1)
            {
                if(set.contains(l))
                {
                    adjPair--;
                }
                l++;
            }
            maxi = Math.max(maxi , r-l+1);
            r++;
        }
        return maxi;
    }
}