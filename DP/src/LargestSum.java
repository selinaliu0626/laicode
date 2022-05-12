public class LargestSum {
    public static int largestSum(int[] array) {
        // Write your solution here
        int max = array[0];
        int sum = array[0];
        for (int i = 1; i < array.length; i++) {
            sum = Math.max(array[i] + sum, array[i]);
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {-3, -4, -2, -5};
        int res = largestSum(array);
        System.out.println(res);
    }
}



