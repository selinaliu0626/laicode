//https://app.laicode.io/app/problem/138
//Given a binary tree in which each node contains an integer number.
// Find the maximum possible sum from one leaf node to another leaf node.
// If there is no such path available, return Integer.MIN_VALUE(Java)/INT_MIN (C++).
public class LeafToLeafSum {
    public int maxPathSum(TreeNode root){
        int[] maxSum = new int[]{Integer.MIN_VALUE};
        if(root == null || (root.left== null && root.right == null)) return maxSum[0];
         helper(root,maxSum);
        return maxSum[0];
    }

    private  int helper(TreeNode root, int[] maxSum) {
        //base case
        // root == null 一定要写在前面
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val;

        //recursion rule
        int leftSum =helper(root.left, maxSum);
        int rightSum = helper(root.right,maxSum);

        if(root.left != null && root.right != null){
           maxSum[0] =Math.max(maxSum[0],leftSum+rightSum+ root.val);
            return Math.max(leftSum,rightSum)+ root.val;
        }
        return root.left == null? rightSum+ root.val : leftSum+root.val;

    }
    public static void main(String[] args) {
        LeafToLeafSum ls = new LeafToLeafSum();
        TreeNode root = new TreeNode(-15);
        root.left = new TreeNode(2);
        root.right = new TreeNode(11);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(14);
        int res= ls.maxPathSum(root);
        System.out.println(res);
    }
}
