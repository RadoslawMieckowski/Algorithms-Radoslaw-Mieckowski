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
        in.push(x);
    }

    public int pop() throws EmptyStackException {
        int value;
        if (out.empty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
            value = out.pop();
        } else {
            value = out.pop();
        }
        return value;
    }

    public int peek() throws EmptyStackException {
        if (out.isEmpty() && in.isEmpty()) {
            throw new EmptyStackException();
        }
        int value;
        if (!out.isEmpty()) {
             value = out.peek();
        }
        else {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
            value = out.peek();
            while (!out.isEmpty()) {
                in.push(out.pop());
            }
        }
       return value;
    }

    public boolean empty() {
        if (out.isEmpty() && in.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        myQueue.push(5);
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