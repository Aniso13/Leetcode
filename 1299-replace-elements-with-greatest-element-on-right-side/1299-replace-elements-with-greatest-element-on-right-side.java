class Solution {
    public int[] replaceElements(int[] arr) {
        int mx=-1 , n;
        for( int i=arr.length-1; i>=0 ;i-- ){
            n = arr[i];
            arr[i] = mx;
            mx = Math.max(n,mx);
        }
        return arr;
    }
}