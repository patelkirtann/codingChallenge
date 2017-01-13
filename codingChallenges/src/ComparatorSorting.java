import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by kt_ki on 1/9/2017.
 */
class StudentData {
    String name;
    int score;

    public StudentData(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class CompareName implements Comparator<StudentData> {

    @Override
    public int compare(StudentData o1, StudentData o2) {
        return o1.name.compareTo(o2.name);
    }
}

class CompareScore implements Comparator<StudentData> {

    @Override
    public int compare(StudentData o1, StudentData o2) {
        if (o1.score == o2.score)
            return 0;
        else if (o1.score > o2.score)
            return 1;
        else
            return -1;
    }
}

public class ComparatorSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<StudentData> al = new ArrayList<>();

        System.out.print("Enter number of Students :");
        int total = sc.nextInt();
        System.out.println("Add Name and Score: ");

        for (int i = 0; i < total; i++) {
            System.out.print("Name:");
            String name = sc.next();
            System.out.print("Score:");
            int score = sc.nextInt();
            al.add(new StudentData(name, score));
        }

        System.out.println("Sorting with Score: ");
        Collections.sort(al, new CompareScore());
        for (StudentData sd : al) {
            System.out.println(sd.name + " " + sd.score);
        }

        System.out.println(" Sorting with Name: ");
        Collections.sort(al, new CompareName());
        for (StudentData sd : al) {
            System.out.println(sd.name + " " + sd.score);
        }
    }
}
