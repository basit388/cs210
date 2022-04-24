//Basit Qureshi
//April 2, 2020
//CS210



public class InsertionSort 
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
            for (int j = i; j > 0; j--)
                if (less(A[j], A[j-1]))
                    swap(j, j-1);
                else 
                    break;
        
        
        
        writeOutput(array);
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
