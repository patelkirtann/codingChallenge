import java.util.Scanner;

/**
 * Created by kt_ki on 1/7/2017.
 */
public class StackDelimiters {
    private String string;
    private char[] charArray;
    private int top = -1;

    private StackDelimiters(String string) {
        this.string = string;
        charArray = new char[100];
    }

    private boolean isEmpty() {
        return (top == -1);
    }

    private void push(char s) {
        charArray[++top] = s;
    }

    private char pop() {
        return charArray[top--];
    }

    private boolean compareDelimiters() {
        String input = string;
        boolean output = false;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '{':
                case '[':
                case '(':
                    push(ch);
                    break;

                case '}':
                case ']':
                case ')':
                    if (!isEmpty()) {
                        char chPop = pop();
                        if ((ch == '}' && chPop != '{') ||
                                (ch == ']' && chPop != '[') ||
                                (ch == ')' && chPop != '(')) {
//                            System.out.println("false");
                            output = false;
                        }else {
                            output = true;
                        }
                    } else {
                        output = false;
//                        System.out.println("false");
                    }
                    break;

                default:
                    break;
            }
        }
        if (!isEmpty()){
            output = false;
        }
        return output;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Delimiters(Ex: { } ( ) [ ]):");
        StackDelimiters stackDelimiters = new StackDelimiters(sc.next());

        System.out.println(stackDelimiters.compareDelimiters());
    }
}
