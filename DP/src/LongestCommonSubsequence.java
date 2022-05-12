//177. Longest Common Subsequence
//https://app.laicode.io/app/problem/177?plan=3
//Examples
//
//S = “abcde”, T = “cbabdfe”, the longest common subsequence of s and t is {‘a’, ‘b’, ‘d’, ‘e’}, the length is 4.
public class LongestCommonSubsequence {
    public int longest(String source, String target) {
        if(source.length()==0 || target.length()==0){
            return 0;
        }
        int m=source.length();
        int n =target.length();
        int[][]dp = new int[m+1][n+1];
        int max=0;
        for(int i=1;i<m+1;i++){
            for(int j =1;j<n+1;j++){
                if(source.charAt(i-1)==target.charAt(j-1)){
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        max = Math.max(dp[i][j], max);
                } else{
                        dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                        dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcse = new LongestCommonSubsequence();
        String source = "af";
        String target = "abf";
        int res = lcse.longest(source, target);
        System.out.println(res);
    }

}
