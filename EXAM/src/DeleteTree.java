public class DeleteTree {
    public TreeNode deleteTree(TreeNode root){
        //
        if(root == null) return null;
        while(root!= null){
            // no child
            if(root.left == null && root.right==null){
                root = null;
            }else if(root.left ==null){
                TreeNode tmp = root;
                root =tmp.right;
                tmp =null;
            }else if(root.right == null){
                TreeNode tmp = root;
                root=tmp.left;
                tmp =null;
            }else{
                // have two kids
                TreeNode tmp = root;
                if(root.right.left== null && root.right.right == null){
                    root = root.right;
                    root.left=tmp.left;
                    root.right= null;
                }else if(root.left.left== null && root.left.right==null){
                    root = root.left;
                    root.right=tmp.right;
                    root.left = null;
                }else if(root.right.left== null){
                    root = root.right;
                    root.right = tmp.right.right;
                    root.left =tmp.left;
                }else if(root.right.right == null){
                    root =root.right;
                    root.right =tmp.right.left;
                    root.left = tmp.right;
                }else {
                    TreeNode node = tmp.right.right;
                    root = root.right;
                    root.right = node;
                    root.left = tmp.left;
                    if (node.left != null) {
                        root.right.left = node.left;
                    }
                }



            }
        }
        return root;
    }

    public static void main(String[] args) {
        DeleteTree dt = new DeleteTree();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right =new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right.left =new TreeNode(7);
        TreeNode node =dt.deleteTree(root);
    }
}
