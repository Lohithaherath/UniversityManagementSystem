public class StudentBST {
    class Node { 
        Student data; 
        Node left, right; 
        Node(Student d) { data = d; } 
    }
    private Node root;

    public void insert(Student s) { root = insertRec(root, s); }
    private Node insertRec(Node root, Student s) {
        if (root == null) { return new Node(s); }
        if (s.id.compareTo(root.data.id) < 0) { root.left = insertRec(root.left, s); }
        else if (s.id.compareTo(root.data.id) > 0) { root.right = insertRec(root.right, s); }
        return root;
    }

    public void displayInOrder() { 
        if (root == null) {
            System.out.println("No records in BST.");
            return;
        }
        inorderRec(root); 
    }
    private void inorderRec(Node root) {
        if (root != null) { 
            inorderRec(root.left); 
            System.out.println(root.data); 
            inorderRec(root.right); 
        }
    }
}