package StackWithLinkedStructures;

// Basit Qureshi Oct 22, 2017 2:37:03 PM

public class Test 
{
    public static void main(String [] args)
    {
        
        Stack S = new Stack();
        S.Push(10);
        S.Push(20);
        S.Push(30);
        
        System.out.println(S.Top());
        
        S.Pop();
        System.out.println(S.Top());
        
        S.Pop();
        System.out.println(S.Top());
    }
}
