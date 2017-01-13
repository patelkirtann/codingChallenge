/**
 * Created by kt_ki on 1/6/2017.
 */
public class Reverse {
    private String word;
    private int top = -1;
    private char[] aChar = new char[10];

    private Reverse(String word) {
        this.word = word;
    }

    private boolean isEmpty() {
        return (top == -1);
    }

    private void push(char ch) {
        aChar[++top] = ch;
    }

    private char pop() {
        return aChar[top--];
    }

    private String revWord() {
        String input = word;
        String output = "";

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            push(ch);
        }
        while (!isEmpty()) {
            char ch = pop();
            output += ch;
        }
        return output;
    }

    public static void main(String[] args) {

        Reverse reverse = new Reverse("kirtan");
        System.out.println(reverse.word);
        System.out.println(reverse.revWord());
    }
}
