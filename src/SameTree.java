import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class SameTree {
    public static void main(String[] args) {
        TreeNode pv1 = new TreeNode(1);
        TreeNode pv2 = new TreeNode(2);
        TreeNode pv3 = new TreeNode(3);
        pv1.left = pv2;
        pv1.right = pv3;

        TreeNode qv1 = new TreeNode(1);
        TreeNode qv2 = new TreeNode(2);
        TreeNode qv3 = new TreeNode(3);
        qv1.left = qv2;
        qv1.right = qv3;

        System.out.println(isSameTree(pv1, qv1));

        TreeNode pv4 = new TreeNode(1);
        TreeNode pv5 = new TreeNode(2);
        TreeNode pv6 = new TreeNode(1);
        pv4.left = pv5;
        pv4.right = pv6;

        TreeNode qv4 = new TreeNode(1);
        TreeNode qv5 = new TreeNode(1);
        TreeNode qv6 = new TreeNode(2);
        qv4.left = qv5;
        qv4.right = qv6;

        System.out.println(isSameTree(pv4, qv4));
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> visitedVertexesP = BFSTraversal(p);
        System.out.println(visitedVertexesP);

        List<Integer> visitedVertexesQ = BFSTraversal(q);
        System.out.println(visitedVertexesQ);
        if (visitedVertexesP.equals(visitedVertexesQ)) {
            return true;
        }
        else {
            return false;
        }
    }

    public static List<Integer> BFSTraversal(TreeNode root) {
        Queue<TreeNode> queue =  new LinkedList<>();
        List<Integer> visitedVertexes = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.remove();
            if(currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if(currentNode.right != null) {
                queue.add(currentNode.right);
            }
            visitedVertexes.add(currentNode.val);
        }
        return visitedVertexes;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

//    Are these trees identical? (use breadth-first-search)