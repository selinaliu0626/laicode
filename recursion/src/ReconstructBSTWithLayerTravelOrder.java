import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//215. Reconstruct Binary Tree With Levelorder And Inorder
//https://app.laicode.io/app/problem/215?plan=3
//Given the levelorder and inorder traversal sequence of a binary tree, reconstruct the original tree.
//
//Assumptions
//
//The given sequences are not null and they have the same length
//There are no duplicate keys in the binary tree
//Examples
//
//levelorder traversal = {5, 3, 8, 1, 4, 11}
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
public class ReconstructBSTWithLayerTravelOrder {
    public TreeNode reconstruct(int[] inOrder, int[] levelOrder) {
        // Write your solution here
        Map<Integer,Integer> inMap = new HashMap<>();
        for(int i =0;i<inOrder.length;i++){
            inMap.put(inOrder[i],i);
        }
        List<Integer> level = new LinkedList<>();
        for(int i =0;i<levelOrder.length;i++){
            level.add(levelOrder[i]);
        }
        return helper(level,inMap);
    }
    private TreeNode helper(List<Integer> level,Map<Integer,Integer>in){
        //base case
        if(level.isEmpty()){
            return null;
        }
        TreeNode root = new TreeNode(level.remove(0));
        //分割成两段，大于root是右边的，小于root 是左边的
        List<Integer> left = new LinkedList<>();
        List<Integer> right = new LinkedList<>();
        for(int num: level){
            if(in.get(num)<in.get(root.val)){
                left.add(num);
            }else{
                right.add(num);
            }
        }
        root.left = helper(left,in);
        root.right = helper(right,in);
        return root;
    }

    public static void main(String[] args) {
        ReconstructBSTWithLayerTravelOrder relevel = new ReconstructBSTWithLayerTravelOrder();
        int[]level ={5, 3, 8, 1, 4, 11};
        int[]in ={1, 3, 4, 5, 8, 11};
        TreeNode root = relevel.reconstruct(in,level);
    }
}
