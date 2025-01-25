class Solution {
    public boolean isPerfectSquare(int num) {
    long r=num;
    long l=0;
    while(l<=r)
    {
        long mid=(r+l)/2;
        long sq=mid*mid;

        if(sq==num)
            return true;
        else if(sq>num)
            r=mid-1;
        else
             l=mid+1;
    }
    return false;
    }
}