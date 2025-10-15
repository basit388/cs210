// Basit Qureshi Oct 14, 2022 

package AVLTree;
public class Node {
    int key;
    int value;
    int height;
    Node left, right;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.height = 1; // new node is initially added at leaf
    }
}
