import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram {
    public int largest(int[] array) {
        int result = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i =0;i<=array.length;i++){
            int cur = i==array.length?0 : array[i];
            while(!stack.isEmpty() && array[stack.peekFirst()]>= cur){
                int height = array[stack.pollFirst()];
                int left = stack.isEmpty()?0:stack.peekFirst()+1;
                result = Math.max(result,height*(i-left));
            }
            stack.offerFirst(i);
        }
        return result;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram ls = new LargestRectangleInHistogram();
        int[] array={1,3,3,3,3};
        int res = ls.largest(array);
        System.out.println(res);

    }
}
