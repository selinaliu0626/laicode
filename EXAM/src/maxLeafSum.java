
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int key){
        this.val = key;
        right = null;
        left = null;
    }

}

public class maxLeafSum {
    TreeNode root;
    public int maxleafSum(TreeNode root ){
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        maxGain(root,maxSum);
        return maxSum[0];

    }

    public int maxGain(TreeNode node, int[] maxSum){
        if(node == null){
            return 0;
        }
        if(node.left == null && node.right == null){
            return node.val;
        }
        int leftGain = maxGain(node.left, maxSum);
        int rightGain = maxGain(node.right,maxSum);
        if(node.left != null && node.right!= null){
            int newPathGain = node.val +leftGain+rightGain;
            maxSum[0] = Math.max(maxSum[0],newPathGain);
            return node.val +Math.max(leftGain,rightGain);
        }
        return node.left == null ?  rightGain+ node.val :leftGain+ node.val;
    }
}
//time complexity: O(n)
//space complexity:O(H);
