package DoublyLinkedList;

// Basit Qureshi Feb 5, 2018 2:09:39 PM
 
public class Node 
{
    Node prev;
    Node next;
    int val;
    
    public Node()
    {
        prev = next = null;
        val = 0;
    }
    public Node(int val)
    {
        prev = next = null;
        this.val = val;
    }
    
}
