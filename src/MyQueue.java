import java.util.EmptyStackException;
import java.util.Stack;

class MyQueue {
private Stack<Integer> in;
private Stack <Integer> out;

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void push(int x) {
        if (out.isEmpty()) {
            out.push(x);
        } else  {
            in.push(x);
        }
    }

    public int pop() throws EmptyStackException {
        if (out.isEmpty()) {
            throw new EmptyStackException();
        }
        int value = out.pop();
        if (!in.isEmpty()) {
            out.push(in.pop());
        }
        return value;
    }

    public int peek() throws EmptyStackException {
        if (out.isEmpty()) {
            throw new EmptyStackException();
        }
       return out.peek();
    }

    public boolean empty() {
        if (out.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        int value1 = myQueue.pop();
        System.out.println(value1);
        System.out.println(myQueue.peek());
        int value2 = myQueue.pop();
        System.out.println(value2);
        System.out.println(myQueue.empty());
//        myQueue.pop();
//        myQueue.peek();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */