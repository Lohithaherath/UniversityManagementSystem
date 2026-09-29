import java.util.Stack;

public class HistoryStack {
    private Stack<String> actionStack = new Stack<>();

    public void addAction(String action) { actionStack.push(action); }

    public void displayRecentActions() {
        System.out.println("--- Recent Actions ---");
        if (actionStack.isEmpty()) { System.out.println("No recent actions found."); } 
        else {
            for (int i = actionStack.size() - 1; i >= 0; i--) {
                System.out.println("- " + actionStack.get(i));
            }
        }
    }
}