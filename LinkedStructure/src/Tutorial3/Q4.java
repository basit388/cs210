/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tutorial3;

import DoublyLinkedList.DoublyLinkedList;
import DoublyLinkedList.Node;

public class Q4 {
       
    
    public void swap(Node x, Node y)
    {
        
        
        // Note: we have to be careful with this swap method
        
        // do nothing if either of the Nodes is null
        if(x==null || y==null)
            return;
        
        // do nothing if x is a head
        if(x.prev == null)
            return;
        
        // do nothing if y is a tail
        if(y.next==null)
            return;

        //we need to treat the head and tail as special cases.
        
        
        /*Assume you have a long DLL with many nodes; x and y are some nodes 
        in the middle of the list. We need to find the Predecessor and 
        Successor of x and y
        */
        
        Node Px = x.prev;
        Node Sx = x.next;
        
        Node Py = y.prev;
        Node Sy = y.next;
        
        //remove x from list
        Px.next = y;
        Sx.prev = y;
        y.next = Sx;
        y.prev = Px;
        
        Py.next = x;
        Sy.prev = x;
        x.next = Sy;
        x.prev = Py;
        
        
    } 
    
    public void Q5(DoublyLinkedList L)
    {
        
        //the following is an algorithm
        Node x = L.Head;
        Node y = L.Tail;
        
        for(int i=0; i<L.size / 2;i++)
        {
            
            swap(x,y);
            
            
        }
        
        
    }
}
