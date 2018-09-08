package QueueWithArrays;

// Basit Qureshi Oct 23, 2017 12:32:57 PM
 
public class Queue 
{
    int [] A;
    int size;
    int top;
    public Queue(int maxSize)
    {
        size=0;
        top=0;
        A = new int[maxSize];
    }
    public boolean isEmpty()
    {
        return size==0;
    }
    public int Size()
    {
        return size;
    }
    public void enqueue(int E)
    {
        if(size>=A.length-1)
        {
            System.out.println("Error: Full");
            return;
        }
        int pos = (top + size) % A.length;
        A[pos]=E;
        size++;
    }
    public int dequeue()
    {
        if(isEmpty())
        {
            System.out.println("Error: Empty");
            return -1;
        }
        int temp = A[top];
        top = (top + 1)%A.length;
        size--;
        return temp;
    }
    public int Top()
    {
        return A[top];
    }
}
