//https://app.laicode.io/app/problem/136?plan=3
//In a binary search tree, find the node containing the largest number smaller than the given target number.
//If there is no such number, return -2^31.
public class LargestSmallerInBST {
    public int largestSmaller(TreeNode root, int target) {
        int result = Integer.MIN_VALUE;
        while (root != null) {
            if (root.key >= target) {
                root = root.left;
            } else {

                //当前的数小于目标， 往右走，继续往下走，如果还有依旧小于目标， 此值一定是大于之前小于目标的数
                // 因为我们当前找到的数，是在之前根结点的右子树上
                result = root.key;
                root = root.right;
            }
        }
        return result;
    }

        //      5
    //
    //        /    \
    //
    //        2      11
    //
    //              /    \
    //
    //              6     14

    public static void main(String[] args) {
        LargestSmallerInBST ls = new LargestSmallerInBST();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(11);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(14);
        int res = ls.largestSmaller(root, 10);
        System.out.println(res);
    }
}
