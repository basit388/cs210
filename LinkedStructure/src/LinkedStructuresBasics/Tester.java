package LinkedStructuresBasics;

// Basit Qureshi Jan 23, 2018 2:08:02 PM
 
public class Tester 
{
    public static void main(String [] s)
    {
        int x;
        x = 10;
        
        
        Node obj1; //8 bytes for the reference
        obj1 = new Node();//28 bytes
        
        //Node obj3 = new Node("Ahmed", 18, null);
        obj1.name = "Ali";
        obj1.age = 20;
        
        Node obj2;
        obj2 = obj1;
        
        obj2.name = "Ahmed";
        
        
        Node obj3 = obj2;
        obj3 = new Node();
        obj3.name = obj2.name;
        obj3.age = obj1.age;
        
        
        
        
    }
}
