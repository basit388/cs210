package LinkedStructuresBasics;

// Basit Qureshi Sep 9, 2018 2:38:37 PM
 
public class Chain1 
{
    public static void main(String [] Baraa)
    {
        Node temp, head;
        head = new Node("head", 1, null);
        head.next = new Node("str2",2,null);
        head.next.next = new Node("str3", 3, null);
        
        
        
        
        
        
        
        
        
        
        
        
        head = new Node("str10",10,null);
        
        for(int i=9;i>=1;i--)
        {
            temp = new Node("str"+i, i, head);
            head = temp;
        }
        
        
        
    }
}
