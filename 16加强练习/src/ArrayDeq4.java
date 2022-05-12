import java.util.Arrays;

public class ArrayDeq4 {
    public int[] dedup(int[]array){
        int slow =0;
        for(int fast =1;fast<array.length;fast++){
            if(slow == -1 ||array[slow]!= array[fast]){
                slow++;
                array[slow] =array[fast];
            }else if(array[slow] == array[fast]){
                slow --;
                while(fast+1 < array.length && array[fast] ==array[fast+1]){
                    fast +=1;
                }
            }
        }
        return Arrays.copyOf(array,slow+1);
    }

    public static void main(String[] args) {
        ArrayDeq4  ad4 = new ArrayDeq4();
        int[] array ={1,2,2,2,2,5,5,1};
        int[] res = ad4.dedup(array);
        System.out.println(Arrays.toString(res));
    }
}
