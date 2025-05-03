class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int [] freq = new int[7];

        for(int i=0;i<tops.length; i++)
        {
            for(int j=1;j<7;j++)
            {
                if(tops[i]==j || bottoms[i]==j) freq[j]++;
            }
        }
        int mincounter= Integer.MAX_VALUE;
        for(int i=1;i<7;i++)
        {
            if(freq[i]==tops.length)
            {
                int x = i;
                int countertop = 0;
                int counterbottom=0;
                for(int j=0 ; j<tops.length;j++)
                {
                    if(tops[j]!=x) countertop++;
                    if(bottoms[j]!=x) counterbottom++;
                }
                mincounter=Math.min(mincounter , countertop);
                mincounter=Math.min(mincounter , counterbottom);
            }
        }

        if(mincounter == Integer.MAX_VALUE)
            return -1;
        return mincounter;
    }
}