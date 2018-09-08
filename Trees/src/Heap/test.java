package Heap;

// Basit Qureshi Nov 20, 2017 1:55:03 PM
 
public class test 
{
    public static void main(String [] args)
    {
        
        BinaryHeap B = new BinaryHeap(10);
        
        B.insert(10);
        B.insert(5);
        B.insert(2);
        
        B.insert(7);
        B.insert(9);
        B.insert(11);
        
        B.insert(15);
        B.insert(20);
        B.insert(17);
        
        //Lets use a loop to empty the Heap and print the values
        //we discover that all values printed are sorted!
        
        while(!B.isEmpty())
            System.out.println(B.remove());
        
    }
}
