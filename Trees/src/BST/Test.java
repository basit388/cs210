package BST;

public class Test
{

        public static void main(String [] args)
        {
            BST B = new BST();
            
            B.insert(10, 100);
            B.insert(3, 300);
            B.insert(20, 200);
            B.insert(18, 180);
            B.insert(30, 300);
            B.insert(15, 150);
            B.insert(16, 160);
            B.insert(17, 170);
            
            System.out.println("searching value for key 30: " + B.get(30).val);

            System.out.println(B.Inorder(B.root));
            
            System.out.println("Removing 10");
            B.remove(10);

            System.out.println(B.Inorder(B.root));
            
            
        }
}

