/**
 * Created by kt_ki on 1/13/2017.
 */

class Link {
    public int key;
    public double data;
    public Link next;

    public Link(int key, double data) {
        this.key = key;
        this.data = data;
        next = null; // default null...no need to specify
    }

    public void displayLink() {
        System.out.println(" " + key + " " + data);
    }
}

public class LinkList {
    private Link first;

    public LinkList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(int key, double data) {
        Link newLink = new Link(key, data);
        newLink.next = first;
        first = newLink;
    }

    public Link deleteFirst() {
        Link temp = first;
        first = first.next;
        return temp;
    }

    public void display() {
        System.out.println("List: ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {

        LinkList linkList = new LinkList();
        linkList.insertFirst(1, 22);
        linkList.insertFirst(2, 52);

        linkList.display();

        while (!linkList.isEmpty()) {
          Link delete = linkList.deleteFirst();
            System.out.print("Deleted: ");
            delete.displayLink();
        }
        System.out.println();
        System.out.println("After Deletion: ");
        linkList.display();

    }
}
