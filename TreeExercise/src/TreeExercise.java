import java.util.ArrayList;

public class TreeExercise {
    public static void main(String[] args) {
        //create root node
        TreeNode root = new TreeNode(1);
        //add children to root node
        TreeNode child1 = root.addChild(2);
        TreeNode child2 = root.addChild(3);
        //add children to child nodes
        TreeNode child11 = child1.addChild(4);
        TreeNode child12 = child1.addChild(5);

        TreeNode child21 = child2.addChild(6);
        TreeNode child22 = child2.addChild(7);

        //call methods
        preOrderTraversal(root);
        System.out.println("\n" + depth(child21));
        System.out.println(treeSize(root));
        postOrderTraversal(root);
    }

    //write a method to implement the preorder traversal
    //pseudocode from the slides
    public static void preOrderTraversal(TreeNode node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        ArrayList<TreeNode> children = node.getChildren();
        for (TreeNode tn : children) {
            preOrderTraversal(tn);
        }
    }
//write a method implement the postorder traversal
//pseudocde from the slides
    public static void postOrderTraversal(TreeNode node) {
        if(node == null) {
            return;
        }
        ArrayList<TreeNode> children = node.getChildren();
        for(TreeNode tn : children) {
            postOrderTraversal(tn);
        }
        System.out.print(node.data + " ");
    }

//write a method that given a node, finds the depth of that node
    public static int depth(TreeNode root, TreeNode node) {
        return depthRecursive(root, node, 0);
    }
    public static int depthRecursive(TreeNode current, TreeNode target, int depth) {
        if (current == null) {
            return -1;
        }
        if (current == target) {
            return depth;
        }
        int leftDepth = findRecursiveDepth(current.left, target, )


    }
//write a method that given the root node, finds the size of tree
//aka how many nodes the tree has
    public static int treeSize(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int size = 1;
        ArrayList<TreeNode> children = node.getChildren();
        for (TreeNode tn : children) {
            size += treeSize(tn);
        }
        return size;
    }
}