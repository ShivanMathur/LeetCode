class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0, left = 0;
        int bottom = matrix.length - 1, right = matrix[0].length - 1;

        ArrayList<Integer> result = new ArrayList<>();

        while (top <= bottom && left <= right) {
            // Traverse Right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // Traverse Down
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                // Traverse Left
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
            }
            bottom--;

            if (left <= right) {
                // Traverse Up
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
            }
            left++;
        }

        return result;
    }
}