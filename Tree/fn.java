class Node{
    int data;
    Node left;
    Node right;
    public Node(int key){
        this.data = key;
        this.left = null;
        this.right = null;
    }
}

class fn{

    static void inOrder(Node root){
        if(root == null){
            return;
        }

        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    static void preOrder(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static void postOrder(Node root){
        if(root == null){
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.right.left = new Node(7);


        System.out.println("preOrder");
        preOrder(root);
        System.out.println("inOrder");
        inOrder(root);
        System.out.println("postOrder");
        postOrder(root);


    }
}