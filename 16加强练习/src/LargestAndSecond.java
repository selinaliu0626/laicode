import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//120,https://app.laicode.io/app/problem/120
//Use the least number of comparisons to get the largest and 2nd largest number in the given integer array.
// Return the largest number and 2nd largest number.
public class LargestAndSecond {
    static class Elements{
        int value;
        List<Integer> comparedValues;
        Elements(int value){
            this.value = value;
            this.comparedValues= new ArrayList<>();
        }
    }
    public int[] largestAndSecond(int[] array){
        //convert original array to Elements array
        Elements[] helper = convert(array);
        int largerLength = array.length;
        while(largerLength>1){
            compareAndSwap(helper,largerLength);
            largerLength =(largerLength+1)/2;
        }
        return new int[]{ helper[0].value,largest(helper[0].comparedValues)};
    }
    //return the max number in the list
    private int largest(List<Integer> comparedValues) {
        int max = comparedValues.get(0);
        for(int num: comparedValues){
            max = Math.max(max,num);
        }
        return max;

    }

    // a function to compare all elements, and move them to the left
    private void compareAndSwap(Elements[] helper, int largerLength) {
        for(int i=0;i<largerLength/2;i++){
            if(helper[0].value <helper[largerLength-1-i].value){
                swap(helper,i,largerLength-1-i);
            }
            helper[i].comparedValues.add(helper[largerLength-1-i].value);
        }
    }
    //swap function
    private void swap(Elements[] helper, int i, int j) {
        Elements tmp = helper[i];
        helper[i] = helper[j];
        helper[j] = tmp;
    }

    private Elements[] convert(int[] array){
        Elements[] helper = new Elements[array.length];
        for(int i =0;i< array.length;i++){
            helper[i] = new Elements(array[i]);
        }
        return helper;
    }

    public static void main(String[] args) {
        LargestAndSecond ls = new LargestAndSecond();
        int[] array ={2,1,5,4,3};
        int[] result = ls.largestAndSecond(array);
        System.out.println(Arrays.toString(result));


    }
}
