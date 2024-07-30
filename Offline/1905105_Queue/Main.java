import java.util.Scanner;
//Object initialization at line no. 48 & 49

public class Main {
    public static void print(ArrQ<Object> obj) {
        Object[] l = new Object[obj.length()];
        int l_s = obj.length();
        System.out.print("<");
        for (int i = 0; i < l_s; i++) {
            l[i] = obj.dequeue();
        }
        for (int i = 0; i < l_s; i++) {
            System.out.print(l[i]);
            if (i < l_s - 1)
                System.out.print(" ");
            obj.enqueue(l[i]);
        }
        System.out.println(">");
    }

    public static void print(LLQ<Object> obj) {
        Object[] l = new Object[obj.length()];
        int l_s = obj.length();
        System.out.print("<");
        for (int i = 0; i < l_s; i++) {
            l[i] = obj.dequeue();
        }
        for (int i = 0; i < l_s; i++) {
            System.out.print(l[i]);
            if (i < l_s - 1)
                System.out.print(" ");
            obj.enqueue(l[i]);
        }
        System.out.println(">");
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        Object[] l = new Object[x];
        Scanner scn1 = new Scanner(System.in);
        String s1 = scn1.nextLine();
        String[] s2 = s1.split(" ");
        for (int i = 0; i < x; i++) {
            l[i] = Integer.parseInt(s2[i]);
        }

          ArrQ<Object> obj = new ArrQ<>(l);
//        LLQ<Object> obj = new LLQ<>(l);

        print(obj);

        for (; ; ) {
            Scanner scn3 = new Scanner(System.in);
            s1 = scn3.nextLine();
            s2 = s1.split(" ");
            int z = Integer.parseInt(s2[0]);
            if (z == 0)
                break;
            switch (z) {
                case 1:
                    obj.clear();
                    print(obj);
                    System.out.println(-1);
                    break;
                case 2:
                    obj.enqueue(Integer.parseInt(s2[1]));
                    print(obj);
                    System.out.println(-1);
                    break;
                case 3:
                    Object p = obj.dequeue();
                    print(obj);
                    if(p == null)
                        System.out.println("The Queue is empty");
                    else
                        System.out.println(p);
                    break;
                case 4:
                    print(obj);
                    System.out.println(obj.length());
                    break;
                case 5:
                    print(obj);
                    if(obj.frontValue() == null)
                        System.out.println("The Queue is empty");
                    else
                        System.out.println(obj.frontValue());
                    break;
                case 6:
                    print(obj);
                    if(obj.rearValue()==null)
                        System.out.println("The Queue is empty");
                    else
                        System.out.println(obj.rearValue());
                    break;
                case 7:
                    Object q = obj.leaveQueue();
                    print(obj);
                    if(q==null)
                        System.out.println("The Queue is empty");
                    else
                        System.out.println(q);
                    break;
                default:
                    System.out.println("Invalid Option");
                    break;
            }
        }
    }
}