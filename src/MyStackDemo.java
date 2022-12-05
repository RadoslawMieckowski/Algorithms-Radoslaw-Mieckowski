import java.util.EmptyStackException;

public class MyStackDemo {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
//        myStack.pop();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack);
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
        System.out.println(myStack);
    }
}

class MyStack {
    public Node top;
    public Node bottom;
    public int length;

    public MyStack() {
        this.top = null;
        this.bottom = null;
        this.length = 0;
    }

    public int peek() {
        return top.value;
    }

    public Node push(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            top = newNode;
            bottom = newNode;// w tym momnencie pierwszy el jest już zawsze bottom
        } else {
            Node previousNode = top;
            top = newNode;
            top.next = previousNode;
        }
        length++;
        return newNode;
    }

    public Node pop() {
        Node previousTop = top;
        if (length == 0) {
            throw new EmptyStackException();
        } else if (length == 1) {
            top = null;
            bottom = null;
            length = 0;
        } else {
            top = previousTop.next;
        }
        length--;
        return previousTop;
    }

    @Override
    public String toString() {
        return "MyStack{" +
                "top=" + top +
                ", bottom=" + bottom +
                ", length=" + length +
                '}';
    }
}

class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
