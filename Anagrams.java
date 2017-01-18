import java.util.Locale;

/**
 * Created by kt_ki on 9/16/2016.
 */
public class Anagrams {

    public void setStringValues(String s1 , String s2){
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();

        int result1 = s1.charAt(0);
        int result2 = s2.charAt(0);
        for (int i = 0; i < s1.length()-1; i++) {
            result1 = s1.charAt(i+1) + result1;
        }
        for (int i = 0; i < s2.length()-1; i++) {
            result2 = s2.charAt(i+1) + result2;
        }

//        System.out.println(result1);
//        System.out.println(result2);

        if(result1 == result2){
            System.out.println("Anagrams");
        }else {
            System.out.println("Not Anagrams");
        }
    }



    public static void main(String[] args) {
        Anagrams an = new Anagrams();

        an.setStringValues("xywz","xyxy");
    }
}
