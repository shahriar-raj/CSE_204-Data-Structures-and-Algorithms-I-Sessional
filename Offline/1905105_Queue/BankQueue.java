import java.util.Scanner;
//Object initialization at line no. 12,13 & 15,16

public class BankQueue {
    public static void main(String[] args) {
        int t = 0, t_1 = 0, t_2 = 0, n;
        boolean end = false;
        Scanner scn = new Scanner(System.in);
        n = scn.nextInt();
        int in_count = 0;

        ArrQ<Customer> Q1 = new ArrQ<>(n);
        ArrQ<Customer> Q2 = new ArrQ<>(n);

//        LLQ<Customer> Q1 = new LLQ<>(n);
//        LLQ<Customer> Q2 = new LLQ<>(n);

        while (in_count < n) {
            Scanner scn1 = new Scanner(System.in);
            String s1 = scn1.nextLine();
            String[] s2 = s1.split(" ");
            Customer input = new Customer(Integer.parseInt(s2[0]), Integer.parseInt(s2[1]));
            boolean f_c = true;
            in_count++;
            while (f_c || end) {
                if (Q1.length() != 0) {
                    Q1.frontValue().setS_time(Q1.frontValue().getS_time() - 1);
                    if (Q1.frontValue().getS_time() == 0) {
                        Q1.dequeue();
                        t_1 = t;
                    }
                }
                if (Q2.length() != 0) {
                    Q2.frontValue().setS_time(Q2.frontValue().getS_time() - 1);
                    if (Q2.frontValue().getS_time() == 0) {
                        Q2.dequeue();
                        t_2 = t;
                    }
                }

                if (input.getE_time() <= t && !end) {
                    if (Q1.length() > Q2.length()) {
                        Q2.enqueue(input);
                    } else
                        Q1.enqueue(input);
                    f_c = false;
//                    System.out.println(s2[1]);
                    if (in_count == n)
                        end = true;
                }

                if (Q1.length() - 1 > Q2.length())
                    Q2.enqueue(Q1.leaveQueue());
                else if (Q2.length() - 1 > Q1.length())
                    Q1.enqueue(Q2.leaveQueue());
                if (end && (Q1.length() == 0) && (Q2.length() == 0))
                    break;
                t++;
            }
        }
        System.out.println("Booth 1 finishes service at t="+t_1);
        System.out.println("Booth 2 finishes service at t="+t_2);
    }
}
