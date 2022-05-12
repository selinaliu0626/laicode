//https://app.laicode.io/app/problem/639?plan=3
//639. Max Path Sum From Leaf To Root
//Given a binary tree in which each node contains an integer number.
// Find the maximum possible path sum from a leaf to root.

//对于这种必须是到叶子节点的题，假设root不是NULL,BASE CASE一定是当节点是叶子情况的时候
//也必须分别讨论只有一边有孩子的情况
//当两个孩子都有的时候，才能正常的计算LEFTSUM 和RIGHT SUM
public class MaxpathSumFromLeftToRoot {
    public int maxPathSumLeafToRoot(TreeNode root) {
        //assume root is not null
        //base case could only discuss the when the root is a leaf
        if(root.left == null && root.right== null) return root.val;
        if(root.left == null){
            return maxPathSumLeafToRoot(root.right)+root.val;
        }
        if(root.right == null){
            return maxPathSumLeafToRoot(root.left)+root.val;
        }
        // when left kid and right kid are not null
        int left = maxPathSumLeafToRoot(root.left);
        int right=maxPathSumLeafToRoot(root.right);
        return Math.max(left,right)+root.val;
    }
}
