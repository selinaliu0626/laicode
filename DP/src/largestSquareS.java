public class largestSquareS {
    public static int largestS(int[][] matrix){
        //assump the matrix is not null
        if(matrix.length == 0 ||matrix[0].length == 0){
            return 0;
        }
        int result =0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        //to reduce the corner case, ep: out of index problem,
        int[][]left =new int[rows+1][cols+1];
        int[][]up = new int[rows+1][cols+1];
        for(int i =0;i<rows;i++){
            for(int j =0;j<cols;j++){
                if(matrix[i][j]==1){
                left[i+1][j+1] = left[i+1][j]+1;
                up[i+1][j+1] = up[i][j+1]+1;
                for(int maxLength = Math.min(left[i+1][j+1],up[i+1][j+1]);maxLength >=1;maxLength--) {
                    if (left[i + 2 - maxLength][j + 1] >= maxLength && up[i + 1][j + 2 - maxLength] >= maxLength) {
                        result = Math.max(result, maxLength);
                        break;
                    }//end if loop
                }
                }
            }
        }// end for loop
        return result;
    }

    public static void main(String[] args) {
        int[][]matrix ={{1,0,1,1,1},{1,1,1,1,1},{1,1,0,1,1},{1,1,1,1,1},{1,1,1,0,0}};
        int length = largestS(matrix);
        System.out.println(length);
    }
}
