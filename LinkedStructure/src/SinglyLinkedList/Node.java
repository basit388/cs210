package SinglyLinkedList;

// Basit Qureshi Jan 28, 2018 2:42:23 PM
 
public class Node 
{
    public int key;
    public Node next;
    
    public Node()
    {
        key=0;
        next = null;
    }
    public Node(int v, Node n)
    {
        key = v;
        next = n;
    }
}
