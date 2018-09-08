package QueueWithArrays;

// Basit Qureshi Oct 23, 2017 12:32:57 PM
 
public class Test 
{
    public static void main(String [] s)
    {
        Queue Q = new Queue(5);
        System.out.println(Q.isEmpty());
        Q.enqueue(3);
        Q.enqueue(5);
        System.out.println(Q.Top());
        Q.enqueue(10);
        Q.dequeue();
        Q.enqueue(20);
        System.out.println(Q.Top());
        Q.enqueue(30);




    }
}
