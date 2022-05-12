public class printIf {
    public static void printIf(int n){
        if(n<0) return;
        char[]cur = new char[2*n];
        helper(n,n,0,cur);
    }
    private static void helper(int leftRemain, int rightRemain, int index, char[] cur){
        //base case
        if(leftRemain == 0 && rightRemain ==0){
            printBlock(cur);
            return;
        }
        if(leftRemain>0){
            cur[index] ='{';
            helper(leftRemain-1,rightRemain,index+1,cur);

        }
        if(rightRemain>leftRemain){
            cur[index] ='}';
            helper(leftRemain,rightRemain-1,index+1,cur);
        }
    }
    private static void printBlock(char[] cur) {
        int space = 0;
        for (int i = 0; i < cur.length; i++) {
            if (cur[i] == '{') {
                printSpace(space);
                System.out.println("if{");
                space += 2;
            } else {
                space -= 2;
                printSpace(space);
                System.out.println("}");
            }
        }
        System.out.println();
    }

    private static void printSpace(int space) {
        for(int i = 0;i<=space;i++){
            System.out.print(" ");
        }
    }
    //time: 2^2n print n->2^2n*n
    //space:O(2n);

    public static void main(String[] args) {
        int n = 2;
        printIf(2);
    }
}
