// Basit Qureshi Oct 14, 2022 

package AVLTree;

public class AVLTree {

    private Node root;

    int height(Node n) {
        return (n == null) ? 0 : n.height;
    }

    int getBalance(Node n) {
        return (n == null) ? 0 : height(n.left) - height(n.right);
    }

    //rotations
    Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x; // new root
    }

    Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y; // new root
    }

    public void insert(int key, int value) {
        root = insertRec(root, key, value);
    }

    private Node insertRec(Node node, int key, int value) {
        // Perform standard BST insertion
        if (node == null)
            return new Node(key, value);

        if (key < node.key)
            node.left = insertRec(node.left, key, value);
        else if (key > node.key)
            node.right = insertRec(node.right, key, value);
        else {
            // Update value if key already exists
            node.value = value;
            return node;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        // Left Left Case
        if (balance > 1 && key < node.left.key)
            return rotateRight(node);

        // Right Right Case
        if (balance < -1 && key > node.right.key)
            return rotateLeft(node);

        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node; // unchanged node
    }

    public Integer search(int key) {
        Node node = searchRec(root, key);
        return (node != null) ? node.value : null;
    }

    private Node searchRec(Node node, int key) {
        if (node == null || node.key == key)
            return node;

        if (key < node.key)
            return searchRec(node.left, key);
        else
            return searchRec(node.right, key);
    }

    public void remove(int key) {
        root = removeRec(root, key);
    }

    private Node removeRec(Node root, int key) {
        if (root == null)
            return root;

        if (key < root.key)
            root.left = removeRec(root.left, key);
        else if (key > root.key)
            root.right = removeRec(root.right, key);
        else {
            // Node with one or no child
            if ((root.left == null) || (root.right == null)) {
                Node temp = (root.left != null) ? root.left : root.right;

                // No child case
                if (temp == null)
                    root = null;
                else
                    root = temp;
            } else {
                // Node with two children:
                // Get the successor (smallest in the right subtree)
                Node temp = minValueNode(root.right);

                // Copy successor's data
                root.key = temp.key;
                root.value = temp.value;

                // Delete the inorder successor
                root.right = removeRec(root.right, temp.key);
            }
        }

        if (root == null)
            return root;

        root.height = Math.max(height(root.left), height(root.right)) + 1;

        int balance = getBalance(root);

        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0)
            return rotateRight(root);

        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }

        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0)
            return rotateLeft(root);

        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }

        return root;
    }

    // Get node with minimum key value found in the tree for successor
    Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }

    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(Node node) {
        if (node != null) {
            inorderRec(node.left);
            System.out.print("(" + node.key + ":" + node.value + ") ");
            inorderRec(node.right);
        }
    }
}