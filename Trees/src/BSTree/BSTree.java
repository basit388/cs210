package BSTree;

// Basit Qureshi Mar 22, 2017 2:09:28 PM
// Basit Qureshi Nov 07, 2017 1:11:23 PM
 
public class BSTree 
{
    Node Root;
    int size; // number of nodes
    public BSTree()
    {
        Root = null;
        size=0;
    }
    public void insert(int val)
    {
        //N.left=N.right=N.parent=null;
        Node N = new Node(val);
        if(Root==null)
        {
            size++;
            Root = N;
            
            return;
        }
        //search tree to make sure it N exists
        
        Node temp = Root;
        while(true)
        {
            if(N.id > temp.id)
            {
                //go right
                if(temp.right==null)
                {
                    //insert N;
                    temp.right = N;
                    N.parent = temp;
                    break;
                }
                temp = temp.right;
            }
            else
            {
                //go left!
                if(temp.left==null)
                {
                    //insert N;
                    temp.left = N;
                    N.parent = temp;
                    break;
                }
                temp = temp.left;
            } 
        }
        size++;
        return;
    }
    
    public Node search(int id)
    {
        Node temp = Root;
        if(temp==null)
            return null;
        if(temp.id==id)
            return temp;
        while(true)
        {
            if(id > temp.id)
            {
                //go right
                if(temp.right==null)
                    return null;
                temp = temp.right;      
            }
            else if(id < temp.id)
            {
                //go left
                if(temp.left==null)
                    return null;
                temp = temp.left;
            }
            else //found it!
            {
                return temp;
            }
                   
        }
        
    }
    
    public String PreOrder()
    {
        //bad code... doesnt work!
        //scroll down for a more efficient code
        String Str = "";
        Node temp = Root;
        if(temp==null)
            return "";
        while(true)
        {
            Str = Str + " " +temp.id;
            if(temp.left!=null)
                temp = temp.left;
            else if(temp.right!=null)
                temp = temp.right;
            else if(temp.left==null && temp.right== null)
                temp = temp.parent;
                
        }
        //return Str;
        
        
    }
    
    
    public String PreOrder(Node temp)
    {
        if(temp==null)
            return "";
        else
            return temp.id + " " + PreOrder(temp.left) + PreOrder(temp.right);
    }
    public String InOrder(Node temp)
    {
        if(temp==null)
            return "";
        else
            return InOrder(temp.left) + " " +temp.id+" "+InOrder(temp.right);
    }
    public String PostOrder(Node temp)
    {
        if(temp==null)
            return "";
        else
            return PostOrder(temp.left) + PostOrder(temp.right)+ " " +temp.id;
    
    }
    
    public boolean remove(int key)
    {
        if(Root ==null)
        {
            return false;
        }
        Node find = search(key); //using search
        if(find==null)
        {
            //didnt find it!
            return false;
        }
        else if (find == Root)
        {
            //if find is the root.
            
            //if find has no children
            if(find.left==null && find.right==null)
            {
                Root=null;
                return true;
            }
            else if ((find.left!=null && find.right==null) ||
                    (find.left==null && find.right!=null))
            {
                // if find is the root and has 1 child
                // this child becomes the new Root;
                if(Root.left==null)
                    Root = Root.right;
                else
                    Root = Root.left;
                Root.parent=null;
            }
            //else both children exist.
            else
            {
                // we have to find a candidate node that will serve as new root
                // candidate is smallest valued node on the right of existing root
                
                // we will update this code later!!!
                
            }
            
        }
        
        //we found the node to be removed!
        //there are 3 cases
        // case 0: no child
        // case 1: 1 child
        // case 2: 2 children
        
        
        //case 0; no child
        if(find.left==null && find.right==null)
        {
            //check if find is the right or left child!
            if(find.parent.left==find)
                find.parent.left=null;
            else
                find.parent.right=null;
            find=null;
            size--;
            return true;  
        }
        //case 1: 
        else if((find.left==null && find.right!=null) ||
                (find.left!=null && find.right==null))
        {
            //Node child = find.right==null?find.left:find.right;
            Node child;
            if(find.right==null)
                child = find.left;
            else
                child = find.right;
            
            if(find.parent.left==find)//find is the left child
            {
                find.parent.left= child;  
            }
            else
            {
                find.parent.right=child;
            }
            child.parent=find.parent;
            find = null;
            size--;
            return true;
        }
        //two children
        else
        {
            //candidate is a reference to the best candiate. In this case 
            //the smallest valued node on the right of find
            
            //we have 3 scenarios...
            //1. the candidate IS the right child of find.. 
            //2. the candidate is a grand child (at any depth) of the right child. Candidate has NO children
            //3. the candidate is a grand child (at any depth) of the right child. Candidate has a right children
            
            //lets find the candidate
            Node candidate = find.right;
            while(candidate.left!=null)
                candidate = candidate.left;
            
            // we need to check which scenario applies
            //scenario 1
            if(find.right==candidate)
            {
                candidate.left=find.left;
                find.left.parent = candidate;
                candidate.parent = find.parent;
                
                //now re-assign candidate (as a child) to the parent of find
                if(find.parent.right==find)
                    candidate.parent.right= candidate;
                else
                    candidate.parent.left=candidate;
            }
            
            //scenario 2. check if candiate has no children
            else if(candidate.right==null)
            {
                //candidate has no child
                //readjust candidate's environment
                candidate.parent.left=null; // detach candidate
                
                //copy find's children and parent to candidate
                candidate.left=find.left;
                candidate.right=find.right;
                candidate.parent=find.parent;
                
                //now re-attached find.parent to candidate. we have to figure out
                //if find was the left or right child!
                if(candidate.parent.left==find)
                    find.parent.left=candidate;
                else
                    find.parent.right=candidate;
                
                find=null;
            }
            else
            {
                //here candidate obviously has a right child!!
                //scenario 3!!
                
                // Strategy: 2 steps
                // step 1. remove node candidate from the tree... lets use case 1 of the remove
                // step 2. re-attach candidate in the appropriate position
                
                //temporarily store candidate in a new node temp
                Node temp = new Node(candidate.id);
                
                //remove candidate from tree
                remove(candidate.id);
                
                //re-attach left and right children of find to temp
                temp.left = find.left;
                temp.right=find.right;
                
                //reattach temp to appropriate parent.left or .right
                if(find.parent.right==find)
                    temp.parent.right= temp;
                else
                    temp.parent.left=temp;
       
            }
            size--;
            return true; 
        }
    }
}
