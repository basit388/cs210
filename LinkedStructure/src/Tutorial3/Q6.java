/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tutorial3;

import CircularList.CircularList;
import CircularList.Node;

/**
 *
 * @author basit
 */
public class Q6 
{
    public CircularList Duplicate(CircularList C1)
    {
        CircularList C2 = new CircularList();
        
        for(int i=1; i < C1.size; i++)
        {
            int x = C1.Cursor.val;
            C2.insert(x);
        }
        return C2;
  
    }
    
    
    
    public int Q7(CircularList C, int s)
    {
        //find the min;
        int min = C.Cursor.val;
        for(int i=1;i<C.size;i++)
        {
            if(min > C.Cursor.val)
                min = C.Cursor.val;
            C.Cursor=C.Cursor.next;
        }
        C.remove(min);
        return min;
    }
    
    
    
    
    public void Q7(CircularList C)
    {
        //find the max;
        int s = C.size;
        for(int i=1; i<s; i++)
            System.out.println(Q7(C,s));
        
        
    }    
    
}
