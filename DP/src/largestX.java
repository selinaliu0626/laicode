public class largestX {
    public static int largestX(int[][] matrix) {
        // Write your solution here
        int rows = matrix.length;
        int cols = matrix[0].length;
        if(rows == 0 || cols ==0) return 0;
        int[][] leftUp = leftUp(matrix, rows,cols);
        int[][] rightDown = rightDown(matrix, rows,cols);
        return merge(leftUp,rightDown, rows,cols);

    }
    private static int merge(int[][] leftUp, int[][] rightDown, int rows, int cols){
        int result = 0;
        for(int i = 0;i<rows;i++){
            for(int j =0;j<cols;j++){
                leftUp[i][j] =Math.min(leftUp[i][j],rightDown[i][j]);
                result = Math.max(result,leftUp[i][j]);
            }
        }
        return result;
    }
    private static int getNumber(int[][] matrix, int i, int j, int rows, int cols){
        if(i<0 ||i>= rows ||j< 0 ||j>= cols){
            return 0;
        }
        return matrix[i][j];
    }
    //left means from left up to down right "\"
    //up means from right up to down left"/"
    private static int[][]leftUp(int[][] matrix, int rows, int cols){
        int[][] left = new int[rows][cols];
        int[][] up = new int[rows][cols];
        for(int i =0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j] ==1){
                    left[i][j]= getNumber(left,i-1,j-1,rows,cols)+1;
                    up[i][j]  = getNumber(up,i-1,j+1,rows,cols)+1;
                }
            }
        }//end for loop
        merge(left,up,rows,cols);
        return left;
    }
    //right means from down left to up right "\"
    //down means from down right to up left "/"
    private static int[][] rightDown(int[][] matrix, int rows, int cols){
        int[][]right = new int[rows][cols];
        int[][]down = new int[rows][cols];
        for(int i = rows-1;i>=0;i--){
            for(int j = cols-1;j>= 0;j--){
                if(matrix[i][j]==1){
                    right[i][j] = getNumber(right,i+1,j+1,rows,cols)+1;
                    down[i][j] = getNumber(down,i+1,j-1,rows,cols)+1;
                }
            }
        }// end for loop
        merge(right,down,rows,cols);
        return right;
    }

    public static void main(String[] args) {
        int[][] matrix ={{1,0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0,0},{0,0,1,0,0,0,1,0,0},{0,0,0,1,0,1,0,0,0},{0,0,0,0,1,0,0,0,0},
                {0,0,0,1,0,1,0,0,0},{0,0,1,0,0,0,1,0,0},{0,1,0,0,0,0,0,1,0},{1,0,0,0,0,0,0,0,1}};
        int n = largestX(matrix);
        System.out.println(n);


    }
}
