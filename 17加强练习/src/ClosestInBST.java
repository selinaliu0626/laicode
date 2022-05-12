class TreeNode {
    int key;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.key = val;
        this.left = null;
        this.right = null;

    }
}
public  class ClosestInBST {

    public int closest(TreeNode root, int target) {
        // 因为结果是需要当前这个节点的值，那么用result 存储当前节点的值比直接记录difference 要更方便
        int result = root.key;
        while(root != null) {
            if (root.key == target) return root.key;
            else {
                if (Math.abs(root.key - target) < Math.abs(result - target)) {
                    result = root.key;
                }
                if (root.key < target) {
                    root = root.right;
                } else {
                    root = root.left;
                }
            }
        }
            return result;

    }
    public static void main(String[] args) {
        ClosestInBST cbst = new ClosestInBST();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(11);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(14);
        int res = cbst.closest(root,10);
        System.out.println(res);
    }
}
