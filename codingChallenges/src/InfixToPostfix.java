import java.util.Scanner;

/**
 * Created by kt_ki on 1/11/2017.
 */

class Stack {

    int maxSize;
    char[] charArray;
    int top;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        charArray = new char[maxSize];
        top = -1;
    }

    public void push(char c) {
        charArray[++top] = c;
    }

    public char pop() {
        return charArray[top--];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public int size() {
        return top + 1;
    }

    public char peek(int n) {
        return charArray[n];
    }

    public void display(String s) {
        System.out.print(s);
        System.out.print(" Stack(Bottom to Top) :");
        for (int i = 0; i < size(); i++) {
            System.out.print(peek(i));
            System.out.print(' ');
        }
        System.out.println("");
    }
}

public class InfixToPostfix {

    Stack stack;
    String input;
    String output = "";

    public InfixToPostfix(String input) {
        this.input = input;
        int size = input.length();
        stack = new Stack(size);
    }

    public void operFound(char oper, int prec1) {
        while (!stack.isEmpty()) {
            char topOper = stack.pop();
            if (topOper == '(') {
                stack.push(topOper);
                break;
            } else {
                int prec2;
                if (topOper == '+' || topOper == '-') {
                    prec2 = 1;
                } else {
                    prec2 = 2;
                }
                if (prec1 > prec2) {
                    stack.push(topOper);
                    break;
                } else {
                    output += topOper;
                }
            }
        }
        stack.push(oper);
    }

    public void parenFound(char c) {
        while (!stack.isEmpty()) {
            char topOper = stack.pop();
            if (topOper == '(') {
                break;
            } else {
                output += topOper;
            }
        }
    }

    public String toPost() {
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            stack.display("for " + ch + " ");
            switch (ch) {
                case '+':
                case '-':
                    operFound(ch, 1);
                    break;

                case '*':
                case '/':
                    operFound(ch, 2);
                    break;

                case '(':
                    stack.push(ch);
                    break;
                case ')':
                    parenFound(ch);
                    break;
                default:
                    output += ch;
            }
        }
        while (!stack.isEmpty()) {
            stack.display("While ");
            output += stack.pop();
        }
        stack.display("End ");
        return output;
    }

    public static void main(String[] args) {

        String input, output;
        Scanner sc = new Scanner(System.in);
        InfixToPostfix toPostfix;
        while (true) {
            System.out.print("Enter Infix:");
            input = sc.nextLine();
            if (input.equals("")){
                break;
            }
            toPostfix = new InfixToPostfix(input);
            output = toPostfix.toPost();
            System.out.println("Postfix: " + output + "\n");
        }
    }
}
