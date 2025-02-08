class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int col = -1;  
        
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == target) {
                return true; 
            }
            if (matrix[i][0] > target) {
                col = i - 1; 
                break;
            }
        }
        
        if (col == -1) {
            col = rows - 1;
        } 
        int low = 0;
        int high = cols - 1;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            
            if (matrix[col][mid] == target) {
                return true;
            }
            
            if (matrix[col][mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return false; 
    }
}