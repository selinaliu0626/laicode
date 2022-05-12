import java.util.ArrayList;
import java.util.List;

public class spiralPrint {
    public List<Integer> spiral(int[][] matrix) {
        // Write your solution here
        List<Integer> result = new ArrayList<>();
        helper(matrix,0,matrix.length,result);
        return result;
    }
    private void helper(int[][]matrix,int offset, int size, List<Integer> result){
        //base case,size ==0 or size ==1
        if(size == 0) return;
        if(size==1){
            result.add(matrix[offset][offset]);
            return;
        }
        for(int i =0;i<size-1;i++){
            result.add(matrix[offset][offset+i]);
        }
        for(int i=0;i<size-1;i++){
            result.add(matrix[offset+i][offset+size-1]);
        }
        for(int i= size-1;i>=1;i--){
            result.add(matrix[offset+size-1][offset+i]);
        }
        for(int i=size-1;i>=1;i--){
            result.add(matrix[offset+i][offset]);
        }
        helper(matrix,offset+1,size-2,result);
    }

    public static void main(String[] args) {
        spiralPrint sp = new spiralPrint();
        int[][] matrix = {{40,33,19,28,56,55,99,-15,18},{75,-83,59,-77,60,-38,-90,43,96},{5,-61,-63,-81,-56,88,57,-21,2},{-85,-44,14,77,-99,59,-4,-15,54},{62,-25,-50,93,-47,98,-59,62,68},{-78,91,4,-44,56,-1,-96,-93,-34},{70,35,-76,88,-55,-17,77,4,19},{-47,-71,-24,-12,10,26,-24,-67,30},{-58,-19,-49,-38,51,-13,-82,-10,-10}};
        List<Integer> res = sp.spiral(matrix);
        System.out.println(res);
    }
}
