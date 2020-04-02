//Basit Qureshi
//April 2, 2020
//CS210


public class HeapSort 
{
    private static int [] A;
    private  boolean order;
    private static int N;
    
    public void sort(int [] array, boolean order)
    {
        this.order = order;
        A = new int[array.length+1] ;
        N = 0;
        for(int i=0; i< array.length; i++)
            insert(array[i]);
        
        for(int i=0; i< array.length; i++)
            array[i]=delMax();
                
    }
    
    private boolean less(int i, int j)
    {
        if(order) return A[i] < A[j];
        return A[i] > A[j];
    }

    private void swim(int k)
    {
       while (k > 1 && less(k/2, k))
       {
          swap(k, k/2);
          k = k/2;
       }
    }

    public void insert(int x)
    {
       A[++N] = x;
       swim(N);
    }

    private void sink(int k)
    {
       while (2*k <= N)
       {
          int j = 2*k;
          if (j < N && less(j, j+1)) j++;
          if (!less(k, j)) break;
          swap(k, j);
          k = j;
       }
    }

    public int delMax()
    {
       int max = A[1];
       swap(1, N--);
       sink(1);
       return max;
    } 


    public static void swap(int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;       
    }
    

}