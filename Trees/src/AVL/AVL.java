package AVL;

// Basit Qureshi Dec 4, 2016 8:31:54 PM
 
public class AVL 
{
    public AVLNode root;
    public int size;
    public AVL()
    {
        size = 0;
        root = null;
    }
    public AVLNode search(int key)
    {
        AVLNode temp = root;
        while(temp!=null)
        {
            if(key < temp.value )
            {
                // go left
                temp = temp.left;
            }
            else if (key > temp.value)
            {
                // go right
                temp = temp.right;
            }
            else // is equal
            {
                //stop and replace the value
                break;
            }
        }
        return temp;
    }
    
    public boolean insert(int key)
    {        
        if(root == null)
        {
            root = new AVLNode(key,null,null,null);;
            size++;
            return true;
        }
        //check if key already in tree
        AVLNode temp = search(key);
        if(temp!=null)
        {
            System.out.println(key + " already in tree!");
            return false;
        }
        
        //find a place to put the new key;
        //re-using temp
        temp = root;
        AVLNode parent = null;
        while(temp!=null)
        {
            parent = temp;
            if(key < temp.value )
            {
                // go left
                temp = temp.left;
            }
            else if (key > temp.value)
            {
                // go right
                temp = temp.right;
            }
        }
        
        //now temp has reached null and parent is pointing to a leaf
        //we have to attach newNode in the right place;
                
        AVLNode newNode = new AVLNode(key,parent,null,null);
        
        if(key<parent.value)
            parent.left = newNode;
        else
            parent.right = newNode;
        size++;
        
        //check now if tree is AVL!
        setHeights(this.root);
        if(root.height>=2)
        {
            if(root.left!=null && root.right!=null)
                if(root.left.height - root.right.height >=2)
                    root=rotateLeft(root);
                else if(root.right.height - root.left.height >=2)
                    root=rotateRight(root);
                else
                    ;//do nothing
            else
                //one side is null
                if(root.left!=null)
                    root=rotateLeft(root);
                else if(root.right!=null)
                    root=rotateRight(root);
          
        }
        
        
        return true;
    }
    

    //we assume that AVLNode z has a problem with height difference >=2
    //we determine which rotation
    /*
    rotation = 1 is single left rotation
                 z                            y
                / \                          / \
               y   D                        x   z
              / \                          / \ / \
             x   C           becomes      A  B C  D            
            / \                     
           A   B                     

    rotation = 2 is double left rotation        
                 z                            x
                / \                          / \
               y   D                        y   z
              / \                          / \ / \
             A   x           becomes      A  B C  D            
                / \                     
               B   C                     

    rotation = 3 is single right rotation
                 z                            y
                / \                          / \
               A   y                        z   x
                  / \                      / \ / \
                 B   x       becomes      A  B C  D            
                    / \                     
                   C   D                     
    rotation = 4 is double right rotation
                 z                            x
                / \                          / \
               A   y                        z   y
                  / \                      / \ / \
                 x   D       becomes      A  B C  D            
                / \                     
               B   C                     
    */
    public AVLNode rotateLeft(AVLNode z)
    {
        // case when z.left.height - z.right.height >=2
        AVLNode y = z.left;
        boolean single = false;
        //check to single or double rotate it!
        if(y.left!=null && y.right !=null)
        {
            if(y.left.height > y.right.height)
                single = true;
            else
                single = false; // do double rotate
        }
        else if(y.left==null)
            single = false;
        else
            single = true;
        //define temp variables
        AVLNode A, B, C, D, x;        
        if(single) // do single rotate
        {
            x = y.left;
            A = x.left;
            B = x.right;
            C = y.right;
            D = z.right;
            
            y.right = z;
            z.left = C;
            //z.right = D;
            
            //C.parent = D.parent = z;
            if(C!=null) C.parent = z;
            //if(D!=null) D.parent = z;
            z.parent = y;
            return y;
        }
        else
        {
            //double rotate
            x = y.right;
            A = y.left;
            B = x.left;
            C = x.right;
            D = z.right;
            //rotate now
            x.left = y;
            x.right = z;
            
            //y.left = A;
            y.right = B;
            z.left = C;
            //z.right = D;
            
            y.parent = z.parent = x;     
            if(B!=null)B.parent = y;
            if(C!=null)C.parent =  z;
            return x;
        }
       
    }
    public AVLNode rotateRight(AVLNode z)
    {
        // case when z.right.height - z.left.height >=2
        AVLNode y = z.right;
        boolean single = false;
        //check to single or double rotate it!
        if(y.left!=null && y.right !=null)
        {
            if(y.right.height > y.left.height)
                single = true;
            else
                single = false; // do double rotate
        }
        else if(y.right==null)
            single = false; // do double rotate
        else
            single = true;
        //define temp variables
        AVLNode A, B, C, D, x; 
        
        if(single) // do single rotate
        {
            x = y.right;
            A = z.left;
            B = y.left;
            C = x.left;
            D = x.right;
            //do single rotation
            y.left = z;
            //z.left = A;
            z.right = B;
            
            z.parent = y;
            if(B!=null)B.parent = z;
            
            return y;
        }
        else
        {
            //double rotate
            x = y.left;
            A = z.left;
            B = x.left;
            C = x.right;
            D = y.right;
            
            x.left = z;
            x.right = y;
            //z.left = A;
            z.right = B;
            y.left = C;
            //y.right = D;
            
            y.parent = z.parent = x;
            if(B!=null) B.parent = z;
            if(C!=null)C.parent = y;
            
            return x;
        }
        
    }
    
