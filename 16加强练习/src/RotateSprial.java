import java.util.Arrays;

public class RotateSprial {
    public void rotate(int[][] matrix){
        int n = matrix.length;
        if(n<=1){
            return;
        }
        mirrorY(matrix,n);
        mirrorYEX(matrix,n);
    }
    private void mirrorY(int[][] matrix, int n){
        for(int i = 0; i<n ;i++){
            for(int j = 0; j<n/2;j++){
                swap(matrix,i ,j,i , n-1-j);
            }
        }
    }
    private void mirrorYEX(int[][] matrix, int n){
        for(int i = 0;i<n;i++){
            for(int j= 0;j+ i<n-1;j++){
                swap(matrix,i,j,n-1-j,n-1-i);
            }
        }
    }
    private void swap(int[][]matrix, int irow,int icol, int jrow,int jcol){
        int tmp = matrix[irow][icol];
        matrix[irow][icol] = matrix[jrow][jcol];
        matrix[jrow][jcol] = tmp;
    }

    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        if (n <= 1) return;
        int round = n / 2;
        for (int level = 0; level < round; level++) {
            int left = level;
            int right = n - 2 - level;
            for (int j = left; j <= right; j++) {
                int tmp = matrix[left][j];
                matrix[left][j] = matrix[n - 1 - j][left];
                matrix[n - 1 - j][left] = matrix[n - 1 - left][n - 1 - j];
                matrix[n - 1 - left][n - 1 - j] = matrix[j][n - 1 - left];
                matrix[j][n - 1 - left] = tmp;
            }
        }
    }


    public static void print2D(int mat[][])
    {
        // Loop through all rows
        for (int[] row : mat)

            // converting each row as string
            // and then printing in a separate line
            System.out.println(Arrays.toString(row));
    }

    public static void main(String[] args) {
        RotateSprial rs = new RotateSprial();
        int[][] matrix ={{1,2,3,4,5},{16,17,18,19,6},{15,24,25,20,7},{14,23,22,21,8},{13,12,11,10,9}};
        rs.rotate(matrix);
        print2D(matrix);
        System.out.println(" ");
        int[][] matrix2 ={{1,2,3,4,5},{16,17,18,19,6},{15,24,25,20,7},{14,23,22,21,8},{13,12,11,10,9}};
        rs.rotate2(matrix2);
        print2D(matrix2);
    }
}
