import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentLinkedList list = new StudentLinkedList();
        HistoryStack history = new HistoryStack();
        ServiceQueue queue = new ServiceQueue();
        StudentBST bst = new StudentBST();
        HashMap<String, Student> studentHash = new HashMap<>();
        CampusGraph graph = new CampusGraph();

        int choice = 0;
        while (choice != 16) {
            System.out.println("\n--- University Student Record and Campus Route Management System ---");
            System.out.println("1. Add Student Record");
            System.out.println("2. Update Student Record");
            System.out.println("3. Delete Student Record");
            System.out.println("4. Display All Records using Linked List");
            System.out.println("5. Add Service Request to Queue");
            System.out.println("6. Process Next Service Request");
            System.out.println("7. Display Recent Actions using Stack");
            System.out.println("8. Display Students using BST/AVL");
            System.out.println("9. Search Student using Hashing");
            System.out.println("10. Add Campus Location");
            System.out.println("11. Remove Campus Location");
            System.out.println("12. Add Campus Connection/Road");
            System.out.println("13. Remove Campus Connection/Road");
            System.out.println("14. Display Campus Connections");
            System.out.println("15. Traverse Campus Locations using BFS or DFS");
            System.out.println("16. Exit");
            System.out.print("Enter your choice (1-16): ");

            try { choice = Integer.parseInt(sc.nextLine()); } 
            catch (NumberFormatException e) { continue; }

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: "); String id = sc.nextLine();
                    System.out.print("Enter Name: "); String name = sc.nextLine();
                    System.out.print("Enter Program: "); String prog = sc.nextLine();
                    System.out.print("Enter Marks: "); 
                    double marks = Double.parseDouble(sc.nextLine());
                    Student s = new Student(id, name, prog, marks);
                    list.addStudent(s); bst.insert(s); studentHash.put(id, s);
                    history.addAction("Added student: " + id);
                    break;
                case 2:
                    System.out.print("Enter Student ID to update: ");
                    String uid = sc.nextLine();
                    if (studentHash.containsKey(uid)) {
                        System.out.print("Enter New Name: "); String nName = sc.nextLine();
                        System.out.print("Enter New Program: "); String nProg = sc.nextLine();
                        System.out.print("Enter New Marks: "); double nMarks = Double.parseDouble(sc.nextLine());
                        Student updatedStudent = new Student(uid, nName, nProg, nMarks);
                        studentHash.put(uid, updatedStudent);
                        history.addAction("Updated student record: " + uid);
                        System.out.println("Record updated successfully!");
                    } else {
                        System.out.println("Student ID not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Student ID to delete: ");
                    String did = sc.nextLine();
                    boolean deleted = list.deleteStudent(did);
                    if (deleted || studentHash.containsKey(did)) {
                        studentHash.remove(did);
                        history.addAction("Deleted student record: " + did);
                        System.out.println("Record removed successfully.");
                    } else {
                        System.out.println("Student ID not found.");
                    }
                    break;
                case 4: list.displayAll(); break;
                case 5:
                    System.out.print("Enter Service Request: "); queue.addRequest(sc.nextLine());
                    break;
                case 6: queue.processNext(); break;
                case 7: history.displayRecentActions(); break;
                case 8: bst.displayInOrder(); break;
                case 9:
                    System.out.print("Enter Search ID: "); String sid = sc.nextLine();
                    if (studentHash.containsKey(sid)) System.out.println(studentHash.get(sid));
                    else System.out.println("Record not found.");
                    break;
                case 10: 
                    System.out.print("Enter Location Name: "); 
                    graph.addLocation(sc.nextLine()); 
                    break;
                case 11:
                    System.out.print("Enter Location Name to Remove: ");
                    graph.removeLocation(sc.nextLine());
                    break;
                case 12: 
                    System.out.print("Enter From Location: "); String l1 = sc.nextLine();
                    System.out.print("Enter To Location: "); String l2 = sc.nextLine();
                    graph.addConnection(l1, l2); 
                    break;
                case 13:
                    System.out.print("Enter From Location: "); String cl1 = sc.nextLine();
                    System.out.print("Enter To Location: "); String cl2 = sc.nextLine();
                    graph.removeConnection(cl1, cl2);
                    break;
                case 14: graph.displayConnections(); break;
                case 15: 
                    System.out.print("Enter Start Location for BFS: "); 
                    graph.traverseBFS(sc.nextLine()); 
                    break;
                case 16: System.out.println("Exiting system. Thank you!"); break;
                default: System.out.println("Invalid choice. Please try again.");
            }
        }
        sc.close();
    }
}