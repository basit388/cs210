package BSTree;

// Basit Qureshi Mar 28, 2017 2:31:03 PM
 
public class test 
{
    public static void main(String [] s)
    {
        BSTree BST = new BSTree();
        BST.insert(10);
        BST.insert(20);
        BST.insert(5);
        BST.insert(15);
        System.out.println("Stop here!");
        System.out.println(BST.InOrder(BST.Root));
        System.out.println(BST.PostOrder(BST.Root));
        System.out.println(BST.PreOrder(BST.Root));
        
        //testing remove
        // case 0
        BST.remove(15);
        System.out.println(BST.InOrder(BST.Root));
        
        //case 1
        BST.insert(18);
        BST.remove(18);
        System.out.println(BST.InOrder(BST.Root));
        
        //case 2
        BST.insert(30);
        BST.insert(40);
        BST.insert(25);
        
        //scenario 1
        BST.remove(20);
        System.out.println(BST.InOrder(BST.Root));
        
        //scenario 2
        BST.remove(30);
        System.out.println(BST.InOrder(BST.Root));
        
        //scenario 3
        BST.insert(20);
        BST.insert(22);
        
        BST.remove(25);
        System.out.println(BST.InOrder(BST.Root));
        
    }
}
