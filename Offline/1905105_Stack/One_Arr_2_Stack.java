import java.util.Scanner;

public class One_Arr_2_Stack {
    private static void print(Arr<d_t> clean_d){
        Arr<Integer> c_time = new Arr<>(clean_d.length());
        while(clean_d.topValue()!=null)
            c_time.push(clean_d.pop().getFinish());
        while(c_time.topValue()!=null) {
            System.out.print(c_time.pop());
            if(c_time.topValue()!=null)
                System.out.print(",");
        }
        System.out.println();
    }

    private static void print_n(int[] n_l, int n, int x){
        int[] counter = new int[n];
        int[] n_l_arr = new int[n_l.length];
        int full = 0;
        boolean yes = true;
        for(int i=0;i<n_l.length;i++) {
            counter[n_l[i]-1]++;
        }
        for (int i:counter){
            if(i!=x){
                yes = false;
                break;
            }
        }
        if(yes)
            System.out.println("Y");
        else
            System.out.println("N");
        for (int j=0;j<n_l.length;j++){
            int i = n_l[j]-1;
            if(counter[i]==x){
                if(full!=0)
                    System.out.print(",");
                System.out.print(i+1);
                counter[i]--;
                full++;
            }
            if(full==n)
                break;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n,x;
        int time = 0;
        Scanner scn = new Scanner(System.in);
        n = scn.nextInt();
        x = scn.nextInt();
        int[] x_l = new int[x];
        d_t[] array = new d_t[n*x];

        Arr<d_t> dirty_d = new Arr<>(array,1);
        Arr<d_t> clean_d = new Arr<>(array,-1);

        int[] n_l = new int[n];
        int c_l=0;

        Scanner scn2 = new Scanner(System.in);

        for(int i =0; i<x; i++){
            x_l[i] = scn2.nextInt();
            // System.out.println(x_l[i]);
        }

        for(;;){
            Scanner scn1 = new Scanner(System.in);
            String s_1 = scn1.nextLine();
            String[] s_2 = s_1.split(" ");
            int c = Integer.parseInt(s_2[0]);
            if(c!=0) {
                n_l[c_l] = c;
                c_l++;
            }
            int a = Integer.parseInt(s_2[1]);
            int b = Integer.parseInt(s_2[2]);
            d_t inp = new d_t(a, b);
            while (true) {
                if (inp.getTime() <= time && c!=0) {
                    dirty_d.push(inp);
                    break;
                }
                if(dirty_d.topValue() != null) {
                    d_t recent = dirty_d.pop();
                    for (int i = 0; i < x_l[recent.getCo_n() - 1]; i++) {
//                        System.out.println("Yes In");
                        if (i == (x_l[recent.getCo_n() - 1] - 1)) {
                            recent.setFinish(time);
                            clean_d.push(recent);
//                            System.out.println("Yes In 2");
                        }
                        time++;
                    }
                    //System.out.println(recent.getFinish());
                }
                else if(c!=0)
                    time++;
                else
                    break;
            }
            if(c==0) {
                System.out.println(time-1);
                break;
            }
        }

        print(clean_d);
        print_n(n_l,n,x);
    }
}
