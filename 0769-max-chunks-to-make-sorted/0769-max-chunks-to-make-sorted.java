class Solution {
    public int maxChunksToSorted(int[] arr) {
        
        int max_so_far =0 , count=0;
        for(int i=0;i<arr.length-1;i++)
        {
            max_so_far = Math.max(max_so_far , arr[i]);
            
            if(max_so_far == i)
                count++;
                
        }
        
        return count+1;
    }
}