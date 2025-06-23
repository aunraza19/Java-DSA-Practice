public class main {
    public class Node{
        private int data;
        private Node left;
        private Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
         public Node createNode (int data){
            return new Node(data);
         }
         public Node insert(Node node, int data){
            if (node==null){
                return createNode(data);
            }
            if(data<node.data){
                node.left=insert(node.left,data);
            }
            if (data>node.data){
                node.right=insert(node.right,data);
            }
            return node;
         }
         public void preorder(Node root){
        if (root==null){
            return;
        }
             System.out.println(root.data);
            preorder(root.left);
            preorder(root.right);
         }
         public void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
             System.out.println(root.data);
             inorder(root.right);
         }
         public void postorder(Node root){
        if(root==null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
             System.out.println(root.data);

         }
         public Node search(Node node, int target){
            if (node==null || node.data==target){
                return node;
            }
            if (target<node.data){
                return search(node.left, target);
            }
            else{
               return search(node.right,target);
            }

         }

    public static void main(String[] args) {
        main bst=new main();
        Node root= bst.createNode(50);
        bst.insert(root,32);
        bst.insert(root,1);
        bst.insert(root,12);
        bst.insert(root,17);
        bst.insert(root,21);
        bst.inorder(root);

        int target= 7;
        Node result= bst.search(root,target);
        if(result!=null){
            System.out.println("found "+target+" in the tree");

        }
        else{
            System.out.println(target+"     not found");
        }
    }
    }
