import java.util.Arrays;

//Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
//
//Example 1:
//
//Input: n = 12 Output: 3 Explanation: 12 = 4 + 4 + 4. Example 2:
//
//Input: n = 13 Output: 2 Explanation: 13 = 4 + 9.
public class PackingUptheSwags {
    public int numSquares(int n){
        //dp[i]物理意义是 i这个数最少可以分割成几个平方和
        int[]dp= new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++) {
            dp[i]=Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        PackingUptheSwags ps = new PackingUptheSwags();
        int res = ps.numSquares(27);
        System.out.println(res);
    }
}
//TIME:n^1.5  n*根号n
//space O(N)
