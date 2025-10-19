package BST;

public class Node
{
    int key;
    int val;
    Node left, right;
    public Node(int key, int val)
    {
       this.key = key;
       this.val = val;
    }
   
    int compareTo(int key)
    {
        if(key < this.key)
            return -1;
        else if(key > this.key)
            return 1;
        else
            return 0;
    }
    public String toString()
    {
        return key + " " + val;
    }
}
