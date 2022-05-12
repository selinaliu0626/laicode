import java.util.ArrayList;
import java.util.List;
class TreeNode{
    public int key;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int key){
        this.key = key;
    }
}
public class ClosetNumTree {
    public void inorder(TreeNode root, List<Double>res,double target){
        if(root == null) return;
        inorder(root.left,res,target);
        res.add(root.key-target);
        inorder(root.right,res,target);
    }

    public static void main(String[] args) {
        ClosetNumTree ct = new ClosetNumTree();
        TreeNode root= new TreeNode(5);
        root.left =new TreeNode(3);
        root.right =new TreeNode(8);
        root.left.left =new TreeNode(1);
        root.left.right =new TreeNode(4);
        root.right.right =new TreeNode(11);
        List<Double> res = new ArrayList<>();
        ct.inorder(root,res,4.2);
        System.out.println(res);

        System.out.println(res);
    }
}
