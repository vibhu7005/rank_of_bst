//rank of bst
class Node
{
    int data;
    Node left;
    Node right;
    public Node(int data)
    {
        this.data=data;
        left=right=null;
    }
}
class Bst
{
    Node construct_tree(Node root,int data)
    {
        if(root==null)
        return new Node(data);
        if(data>root.data)
        root.right=construct_tree(root.right,data);
        else
        root.left=construct_tree(root.left,data);
        return root;
    }
    int size(Node root)//return no of nodes                                                                                                                                                                                                                                          
    {
        if(root==null)
        return 0;
        return (size(root.left)+1+size(root.right));
    }
    int ranking(Node root,int data)
    {
        int rank=1;//start from 1 or 0
        while(root!=null)
        {
            if(data<root.data)
            root=root.left;
            else if(data>root.data){
                root=root.right;
                rank+=1+size(root.left);}
            else
            {
                return rank+size(root.left);
            }
        }
        return -999;
    }
    void inorder(Node root)
    {
        if(root==null)
        return;
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
    }
public class Main {
    public static void main(String[] args)
    {
        Bst tree=new Bst();
        Node root=null;
        root=tree.construct_tree(root,1);
        root=tree.construct_tree(root,2);
        root=tree.construct_tree(root,3);
        root=tree.construct_tree(root,4);

        tree.inorder(root);
        System.out.println(tree.ranking(root,4));
    }
}


