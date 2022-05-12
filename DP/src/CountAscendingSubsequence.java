import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//683. Count Ascending Subsequence
//https://app.laicode.io/app/problem/683?plan=3
//Given an array A[0]...A[n-1] of integers, count the number of ascending subsequences.
//
//In case that the result is larger than 32-bit integer, return the result in 10^9+7 modulo.
//
//Assumptions
//
//A is not null
//Examples
//Input: A = {1,2,3}
//Output: 7
//Explanation: [1],[2],[3],[1,2],[1,3],[2,3],[1,2,3]
public class CountAscendingSubsequence {
    public int numIncreasingSubsequences(int[] a) {
        if(a.length ==0) return 0;
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        dfs(a,set,list,0);
        return set.size();
    }
        private void dfs(int[]a, Set<List<Integer>> set,List<Integer> list,int index) {
            if (list.size() > 0) {
                set.add(new ArrayList<>(list));
            }
            for (int i = index; i < a.length; i++) {
                if (list.size() == 0 || list.get(list.size() - 1) <= a[i]) {
                    list.add(a[i]);
                    dfs(a, set, list, i + 1);
                    //backtrack
                    list.remove(list.size() - 1);
                }
            }
        }

    public static void main(String[] args) {
        CountAscendingSubsequence cas = new CountAscendingSubsequence();
        int[] a ={28,5,5};
        int res = cas.numIncreasingSubsequences(a);
        System.out.println(res);
    }
}
