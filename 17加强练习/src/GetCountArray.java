import java.util.Arrays;

//276. Get Count Array
//https://app.laicode.io/app/problem/276?plan=3
//A = { 4, 1, 3, 2 }, we should get B = { 3, 0, 1, 0 }.
public class GetCountArray {

     class Items{
     int val;
     int index;
     public Items(int v,int i){
         val =v;
         index =i;
     }
    }
    public int[] countArray(int[] array) {
        int n = array.length;
        Items[] items = new Items[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Items(array[i], i);
        }
        int[] count = new int[n];
        mergeSort(items, 0, n - 1, count);
        return count;
    }

    private void mergeSort(Items[] items, int left, int right, int[] count) {
         if(left>=right) return;
         int mid =left+(right-left)/2;
         mergeSort(items,left,mid,count);
         mergeSort(items,mid+1,right,count);
         merge(items,left,mid,mid+1,right,count);
    }

    private void merge(Items[] items, int l, int lend,  int r,int rend, int[] count) {
         int ms = rend-l+1;
         Items[] helper = new Items[ms];
         int lptr =l,rptr =r;
         int c =0;
         int index=0;
         while(lptr<= lend &&rptr<=rend){
             //如果右边的数更小
             if(items[rptr].val <items[lptr].val){
                 c++;//左边的值小，就证明我们需要计算右边小的数字++
                 helper[index++] = items[rptr++];
             }else{//但确定一次左边的数字的时候，我们就更新一下count
                 count[items[lptr].index] += c;
                 helper[index++] =items[lptr++];
             }
         }
         while(lptr<=lend){
             count[items[lptr].index] += c;
             helper[index++] = items[lptr++];
         }
         while(rptr<= rend){
             helper[index++] = items[rptr++];
         }
         System.arraycopy(helper,0,items,l,ms);
    }


    public static void main(String[] args) {
        GetCountArray gca = new GetCountArray();
        int[] array ={5,2,1,3,7,6};
        int[] res = gca.countArray(array);
        System.out.println(Arrays.toString(res));
    }
}
