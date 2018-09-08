package SinglyLinkedList;

// Basit Qureshi Jan 30, 2018 1:19:10 PM
 
public class Tester 
{
    public static void main(String [] s)
    {
        SingleLinkedList L = new SingleLinkedList();
        
        L.insert(10);
        L.insert(20);
        L.insert(30);
        L.insert(40);

        System.out.println(L);
        
        System.out.println(L.search(40).val);
        
        L.remove(20);
        System.out.println(L);

        
        
    }
}
