package AVL;

// Basit Qureshi Dec 4, 2016 8:29:59 PM

public class AVLNode
{
    public int value;
    public AVLNode left;
    public AVLNode right;
    public AVLNode parent;
    public int height;
    public AVLNode()
    {
        value = 0;
        height = 0;
        parent = left = right = null;
    }
    public AVLNode(int v,AVLNode p, AVLNode l, AVLNode r)
    {
        value = v;
        parent = p;
        left = l;
        right = r;
        height = 0;
    }
    
}
