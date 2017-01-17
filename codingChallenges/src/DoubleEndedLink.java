/**
 * Created by kt_ki on 1/15/2017.
 */
//class Link_Double {
//    public double data;
//    public Link_Double next;
//
//    public Link_Double(double data) {
//        this.data = data;
//        next = null;
//    }
//
//    public void displayLink() {
//        System.out.print(data + " ");
//    }
//}

public class DoubleEndedLink {
    public Main_Link first;
    public Main_Link last;

    public DoubleEndedLink() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void addFirst(double data) {
        Main_Link newLink = new Main_Link(data);
        if (isEmpty()){
            first = newLink;
            last = newLink;
        }else {
            newLink.next = first;
            first = newLink;
        }
    }

    public void addLast(double data) {
        Main_Link newLink = new Main_Link(data);
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
        Main_Link current = first;
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
