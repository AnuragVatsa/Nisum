import java.util.*;
public class Stack {
    ArrayDeque<String> stack = new ArrayDeque<>();
    public void push(String x) {
        stack.push(x);
    }
    public String pop() {
        return stack.pop();
    }
    public String peek() {
        return stack.peek();
    }
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push("Abc");
        s.push("Xyz");
        System.out.println("Peek: " + s.peek());
        System.out.println("Pop: " + s.pop());
        System.out.println("Peek after pop: " + s.peek());
    }
}
