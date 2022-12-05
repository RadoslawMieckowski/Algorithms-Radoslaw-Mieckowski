import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeDemo {
    public static void main(String[] args) {

        Tree tree = new Tree();
        tree.insert(50);
        tree.insert(45);
        tree.insert(55);
        tree.insert(40);
        tree.insert(47);
        tree.insert(53);
        tree.insert(60);

        System.out.println(tree.lookUp(50));
        System.out.println(tree.lookUp(40));
        System.out.println(tree.lookUp(60));
        System.out.println(tree.lookUp(80));

        System.out.println(tree);
        System.out.println(tree.DFS_InorderTraversal(tree.root, new ArrayList<>()));
//        System.out.println(tree.DFS_PreorderTraversal(tree.root, new ArrayList<>()));
//        System.out.println(tree.DFS_PostorderTraversal(tree.root, new ArrayList<>()));
    }
}

class Tree {
    TreeNode root;

    public Tree() {
        root = null;
    }

    public boolean lookUp(int value) {
        TreeNode currentNode = root;
        while (true) {
            if (currentNode == null) {
                return false;
            }
            if(value < currentNode.val) {
                currentNode = currentNode.left;
            }
            else if (value > currentNode.val) {
                currentNode = currentNode.right;
            } else {
                return true;
            }
        }
    }

    public void insert(int value) {
        TreeNode newNode = new TreeNode(value);
        TreeNode currentNode = root;
        if (currentNode == null) {     //drzewo jest puste
            root = newNode;
        } else {        // drzewo nie jest puste
            while (true) {
                if(value < currentNode.val) {
                    if (currentNode.left == null) {
                        currentNode.left = newNode;
                        return;
                    }
                    currentNode = currentNode.left;
                } else if (value > currentNode.val) {
                    if (currentNode.right == null) {
                        currentNode.right = newNode;
                        return;
                    }
                    currentNode = currentNode.right;
                }
            }
        }
    }

    public List<Integer> DFS_InorderTraversal(TreeNode root, List<Integer> list) {
        if (root != null) {
            if (root.left != null) {
                DFS_InorderTraversal(root.left, list);
            }
            list.add(root.val);
            if (root.right != null) {
                DFS_InorderTraversal(root.right, list);
            }
        }
        return list;
    }

    public List<Integer> DFS_PreorderTraversal(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            if (root.left != null) {
                DFS_PreorderTraversal(root.left, list);
            }
            if (root.right != null) {
                DFS_PreorderTraversal(root.right, list);
            }
        }
        return list;
    }

    public List<Integer> DFS_PostorderTraversal(TreeNode root, List<Integer> list) {
        if (root != null) {
            if (root.left != null) {
                DFS_PostorderTraversal(root.left, list);
            }
            if (root.right != null) {
                DFS_PostorderTraversal(root.right, list);
            }
            list.add(root.val);
        }
        return list;
    }


        @Override
    public String toString() {
        return "Tree{" +
                "root=" + root +
                '}';
    }

    public TreeNode remove() {
        return null;
    }


}

