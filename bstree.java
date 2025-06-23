public class bstree {
     class Node{
        int data;
        Node left;
        Node right;
       public Node(int data){
            this.data=data;
            this.right=null;
            this.left=null;
        }
     }
        public Node createnode( int data){

         return new Node(data);
        }
        public Node insert(Node node, int data){
            if(node==null){
                return createnode(data);
            }
            if(data<node.data){
                node.left= insert(node.left,data);
            } else if (data>node.data) {
                node.right= insert(node.right,data);

            }
            return node;
        }
        public void preorder(Node root){
         if (root == null){
             return;
         }
            System.out.println(root.data);
            preorder(root.left);
            preorder(root.right);
        }
        public void inorder(Node root){
         if (root==null){
             return;
         }
         inorder(root.left);
            System.out.println(root.data);
            inorder(root.right);
        }
        public void postorde(Node root) {
            if (root == null) {
                return;
            }
            inorder(root.left);

            inorder(root.right);

            System.out.println(root.data);
     }

    public static void main(String[] args) {
        bstree bst=new bstree();
        Node root= bst.createnode(50);
        bst.insert(root,3);
        bst.insert(root,2);
        bst.insert(root,1);
        bst.insert(root,5);
        bst.inorder(root);
    }
    }
    ()

