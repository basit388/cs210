// Basit Qureshi Oct 14, 2022 

package AVLTree;

public class Test {
    
     public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.insert(10, 100);
        tree.insert(20, 200);
        tree.insert(30, 300);
        //should do RR rotation
        tree.inorder();

        tree.insert(15, 150);
        tree.insert(17, 170);
        //should do LR rotation
        tree.inorder();
        
        tree.insert(16, 160);
        //should do RL rotation
        tree.inorder();
        
        tree.insert(40, 400);
        //should do RR rotation on 20
        tree.inorder();


        System.out.println("Search key 30 → value = " + tree.search(30));

        tree.remove(17); //remove root 17. successor is 20
        System.out.println("After deleting key 17:");
        tree.inorder();
    }
}
