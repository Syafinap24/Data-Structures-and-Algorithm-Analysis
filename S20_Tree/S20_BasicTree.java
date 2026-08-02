package Forum;

class Tree {
    String data;
    Tree left, right;

    Tree(String data) {
        this.data = data;
        left = right = null;
    }

    static void display(Tree node, int level) {
        if (node == null) return;
        for (int i = 0; i < level; i++) System.out.print("   ");
        System.out.println(node.data);
        display(node.left, level + 1);
        display(node.right, level + 1);
    }
}

public class S20_BasicTree {
    public static void main(String[] args) {
        Tree root = new Tree("Root");
        root.left = new Tree("Internal Node");
        root.right = new Tree("Leaf 1");
        root.left.left = new Tree("Leaf 3");
        root.left.right = new Tree("Leaf 2");

        Tree.display(root, 0);
    }
}