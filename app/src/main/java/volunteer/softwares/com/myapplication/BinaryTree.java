package volunteer.softwares.com.myapplication;

/**
 * Created by awesomefat on 11/28/17.
 */

public class BinaryTree
{
    private Node root;
    private int count;

    public BinaryTree()
    {
        this.root = null;
        this.count = 0;
    }

    public int getCount() {
        return count;
    }

    public void add(int payload)
    {
        Node n = new Node(payload);
        this.count++;

        if(this.root == null)
        {
            this.root = n;
        }
        else
        {
            //we know that this.root is a thing
            this.root.add(n);
        }
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
