import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

//27. Kth Smallest Sum In Two Sorted Arrays
//https://app.laicode.io/app/problem/27?plan=3
public class KthSmallestSumInSortedArrays {
    public int kthSum(int[] A, int[] B, int k) {
        if (k == 1) {
            return A[0] + B[0];
        }

        int lenA = A.length;
        int lenB = B.length;

        if (k == lenA * lenB) {
            return A[lenA - 1] + B[lenB - 1];
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> A[a[0]] + B[a[1]]));
        Set<Integer> expanded = new HashSet<>();
        int[][] dirs = new int[][]{{0, 1}, {1, 0}};

        pq.offer(new int[]{0, 0});
        expanded.add(0);

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            --k;

            if (k == 0) {
                return A[cur[0]] + B[cur[1]];
            }

            for (int[] dir : dirs) {
                int nextI = cur[0] + dir[0];
                int nextJ = cur[1] + dir[1];

                if (nextI < lenA && nextJ < lenB && expanded.add(nextI + nextJ * 10)) {
                    pq.offer(new int[]{nextI, nextJ});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        KthSmallestSumInSortedArrays kss = new KthSmallestSumInSortedArrays();
        int[] a ={1,3,6};
        int[] b ={4,8,10};
        int sum =kss.kthSum(a,b,3);
        System.out.println(sum);
    }
}
