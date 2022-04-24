
import java.util.Random;

//Basit Qureshi
//April 2, 2020
//CS210



public class QuickSort 
{
    private static int [] A;
    private  boolean order;
    
    public void sort(int [] array, boolean order)
    {
        A = new int[array.length] ;
        readInput(array);

        this.order=order;
        
        // Shuffle array
        
        Random rgen = new Random();  // Random number generator			
 
        for (int i=0; i<A.length; i++) 
        {
            int randomPosition = rgen.nextInt(A.length);
            swap(i,randomPosition);
        }
        
        sort(A, 0, A.length - 1);
        
        writeOutput(array);
    }
    
   private void sort(int[] a, int lo, int hi)
   {
      if (hi <= lo) return;
      int j = partition(a, lo, hi);
      sort(a, lo, j-1);
      sort(a, j+1, hi);
  }

    
    
    
    
    private int partition(int[] a, int lo, int hi)
    {
        int i = lo, j = hi+1;
        while (true)
        {
            while (less(a[++i], a[lo]))
                if (i == hi) 
                    break;

            while (less(a[lo], a[--j]))
                if (j == lo) 
                    break;
     
            if (i >= j) 
                break;
            swap(i, j);
        }

        swap(lo, j);
        return j;
    } 
    
    
    
    
    
    
    
    
    private boolean less(int x, int y)
    {
        if(order) return x < y;
        return x > y;
    }
    
    private void swap(int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;       
    }
    
    private void readInput(int [] array)
    {
        for(int i=0; i< array.length; i++)
            A[i]=array[i];
    }
    private void writeOutput(int [] array)
    {
        for(int i=0; i< array.length; i++)
            array[i]=A[i];
    }    
    
    
}
