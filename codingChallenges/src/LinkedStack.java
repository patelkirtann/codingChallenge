/**
 * Created by kt_ki on 1/17/2017.
 */
class Link_Stack {
    public double data;
    public Link_Stack next;

    public Link_Stack(double data) {
        this.data = data;
        next = null;
    }

    public void displayLink() {
        System.out.print(data + " ");
    }
}

class LinkList_Stack {
   public Link_Stack first;

    public LinkList_Stack() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void addFirst(double data) {
        Link_Stack newLink = new Link_Stack(data);
        newLink.next = first;
        first = newLink;
    }

    public double deleteFirst(){
        Link_Stack temp = first;
        first = first.next;
        return temp.data;
    }

    public void displayList(){
        System.out.print("Stack Values :");
        Link_Stack current = first;
        while (current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.println(" ");
    }
}

public class LinkedStack {

    public LinkList_Stack theList;

    public LinkedStack(){
        theList = new LinkList_Stack();
    }

    public void push(double value){
        theList.addFirst(value);
    }

    public void pop(){
        theList.deleteFirst();
    }

    public boolean isEmpty(){
        return theList.isEmpty();
    }

    public void displayStack(){
        theList.displayList();
    }

    public static void main(String[] args) {
        LinkedStack linkedStack = new LinkedStack();

        while (linkedStack.isEmpty())
        linkedStack.push(32.22);
        linkedStack.push(52.36);
        linkedStack.push(33);

        linkedStack.displayStack();

        linkedStack.pop();

        linkedStack.displayStack();
    }

}
