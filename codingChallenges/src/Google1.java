import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by kt_ki on 1/7/2017.
 */
public class Google1 {

    public static int generateNumbers(int SS) {
        String s = String.valueOf(SS);
        ArrayList<String> possibleNumbers = new ArrayList<>();

        for (int i = 0; i < s.length() - 1; i++) {
            int x = Integer.parseInt(String.valueOf(s.charAt(i)));
            int y = Integer.parseInt(String.valueOf(s.charAt(i + 1)));
            long replace = Math.round((x + y) / 2.0);

            possibleNumbers.add(
                    s.substring(0, i)
                            + String.valueOf(replace)
                            + s.substring(i + 2, s.length()));
        }
        System.out.println(possibleNumbers.toString());
        return Integer.parseInt(Collections.max(possibleNumbers));
    }

    public static void main(String[] args) {
        // TODO code application logic here
        int x = 623315;
        String s = String.valueOf(x);

//        System.out.println(Integer.parseInt(generateNumbers(s)));
        System.out.println(generateNumbers(x));
    }
}
