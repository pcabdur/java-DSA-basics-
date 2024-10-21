// Node class representing a node in the BST
class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

// Binary Search Tree class
class BinarySearchTree {
    Node root;

    // Constructor for the BST
    BinarySearchTree() {
        root = null;
    }

    // Insert a new key into the BST
    void insert(int key) {
        root = insertRec(root, key);
    }

    // A recursive function to insert a new key in BST
    Node insertRec(Node root, int key) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Otherwise, recursively find the correct spot to insert the new node
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        // return the (unchanged) node pointer
        return root;
    }

    // In-order traversal of the BST
    void inorder() {
        inorderRec(root);
    }

    // Recursive function for in-order traversal
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Main function to test the above implementation
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        /* Inserting elements into the tree */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Print the in-order traversal of the tree
        System.out.println("In-order traversal of the BST:");
        tree.inorder();
    }
}
