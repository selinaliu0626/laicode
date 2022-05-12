//https://app.laicode.io/app/problem/46
//46. Check If Binary Tree Is Balanced
public class IsTreeBalanced {
    public boolean isBalanced(TreeNode root){
        if(root == null || (root.left ==null &&root.right ==null))return true;
        int height =getHeight(root);
        if (height== -1)return  false;
        return true;

    }
    //左子树或右子树不平衡或者左右两边各自平衡但是两者之差大于1，这三种情况都是不平衡
    private int getHeight(TreeNode root){
        if(root == null) return 0;
        int left = getHeight(root.left);
        if(left == -1) return -1;
        int right = getHeight(root.right);
        if(right == -1) return -1;
        if(Math.abs(left-right)>1) return -1;
        return Math.max(left,right)+1;
    }
}
