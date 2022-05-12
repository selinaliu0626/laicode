import java.util.ArrayList;
import java.util.List;

//The decoding scheme is:
//
//1 -> A
//
//2 -> B
//
//…
//
//10 -> J
//
//11 -> K
//
//12 -> L
//
//…
//
//21 -> U
//
//22 -> V
//
//...
//
//26 -> Z
//
//
//
//e.g. Given input String  "1121"
//
//It can be decoded as
//
//[ "AABA",
//
//  "AAU",
//
//  "ALA",
//
//  "KBA",
//
//  "KU"
//
//]
//
//return all the possible decode ways, or just print out all decodes ways
public class Decode {
    public List<String> decode(String input){
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(result,sb,input,0);
        return result;
    }

    private void helper(List<String> result, StringBuilder sb, String input, int index) {
        //base case
        if(index == input.length()){
            result.add(sb.toString());
            return;
        }
        //dfs rule
        //pick one
        int number =input.charAt(index)-'0';
        if(number>=1 &&number<=9){
            char cur =(char)(number-1+'A');
            sb.append(cur);
            helper(result,sb,input,index+1);
            //backtrack
            sb.deleteCharAt(sb.length()-1);
        }
        //pick two
        if(index+1<input.length()){
            number =(input.charAt(index)-'0')*10+(input.charAt(index+1)-'0');
            if(number>=10 && number<=26){
                char cur =(char)(number-1+'A');
                sb.append(cur);
                helper(result,sb,input,index+2);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }


   /*public List<String> decode(String input){
       List<String> res = new ArrayList<>();
       if(input.length()==0)return res;
       helper(input, new StringBuilder(), res);
       return res;
   }

    private void helper(String input, StringBuilder sb, List<String> res){
        if(input.length()==0) {
            res.add(sb.toString());
            return;
        }
        if(input.length() == 1){
            sb.append((char)('A'+Integer.valueOf(input)-1));
            res.add(sb.toString());
            sb.deleteCharAt(sb.length()-1);
            return;
        }
        char cur1 = (char)('A' + Integer.valueOf(input.substring(0, 1))-1);
        sb.append(cur1);
        helper(input.substring(1), sb, res);
        sb.deleteCharAt(sb.length()-1);


        char cur2 = (char)('A' + Integer.valueOf(input.substring(0, 2))-1);
        sb.append(cur2);
        helper(input.substring(2), sb, res);
        sb.deleteCharAt(sb.length()-1);
    }*/

    public static void main(String[] args) {
        Decode dc = new Decode();
        String input = "1121";
        List<String> res =dc.decode(input);
        System.out.println(res);
    }
}
