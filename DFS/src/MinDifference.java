import java.util.ArrayList;
import java.util.List;

public class MinDifference {
    public int minDifference(int[] array) {
        if(array == null ||array.length == 0) return 0;
        if(array.length ==1) return array[0];
        int total = 0;
        int[] min ={Integer.MAX_VALUE};
        for(int i =0;i<array.length;i++){
            total += array[i];
        }
        dfs(array,0,0,0,min,total);
        return min[0] ;

    }
    private void dfs(int[]array, int index, int curSum, int size,int[]min,int total) {
        //base case
        if (size == array.length / 2 ) {
            int rest = total- curSum;
            min[0] = Math.min(Math.abs(rest-curSum),min[0]);
            return;
        }

        if (index == array.length) return;

        //add
        dfs(array, index + 1, curSum+array[index], size+1,min,total);
        //not add
        dfs(array, index + 1, curSum, size,min,total);
    }


    public static void main(String[] args) {
        MinDifference md = new MinDifference();
        int[] array ={8,3,0,0,0};
        int mindiff = md.minDifference(array);
        System.out.println(mindiff);
    }



}
