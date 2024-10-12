class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // Find the correct row where the target might be
        int col = -1;  // Initialize row index
        
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == target) {
                return true; // If the target is the first element of a row
            }
            if (matrix[i][0] > target) {
                col = i - 1; // The target must be in the previous row
                break;
            }
        }
        
        // If no valid row was found (target might be in the last row)
        if (col == -1) {
            col = rows - 1;
        }
        
        // Binary search in the identified row
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
        
        return false; // Target not found
    }
}
