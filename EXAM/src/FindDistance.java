//Q2. Distance between two given nodes in a given binary search tree.
//
//
//
//    Assuming:
//
//there is no parent pointer.
//
//both nodes belong to the tree.
//
//           15
//
//        /          \
//
//      5           20
//
//     /    \
//
//   3      10
//
// /   \      /
//
//1   4    8
//
//          /   \
//
//         7     9
//
//
//
//distance(3, 8) = 3
//
//distance(5, 7) = 3
//
//distance(1, 9) = 5
//
//
//
//class TreeNode {
//
//int val;
//
//TreeNode left;
//
//TreeNode right;
//
//}
public class FindDistance {

    public int findDistance(TreeNode root, int a, int b){
        if(root == null) return 0;
        TreeNode lca = findLCA(root, a, b);
        int lcaHeight = findHeight(root, lca.val, 0);
        int aHeight = findHeight(root, a, 0);
        int bHeight = findHeight(root, b, 0);
        return aHeight-lcaHeight + bHeight - lcaHeight;
    }

    private int findHeight(TreeNode node, int target, int curHeight){
        if(node == null) return -1;
        if(node.val == target) return curHeight;
        int left = findHeight(node.left, target, curHeight+1);
        return left == -1? findHeight(node.right, target, curHeight+1) : left;
    }

    private TreeNode findLCA(TreeNode node, int a, int b){
        if(node == null) return null;
        if(node.val == a || node.val == b){
            return node;
        }
        TreeNode left = findLCA(node.left, a, b);
        TreeNode right = findLCA(node.right, a, b);
        if(left != null && right !=null){
            return node;
        }
        return left == null ? right : left;
    }
    //since this question is a binary search tree
     //we could use binary search to find our lca
    //in this method we could optimise time to O(H) and space to O(1);
    public int findDistance2(TreeNode root, int a, int b){
        int small = Math.min(a,b);
        int max = Math.max(a,b);
        TreeNode lca = root;
        while(root!=null) {
            if (root.val > max) {
                root = root.left;
            } else if (root.val < small) {
                root = root.right;
            } else {
                lca = root;
                break;
            }
        }
        return distance(lca,a)+distance(lca,b);
    }

    private int distance(TreeNode lca, int n) {
        int dis =0;
       while(lca.val!= n){
           if(n>lca.val){
               lca =lca.right;
           }else{
               lca =lca.left;
           }
           dis++;
       }
       return dis;
    }


    public static void main(String[] args) {
        FindDistance fs  = new FindDistance();
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(10);
        root.left.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(8);
        int d1 = fs.findDistance2(root,4,5);
        System.out.println("node 4 and node 5 has distance: "+d1);
        int d2 = fs.findDistance2(root,4,20);
        System.out.println("node 4 and node 20 has distance: "+d2);
        int d3 =fs.findDistance2(root,8,15);
        System.out.println("node 8 and node 15 has distance: "+d3);


    }
}
