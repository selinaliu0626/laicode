//523. Flatten Binary Tree to Linked List
//https://app.laicode.io/app/problem/523?plan=3
//Given a binary tree, flatten it to a linked list in-place.
//
//For example,
//Given
//
//         1
//        / \
//       2   5
//      / \   \
//     3   4   6
//The flattened tree should look like:
//
//   1
//    \
//     2
//      \
//       3
//        \
//         4
//          \
//           5
//            \
//             6
public class FlattenBinaryTreetoLinkedList {
    public TreeNode flatten(TreeNode root) {
        TreeNode[] prev = new TreeNode[1];
        helper(root,prev);
        return root;

    }
    private void helper(TreeNode root,TreeNode[] prev){
        if(root == null) return;
        helper(root.right,prev);
        helper(root.left,prev);
        root.right = prev[0];
        root.left = null;
        prev[0] = root;
    }

    public static void main(String[] args) {
        FlattenBinaryTreetoLinkedList fbt = new FlattenBinaryTreetoLinkedList();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        fbt.flatten(root);
        while(root!= null){
            System.out.println(root.val);
            root = root.right;
        }

    }
}
