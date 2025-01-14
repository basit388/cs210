package CircularList;

// Basit Qureshi Feb 6, 2018 2:25:32 PM
 
public class CircularList 
{
    public int size;
    public Node Cursor;
    
    public CircularList()
    {
        size = 0;
        Cursor = null;
    }
    public boolean isEmpty()
    {
        return size==0;
    }
    
    public void insert(int x)
    {
        Node N = new Node(x);
        if(size==0)
        {
            Cursor = N;
            Cursor.next = Cursor;
            Cursor.prev = Cursor;

        }
        else if(size==1)
        {
            
            N.next = Cursor;
            N.prev = Cursor;
            Cursor.next = N;
            Cursor.prev = N;
        }
        else
        {
            N.next = Cursor.next;
            N.prev = Cursor;
            Cursor.next = N;
            N.next.prev = N;
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
    
    public Node remove(int x)
    {
        if(size==0)
            return null;
        
        for(int i=0;i<size;i++)
        {
            if(Cursor.val==x)
            {
                Node Before = Cursor.prev;
                Node After = Cursor.next;
                Before.next = After;
                After.prev = Before;
                
                Node toDelete = Cursor;
                //reset cursor
                Cursor = After;
                size--;
                return toDelete;
            }
            Cursor = Cursor.next;
        }
       
        return null;
    
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
