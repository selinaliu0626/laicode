import java.util.ArrayList;
import java.util.List;

//Our company is organizing a series of university recruiting events. Each day, we host an event at one university, but sometimes we want to take a break for one day before moving on to the next university.
//
//Given a sequence of universities, print all possible schedules of the recruiting events.
//
//Input: a string of universities. Each university is represented as a single capital letter.
//
//Output: all possible schedules. A lowercase letter “x” means we take a break.
//
//Example
//
//Input: String = “ABC”
//
//Output:
//
//ABC
//
//ABxC
//
//AxBC
//
//AxBxC
public class RecruitingEventSchedules {
    public List<String> recuitEvents(String input){
        List<String> res = new ArrayList<>();
        if(input.length()==0){
            return res;
        }
        char[] array = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        helper(array,0,sb,res);
        return res;
    }

    private void helper(char[] array, int index, StringBuilder sb, List<String> res) {
        //base case
        if(index ==array.length){
            res.add(sb.toString());
            return;
        }
        //not add x
        sb.append(array[index]);
        helper(array,index+1,sb,res);
        sb.deleteCharAt(sb.length()-1);

        //with x
        //can not add at start
        if(sb.length()==0)return;
        sb.append('x');
        sb.append(array[index]);
        helper(array,index+1,sb,res);
        sb.delete(sb.length()-2,sb.length());
    }

    public static void main(String[] args) {
        RecruitingEventSchedules rs = new RecruitingEventSchedules();
        String input = "ABC";
        List<String> res =rs.recuitEvents(input);
        System.out.println(res);
    }
    // 2 branches, levels(n+n-1=2n-1)  2^n
    //space O(levels)->O(n)
}
