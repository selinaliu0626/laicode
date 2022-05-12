import java.util.ArrayList;

//1. Longest Ascending Subsequence
//https://app.laicode.io/app/problem/1?plan=3
//Given an array A[0]...A[n-1] of integers, find out the length of the longest ascending subsequence.
//
//Assumptions
//
//A is not null
//Examples
//Input: A = {5, 2, 6, 3, 4, 7, 5}
//Output: 4
//Because [2, 3, 4, 5] is the longest ascending subsequence.
public class LongestAscendingSubsequence {
    public int longest(int[] nums) {
        // Write your solution here
        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > sub.get(sub.size() - 1)) {
                sub.add(num);
            } else {
                int j = binarySearch(sub, num);
                sub.set(j, num);
            }
        }

        return sub.size();
    }
   //replace the large one
    private int binarySearch(ArrayList<Integer> sub, int num) {
        int left = 0;
        int right = sub.size() - 1;
        int mid = (left + right) / 2;

        while (left < right) {
            mid = (left + right) / 2;
            if (sub.get(mid) == num) {
                return mid;
            }

            if (sub.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        LongestAscendingSubsequence las = new LongestAscendingSubsequence();
        int[] array = {5, 2, 6, 3, 4, 7, 5};
        int res = las.longest(array);
        System.out.println(res);
    }
}
