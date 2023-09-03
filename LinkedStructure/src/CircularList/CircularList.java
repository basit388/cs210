package CircularList;

// Basit Qureshi Feb 6, 2018 2:25:32 PM
 
public class CircularList 
{
    public int size;
    public Node Cursor;
    
    public CircularList()
    {
        size =0;
        Cursor = null;
    }
    public boolean isEmpty()
    {
        return size==0;
    }
    
    public void insert(int x)
    {
        Node N= new Node(x);
        if(size==0)
        {
            Cursor = N;
            Cursor.next = Cursor;

        }
        else if(size==1)
        {
            
            N.next = Cursor;
            Cursor.next = N;
        }
        else
        {
            N.next = Cursor.next;
            Cursor.next = N;
        } 
        size++;
        return; 
    }
    public Node search(int x)
    {
        if(size==0)
            return null;
        for(int i=0;i<size;i++)
        {
            if(Cursor.val == x)
                return Cursor;
            Cursor = Cursor.next;
        }
        return null;
    }
    
    public boolean remove(int x)
    {
        if(size==0)
            return false;
        
        for(int i=0;i<size;i++)
        {
            if(Cursor.next.val==x)
            {
                Cursor.next = Cursor.next.next;
                size--;
                return true;
            }
            Cursor = Cursor.next;
        }
        //1. either Cursor is behind the search value
        //2. we failed to find x
       
        return false;
    
    }
    public String toString()
    {
        String str = "";
        for(int i=0;i<size;i++)
        {
            str = str + "[" +Cursor.val+ "]";
            Cursor = Cursor.next;
        }
        return str;
    }
    
}
