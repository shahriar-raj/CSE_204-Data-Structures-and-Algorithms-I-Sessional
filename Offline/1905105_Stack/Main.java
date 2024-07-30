import java.util.Scanner;
//Object declaration at line no. 47 & 48

public class Main<T> {
    public static void print(Arr<Object> obj){
        Object[] l =new Object[obj.length()];
        int l_s = obj.length();
        System.out.print("<");
        for(int i = l_s-1; i>=0;i--){
            l[i] =  obj.pop();
        }
        for(int i =0;i< l_s;i++){
            System.out.print(l[i]);
            if(i<l_s-1)
                System.out.print(" ");
            obj.push(l[i]);
        }
        System.out.println(">");
    }

    public static void print(LL<Object> obj){
        Object[] l =new Object[obj.length()];
        int l_s = obj.length();
        System.out.print("<");
        for(int i = l_s-1; i>=0;i--){
            l[i] =  obj.pop();
        }
        for(int i =0;i< l_s;i++){
            System.out.print(l[i]);
            if(i<l_s-1)
                System.out.print(" ");
            obj.push(l[i]);
        }
        System.out.println(">");
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        Object[] l = new Object[x];
        Scanner scn1= new Scanner(System.in);
        String s1 = scn1.nextLine();
        String[] s2 = s1.split(" ");
        for(int i= 0;i<x;i++){
            l[i] = Integer.parseInt(s2[i]);
        }

          Arr<Object> obj = new Arr<>(l,1);
//        LL<Object> obj = new LL<>(l,1);

        print(obj);

        for(;;){
            Scanner scn3 = new Scanner(System.in);
            s1 = scn3.nextLine();
            s2 = s1.split(" ");
            int z = Integer.parseInt(s2[0]);
            if(z==0)
                break;
            switch (z){
                case 1:
                    obj.clear();
                    print(obj);
                    System.out.println(-1);
                    break;
                case 2:
                    obj.push(Integer.parseInt(s2[1]));
                    print(obj);
                    System.out.println(-1);
                    break;
                case 3:
                    Object p =obj.pop();
                    print(obj);
                    if(p==null)
                        System.out.println(-1);
                    else
                        System.out.println(p);
                    break;
                case 4:
                    print(obj);
                    System.out.println(obj.length());
                    break;
                case 5:
                    print(obj);
                    if(obj.topValue()==null) {
                        System.out.println("The list is empty!");
                        //System.out.println(-1);
                    }
                    else
                        System.out.println(obj.topValue());
                    break;
                case 6:
                    print(obj);
                    if(obj.length()!=0)
                        System.out.println("The list is not empty");
                    else
                        obj.setDirection(Integer.parseInt(s2[1]));
                    System.out.println(-1);
                    break;
                default:
                    System.out.println("Invalid Option");
                    break;
            }
        }
    }
}
