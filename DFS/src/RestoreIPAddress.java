import java.util.ArrayList;
import java.util.List;

//147. Restore IP Addresses
//https://app.laicode.io/app/problem/147?plan=3
//ip:x1.x2.x3.x4->0<xi<255, and no leading zeros are allowed
public class RestoreIPAddress {
    public List<String> Restore(String ip) {
        List<String> res = new ArrayList<>();
        if(ip == null || ip.length()==0){
            return res;
        }
        StringBuilder sb = new StringBuilder();
        helper(ip.toCharArray(),0,0,sb,res);
            return res;
    }

    private void helper(char[] ip, int level, int offset, StringBuilder sb, List<String> res) {
        //base case
        if (level == 4) {
            if (sb.length() == ip.length + 4) {
                res.add(sb.substring(0, sb.length() - 1));
            }
            return;
        }
        if (offset < ip.length) {
            helper(ip, level + 1, offset + 1, sb.append(ip[offset]).append('.'), res);
            //back track
            sb.delete(sb.length() - 2, sb.length());
        }
        if (offset + 1 < ip.length) {
            char a = ip[offset];
            char b = ip[offset + 1];
            if (a != '0') {
                helper(ip, level + 1, offset + 2, sb.append(a).append(b).append('.'), res);
                sb.delete(sb.length() - 3, sb.length());
            }
        }
        if (offset + 2 < ip.length) {
            char a = ip[offset];
            char b = ip[offset + 1];
            char c = ip[offset + 2];
            if (a == '1' || a == '2' && b >= '0' && b <= '4' || a == '2' && b == '5' && c >= '0' && c <= '5') {
                helper(ip, level + 1, offset + 3, sb.append(a).append(b).append(c).append('.'), res);
                sb.delete(sb.length() - 4, sb.length());
            }
        }
    }

    public static void main(String[] args) {
        RestoreIPAddress ri = new RestoreIPAddress();
        String ip ="25525511135";
        List<String> res =ri.Restore(ip);
        System.out.println(res);
    }

}
