import java.util.Arrays;

/**
 * Created by kt_ki on 1/4/2017.
 *
 * You are playing a game on your cell phone. You are given an array of length N , indexed from 0 to
 * N-1 . Each element of the array is either 0 or 1. You can only move to an index which contains 0.
 * At first, you are at the 0th position. In each move you can do one of the following things:
 *
 * Walk one step forward or backward. Make a jump of exactly length M forward.
 *
 * That means you can move from position x to x+1,x-1 or x+m in one move, but at least one of the
 * following conditions must be true:
 *
 * The new position contains 0. The new position is greater than n-1.
 *
 * You can't move backward from position 0. If you move to any position greater than n-1, you win
 * the game.
 *
 * Given the array and the length of the jump, you need to determine if it's possible to win the
 * game or not.
 */

public class ArrayProblem {
    private int totalNumber;
    private int jumpTo;

    private int[] array;

    private ArrayProblem(int totalNumber, int jumpTo) {
        this.totalNumber = totalNumber;
        this.jumpTo = jumpTo;
    }

    private void displayRandom() {
        array = new int[totalNumber];
        array[0] = 0;

        for (int i = 1; i < totalNumber; i++) {
            array[i] = (int) (Math.random() * 2);
        }

        System.out.println(Arrays.toString(array));
    }


    private String finalResult() {
        String win = "no";
        int count;

        for (count = 0; count < totalNumber; ) {

            if (array[count + 1] == 0) {
                count++;
                win = "yes";
                if (count + 1 == totalNumber) {
                    break;
                }
            } else if ((array[count + 1] == 1 && count > 0)) {
                if (count + jumpTo >= totalNumber) {
                    win = "yes";
                    break;
                } else if (array[(count - 1) + jumpTo] == 0 && ((count - 1) + jumpTo) < totalNumber) {
                    count += jumpTo;
                    if (count + jumpTo >= totalNumber) {
                        win = "yes";
                        break;
                    }
                } else if (array[count + jumpTo] == 0) {
                    count += jumpTo;
                    if (count + jumpTo >= totalNumber) {
                        win = "yes";
                        break;
                    }
                } else if (array[(count - 1) + jumpTo] == 0) {
                    count += jumpTo;
                    if (count + jumpTo >= totalNumber) {
                        win = "yes";
                        break;
                    }
                } else {
                    win = "no";
                    break;
                }

            } else if ((array[count + 1] == 1 && count == 0 && array[count + jumpTo] == 0)) {
                count += jumpTo;
                if (count + 1 >= totalNumber) {
                    win = "yes";
                    break;
                }
            } else {
                win = "no";
                break;
            }

//            if (count > totalNumber) {
//                win = "yes";
//            }
        }
        return win;
    }

    public static void main(String[] args) {
        ArrayProblem arrayProblem = new ArrayProblem(5, 3);
        arrayProblem.displayRandom();
        System.out.println(arrayProblem.finalResult());
    }
}
