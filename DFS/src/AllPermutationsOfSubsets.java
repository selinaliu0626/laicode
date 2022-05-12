import java.util.ArrayList;
import java.util.List;

public class AllPermutationsOfSubsets {
    public List<String> allPermutationsOfSubsets(String set){
        List<String> res = new ArrayList<>();
        if(set == null || set.length()== 0) return res;
        char[] array = set.toCharArray();
        helper(array,0,res);
        return res;
    }

    private void helper(char[] array, int index, List<String> res) {
        res.add(new String(array,0,index));
        for(int i = index;i<array.length;i++){
            swap(array,i,index);

            helper(array,index+1,res);
            //backtrack
            swap(array,i,index);

        }
    }

    private void swap(char[] array, int i, int j) {
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        String s = "abc";
        AllPermutationsOfSubsets as = new AllPermutationsOfSubsets();
        List<String> result = as.allPermutationsOfSubsets(s);
        System.out.println(result);
    }
}
