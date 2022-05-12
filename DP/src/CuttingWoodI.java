//137. Cutting Wood I
//https://app.laicode.io/app/problem/137?plan=3
public class CuttingWoodI {
    public int minCost(int[] cuts, int length) {
        // Write your solution here
        if(length==1) return 0;
        int[] helper = new int[cuts.length+2];
        helper[helper.length-1]=length;
        for(int i =1;i<helper.length-1;i++){
            helper[i]=cuts[i-1];
        }
        int[][]dp = new int[helper.length][helper.length];
        // minimum costs start from i and end at j
        for(int j=1;j<helper.length;j++){
            for(int i=j-1;i>=0;i--){
                int diff = j-i;
                if(diff ==1){
                    dp[i][j]=0;
                } else{
                    dp[i][j]= Integer.MAX_VALUE;
                    for(int k=i+1;k<i+diff;k++){
                        dp[i][j]= Math.min(dp[i][k]+dp[k][j], dp[i][j]);
                    }
                    dp[i][j]+= helper[j]- helper[i];
                }
            }
        }
        return dp[0][helper.length-1];
    }

    public static void main(String[] args) {
        CuttingWoodI cw1 = new CuttingWoodI();
        int len =10;
        int[]cuts ={2,4,7};
        int res =cw1.minCost(cuts,len);
        System.out.println(res);
    }
}

