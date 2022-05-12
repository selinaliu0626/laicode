import java.util.LinkedList;
import java.util.Queue;

public class mysolution3 {
    public int minCut(String s) {
        int cutsDp[];
        cutsDp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            cutsDp[i] = i;
        }
        for (int mid = 0; mid < s.length(); mid++) {
            // check for odd length palindrome around mid index
            findMinimumCuts(mid, mid, cutsDp, s);
            // check for even length palindrome around mid index
            findMinimumCuts(mid - 1, mid, cutsDp, s);

        }
        return cutsDp[s.length() - 1];
    }

    public void findMinimumCuts(int startIndex, int endIndex, int[] cutsDp, String s) {
        for (int start = startIndex, end = endIndex;
             start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end); start--, end++) {
            int newCut = start == 0 ? 0 : cutsDp[start - 1] + 1;
            cutsDp[end] = Math.min(cutsDp[end], newCut);

        }
    }
    public static void main(String[] args) {
        mysolution3 m3 = new mysolution3();
        String input = "cdcabaaba";
        int n = m3.minCut(input);
        System.out.println(n);
    }
}
