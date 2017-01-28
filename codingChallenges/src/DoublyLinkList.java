import java.util.List;

/**
 * Created by kt_ki on 1/20/2017.
 */
public class DoublyLinkList {
    Main_Link first;
    Main_Link last;

    public DoublyLinkList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(double value){
        Main_Link newLink = new Main_Link(value);
        if (isEmpty()){
            last = newLink;
        }else {
            first.previous = newLink;
            newLink.next = first;
        }
        first = newLink;
    }

    public void insertLast(double value){
        Main_Link newLink = new Main_Link(value);
        if (isEmpty()){
            first = newLink;
        }else {
            last.next = newLink;
            newLink.previous = last;
        }
        last = newLink;
    }

    public Main_Link deleteFirst(){
        Main_Link temp = first;
        if (first.next == null){
            last = null;
        }else {
            first.next.previous = null;
        }
        first = first.next;
        return temp;
    }

    public Main_Link deleteLast(){
        Main_Link temp = last;
        if (first.next == null){
            first = null;
        }else {
            last.previous.next = null;
        }
        last = last.previous;
        return temp;
    }

    public boolean insertAfter(double key , double value){
        Main_Link current = first;

        while (current.data != key){
            current = current.next;
            if (current == null){
                return false;
            }
        }
        Main_Link newLink = new Main_Link(value);
        if (current == last){
            newLink.next = null;
            last = newLink;
        }else {
            newLink.next = current.next;
            current.next.previous = newLink;
        }
        newLink.previous = current;
        current.next = newLink;

        return true;
    }

    public Main_Link deleteKey(double key){
        Main_Link current = first;

        while (current.data != key){
            current = current.next;
            if (current == null){
                System.out.println("No " + key + " found");
                return null;
            }
        }
        if (current == first){
            first = current.next;
        }else {
            current.previous.next = current.next;
        }
        if (current == last){
            last = current.previous;
        }else {
            current.next.previous = current.previous;
        }
        return current;
    }

    public void displayForward(){
        System.out.print("Forward: ");
        Main_Link current = first;
        while (current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }

    public void displayBackward(){
        System.out.print("Backward: ");
        Main_Link current = last;
        while (current != null){
            current.displayLink();
            current = current.previous;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        DoublyLinkList doublyLinkList = new DoublyLinkList();

        doublyLinkList.insertFirst(23);
        doublyLinkList.insertFirst(22);
        doublyLinkList.insertFirst(56);
        doublyLinkList.insertLast(44);
        doublyLinkList.insertLast(10);

        doublyLinkList.displayForward();
        doublyLinkList.displayBackward();

        doublyLinkList.insertAfter(10 , 20);
        doublyLinkList.insertAfter(20 , 30);

        doublyLinkList.displayForward();
        doublyLinkList.displayBackward();

        doublyLinkList.deleteFirst();

        doublyLinkList.displayForward();
        doublyLinkList.displayBackward();

        doublyLinkList.deleteLast();

        doublyLinkList.displayForward();
        doublyLinkList.displayBackward();

        doublyLinkList.deleteKey(56);

    }
}
