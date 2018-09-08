package QueueWithLinkedStructures;

// Basit Qureshi Oct 23, 2017 12:35:37 PM
 
public class Queue 
{
    int size;
    Node Top;
    Node Tail;
    public Queue()
    {
        size=0;
        Top=Tail=null;
    }
    public boolean isEmpty()
    {
        return Top==null;
    }
    public int Size()
    {
        return size;
    }
    public void enqueue(int val)
    {
        if(isEmpty())
        {
            Top = Tail = new Node(val);
            size++;
            return;
        }
        Tail.next = new Node(val);
        Tail = Tail.next;
        size++;
    }
    public int dequeue()
    {
        if(isEmpty())
        {
            System.out.println("Error: Empty");
            return -1;
        }
        int temp = Top.id;
        Top = Top.next;
        size--;
        return temp;
    }
    public int Top()
    {
        return Top!=null ? Top.id : -1;
    }
}
