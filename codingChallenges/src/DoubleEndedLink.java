/**
 * Created by kt_ki on 1/15/2017.
 */
class LinkD {
    public double data;
    public LinkD next;

    public LinkD(double data) {
        this.data = data;
        next = null;
    }

    public void displayLink() {
        System.out.print(data + " ");
    }
}

public class DoubleEndedLink {
    public LinkD first;
    public LinkD last;

    public DoubleEndedLink() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void addFirst(double data) {
        LinkD newLink = new LinkD(data);
        if (isEmpty()){
            first = newLink;
            last = newLink;
        }else {
            newLink.next = first;
            first = newLink;
        }
    }

    public void addLast(double data) {
        LinkD newLink = new LinkD(data);
        if (isEmpty()) {
            first = newLink;
            last = newLink;
        } else {
            last.next = newLink;
            last = newLink;
        }
    }

    public double deleteFirst() {
        double temp = first.data;
        if (first.next == null) {
            last = null;
        }
        first = first.next;
        return temp;
    }

    public void displayList() {
        System.out.print("List (first-->last): ");
        LinkD current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        DoubleEndedLink endedLink = new DoubleEndedLink();
        endedLink.addFirst(22);
        endedLink.addFirst(23);
        endedLink.addFirst(24);
        endedLink.addLast(16);
        endedLink.addLast(65);

        endedLink.displayList();
        System.out.println();
        endedLink.deleteFirst();
        endedLink.displayList();


    }
}
