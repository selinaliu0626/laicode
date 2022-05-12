import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://app.laicode.io/app/problem/186
//此题返回的是数，并不是INDEX;
//遍历数组，每一个数用BS 的方法寻找有没有等于target 与这个数的查

public class ThreeSum {
    public List<List<Integer>> allTriples(int[] array, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(array);
        for(int i =0;i<array.length-2;i++){
            //for 循环是为了遍历数组，第一个数只需要确定一次， 因为如果相同的话，那么找目标差的结果是一致的
            if(i>0 && array[i]== array[i-1]){
                continue;
            }
            //两指针遍历目前这个数后面的所有数，找出所有等于target-ARRAY[I]的组合
            int left= i+1;
            int right = array.length-1;
            while(left<right){
                //CASE 1，找到了目标差
                if(array[left]+array[right] ==target-array[i]){
                    res.add(Arrays.asList(array[i],array[left],array[right]));
                    left++; //继续遍历，看看有没有其他结果
                    // consider the duplicate conditions
                    //此处是RETURN ELEMENT， 所以如果重复的数字，会产生同样的结果，并不是我们需要的
                    while(left<right && array[left] ==array[left-1]) {
                        left++;
                    }
                }else if(array[left]+array[right] < target-array[i]){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] array = new int[]{1,2,2,3,3,4};
        ThreeSum t3s = new ThreeSum();
        List<List<Integer>> res = t3s.allTriples(array,7);
        System.out.println(res);
    }

}
