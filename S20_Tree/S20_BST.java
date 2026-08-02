package Forum;

class BSTNode {
    int data;
    BSTNode left, right;

    public BSTNode(int data) {
        this.data = data;
        left = right = null;
    }
}

class S20_BST {
    BSTNode root;

    public S20_BST() {
        root = null;
    }

    // Insert
    void insert(int key) {
        root = insertRec(root, key);
    }

    BSTNode insertRec(BSTNode root, int key) {
        if (root == null) {
            root = new BSTNode(key);
            return root;
        }
        if (key < root.data)
            root.left = insertRec(root.left, key);
        else if (key > root.data)
            root.right = insertRec(root.right, key);
        return root;
    }

    // Search
    boolean search(BSTNode root, int key) {
        if (root == null) return false;
        if (root.data == key) return true;
        return key < root.data
                ? search(root.left, key)
                : search(root.right, key);
    }

    // Delete
    BSTNode delete(BSTNode root, int key) {
        if (root == null) return root;
        if (key < root.data)
            root.left = delete(root.left, key);
        else if (key > root.data)
            root.right = delete(root.right, key);
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            root.data = findMinRec(root.right);
            root.right = delete(root.right, root.data);
        }
        return root;
    }

    // FindMin
    int findMin() {
        return findMinRec(root);
    }

    int findMinRec(BSTNode root) {
        if (root.left == null) return root.data;
        return findMinRec(root.left);
    }

    // FindMax
    int findMax() {
        return findMaxRec(root);
    }

    int findMaxRec(BSTNode root) {
        if (root.right == null) return root.data;
        return findMaxRec(root.right);
    }

    // Inorder
    void inorder() {
        inorderRec(root);
    }

    void inorderRec(BSTNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }
    
    public static void main(String[] args) {
    	S20_BST bst = new S20_BST();

        // Stok barang di gudang
        bst.insert(150);
        bst.insert(75);
        bst.insert(200);
        bst.insert(50);
        bst.insert(100);
        bst.insert(175);
        bst.insert(250);

        //          150
        //         /   \
        //        75   200
        //       / \   / \
        //      50 100 175 250

        System.out.println("Stok barang (urutan kecil ke besar):");
        bst.inorder();

        System.out.println("\nStok paling sedikit: " + bst.findMin());
        System.out.println("Stok paling banyak: " + bst.findMax());

        System.out.println("Cari stok 100: " + bst.search(bst.root, 100));
        System.out.println("Cari stok 999: " + bst.search(bst.root, 999));

        bst.root = bst.delete(bst.root, 75);
        System.out.println("\nSetelah hapus stok 75:");
        bst.inorder();
    }
}
