package Tutorial2;

// Basit Qureshi Jan 28, 2018 2:44:04 PM

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
            if(temp.id==v)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    public void insert(Node N)
    {
        //we always insert in the begining to reduce to overhead.
        if(head==null)
        {
            head = N;
            size++;
            return;
        }
        //head is not null
        //Node temp = new Node(v,head);
        
        N.next = head;
        
        head = N;
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
        if(head.id == v)
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
            if(temp.id==v)
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
            str = str + "["+temp.id+"]";
            temp = temp.next;
        }
        return str;
    }
    
    //Tutorial 2 Q5
    public void addMiddle(Node N)
    {
        int mid = (size-1)/2 ;
        Node temp = head;
        for(int i=0;i<mid;i++)
            temp=temp.next;
        
        N.next=temp.next;
        temp.next=N;
        
    }

    //Tutorial 2 Q6
    public Node findID(int v)
    {
        Node temp = head;
        while(temp!=null)
        {
            if(temp.id==v)
                return temp;
            temp = temp.next;
        }
        return null;
    }    
    
    //Tutorial 2 Q7
    public void bringToFirst(int v) 
    {
        Node temp = head;
        Node Prev = null;
        while(temp.next!=null)
        {
            if(temp.id==v)
                break;
            Prev = temp;
            temp=temp.next;
        }
        
        //detach temp from the list;
        Prev.next=temp.next;
        temp.next=head;
        head=temp;

    }
}
