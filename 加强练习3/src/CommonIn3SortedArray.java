//171. Common Elements In Three Sorted Array
/*Find all common elements in 3 sorted arrays.
//https://app.laicode.io/app/problem/171?plan=3

        Assumptions

        The 3 given sorted arrays are not null
        There could be duplicate elements in each of the arrays
        Examples

        A = {1, 2, 2, 3}, B = {2, 2, 3, 5}, C = {2, 2, 4}, the common elements are [2, 2]*/


import java.util.ArrayList;
import java.util.List;

public class CommonIn3SortedArray {
    public List<Integer> common(int[] a, int[] b, int[] c) {
        // Write your solution here
        List<Integer> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        int i =0;
        int j =0;
        int n =0;
        while(i<a.length &&j<b.length){
            if(a[i]<b[j]){
                i++;
            }else if(a[i]>b[j]){
                j++;
            }
            else{
                tmp.add(a[i]);
                i++;
                j++;
            }

        }
        int m =0;
        while(n<c.length && m<tmp.size()){
            if(c[n] == tmp.get(m)){
                res.add(c[n]);
                n++;
                m++;
            }else if(c[n]<tmp.get(m)){
                n++;

            }else{
                m++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CommonIn3SortedArray c3e= new CommonIn3SortedArray();
        int[] a ={1,1,3,4,4,7};
        int[] b ={1,1,3,3,4,4,4};
        int[] c = {1,1,1,3,4,4,5};
        List<Integer> res = c3e.common(a,b,c);
        System.out.println(res);


    }
}

