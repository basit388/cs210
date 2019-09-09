package SinglyLinkedList;

// Basit Qureshi Jan 28, 2018 2:44:04 PM
 
public class SingleLinkedList 
{
    Node head;
    int size;
    
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
        Node temp = head;
        while(temp!=null)
        {
            if(temp.val==v)
                return temp;
            temp = temp.next;
        }
        return null;
    }
    
    
    
    
    
    
    
    public void insert(int v)
    {
        //we always insert in the begining to reduce to overhead.
        if(head==null)
        {
            head = new Node(v,null);
            size++;
            return;
        }
        //head is not null
        //Node temp = new Node(v,head);
        
        Node temp = new Node();
        temp.val=v;
        temp.next = head;
        
        head = temp;
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
        if(head.val == v)
        {
            head = head.next;
            size--;
            return true;
        }
        
        //2. if node is somewhere inside the list
        //we use a prev reference to point to a node that occurs before the temp
        
        Node prev = head;
        Node temp = head.next;
        while(temp!=null)
        {
            if(temp.val==v)
            {
                //we found it!
                prev.next = temp.next;
                size--;
                return true;
            }
            prev = temp;
            temp = temp.next;
            
        }
        // At this time we can assert that we failed to find v in the list
        return false;
        
    }
    
    public String toString()
    {
        String str = "";
        Node temp = head;
        while(temp!=null)
        {
            str = str + "["+temp.val+"]";
            temp = temp.next;
        }
        return str;
    }
    
}
