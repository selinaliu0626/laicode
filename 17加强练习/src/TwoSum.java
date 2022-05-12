import java.util.*;

public class TwoSum {
    public List<List<Integer>> allPairs(int[] array, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            List<Integer> indices = map.get(target - array[i]);
            if (indices != null) {
                for (int num : indices) {
                    res.add(Arrays.asList(num, i));
                }
            }
            if (!map.containsKey(array[i])) {
                map.put(array[i], new ArrayList<>());
            }
            map.get(array[i]).add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4};
        TwoSum ts = new TwoSum();
        List<List<Integer>> res = ts.allPairs(array,5);
        System.out.println(res);
    }
}


