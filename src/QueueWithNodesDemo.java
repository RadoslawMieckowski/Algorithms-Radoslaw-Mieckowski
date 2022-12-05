import java.util.EmptyStackException;

public class QueueWithNodesDemo {
    public static void main(String[] args) {
        Queue queue = new Queue();
//        queue.dequeue();
        System.out.println(queue);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue);
        System.out.println(queue.peek());
        queue.dequeue();
        System.out.println(queue);
    }
}
class Queue {
    Node first;
    Node last;
    int length;

    public Queue() {
        first = null;
        last = null;
        length = 0;
    }

    public int peek() {
        return first.value;
    }

    public Node enqueue(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            first = newNode;  //tu first na dobre zostaje first
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        length++;
        return newNode;
    }

    public Node dequeue() {
        Node previousFirst = first;
        if (length == 0) {
            throw new EmptyStackException();
        }
        else if (length == 1) {
            first = null;
            last = null;
        } else {
            first = previousFirst.next;  //teraz drugi jest pierwszym
        }
        length--;
        return previousFirst;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "first=" + first +
                ", last=" + last +
                ", length=" + length +
                '}';
    }
}
