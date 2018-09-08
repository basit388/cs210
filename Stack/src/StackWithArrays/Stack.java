package StackWithArrays;

// Basit Qureshi Oct 22, 2017 2:30:24 PM
 
public class Stack 
{
    int size;
    int top;
    int [] A;
    public Stack(int maxSize)
    {
        A = new int [maxSize];
        size =0;
        top = 0;
    }
    public void Push(int id)
    {
        if(size >=A.length)
        {
           //error
            return;
        }
        A[top++]= id;
       // top++;
        size++;
    }
    public int Pop()
    {
        if(isEmpty())
        {
            //error
            return -1;
        }
        top--;
        size--;
        return A[top];
    }
    public int Top()
    {
        return A[top-1];
    }
    public boolean isEmpty()
    {
        return size==0;
    }
    public int size()
    {
        return size;
    }
}
