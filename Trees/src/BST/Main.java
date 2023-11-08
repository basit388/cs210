package BST;

/**
 * @author Basit Qureshi (c) 2020
 */
class BST {
    Node root;
    int size;
    public BST(){
        root = null;
        size = 0;
    }
    public void put(int key, int val)
    {  
        root = put(root, key, val);  
    }
    public Node put(Node x, int key, int val)
    {
        if (x == null) 
            return new Node(key, val);
        int cmp = x.compareTo(key);
        if(cmp < 0)
            x.left = put(x.left, key, val);
        else if (cmp  > 0)     
            x.right = put(x.right, key, val);  
        else if (cmp == 0)
            x.val = val;
        return x;
    }
    public Node get(int key)
    {
        Node x = root;
        while (x != null)
        {
           int cmp = x.compareTo(key);
           if      (cmp  < 0) x = x.left;
           else if (cmp  > 0) x = x.right;
           else if (cmp == 0) 
               return x;
        }
        return null;
    }
    public void delete(int key)
    {  
        root = delete(root, key);  
    }
    private Node delete(Node x, int key) {
        if (x == null) 
            return null;
        int cmp = x.compareTo(key);
        if      (cmp < 0) x.left  = delete(x.left,  key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else { 
           if (x.right == null) return x.left;
           if (x.left  == null) return x.right;

           Node t = x;
           x = min(t.right);
           x.right = deleteMin(t.right);
           x.left = t.left;
        } 
        //x.count = size(x.left) + size(x.right) + 1;
        return x;
    } 
    private Node min(Node x)
    {
        while(x.left!=null)
            x=x.left;
        return x;
    }
    private Node deleteMin(Node y)
    {
       if (y.left == null) 
           return y.right;
       y.left = deleteMin(y.left);
       //x.count = 1 + size(x.left) + size(x.right);
       return y;
    }
    
    public String Inorder(Node x)
    {
        if(x == null) return "";
        else return "" + Inorder(x.left) + " " + x.key + " " +Inorder(x.right);
    }
 
 
}




/*

CLASS NODE

*/



class Node
{
    int key;
    int val;
    Node left, right;
    public Node(int key, int val)
    {
       this.key = key;
       this.val = val;
    }
   
    int compareTo(int key)
    {
        if(key < this.key)
            return -1;
        else if(key > this.key)
            return 1;
        else
            return 0;
    }
    public String toString()
    {
        return key + " " + val;
    }
}


public class Main
{

        public static void main(String [] args)
        {
            BST B = new BST();
            
            B.put(10, 100);
            B.put(3, 300);
            B.put(20, 200);
            B.put(18, 180);
            B.put(30, 300);
            B.put(15, 150);
            B.put(16, 160);
            B.put(17, 170);
            
            //System.out.println(B.get(30).val);
            B.delete(10);
            System.out.println(B.Inorder(B.root));
            
            //System.out.println(B.get(18));
            
        }
}
