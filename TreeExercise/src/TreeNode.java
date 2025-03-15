import java.util.ArrayList;

class TreeNode{
    int data;
    ArrayList<TreeNode> children = new ArrayList();
    TreeNode parent = null;

    public TreeNode(int d){
        data = d;
    }

    public TreeNode addChild(int d){
        TreeNode n = new TreeNode(d);
        n.setParent(this);
        children.add(n);
        return n;
    }

    public ArrayList<TreeNode> getChildren(){
        return children;
    }

    public void setParent(TreeNode p){
        parent = p;
    }

    public TreeNode getParent(){
        return parent;
    }
}


