//Basit Qureshi
//April 2, 2020
//CS210



public class MergeSort 
{
    private static int [] A;
    private  boolean order;
    
    public void sort(int [] array, boolean order)
    {
        A = new int[array.length] ;
        readInput(array);
        this.order=order;
        
        int [] aux = new int [A.length];
        sort(A, aux, 0, A.length - 1);
        
        writeOutput(array);
    }
    
    
    private void sort(int[] a, int[] aux, int lo, int hi)
    {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        merge(a, aux, lo, mid, hi);
    }

    
    private void merge(int [] A, int [] aux, int lo, int mid, int hi)
    {
        for(int k=lo; k<=hi;k++)
            aux[k] = A[k];

        int i = lo, j = mid+1;
        for(int k=lo;k<=hi;k++)
        {
            if(i > mid)
                A[k] = aux[j++];
            else if (j > hi)
                A[k] = aux[i++];
            else if (less(aux[j], aux[i])) 
                A[k] = aux[j++];
            else  
                A[k] = aux[i++];
        }
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
