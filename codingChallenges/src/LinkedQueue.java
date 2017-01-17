/**
 * Created by kt_ki on 1/17/2017.
 */
class QueueList {
    public Main_Link first;
    public Main_Link last;

    public QueueList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertLast(double value) {
        Main_Link newValue = new Main_Link(value);
        if (isEmpty()) {
            first = newValue;
            last = first;
        } else {
            last.next = newValue;
            last = newValue;
        }
    }

    public double deleteFirst() {
        double temp = first.data;
        if (first.next == null) {
            last = null;
        } else {
            first = first.next;
        }
        return temp;
    }

    public void displayList() {
        System.out.print("Queue : ");
        Main_Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }
}

public class LinkedQueue {

    public QueueList theList;

    public LinkedQueue() {
        theList = new QueueList();
    }

    public boolean isEmpty() {
        return theList.isEmpty();
    }

    public void insert(double value) {
        theList.insertLast(value);
    }

    public double remove() {
        return theList.deleteFirst();
    }

    public void displayQueue() {
        theList.displayList();
    }

    public static void main(String[] args) {

        LinkedQueue linkedQueue = new LinkedQueue();

        while (linkedQueue.isEmpty())
        linkedQueue.insert(55);
        linkedQueue.insert(32);
        linkedQueue.insert(54);

        linkedQueue.displayQueue();

        linkedQueue.remove();

        linkedQueue.displayQueue();

    }
}
