public class ArrayDeq {
    public static int[] dedup(int[] array) {
        // Write your solution here
        if(array.length <=1) return array;
        int slow =0;
        int fast =1;
        while(fast<array.length){
            if(array[fast]!= array[slow]){
                slow +=1;
                array[slow] = array[fast];
            }
            fast++;
        }
        int[]res = new int[slow+1];
        for(int i =0;i<=slow;i++){
             res[i] = array[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[]array ={1,2,3,4,4,5};
        int[] res = dedup(array);
        System.out.println(res);
    }
}
