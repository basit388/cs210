package BST;

public class BST {
    Node root;
    int size;
    public BST(){
        root = null;
        size = 0;
    }
    public void insert(int key, int val)
    {  
        root = insert(root, key, val);  
    }
    public Node insert(Node x, int key, int val)
    {
        if (x == null) 
            return new Node(key, val);
        int cmp = x.compareTo(key);
        if(cmp < 0)
            x.left = insert(x.left, key, val);
        else if (cmp  > 0)     
            x.right = insert(x.right, key, val);  
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
    public void remove(int key)
    {  
        root = remove(root, key);  
    }
    private Node remove(Node x, int key) {
        if (x == null) 
            return null;
        int cmp = x.compareTo(key);
        if      (cmp < 0) x.left  = remove(x.left,  key);
        else if (cmp > 0) x.right = remove(x.right, key);
        else { 
           if (x.right == null) return x.left;
           if (x.left  == null) return x.right;

           Node t = x;
           x = min(t.right);
           x.right = removeMin(t.right);
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
    private Node removeMin(Node y)
    {
       if (y.left == null) 
           return y.right;
       y.left = removeMin(y.left);
       //x.count = 1 + size(x.left) + size(x.right);
       return y;
    }
    
    public String Inorder(Node x)
    {
        if(x == null) return "";
        else return "" + Inorder(x.left) + " " + x.key + " " +Inorder(x.right);
    }
}
