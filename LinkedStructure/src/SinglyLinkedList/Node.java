package SinglyLinkedList;

// Basit Qureshi Jan 28, 2018 2:42:23 PM
 
public class Node 
{
    public int val;
    public Node next;
    
    public Node()
    {
        val=0;
        next = null;
    }
    public Node(int v, Node n)
    {
        val = v;
        next = n;
    }
}