    public AVLNode remove(int key)
    {
        AVLNode temp = search(key);
        if(temp==null)
        {
            //not found;
            return null;
        }
        //case 0: no children
        if(temp.left==null && temp.right==null)
        {
            //check if temp was the left child
            if(temp.parent.left == temp)
                temp.parent.left = null;
            else
                temp.parent.right = null;
            //temp.parent = null;
            size--;
            return temp;
        }
        //case 1: 1 child
        if((temp.left!=null && temp.right==null)
                ||(temp.right!=null)&&(temp.left==null))
            
        {
            if(temp.left==null)
            {
                if(temp.parent.left==temp)
                    temp.parent.left = temp.right;
                else
                    temp.parent.right = temp.right;
                temp.right.parent = temp.parent;
            }
            else 
            {
                if(temp.parent.left==temp)
                    temp.parent.left = temp.left;
                else
                    temp.parent.right=temp.left;  
                temp.left.parent = temp.parent;
            }
            size--;
            return temp;
        }
        //case 2: 2 children
        if(temp.right!=null && temp.left!=null)
        {
            AVLNode x= temp.right;
            
            //case A: if successor.left is non existent
            if(x.left==null)
            {
                temp.right = x.right;
                temp.value = x.value;
                if(x.right!=null) // check if right sub-tree exists
                    x.right.parent = temp;
            }
            else // case B: if successor.left is not empty
            {
                //find successor node
                while(x.left!=null)
                    x=x.left;

                if(x.right==null)
                {
                    x.parent.left=null;
                    
                }
                else
                {
                    x.parent.left = x.right;
                    x.right.parent = x.parent;              
                }
                temp.value = x.value;
            }
            size--;
            return x;
        }
        
        
//check now if tree is AVL!
        setHeights(this.root);
        if(root.height>=2)
        {
            if(root.left!=null && root.right!=null)
                if(root.left.height - root.right.height >=2)
                    root=rotateLeft(root);
                else if(root.right.height - root.left.height >=2)
                    root=rotateRight(root);
                else
                    ;//do nothing
            else
                //one side is null
                if(root.left!=null)
                    root=rotateLeft(root);
                else if(root.right!=null)
                    root=rotateRight(root);
          
        }        
        
        return null;
    } 
    
    public String inorder(AVLNode B)
    {
        if(B==null)
            return "";
        else
            return inorder(B.left) + " " + B.value + " " + inorder(B.right);
    }
    
    public String inorderHeights(AVLNode B)
    {
        if(B==null)
            return "";
        else
            return inorder(B.left) + " " + B.height + " " + inorder(B.right);
    }
    public int setHeights(AVLNode A)
    {
        if(A==null) return -1;
        else if(A.left==null && A.right==null)
        {
            A.height = 0;
        }
        else if(A.left==null)
        {
            A.height = 1 + setHeights(A.right);
        }
        else if(A.right==null)
        {
            A.height = 1 + setHeights(A.left);
        }
        else
        {
            int leftHeight = setHeights(A.left) + 1;
            int rightHeight = setHeights(A.right) + 1;
            A.height = leftHeight > rightHeight ? 
                       leftHeight : rightHeight;
        }
        return A.height;
    }
    public boolean isAVL(AVLNode A)
    {
        //This method is called only after setHeights(A) has been called..
        
        if(A.height<2)
            return true;
        else if(A.left==null)
            return A.right.height + 1 < 2 ? true : false; 
        else if(A.right==null)
            return A.left.height + 1 < 2 ? true : false;
        else if(isAVL(A.left) && isAVL(A.right))
            return Math.abs(A.left.height - A.right.height)<2 ? true : false;
        else 
            return false;   
    }
    
    
}
