public class MaxDiff {
    public int maxDifference(int[] array){
        boolean up = false;
        boolean down = false;
        int res =0;
        int slow =0;
        int fast =0;
        while(fast<array.length){
            fast = slow+1;
            if(array[fast]<array[slow]){
                down =true;
                slow =fast;
                fast++;
            }else{
                while(fast < array.length && array[fast] > array[fast-1]) {
                    up = true;
                    fast++;
                }
                res =Math.max(array[fast-1]-array[slow],res);
                slow=fast;
            }
        }
        if(up && down){
            return res;
        }
        return -1;
    }

    public static void main(String[] args) {
        MaxDiff md = new MaxDiff();
        int [] array = {7,1,2,5};
        int res = md.maxDifference(array);
        System.out.println(res);
    }
}
