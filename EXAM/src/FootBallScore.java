import java.util.Arrays;

//example: A{1,4,2,4}, B{3,5}
//output {2,4}
//A,B both could be unsorted
//duplicate elements are allowed
public class FootBallScore {
    public int[] lowerScore(int[] A, int[] B) {
        Arrays.sort(A);
        int[] res = new int[B.length];
        for (int i = 0; i < B.length; i++) {
            if (B[i] >= A[A[A.length - 1]]) {
                res[i] = A.length;
            } else if (B[i] < A[0]) {
                res[i] = 0;
            } else {
                res[i] = helper(A, B[i]);
            }
        }
        return res;
    }

    private int helper(int[] a, int target) {
        int i = 0;
        int j = a.length - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (target <= a[mid]) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        FootBallScore fb = new FootBallScore();
        int[]a ={1,4,2,2,2,4};
        int[] b ={5,3};
        int[]res =fb.lowerScore(a,b);
        System.out.println(Arrays.toString(res));

    }
}
//time:(nlogn+mlogn)=nlogn
//space:O(1)

