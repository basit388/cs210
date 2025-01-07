package SinglyLinkedList;

// Basit Qureshi Jan 28, 2018 2:44:04 PM
// updated March 2024

public class SingleLinkedList 
{
    public Node head;
    public int size;
    
    public SingleLinkedList()
    {
        head = null;
        size = 0;
    }
    
    public boolean isEmpty()
    {
        return size==0;
    }
    
    public Node search(int v)
    {
        Node itr = head;
        while(itr!=null)
        {
            if(itr.key==v)
                return itr;
            itr = itr.next;
        }
        return null;
    }
    
       
    public void insert(int v)
    {
        //it is cheaper to insert in the begining
        //check if the list is empty
        if(head==null)
        {
            head = new Node(v,null);
            size++;
            return;
        }
        
        //assert: head is not null, so list is not empty
        //create a new node
        Node N = new Node();
        N.key = v;
        N.next = head;
        
        head = N;
        size++;
        return;
    }
    public void insertEnd(int v)
    {
        //check if the list is empty
        if(head==null)
        {
            head = new Node(v,null);
            size++;
            return;
        }
        
        //create a new node
        Node N = new Node();
        N.key = v;
        N.next = null;
        
        //we iterate to the end of the list
        Node itr = head;
        while(itr.next!=null)
            itr = itr.next;
        
        //point the lastnode.next to the new node N
        itr.next= N;
        
        size++;
        return;
    }

    
    public boolean remove(int v)
    {
        //check if list is empty
        if(head==null)
            return false;
        
        //now we may have two cases
        //1. if node with v happens to be the head
        if(head.key == v)
        {
            head = head.next;
            size--;
            return true;
        }
        
        //2. if node is somewhere inside the list
        //we use a before reference to point to a node that occurs before the temp
        
        Node before = head;
        Node itr = head.next;
        while(itr!=null)
        {
            if(itr.key==v)
            {
                //we found it!
                before.next = itr.next;
                size--;
                return true;
            }
            before = itr;
            itr = itr.next;
            
        }
        // At this time we can assert that we failed to find v in the list
        return false;
        
    }
    
    public String toString()
    {
        String str = "";
        Node itr = head;
        while(itr!=null)
        {
            str = str + "["+itr.key+"]";
            itr = itr.next;
        }
        return str;
    }
    
}
