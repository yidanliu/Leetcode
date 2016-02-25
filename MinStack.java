import java.util.PriorityQueue;
import java.util.Stack;

public class MinStack {
    PriorityQueue<Integer> min = new PriorityQueue<Integer>();
    Stack<Integer> stack = new Stack<Integer>();
    
    public void push(int x) {
    	if (min.isEmpty() || min.peek() >= x) {
    		min.add(x);
    	}
        stack.push(x);
    }

    public void pop() {
        int stackTop = stack.pop();
        if (stackTop == getMin()) {
            min.poll();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}