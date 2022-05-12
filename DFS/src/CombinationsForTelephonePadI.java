import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//272. Combinations For Telephone Pad I
//https://app.laicode.io/app/problem/272?plan=3
public class CombinationsForTelephonePadI {
    public String[] combinations(int number) {
        List<String> res = new ArrayList<>();
        String[]numToChar ={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        StringBuilder sb = new StringBuilder();
        char[]num =Integer.toString(number).toCharArray();//->{'2','3','1'}
        helper(num,numToChar,0,sb,res);
        return res.toArray(new String[0]);
    }
    private void helper(char[]number,String[]numToChar, int level, StringBuilder sb,List<String> res){
        //level indicate how many digits(numbers) we have process
        //in this example, that means when level ==3, then we return
        if(level == number.length){
            res.add(sb.toString());
            return;
        }
        //this means which char array we are processing
        //for example, when level =0,we are processing "abc"
        char[] chars = numToChar[number[level]-'0'].toCharArray();
        if(chars.length ==0){
            helper(number,numToChar,level+1,sb,res);
        }else{
            //chars: '2','3','1'
            for(int i =0;i<chars.length;++i){
                helper(number,numToChar,level+1,sb.append(chars[i]),res);
                //backtrack
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationsForTelephonePadI cp = new CombinationsForTelephonePadI();
        int num = 231;
        String[] res = cp.combinations(num);
        System.out.println(Arrays.toString(res));
    }
}
