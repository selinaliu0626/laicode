import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://app.laicode.io/app/problem/65?plan=3
//Given a string with possible duplicate characters, return a list with all permutations of the characters.
//
//Examples
//
//Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]
//Set = "aba", all permutations are ["aab", "aba", "baa"]
//Set = "", all permutations are [""]
//Set = null, all permutations are []


// when our result need to be same length with our input string/array, we could think of swap
public class AllPermutation2 {
    public List<String> permutations(String input){
        List<String>res = new ArrayList<>();
        if(input == null ) return res;
        char[] array = input.toCharArray();
        dfs(array,0,res);
        return res;


    }
    private void dfs(char[] array,int index,List<String>res){
        //base case
        if(index == array.length){
            res.add(new String(array));
            //return;
        }
        Set<Character> set = new HashSet<>();
        for(int i= index;i<array.length;i++){
            if(set.add(array[i])){
                swap(array,i,index);
                dfs(array,index+1,res);
                swap(array,i,index);
            }

        }
    }

    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] =array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        AllPermutation2 ap2 = new AllPermutation2();
        String input ="abbc";
        List<String>res = ap2.permutations(input);
        System.out.println(res);

    }
}
