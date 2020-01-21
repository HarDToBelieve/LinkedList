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



    public BinarySearchTree() {
        root = null;
    }

    public void insert(int value) {
        Node newElement = new Node(value);

        if(root == null) {
            root  = newElement;
            root.setLevel(0);
        }

        else {
            Node current = root;
            Node parent = null;
            while(current != null) {
                parent = current;
                if(value < current.getValue()) {
                    current = current.getLeft();


                }
                else {
                    current = current.getRight();

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
        Node current = root;

        while (current != null) {

            if (value == current.getValue()) {
                return "Found the value at level " + current.getLevel();

            }
            if (value < current.getValue()) {
                current = current.getLeft();
            }
            else {
                current = current.getRight();
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
