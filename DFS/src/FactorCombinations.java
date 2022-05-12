import java.util.ArrayList;
import java.util.List;
//https://app.laicode.io/app/problem/404?plan=3
//time:branchs(log2 n)^(level:number of factors)
//space:O(factors)
public class FactorCombinations {
    public List<List<Integer>> combinations(int target){
        List<List<Integer>> res = new ArrayList<>();
        if(target <=1) return res;
        List<Integer> cur = new ArrayList<>();
        List<Integer> factors = getFactors(target);
        helper(target,factors,0,cur,res);
        return res;

    }
    private void helper(int target,List<Integer> factors, int index,List<Integer>cur, List<List<Integer>>res) {
        //termination condition
        if (index == factors.size()) {
            if (target == 1) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }
        //pick 0
        helper(target, factors, index + 1, cur, res);
        //pick valid factors
        int factor = factors.get(index);
        int size = cur.size();// remember the current size, after add this, we need to back truck to this size
        while (target % factor == 0) {
            cur.add(factor);
            target /= factor;
            helper(target, factors, index + 1, cur, res);
        }
        // backtrack, truncate to the previous size
        cur.subList(size, cur.size()).clear();
    }


    private List<Integer>  getFactors(int target){
        List<Integer> factors = new ArrayList<>();
        for(int i = target/2;i>1;i--){
            if(target%i ==0){
                factors.add(i);
            }
        }
        return factors;
    }

    public static void main(String[] args) {
        FactorCombinations fc = new FactorCombinations();
        int m = 12;
        List<List<Integer>> res = fc.combinations(12);
        System.out.println(res);
    }
}
