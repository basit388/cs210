package BSTree;

// Basit Qureshi Mar 22, 2017 2:07:04 PM
 
public class Node 
{
    int id;
    Node left;
    Node right;
    Node parent;
    public Node()
    {
        id=0;
        left=right=parent=null;
    }
    public Node(int id)
    {
        this.id=id;
        left=right=parent=null;

    }
}
