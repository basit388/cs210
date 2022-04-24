//Basit Qureshi
//April 2, 2020
//CS210

/*

TO DO: INCOMPLETE CODE. WRITE CODE TO COMPLETE

*/

public class SelectionSort 
{
    private static int [] A;
    private  boolean order;
    
    public void sort(int [] array, boolean order)
    {
        A = new int[array.length] ;
        readInput(array);

        this.order=order;
        
        int N = A.length;
        for (int i = 0; i < N; i++)
        {
            int min = i;
            for (int j = i+1; j < N; j++)
                if (less(A[j], A[min]))
                    min = j;
                swap(i, min);
        }  
        
        
        writeOutput(array);
    }
    
    private boolean less(int x, int y)
    {
        if(order) return x > y;
        return x < y;
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
