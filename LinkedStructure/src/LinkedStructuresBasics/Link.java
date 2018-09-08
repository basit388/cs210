package LinkedStructuresBasics;

// Basit Qureshi Jan 23, 2018 2:25:15 PM
 
public class Link 
{
    public static void main(String [] s)
    {
        Node obj1 = new Node(); // 36 bytes
        
        obj1.name = "Ahmed";
        obj1.age = 20;
        
        Node obj2 = new Node();
        obj2.name = "Ali";
        obj2.age = 22;
        
        obj1.next = obj2;
        
        obj1.next.name = "Saleh";
        
        System.out.println("");
        
        
    }
}
