package StackWithLinkedStructures;

// Basit Qureshi Oct 22, 2017 3:37:43 PM
 
public class Stack 
{
    int size;
    Node top;
    public Stack()
    {
        size=0;
        top = null;
    }
    public boolean isEmpty()
    {
        return top==null;
    }
    public int size()
    {
        return size;
    }
    public void Push(int x)
    {
        Node temp = new Node(x);
        temp.next = top;
        top = temp;
        size++;
        
        // no need to worry about max Size limit
    }
    public int Top()
    {
        if(top==null)
            return -1;
        return top.id;
        
    }
    public int Pop()
    {
        if(isEmpty())
            return -1;
        int val = top.id;
        top = top.next;
        return val;
    }
}
