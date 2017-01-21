/**
 * Created by kt_ki on 1/19/2017.
 */
public class SortedList {
    Main_Link first;

    public SortedList() {
        first = null;
    }

    public boolean isEmpty(){
        return first==null;
    }

    public void insert(double value) {
        Main_Link newValue = new Main_Link(value);
        Main_Link previous = null;
        Main_Link current = first;

        while (current != null && value > current.data) {
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            first = newValue;
        } else {
            previous.next = newValue;
            newValue.next = current;
        }
    }

    public Main_Link remove() {
        Main_Link temp = first;
        first = first.next;
        return temp;
    }

    public void displayList(){
        System.out.print(" List : ");
        Main_Link current = first;
        while (current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        SortedList sortedList = new SortedList();

        sortedList.insert(23);
        sortedList.insert(52);
        sortedList.insert(44);

        sortedList.displayList();

    }
}
