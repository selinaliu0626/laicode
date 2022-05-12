import java.util.HashMap;
import java.util.Map;

class Pair {
    Integer left;
    Integer right;

    Pair(int one, int two) {
        this.left = one;
        this.right = two;
    }
}



//https://app.laicode.io/app/problem/188
public class FourSum {
    public boolean exist(int[] array, int target) {
        Map<Integer,Pair> map = new HashMap<>();
        for(int j = 1;j<array.length;j++){
            for(int i =0;i<j;i++){
                int pairSum = array[i]+array[j];
                if(map.containsKey(target-pairSum)){
                    //去重的关键在于i1<J1<i2<J2， 已知i1<j1 &&i2<j2, 所以我们只需要比较第一个J 和第二个i
                    if(map.get(target-pairSum).right< i){
                        return true;
                    }
                }
                if(!map.containsKey(pairSum)){
                    map.put(pairSum,new Pair(i,j));
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        FourSum fs = new FourSum();
        int[] array = {2,1,1,1,0};
        boolean res = fs.exist(array, 3);
        System.out.println(res);
    }


}
