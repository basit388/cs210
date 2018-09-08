package LinkedStructuresBasics;

// Basit Qureshi Jan 28, 2018 2:35:57 PM
 
public class intro1 
{
    public static void main(String [] s)
    {
        
        
        int [] A = {1,2,3};
        //add a fourth element!!!
        //no possible
        //solution: Make a duplicate copy with +1 size
        
        int [] B = new int [A.length + 1];
        for(int i=0;i<A.length;i++)
        {
            B[i] = A[i];
        }
        
        //takes a lot of time...
        //imagine if 1 copy opeartion takes 1 sec
        // this will take 3 secs
        // LINEAR TIME
        
        
    }
}
