import java.util.Scanner;

public class BinaryTree {
     static class bst{
         bst() {

         }
         private Node root;

        private static class Node{
            private int value;
            private Node left;
            private Node right;
            Node(int value){

                this.value=value;
            }
        }
        private void populate(Scanner scanner){
            System.out.println("enter the root node");
            int value= scanner.nextInt();
            root=new Node(value);
            populate(scanner, root);
         }
         private void populate(Scanner scanner, Node node ){
             System.out.println("do you want to enter left child of"+ node.value);
             boolean left= scanner.nextBoolean();
             if(left){
                 System.out.println("enter the value of left node of"+node.value);
                 int value=scanner.nextInt();
                 node.left=new Node(value);
                 populate(scanner, node.left);
             }
             System.out.println("do you want to enter the right node of"+node.value);
             boolean right=scanner.nextBoolean();
             if(right){
                 System.out.println("enter the value of right node of"+node.value);
                 int value=scanner.nextInt();
                 node.right=new Node(value);
                 populate(scanner,node.right);
             }
         }
         public void inOrder(bst.Node root) {
             if (root == null) {  // base case: if the current node is null, return
                 return;
             }
             inOrder(root.left);  // recursively print the left subtree
             System.out.println(root.value);  // print the current node's data
             inOrder(root.right);  // recursively print the right subtree
         }
         // method to print the tree in pre-order traversal
         public void preOrder(bst.Node root) {
             if (root == null) {  // base case: if the current node is null, return
                 return;
             }
             System.out.println(root.value);  // print the current node's data
             preOrder(root.left);  // recursively print the left subtree
             preOrder(root.right);  // recursively print the right subtree
         }
         // method to print the tree in post-order traversal
         public void postOrder(bst.Node root) {
             if (root == null) {  // base case: if the current node is null, return
                 return;
             }
             postOrder(root.left);  // recursively print the left subtree
             postOrder(root.right);  // recursively print the right subtree
             System.out.println(root.value);  // print the current node's data
         }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        bst bst=new bst();
        bst.populate(scanner);
        bst.inOrder(bst.root);



    }

}
