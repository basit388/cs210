package Tutorial2;

// Basit Qureshi Jan 30, 2018 1:19:10 PM

import java.util.Arrays;

public class Tester 
{
    public static void main(String [] s)
    {
        //Q1
        String [] Duplicate = Q1(new String [] {"abc","def","ghi"});
        System.out.println(Arrays.toString(Duplicate));
        
        
        //Q2
        Node N1=new Node();
        N1.id = 111;
        N1.Name = "Mohammad";
        N1.GPA = 3.0;
        N1.next = null;
        
        Node N2=new Node();
        N2.id = 222;
        N2.Name = "Ahmed";
        N2.GPA = 3.3;
        N2.next = null;
        
        Node N3=new Node();
        N3.id = 333;
        N3.Name = "Ali";
        N3.GPA = 3.5;
        N3.next = null;               
        
        N1.next = N2;
        N2.next = N3;
        
        //Q3
        //assuming the same list from Q2; lets set N1 to be the head of this list
        Node Head = N1;
        Node find = Q3(Head);
        
        //Q4
        Node N4 = new Node();
        N4.id = 444;
        N4.Name = "Saleh";
        N4.GPA = 3.7;
        N4.next = null; 

        //adding it before N1
        N4.next=N1;
        Head = N4;
        
        //Q5 
        //refer to addMiddle Method in class SinglyLinkedList
        
        
        //Q6
        //refer to findID Method in class SinglyLinkedList
        
        
        //Q7
        //refer to bringToFirst Method in class SinglyLinkedList        

    }
    
    public static String [] Q1(String [] S)
    {
        String [] D = new String [S.length];
        for(int i=0;i<S.length;i++)
            D[i]=S[i];
        return D;
    }
    
    public static Node Q3(Node Head)
    {
        Node iterator = Head;
        Node Prev = null;
        while(iterator.next!=null)
        {
            Prev = iterator;
            iterator=iterator.next;
        }
        return Prev;
    }    
}
