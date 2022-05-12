//657. Can I Win II
//https://app.laicode.io/app/problem/657?plan=3
public class CanIWin2 {
    public int canWin(int[] nums) {
            int n=nums.length;
            int[][] dp = new int[n][n];
            for (int i = 0; i < n; i++) dp[i][i] = nums[i];
            for (int i = 0; i < n - 1; i++) dp[i][i + 1] = Math.max(nums[i], nums[i + 1]);
            for (int size = 3; size <= n; size++) {
                for (int i = 0; i <= n - size; i++) {
                    int j = i + size - 1;
                    int takeLeft = nums[i] + (nums[i + 1] > nums[j] ? dp[i + 2][j] : dp[i + 1][j - 1]);
                    int takeRight = nums[j] + (nums[i] > nums[j - 1] ? dp[i + 1][j - 1] : dp[i][j - 2]);
                    dp[i][j] = Math.max(takeLeft, takeRight);
                }
            }
            return dp[0][n - 1];
        }
    public static void main(String[] args) {
        CanIWin2 cw2 = new CanIWin2();
        int[] nums = {77,47,84,31,67,38,34,56,33,52,31,99,32,98,82,85,60};
        int res = cw2.canWin(nums);
        System.out.println(res);
    }
}
