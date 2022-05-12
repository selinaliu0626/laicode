import java.util.Arrays;

//https://app.laicode.io/app/problem/264?plan=3
public class KeepDistanceForIndenticalNumbers {
    public int[] keepDistance (int k){
        int[] res = new int[2*k];
        return dfs(res,k)? res: null;
    }

    private boolean dfs(int[]res, int k) {
        if (k == 0) return true;
        for (int i = 0; i < res.length; i++) {
            if (res[i] == 0 && res[i + k + 1] == 0) {
                res[i] = k;
                res[i + k + 1] = k;
                if (dfs(res, k - 1)) {
                    return true;
                }
                res[i] = 0;
                res[i + k + 1] = 0;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        KeepDistanceForIndenticalNumbers ki = new KeepDistanceForIndenticalNumbers();
        int m = 3;
        int[] res = ki.keepDistance(m);
        System.out.println(Arrays.toString(res));
    }

}
