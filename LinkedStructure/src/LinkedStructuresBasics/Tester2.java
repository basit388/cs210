package LinkedStructuresBasics;

// Basit Qureshi Jan 28, 2018 2:07:16 PM
 
public class Tester2 
{
    public static void main(String [] args)
    {
        int x = 10;
        System.out.println(x);
        
        int [] A = new int[10];
        System.out.println(A);
        
        Node N = new Node();
        System.out.println(N);
        
        N.name = "Ahmed";
        N.age = 20;
        N.next = null;
        
        System.out.println(N);
        
        
        Node M = new Node("Ali", 22, null);
        
        Node P = N;
        System.out.println(P);
        System.out.println(N);
     
        Node Q = M;
        System.out.println(Q);
        System.out.println(M);
        
        Q.name = "Saleh";
        
        System.out.println(Q);
        System.out.println(M);
        
        System.out.println(Q.name);
        System.out.println(M.name);
        
        Node X = new Node("John",40, null);
        
        
        N.next = M;
        M.next = X;
        
        System.out.println(N.name);
        System.out.println(N.next.name);
        System.out.println(N.next.next.name);
        
        
    }
}
