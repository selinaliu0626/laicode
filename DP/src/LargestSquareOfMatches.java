//638. Largest Square Of Matches
//https://app.laicode.io/app/problem/638?plan=3
public class LargestSquareOfMatches {
    public int largestSquareOfMatches(int[][] matrix) {
        // Write your solution here
        //corner case
        if(matrix.length ==0 ||matrix[0].length ==0){
            return 0;
        }
        int result = 0;
        int r =matrix.length;
        int c =matrix[0].length;
        int[][]right = new int[r+1][c+1];
        int[][]down = new int[r+1][c+1];
        //从后往前遍历
        for(int i =r-1;i>=0;i--){
            for(int j =c-1;j>=0;j--){
                if(hasRight(matrix[i][j])){
                    right[i][j] =right[i][j+1]+1;
                }
                if(hasDown(matrix[i][j])){
                    down[i][j] = down[i+1][j]+1;
                }
                if(hasBoth(matrix[i][j])){
                    for(int max = Math.min(right[i][j],down[i][j]);max>=1;max--){
                        if(right[i+max][j]>=max && down[i][j+max]>=max){
                            result = Math.max(result,max);
                            break;
                        }
                    }
                }
            }
        }
        return result;

    }
    private boolean hasRight(int value){
        return(value &0b1)!=0; //0b 二进制， 3= 11，1==01  11& 01 =1；
    }
    private boolean hasDown(int value){
        return(value &0b10)!=0;
    }
    private boolean hasBoth(int value){
        return value == 0b11;
    }

    public static void main(String[] args) {
        LargestSquareOfMatches lsm = new LargestSquareOfMatches();
        int[][] matrix ={{3, 1, 1, 3, 0, 1, 1, 0},

                {2, 0, 0, 2, 0, 0, 0, 0},

                {3, 1, 3, 0, 0, 0, 0, 0},

                {2, 0, 2, 0, 0, 0, 0, 0},

                {1, 1, 0, 0, 0, 0, 0, 0}};
        int length = lsm.largestSquareOfMatches(matrix);
        System.out.println(length);
    }
}
