package AVL;

// Basit Qureshi Dec 4, 2016 8:41:50 PM
 
public class test 
{
    public static void main(String [] s)
    {
        
        
        AVL A = new AVL();
        A.insert(10);
        A.insert(5);
        A.insert(20);
        A.insert(15);
        A.insert(11);
        A.insert(30);
        
        A.setHeights(A.root);
        
        System.out.println(A.isAVL(A.root));
        

        
    }
}
