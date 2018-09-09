package LinkedStructuresBasics;

// Basit Qureshi Jan 23, 2018 2:25:15 PM
 
public class Link2 
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
        //System.out.println(obj1.next.next.name);
        
        Node obj3 = new Node();
        obj3.name= "Saleh";
        obj3.age = 23;
        
        obj2.next = obj3;
        
        //obj1.next = obj3;
        
        
        Node temp = obj1;
        while(temp!=null)
        {
            System.out.println(temp.name);
            temp = temp.next;
        }
        
        
        //System.out.println("");
        
        
    }
}
