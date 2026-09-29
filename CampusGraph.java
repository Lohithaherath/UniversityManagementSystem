import java.util.*;

public class CampusGraph {
    private Map<String, List<String>> adjList = new HashMap<>();

    public void addLocation(String loc) { 
        if (adjList.containsKey(loc)) {
            System.out.println("Location already exists.");
            return;
        }
        adjList.putIfAbsent(loc, new ArrayList<>()); 
        System.out.println("Location '" + loc + "' added successfully.");
    }

    public void removeLocation(String loc) {
        if (!adjList.containsKey(loc)) {
            System.out.println("Location not found.");
            return;
        }
        for (String key : adjList.keySet()) {
            adjList.get(key).remove(loc);
        }
        adjList.remove(loc);
        System.out.println("Location '" + loc + "' and its connections removed successfully.");
    }

    public void addConnection(String l1, String l2) {
        if (adjList.containsKey(l1) && adjList.containsKey(l2)) {
            if (!adjList.get(l1).contains(l2)) {
                adjList.get(l1).add(l2);
                adjList.get(l2).add(l1);
                System.out.println("Connection added between " + l1 + " and " + l2);
            } else {
                System.out.println("Connection already exists between these locations.");
            }
        } else {
            System.out.println("One or both locations not found.");
        }
    }

    public void removeConnection(String l1, String l2) {
        if (adjList.containsKey(l1) && adjList.containsKey(l2)) {
            adjList.get(l1).remove(l2);
            adjList.get(l2).remove(l1);
            System.out.println("Connection removed between " + l1 + " and " + l2);
        } else {
            System.out.println("Locations not found.");
        }
    }

    public void displayConnections() {
        if (adjList.isEmpty()) {
            System.out.println("No campus locations available.");
            return;
        }
        for (String loc : adjList.keySet()) {
            System.out.println(loc + " -> " + adjList.get(loc));
        }
    }

    public void traverseBFS(String start) {
        if (!adjList.containsKey(start)) { System.out.println("Start location not found."); return; }
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(start); visited.add(start);

        System.out.print("BFS Traversal Path: ");
        while (!q.isEmpty()) {
            String curr = q.poll();
            System.out.print(curr + " ");
            for (String n : adjList.get(curr)) {
                if (!visited.contains(n)) { visited.add(n); q.add(n); }
            }
        }
        System.out.println();
    }
}