/**
 * Created by kt_ki on 1/17/2017.
 */
public class Main_Link {
    public double data;
    public Main_Link next;

    public Main_Link(double data) {
        this.data = data;
        next = null;
    }

    public void displayLink() {
        System.out.print(data + " ");
    }
}
