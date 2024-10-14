class Solution {
    public int countNegatives(int[][] grid) {
        int rows = grid.length;
        int colums = grid[0].length;
        
        int count = 0;
        
        for(int i=0;i<rows;i++)
        {
            int low = 0;
            int high = colums - 1;
            int rowCount = 0;
            while(low <= high)
            {
                int mid = low + (high - low) / 2;
                
                if(grid[i][mid] < 0)
                {
                    rowCount = colums - mid;
                    high = mid - 1;
                }
                else 
                    low = mid + 1;
            }
            count += rowCount;
                
        }
        return count;
    }
}