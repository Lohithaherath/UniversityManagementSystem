import java.util.LinkedList;
import java.util.Queue;

public class ServiceQueue {
    private Queue<String> queue = new LinkedList<>();

    public void addRequest(String req) { 
        queue.add(req); 
        System.out.println("Service request added to the queue successfully.");
    }

    public void processNext() {
        if (!queue.isEmpty()) { System.out.println("Processing request: " + queue.poll()); } 
        else { System.out.println("No pending service requests."); }
    }
}