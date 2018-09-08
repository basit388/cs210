package DoublyLinkedList;

// Basit Qureshi Feb 5, 2018 2:34:36 PM
 
public class Tester 
{
    public static void main(String [] s)
    {
        DoublyLinkedList DL = new DoublyLinkedList();
        
        DL.insert(10);
        DL.insert(20);
        DL.insert(30);
        DL.insert(40);
        System.out.println(DL.toString());
        
        DL.remove(20);
        
        System.out.println(DL);
        
        System.out.println(DL.search(10));
    }
}
