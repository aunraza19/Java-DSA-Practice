public class binarysearchtree {
    // create a Node class to represent each node in the tree
    class Node {
        int data;  // data stored in the node
        Node left;  // left child of the node
        Node right;  // right child of the node

        // constructor to initialize the node with data
        public Node(int data) {
            this.data = data;
            this.left = null;  // left child is initially null
            this.right = null;  // right child is initially null
        }
    }
    // method to create a new node with the given data
    public Node createNode(int data) {
        return new Node(data);  // return a new Node object
    }
    // method to insert a new node with the given data into the tree
    public Node insert(Node node, int data) {
        if (node == null) {  // if the current node is null, create a new node
            return createNode(data);
        }
        if (data < node.data) {  // if the data to be inserted is less than the current node's data
            node.left = insert(node.left, data);  // insert the data into the left subtree
        } else if (data > node.data) {  // if the data to be inserted is greater than the current node's data
            node.right = insert(node.right, data);  // insert the data into the right subtree
        }
        return node;  // return the (possibly updated) node
    }
    public static void main(String[] args) {
        binarysearchtree bst = new binarysearchtree();  // create a new instance of binarysearchtree
        // create a root node with the data 50
        Node root = bst.createNode(50);
        // insert nodes with the given data values
        bst.insert(root, 30);
        bst.insert(root, 70);
        bst.insert(root, 60);
        bst.insert(root, 80);
        // print the tree in post-order traversal
        //bst.postOrder(root);
        bst.preOrder(root);
        //bst.inOrder(root);
    }
    // method to print the tree in in-order traversal
    public void inOrder(Node root) {
        if (root == null) {  // base case: if the current node is null, return
            return;
        }
        inOrder(root.left);  // recursively print the left subtree
        System.out.println(root.data);  // print the current node's data
        inOrder(root.right);  // recursively print the right subtree
    }
    // method to print the tree in pre-order traversal
    public void preOrder(Node root) {
        if (root == null) {  // base case: if the current node is null, return
            return;
        }
        System.out.println(root.data);  // print the current node's data
        preOrder(root.left);  // recursively print the left subtree
        preOrder(root.right);  // recursively print the right subtree
    }
    // method to print the tree in post-order traversal
    public void postOrder(Node root) {
        if (root == null) {  // base case: if the current node is null, return
            return;
        }
        postOrder(root.left);  // recursively print the left subtree
        postOrder(root.right);  // recursively print the right subtree
        System.out.println(root.data);  // print the current node's data
    }
}