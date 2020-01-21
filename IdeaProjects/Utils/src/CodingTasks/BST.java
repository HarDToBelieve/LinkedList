package CodingTasks;

public class BST {
    public static void main (String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(9);
        tree.insert(10);
        tree.insert(1);
        tree.insert(2);

        System.out.println(tree.lookUp(1));

    }
}

class BinarySearchTree {
    Node root;
    Node leaf;
    Node parent;



    public BinarySearchTree() {
        root = null;
        parent = null;

    }

    public void insert(int value) {
        Node newElement = new Node(value);

        if(root == null) {
            root  = newElement;
            leaf = root;
            root.setLevel(0);


        }

        else {
           while(leaf != null) {
               parent = leaf;
               if(value < leaf.getValue()) {
                   leaf = leaf.getLeft();


               }
               else {
                   leaf = leaf.getRight();

               }
           }

           if(value < parent.getValue()) {
               parent.setLeft(newElement);
               parent.getLeft().setLevel(parent.getLevel()+1);

           }
           else {
               parent.setRight(newElement);
               parent.getRight().setLevel(parent.getLevel()+1);

           }

        }


    }

    public String lookUp(int value) {
        leaf = root;

        while (leaf != null) {

            if (value == leaf.getValue()) {
                return "Found the value at level " + leaf.getLevel();

            }
            if (value < leaf.getValue()) {
                leaf = leaf.getLeft();
            }
            else {
                leaf = leaf.getRight();
            }
        }

        return "Cannot find the value";

    }




}

class Node {
    private int value;
    private Node left;
    private Node right;
    private int level;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;

    }

    public int getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
