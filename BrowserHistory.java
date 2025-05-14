import java.util.Stack;

public class BrowserHistory {
    Stack<String> history = new Stack<>();
    public void visit(String url) {
        history.push(url);
        System.out.println("Visited: " + url);
    }
    public void goBack() {
        if (!history.isEmpty()) {
            String removed = history.pop();
            System.out.println("Went back from: " + removed);
        } else {
            System.out.println("No history");
        }
    }
    public void currentPage() {
        if (!history.isEmpty()) {
            System.out.println("Current page: " + history.peek());
        } else {
            System.out.println("No current page.");
        }
    }
    public void showHistory() {
        System.out.println("Browser History:");
        for (String url : history) {
            System.out.println(url);
        }
    }
    public static void main(String[] args) {
        BrowserHistory bh = new BrowserHistory();
        bh.visit("google.com");
        bh.visit("instagram.com");
        bh.currentPage();
        bh.goBack();
        bh.currentPage();
        bh.showHistory();
    }
}
