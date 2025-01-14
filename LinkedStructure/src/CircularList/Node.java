package CircularList;

// Basit Qureshi Feb 6, 2018 2:24:43 PM
 
public class Node 
{
    public int val;
    public Node next;
    public Node prev;
    
    public Node()
    {
        val=0;
        next=prev=null;
    }
    public Node(int v)
    {
        val = v;
        next = prev=null;
    }
}
