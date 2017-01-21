/**
 * Created by kt_ki on 1/20/2017.
 */

class SortForArray extends SortedList {
    public SortForArray() {
        super();
    }

    public SortForArray(Main_Link[] linkArray) {
        first = null;
        for (int i = 0; i < linkArray.length; i++) {
            insert(linkArray[i]);
        }
    }

    public void insert(Main_Link link) {

        Main_Link previous = null;
        Main_Link current = first;

        while (current != null && link.data > current.data) {
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            first = link;
        } else {
            previous.next = link;
        }
        link.next = current;
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public Main_Link remove() {
        return super.remove();
    }

    @Override
    public void displayList() {
        super.displayList();
    }
}

public class SortedListArray {
    public static void main(String[] args) {
        int size = 10;
        Main_Link[] linkArray = new Main_Link[size];
        for (int i = 0; i < size; i++) {
            int values = (int) (Math.random() * 10);
            Main_Link link = new Main_Link(values);
            linkArray[i] = link;
        }
        System.out.print("Unsorted: ");
        for (int i = 0; i < size; i++) {
            System.out.print(linkArray[i].data + "  ");
        }
        System.out.println(" ");
        SortForArray sort = new SortForArray(linkArray);
        for (int i = 0; i < size; i++) {
            linkArray[i] = sort.remove();
        }
        System.out.print("Sorted:   ");
        for (int i = 0; i < size; i++) {
            System.out.print(linkArray[i].data + "  ");
        }
        System.out.println(" ");
    }
}
