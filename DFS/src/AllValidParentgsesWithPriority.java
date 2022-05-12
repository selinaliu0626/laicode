import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class AllValidParentgsesWithPriority {
    private static final char[]p =new char[]{'(',')','<','>','{','}'};
    public List<String> validParenthesesIII(int l, int m, int n) {
        // Write your solution here
        int[] array =new int[]{l,l,m,m,n,n};
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();
        int total =2*(l+m+n);
        dfs(array,stack,sb,res,total);
        return res;
    }
    private void dfs(int[]array,Deque<Integer> stack,StringBuilder sb,
                     List<String> res,int total){
        //base case
        if(sb.length()== total){
            res.add(sb.toString());
            return;
        }

        for(int i =0;i<array.length;i++){
            if(i%2==0) {//add left parentheses
                // we still have left, and this priority is smaller than previous one
                if (array[i] > 0 && (stack.isEmpty() || stack.peekFirst() > i)) {
                    sb.append(p[i]);
                    stack.offerFirst(i);
                    array[i]--;
                    dfs(array, stack, sb, res, total);
                    //backtrack
                    sb.deleteCharAt(sb.length() - 1);
                    array[i]++;
                    stack.pollFirst();
                }
            }else{// to add right parentheses
                    if(!stack.isEmpty() && stack.peekFirst()==i-1){
                        sb.append(p[i]);
                        stack.pollFirst();
                        array[i]--;
                        dfs(array,stack,sb,res,total);
                        //backtrack
                        sb.deleteCharAt(sb.length()-1);
                        array[i]++;
                        stack.offerFirst(i-1);
                    }
                }
            }
        }


    public static void main(String[] args) {
        int l =3;
        int m =1;
        int n =0;
        AllValidParentgsesWithPriority app = new AllValidParentgsesWithPriority();
        List<String> res = app.validParenthesesIII(l,m,n);
        System.out.println(res);

    }


}
