import java.util.*;


public class Zigzag {
    public List<Integer> zigZagPrint(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerFirst(root);
        int layer = 0;
        TreeNode cur;
        while (!deque.isEmpty()) {
            layer++;
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                if (layer % 2 == 0) {
                    cur = deque.pollFirst();
                    res.add(cur.key);
                    if (cur.left != null) {
                        deque.offerLast(cur.left);
                    }
                    if (cur.right != null) {
                        deque.offerLast(cur.right);
                    }
                } else {
                    cur = deque.pollLast();
                    res.add(cur.key);
                    if (cur.right != null) {
                        deque.offerFirst(cur.right);
                    }
                    if (cur.left != null) {
                        deque.offerFirst(cur.left);
                    }
                }
            }
        }
        return res;
    }
        public List<List<Integer>> layerByLayer(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                List<Integer> temp = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.poll();
                    temp.add(cur.key);
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }
                }
                result.add(temp);
            }
            return result;
        }


    public static void main(String[] args) {
        Zigzag zg = new Zigzag();
        TreeNode root= new TreeNode(5);
        root.left =new TreeNode(3);
        root.right =new TreeNode(8);
        root.left.left =new TreeNode(1);
        root.left.right =new TreeNode(4);
        root.right.right =new TreeNode(11);
        //List<Integer> res = zg.zigZagPrint(root);
        List<List<Integer>> res =zg.layerByLayer(root);
        System.out.println(res);
    }
}