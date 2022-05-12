import java.util.*;

public class CommonElements {
    public List<Integer> common(int[] A, int[] B) {
        // Write your solution here
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        if (A.length == 0 || B.length == 0) {
            return res;
        }
        Arrays.sort(B);
        for (int i = 0; i < A.length; i++) {
                map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }
        for (int i = 0; i < B.length; i++) {
            if (map.containsKey(B[i]) && map.get(B[i])>= 1) {
                res.add(B[i]);
                map.put(B[i], map.get(B[i]) - 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CommonElements ce = new CommonElements();
        int[] a = {1, 2, 3, 2};
        int[] b = {3, 4, 2, 2, 2};
        List<Integer> res = ce.common(a, b);
        System.out.println(res);
    }
}


