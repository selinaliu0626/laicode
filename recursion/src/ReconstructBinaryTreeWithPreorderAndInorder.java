//213. Reconstruct Binary Tree With Preorder And Inorder
//https://app.laicode.io/app/problem/213
//preorder traversal = {5, 3, 1, 4, 8, 11}
//
//inorder traversal = {1, 3, 4, 5, 8, 11}
//
//the corresponding binary tree is
//
//        5
//
//      /    \
//
//    3        8
//
//  /   \        \
//
//1      4        11

import com.sun.source.tree.Tree;
//  T:O(n)
//  S:O(n)

import java.util.*;

public class ReconstructBinaryTreeWithPreorderAndInorder {
    public TreeNode reconstruct(int[] inOrder, int[] preOrder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<inOrder.length;i++){
            map.put(inOrder[i],i);
        }
        return helper(inOrder,0,inOrder.length-1,preOrder,0,preOrder.length-1,map);
    }
    private TreeNode helper( int[] in,int inLeft, int inRight,
                             int[]pre, int preLeft, int preRight,
                             Map<Integer,Integer> inMap){
        if(inLeft >inRight ) return null;
        TreeNode root = new TreeNode(pre[preLeft]);
        int leftSize = inMap.get(root.val)-inLeft;
        int inMid = inMap.get(root.val);
        root.left = helper(in,inLeft,inMid-1,pre,preLeft+1,preLeft+leftSize,inMap);
        root.right = helper(in,inMid+1,inRight,pre,preLeft+leftSize+1,preRight,inMap);

        //leftsize =inMid- inleft;
        //root.left = helper(in,inLeft,inMid-1,pre,preLeft+1,preLeft+inMid-inLeft,inMap);
        //the beginning of the left bound in preorder is preLeft+leftSize+1
        //root.right = helper(in,inMid+1,inRight,pre,preRight+inMid-inRight+1,preRight,inMap);
        return root;
    }






    public static void main(String[] args) {
        ReconstructBinaryTreeWithPreorderAndInorder rect =new ReconstructBinaryTreeWithPreorderAndInorder();
        int[] pre ={1,6,5,7,4,10,9};
        int[] ino={4,1,5,6,7,10,9};
        TreeNode root = rect.reconstruct(pre,ino);
        System.out.println(root.val);

    }


}
