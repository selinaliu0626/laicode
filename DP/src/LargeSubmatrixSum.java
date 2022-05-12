//106. Largest SubMatrix Sum
//https://app.laicode.io/app/problem/106?plan=3
public class LargeSubmatrixSum {
    public int largest(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        int result = Integer.MIN_VALUE;
        for(int i =0;i<rows;i++){
            int[] cur = new int[cols];
            for(int j=i;j<rows;j++ ){
                add(cur,matrix[j]);
                result= Math.max(result,max(cur));
            }
        }
        return result;
    }

    private int max(int[] cur) {
        int result =cur[0];
        int tmp =cur[0];
        for(int i =1;i< cur.length;i++){
            tmp= Math.max(tmp+cur[i],cur[i]);
            result = Math.max(result,tmp);
        }
        return result;
    }

    private void add(int[] cur, int[] ori) {
        for(int i =0;i<cur.length;i++){
            cur[i] += ori[i];
        }
    }

    public static void main(String[] args) {
        LargeSubmatrixSum lss = new LargeSubmatrixSum();
        int [][] matrix ={ {-1, -2, -5, -1},

                {0, 8,11,0},

                {-1,2,-1,-1} };
        int res = lss.largest(matrix);
        System.out.println(res);
    }
}
