
import java.util.ArrayList;
import java.util.HashSet;

import java.util.List;
import java.util.Set;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val){
        this.val = val;
        this.left= null;
        this.right = null;
    }

}

public class TargetPathSum {
  public boolean exist(TreeNode root, int targetSum){
      if(root == null) return false;
      Set<Integer> prefixsums =new HashSet<>();
      prefixsums.add(0);
      return helper(root,prefixsums,targetSum,0);
  }

    private boolean helper(TreeNode root, Set<Integer> prefixsums, int targetSum,int curSum) {
     curSum += root.val;
      if(prefixsums.contains(curSum-targetSum)){
          return true;
      }
      //in case, the new sum is same with previous sums we have added in our list
        // needRemove is for when we go to different paths we need to remove the old paths sums
        //           8
        //         /   \
        //        2
        //      /   \
        //    -2     6     // when we add( 8+2 +(-2))=add(8), it is the same with the root,so we can't remove the root.val

      boolean needRemove = prefixsums.add(curSum);
      // why could just return helper(root.left) or (root.right)
        //when we directly return, when it false it will directly end this function
        //but for this question, we need to check all the possibilities when it still have nodes
      if(root.left!= null && helper(root.left,prefixsums,targetSum,curSum)){
          return true;
      }
      if(root.right != null && helper(root.right,prefixsums,targetSum,curSum)){
          return true;
      }
      if(needRemove){ // if we did not contain duplicate sums, we need to remove cursum to go to next path
          prefixsums.remove(curSum);
      }
      return false;
    }

    //           10
    //         /   \
    //        -2    11
    //             /   \
    //             6    14
    //            /
     //           3
    public static void main(String[] args) {
        TargetPathSum tps = new TargetPathSum();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(11);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(14);
        root.right.left.left = new TreeNode(3);
        int target =17;
        boolean res = tps.exist(root,17);
        System.out.println(res);

    }
}
