import java.util.Scanner;

/**
 * Created by kt_ki on 1/27/2017.
 */
public class AmneChallenge {

    private static int N;
    private static int K;
    private int[] value;
    private static Scanner sc = new Scanner(System.in);

    private AmneChallenge(int N, int K) {
        AmneChallenge.N = N;
        AmneChallenge.K = K;
    }

    /*
        Adding Value into an Array instead of any List, because we already know the length of
        the valued to be inserted.
     */

    private void addValue() {
        int add;
        value = new int[N];
        System.out.println(" Enter " + N + " Values:");
        for (int i = 0; i < N; i++) {
            add = sc.nextInt();
            if (add < 1000000 && add > 0) {
                value[i] = add;
            } else {
                System.out.println("Enter Valid Value: 0< value <1,000,000");
                i--;
            }
        }
    }

    private void track() {
        // We need to keep main loop running for N-K+1 times
        for (int i = 0; i < N - K + 1; i++) {
            boolean check = false; // set the counter
            int inc = 0; // initializing Increment
            int dec = 0; // initializing Decrement

            // Here, we are running the loop for exactly K-1 times.
            for (int j = 0; j < K - 1; j++) {
                // Value of j always starts with 0 and
                // value of i keeps increasing every time subloop finises.
                if (value[j + i] < value[j + i + 1]) {
                    check = true; // if the the left value is less than the right value
                                // the check will be true and will Increment the counter.
                } else if (value[j + i] == value[j + i + 1]) {
                    inc += 1; // this will add 0 if the value is same.
                } else {
                    check = false; // this will Decrement the counter.
                }

                // if check is true than Increment the counter by 1,
                // or else Decrement the counter by -1;
                if (check) {
                    inc++;
                } else {
                    dec--;
                }
            }
            // Here, we are going to calculate the total value of first window
            int total = inc + dec;
            /*
                This if statement will only execute if the total value is the same as K-1,
                because this means the values in the window is Only increasing,
                so we have to count that and add 1 to total.
                And if the value of K is 2, then we don't need to check anything.
            */
            if (total == K -1 && K !=2){
                total += 1;
            }
            System.out.println(total);
        }
    }

    public static void main(String[] args) {

        // Getting Valid input for the values of N & K

        System.out.println("Enter values of N and K");
        N = sc.nextInt();
        K = sc.nextInt();
        if (N >= 1 && N <= 50000 && K >= 1 && K <= N) {
            AmneChallenge challenge = new AmneChallenge(N, K);
            challenge.addValue();
            challenge.track();
        } else {
            System.out.println("Put valid N & K value next time: 1 ≤ N ≤ 50,000 , 1 ≤ K ≤ N");
        }

    }
}
