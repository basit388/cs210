package LinkedStructuresBasics;

// Basit Qureshi Jan 23, 2018 2:05:45 PM
 
public class Node  
{
    public String name;
    public int age;  
    public Node next;
    
    public Node()
    {
        name = "";
        age=0;
        next = null;
    }
    public Node(String n, int age, Node next)
    {
        name = n;
        this.age = age;
        this.next = next;
    }
    
    
}
