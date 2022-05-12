public class CrossOne {
    public static int largest(int[][] matrix){
        int rows = matrix.length;
        if(rows == 0) return 0;
        int cols = matrix[0].length;
        if(cols == 0) return 0;
        int[][]leftUp = leftUp(matrix,rows,cols);
        int[][] rightDown = rightDown(matrix,rows,cols);
        return merge(leftUp,rightDown,rows,cols);

    }
    //merge two matrix
    //for the same position, choose the min number on each matrix
    //the max length for the arm of the cross, should be the max number for the merged matrix
    private static int merge(int[][] leftUp, int[][] rightDown, int rows, int cols){
        int result= 0;
        for(int i =0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                leftUp[i][j] = Math.min(leftUp[i][j],rightDown[i][j]);
                result = Math.max(result,leftUp[i][j]);
            }
        }
        return result;
    }

    //calculate the max possible length of left and up arms for each cell of this matrix
    private static int[][] leftUp(int[][] matrix, int rows, int cols){
        int[][] left = new int[rows][cols];
        int[][] up = new int[rows][cols];
        for(int i =0;i<rows;i++){
            for(int j =0;j<cols;j++){
                //if the original value is 0, we do not to change anything, so we only discuss the situation when we
                //have 1 in the original matrix
                if (matrix[i][j] ==1) {
                    if (i == 0 && j == 0) {
                        up[i][j] = 1;
                        left[i][j] = 1;
                        //discuss the first row
                    } else if (i == 0) {
                        //up matrix remain the same with original
                        up[i][j] = 1;
                        //for the matrix left, the value for this position equals the left one add 1
                        left[i][j] = left[i][j - 1] + 1;
                        //discuss the first column
                    } else if (j == 0) {
                        //matrix left will remain same with original matrix
                        left[i][j] = 1;
                        //in the matrix up,the value for this position equals the up one add 1
                        up[i][j] = up[i - 1][j] + 1;
                    } else {//for others
                        left[i][j] = left[i][j - 1] + 1;
                        up[i][j] = up[i - 1][j] + 1;
                    }//end else
                }// end discuss 1
            }//end cols
        }//end rows
        //merge left and up, each position we choose the min one in these two matrix
        merge(left,up,rows,cols);
        return left;
    }
    // processing the right and down matrix
    //calculate the max possible length of right and down arms
    private static int[][] rightDown(int[][] matrix, int rows, int cols){
        int[][] right = new int[rows][cols];
        int[][] down = new int[rows][cols];
        for(int i =rows-1;i>=0;i--){
            for(int j = cols-1;j>=0;j--){
                if(matrix[i][j] ==1){
                    //the last position  in original matrix
                    if(i ==rows-1 &&j ==cols-1){
                        down[i][j] =1;
                        right[i][j] =1;
                    }else if(i == rows-1) {// the last row
                        //matrix down remain the same
                        down[i][j] = 1;
                        //matrix right, need combine the previous value and 1
                        right[i][j] = right[i][j + 1] + 1;
                    }else if(j == cols-1){// the last column
                        // matrix right remain the same
                        right[i][j] = 1;
                        //matrix down, need to combine the down value and 1
                        down[i][j] = down[i+1][j]+1;
                    }else{
                        down[i][j] = down[i+1][j]+1;
                        right[i][j] = right[i][j+1]+1;
                    }
                }
            }
        }//end of for loop
        merge(right,down, rows, cols);
        return right;
    }

    public static void main(String[] args) {
        int[][] matrix ={{1,1,0,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,0,1,0},{0,0,0,1,1}};
        int n = largest(matrix);
        System.out.println(n);
    }
}
