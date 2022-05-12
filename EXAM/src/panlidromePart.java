public class panlidromePart {
    private static boolean isPanlindrome(char[] array, int i, int j) {
        while (i < j) {
            if (array[i] != array[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static int minCut(String input){
        //base case
        if(input == null || input.length()<=1){
            return 0;
        }
        char[] array = input.toCharArray();
        int n  = array.length;
        int[] mo = new int[n+1];
        mo[1]=0;
        mo[0]=0;
        for(int i =2;i< mo.length;i++){
            int minCutforI = Integer.MAX_VALUE;
            for(int j = 0;j<i;j++){
                if(isPanlindrome(array,j,i-1)){
                    if(j == 0){
                        minCutforI = 0;
                        break;
                    }else{
                        minCutforI = Math.min(minCutforI,mo[j]+1);
                    }
                }
            }
            mo[i] = minCutforI;
        }
        return mo[n];
    }
    //time complexity:O(n^3)
    //space complexity:O(n)

    public static void main(String[] args) {
        String input = "bababa";
        int n = minCut(input);
        System.out.println(n);
    }
}
