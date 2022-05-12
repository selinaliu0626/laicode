import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//682. Longest Ascending Subsequence II
public class LAS2 {
    public int[] longest(int[] arr) {
        // Write your solution here
        // base case
        if (arr == null || arr.length == 0) {
            return arr;
        }

        // LIS[i] stores the longest increasing subsequence of subarray
        // `arr[0…i]` that ends with `arr[i]`
        List<List<Integer>> LIS = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            LIS.add(new ArrayList<>());
        }

        // LIS[0] denotes the longest increasing subsequence ending at `arr[0]`
        LIS.get(0).add(arr[0]);

        // start from the second array element
        for (int i = 1; i < arr.length; i++)
        {
            // do for each element in subarray `arr[0…i-1]`
            for (int j = 0; j < i; j++)
            {
                // find the longest increasing subsequence that ends with `arr[j]`
                // where `arr[j]` is less than the current element `arr[i]`

                if (arr[j] < arr[i] && LIS.get(j).size() > LIS.get(i).size()) {
                    LIS.set(i, new ArrayList<>(LIS.get(j)));
                }
            }

            // include `arr[i]` in `LIS[i]`
            LIS.get(i).add(arr[i]);
        }

        // uncomment the following code to print contents of `LIS`
        /*for (int i = 0; i < arr.length; i++) {
            System.out.println("LIS[" + i + "] — " + LIS.get(i));
        }*/

        // `j` will store an index of LIS
        int j = 0;
        for (int i = 0; i < arr.length; i++)
        {
            if (LIS.get(j).size() < LIS.get(i).size()) {
                j = i;
            }
        }
        List<Integer> result = LIS.get(j);
        int[]res = new int[result.size()];
        for(int i =0;i<result.size();i++){
            res[i] =result.get(i);
        }
        return res;
    }
    public static void main(String[] args) {
        LAS2 las2 = new LAS2();
        int[] array = {28,4,8,14,14,12,7,14,28,24,9,30,28,29,26,3,17,18,5,29,18,8,30,32,13,29,6};
        int[]res = las2.longest(array);
        System.out.println(Arrays.toString(res));
    }
}
