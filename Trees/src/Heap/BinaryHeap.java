package Heap;

// Basit Qureshi Nov 20, 2017 1:46:04 PM
 
public class BinaryHeap 
{
    public int [] B;
    public int size;
    
    public BinaryHeap(int capacity)
    {
        B = new int [capacity];
        size = 0;
    }
    
    public boolean isEmpty()
    {
        return size==0;
    }
    
    public void swim(int k)
    {
        while(k>1 && B[k/2] < B[k])
        {
            int temp = B[k];
            B[k] = B [k/2];
            B[k/2] = temp;
            k = k/2;
        }
    }
    
    public void sink(int k)
    {
        while(2*k <= size)
        {
            int j = 2 * k;
            if(j < size && B[j] < B[j+1])
                j++;
            if(B[k] < B[j])
                break;
            
            int temp = B[k];
            B[k] = B[j];
            B[j] = temp;
            
            k = j;
        }
    }
    public void insert(int x)
    {
        B[++size] = x;
        swim(size);
    }
    
    public int remove()
    {
        int ret = B[1];
        
        B[1] = B[size--];
        B[size] = ret;
        sink(1);
        return ret;
    }
}
