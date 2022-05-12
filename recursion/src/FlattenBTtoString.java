//591. Flatten Binary Tree to String
//https://app.laicode.io/app/problem/591
//Example 1:
//
//Input: [1,2,3,4]
//
//        1
//
//      /   \
//
//    2      3
//
//  /
//
//4
//
//Output: "1(2(4))(3)"

public class FlattenBTtoString {
    public String flattenBinaryTree(TreeNode root) {
        // Write your solution here
        StringBuilder sb = new StringBuilder();
        helper(root,sb);
        return sb.toString();

    }
    private void helper(TreeNode root, StringBuilder sb){
        if(root == null) {
            return;
        }
        sb.append(root.val);
        if(root.left == null && root.right == null) return;
        sb.append("(");
        helper(root.left, sb);
        sb.append(")");
        if(root.right == null) return;
        sb.append("(");
        helper(root.right, sb);
        sb.append(")");
    }

    public static void main(String[] args) {
        FlattenBTtoString fs = new FlattenBTtoString();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        String res = fs.flattenBinaryTree(root);
        System.out.println(res);
    }
}
