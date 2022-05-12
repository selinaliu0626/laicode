import java.util.ArrayDeque;
import java.util.Queue;

//176. Longest Common Substring
//https://app.laicode.io/app/problem/176?plan=3
public class LongestCommonSubString {
    public String longestCommon(String source, String target) {
        if(source.length()==0||target.length()==0)
            //in this case we return empty string, we can not use any of them
        return "";
        int m= source.length();
        int n= target.length();
        int[][]dp = new int[m][n];
        int max=0;
        int start =0;
        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                if(source.charAt(i)==target.charAt(j)){
                    if(i-1<0 ||j-1<0){
                        dp[i][j]=1;
                    }else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    //how to remember the start !!!
                    if(dp[i][j]>max){
                        max =dp[i][j];
                        start =i-max+1;
                    }

                }
            }
        }
        return source.substring(start,start+max);
    }

    public static void main(String[] args) {
        LongestCommonSubString lcs =new LongestCommonSubString();
        String source ="abcde";
        String target ="cdf";
        String res = lcs.longestCommon(source,target);
        System.out.println(res);
    }
}
