/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tutorial3;

import DoublyLinkedList.DoublyLinkedList;
import SinglyLinkedList.Node;
import SinglyLinkedList.SingleLinkedList;

public class T3 
{
    
    public int Q1(SingleLinkedList S)
    {
        int count =0;
        Node temp = S.head;
        
        while(temp!=null)
        {
            count++;
            temp=temp.next;
        }
        return count;
    }
    
    public void Q2a(SingleLinkedList S)
    {
        Node First = S.head;
        
        S.head=S.head.next;
        
        Node Last = S.head;
        while(Last.next!=null)
            Last=Last.next;
        
        Last.next = First;
        First.next=null;
        
        
    
    }
    
    
    
    public void Q2(SingleLinkedList S)
    {
        //addLast and removeFirst;
        
        //Lets identify the first node 
        Node First = S.head;
        
        //Lets identify the Node before the Last node 

        Node beforeTheLastNode = S.head;
        while(beforeTheLastNode.next!=null)
            beforeTheLastNode=beforeTheLastNode.next;
        
        //when this loop terminates, the beforeTheLastNode is pointing at the node before the last
        
        //lets identify the Last node;
        Node Last = beforeTheLastNode.next;
        
        //remove the Last node;
        beforeTheLastNode.next = null;
        
        //Attach the Last node to be the new head;
        Last.next = S.head.next;
        S.head = Last;
        
        //re-attach the First to the end of the list;
        First.next = null;
        beforeTheLastNode.next = First;
        return;
        
    }
    
    public DoublyLinkedList Q3(DoublyLinkedList L, DoublyLinkedList M)
    {
        DoublyLinkedList N = new DoublyLinkedList();
        //Note: Concat will destroy the L and M;
        
        //connect the tail and head of L and M
        L.Tail.next = M.Head;
        M.Head.prev = L.Tail;
        
        //adjust the new head and tail
        N.Head = L.Head;
        N.Tail = M.Tail;
        
        //set the size
        N.size = L.size + M.size;
        
        return N;
        
    }
    

    
    
    
    
    
    
}
