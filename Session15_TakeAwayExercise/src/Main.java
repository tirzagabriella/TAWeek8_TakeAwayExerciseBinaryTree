// B. write a function that returns the sum of all the keys in a binary tree
class Node {
    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }
}

class BinaryTree {

    Node root;

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }
}

public class Main {

    private static BinaryTree createBinaryTree() {
        BinaryTree bt = new BinaryTree();

        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);

        return bt;
    }

    public static void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.value);
            traverseInOrder(node.right);
        }
    }

    static int SumOfKeys(Node node) {
        if(node == null){
            return 0;
        }
        return node.value + SumOfKeys(node.left) + SumOfKeys(node.right);
    }

    public static void main(String[] args) {
        BinaryTree binT = createBinaryTree();
        System.out.print("Elements in order:");
        traverseInOrder(binT.root);
        int sum = SumOfKeys(binT.root);
        System.out.println("\n" + "Sum of all the keys in binary tree : " + sum);
    }


}