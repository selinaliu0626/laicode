import java.util.Arrays;

public class arrayDup2 {
    public int[] dedup(int[] array) {
        // Write your solution here
        if(array.length<=2) return array;
        int slow = 1;
        for(int i =2;i<array.length;i++){
            if(array[i]!= array[slow-1]){
                array[++slow] =array[i];

            }
        }
        return Arrays.copyOf(array,slow+1);
    }

    public static void main(String[] args) {
        arrayDup2 ad = new arrayDup2();
        int[] array ={1,1,2,3,3,3,4,5,5,5};
        int[]res = ad.dedup(array);
        System.out.println(Arrays.toString(res));
    }
}
