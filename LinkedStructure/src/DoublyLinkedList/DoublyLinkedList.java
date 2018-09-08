package DoublyLinkedList;

// Basit Qureshi Feb 5, 2018 2:11:09 PM
 
public class DoublyLinkedList 
{
    Node Head;
    Node Tail;
    int size;
    public DoublyLinkedList()
    {
        Head = Tail = null;
        size = 0;
    }
    public boolean isEmpty()
    {
        return size==0;
    }
    public String toString()
    {
        String str = "";
        Node temp = Head;
        while(temp!=null)
        {
            str = str + "[" + temp.val + "]";
            temp = temp.next;
        }
        return str;
    }
    //search
    public Node search(int x)
    {
        Node temp = Head;
        while(temp!=null)
        {
            if(temp.val == x)
            {
                break;
            }
            temp = temp.next;
        }
        return temp;
    }
    
    //insert
    public void insert(int x)
    {
        Node N = new Node(x);
        
        if(isEmpty())
        {
            Head = Tail = N;
            size++;
            return;
        }
        
        //assertion -> List is not empty;
        //we always insert in the begining
        
        //prepare the N
        N.prev = null;
        N.next = Head;
        
        Head.prev = N;
        Head = N;
        size++;
        return;
    }

    //remove
    public boolean remove(int x)
    {
        if(isEmpty())
            return false;
        //assert -> List is not empty
        
        Node temp = Head;
        while(temp != null)
        {
            if(temp.val == x)
                break;
            temp = temp.next;
        }
        //assertion-> now temp is either null or points to a node with x
        
        if(temp == null)// didnt find it!
            return false;
        
        //three scenarios
        //1. BEGINING: if node with x is the head
        
        if(Head == temp)
        {
            Head = Head.next;
            Head.prev = null;
            
        }
        
        //2. End: if node with x is the tail
        else if(Tail == temp)
        {
            Tail = Tail.prev;
            Tail.next = null;
           
        }
        //3. Middle
        else
        {
            temp.next.prev = temp.prev;
            temp.prev.next = temp.next;
            
            
        }
        size--;
        return true;
        
    }
    
    
    
}
