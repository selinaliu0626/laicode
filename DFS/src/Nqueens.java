import java.util.ArrayList;
import java.util.List;

public class Nqueens {
    public List<List<Integer>> nqueens(int n){
        //assumption: n>0;
        //creat a container for the result
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // the inside list will store the column number for each queen
        List<Integer> cur = new ArrayList<>();
        helper(n,cur,result);
        return  result;

    }
    private boolean valid(List<Integer>cur, int col){
        int row = cur.size();
        for(int i =0;i<row;i++){
            //the same column, and the slope +-1,are not valid position in this board
            //slope = (col2-col1)/(row2-row1)
            if(cur.get(i)==col || Math.abs(cur.get(i)-col )==row-i){
                return false;
            }
        }
        return true;
    }
    private void helper(int n, List<Integer> cur, List<List<Integer>> result){
        //termination condition: when we have n elements in our current list
        //that means we already know all the rows where our queen is positioned
        if(cur.size()==n){
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i = 0;i< n;i++){
            //check in current row, is the position valid for put queen
            if(valid(cur,i)){
                cur.add(i);
                helper(n,cur,result);
                cur.remove(cur.size()-1);
            }
        }
    }

}
