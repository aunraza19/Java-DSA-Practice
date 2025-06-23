public class test{
class Node{
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}
public Node createnode(int data){
        return new Node(data);
}
public Node insert(Node node,int data){
        if (node==null){
          return  createnode(data);
        }
        if(data<node.data){
            node.left=insert(node.left,data);
        } else if (data>node.data) {
            node.right=insert(node.right,data);

        }
        return node;
}
public void preorder(Node root){
        if(root==null){
            return;
        }
    System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
}


    public static void main(String[] args) {
test bst= new test();
Node root=bst.createnode(50);
bst.insert(root,3);
        bst.insert(root,6);
        bst.insert(root,8);
        bst.insert(root,7);
        bst.preorder(root);
    }
}