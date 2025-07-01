class Solution {
     public boolean findRotation(int[][] mat, int[][] target) {
        for (int rotation = 0; rotation < 4; rotation++) {
            if (isEqual(mat, target)) {
                return true;
            }
            mat = rotate90(mat);
        }
        return false;
    }
    private boolean isEqual(int[][] mat1, int[][] mat2) {
        int n = mat1.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat1[i][j] != mat2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    private int[][] rotate90(int[][] mat) {
        int n = mat.length;
        int[][] rotated = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - 1 - i] = mat[i][j];
            }
        }
        return rotated;
    }
}