public class StudentLinkedList {
    class Node {
        Student data;
        Node next;
        Node(Student d) { data = d; next = null; }
    }
    private Node head;

    public void addStudent(Student s) {
        Node newNode = new Node(s);
        if (head == null) { head = newNode; } 
        else {
            Node temp = head;
            while (temp.next != null) { temp = temp.next; }
            temp.next = newNode;
        }
    }

    public boolean deleteStudent(String id) {
        if (head == null) return false;
        if (head.data.id.equals(id)) {
            head = head.next;
            return true;
        }
        Node prev = head;
        Node curr = head.next;
        while (curr != null) {
            if (curr.data.id.equals(id)) {
                prev.next = curr.next;
                return true;
            }
            prev = curr;
            curr = curr.next;
        }
        return false;
    }

    public void displayAll() {
        Node temp = head;
        if (temp == null) { System.out.println("No student records found."); return; }
        while (temp != null) { System.out.println(temp.data); temp = temp.next; }
    }
}