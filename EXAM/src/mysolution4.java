import java.util.ArrayList;
import java.util.List;

public class mysolution4 {
    public static void printAll(int n) {
        List<String> res = new ArrayList<>();
        generate(n, 0, 0, "", res);
        for(String ele : res){
            System.out.println(ele);
            System.out.println();
        }
    }

    public static void generate(int n, int open, int close, String s, List<String> res) {
        if(open == n && close == n){
            res.add(s);
            return;
        }

        if(open < n){
            int diff = open-close;
            s += "\n";
            for(int i=0;i<diff+1;i++) s += "  ";
            s+="if{";
            generate(n, open+1, close, s, res);
        }
        if(close < open){
            int diff = open-close;
            s += "\n";
            for(int i=0;i<diff;i++) s += "  ";
            s+="}";
            generate(n, open, close+1, s, res);
        }
    }
    public static void main(String[] args) {
        int n = 2;
        printAll(2);
    }
}
