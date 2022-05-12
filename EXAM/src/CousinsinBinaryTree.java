//In a binary tree, two nodes are cousins of each other if they are at the same level and have different parents.
//
//For example, in the following tree:
//
//
//                     6
//
//                  /     \
//
//               3            5
//
//            /     \      /     \
//
//           7       8    1       2
//7 and 1 are cousins.

        //3 and 5 are not cousins.

        //7 and 5 are not cousins.

import java.util.ArrayDeque;
import java.util.Queue;

//Given a binary tree and two nodes, determine if the two nodes are cousins or not.
public class CousinsinBinaryTree {
        public boolean isCousin(TreeNode root, int a, int b) {
                if (root == null || root.val == a || root.val == b) return false;
                boolean[]res = new boolean[1];
                helper(root,a,b,0,res);
                return res[0];

        }
        private int helper(TreeNode root, int a, int b,int level,boolean[]res){
                if(root == null) return -1;
                if(root.val == a ||root.val ==b)return level;
                int left = helper(root.left,a,b,level+1,res);
                int right =helper(root.right,a,b,level+1,res);
                if(left ==right &&left-level>1) res[0]= true;
                return left==-1?right:left;
        }



        public static void main(String[] args) {
                CousinsinBinaryTree cb = new CousinsinBinaryTree();
                TreeNode root = new TreeNode(5);
                root.left = new TreeNode(4);
                root.right =new TreeNode(8);
                root.left.left = new TreeNode(1);
                root.right.left =new TreeNode(7);
               boolean res = cb.isCousin(root,1,7);
                System.out.println(res);
        }
}
