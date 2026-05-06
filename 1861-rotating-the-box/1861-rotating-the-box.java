class Solution {

    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] result = new char[n][m];

        // Create the transpose of the input grid in `result`
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = box[j][i];
            }
        }

        // Reverse each row in the transpose grid to complete the 90° rotation
        for (int i = 0; i < n; i++) {
            reverse(result[i]);
        }

        // Apply gravity to let stones fall to the lowest possible empty cell in each column
        for (int j = 0; j < m; j++) {
            // Process each cell in column `j` from bottom to top
            for (int i = n - 1; i >= 0; i--) {
                if (result[i][j] == '.') { // Found an empty cell; check if a stone can fall into it
                    int nextRowWithStone = -1;

                 
                    for (int k = i - 1; k >= 0; k--) {
                        if (result[k][j] == '*') break; 
                        if (result[k][j] == '#') { 
                            nextRowWithStone = k;
                            break;
                        }
                    }

                   
                    if (nextRowWithStone != -1) {
                        result[nextRowWithStone][j] = '.';
                        result[i][j] = '#';
                    }
                }
            }
        }
        return result;
    }

    private void reverse(char[] row) {
        int left = 0;
        int right = row.length - 1;
        while (left < right) {
            char temp = row[left];
            row[left] = row[right];
            row[right] = temp;
            left++;
            right--;
        }
    }
}