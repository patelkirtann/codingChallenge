/**
 * Created by kt_ki on 1/6/2017.
 */
public class ReverseString {
    private String string;
    private String[] stringArray;
    private int top = -1;

    private ReverseString(String string) {
        this.string = string;
        stringArray = new String[100];
    }

    private boolean isEmpty() {
        return (top == -1);
    }

    private void push(String s) {
        stringArray[++top] = s;
    }

    private String pop() {
        return stringArray[top--];
    }

    private String revString() {
        String input = string;
        String output = "";

        String[] sArray = input.split(" ");
        for (String word : sArray) {
            push(word + " ");
        }

        while (!isEmpty()) {
            String s = pop();
            output += s;
        }

        return output;
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString("Hello World");
        System.out.println(reverseString.revString());
    }
}
