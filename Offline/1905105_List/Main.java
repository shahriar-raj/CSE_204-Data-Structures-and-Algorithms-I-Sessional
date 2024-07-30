import java.util.Scanner;
/* Object Declaration in line 66 & 68 */
public class Main<T> {

    /*print function for Arr type object
     *the print function is executed by traversing through the whole list from start position(0) to last position(length-1)
     *the current position is stored in a temporary "l" variable and after the print statements are executed the current position once again becomes "l"*/
    public static void print(Arr<Object> obj){
        int l = obj.currPos();
        System.out.print("<");
        obj.moveToStart();
        for(int i=0;i< obj.length();i++){
            if(i==l)
                System.out.print("| ");
            System.out.print(obj.getValue());
            if (i == obj.length()-1) {
            } else
                System.out.print(" ");

            if(i< obj.length()-1)
                obj.next();
        }
        System.out.println(">");
        obj.moveToPos(l);
    }

    /*print function for LL type object
    *works same as the print function with the parameter (Arr Object)*/
    public static void print(LL<Object> obj){
        int l = obj.currPos();
        System.out.print("<");
        obj.moveToStart();
        for(int i=0;i< obj.length();i++){
            if(i==l)
                System.out.print("| ");
            System.out.print(obj.getValue());
            if (i == obj.length()-1) {
            } else
                System.out.print(" ");

            if(i< obj.length()-1)
                obj.next();
        }
        System.out.println(">");
        obj.moveToPos(l);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.nextLine();             // Takes input as a string
        String[] s2 = s1.split(" ");      //splits the input in two parts
        int y = Integer.parseInt(s2[0]);        //first part is stored in "y" which is the input array size
        int x = Integer.parseInt(s2[1]);        //second part is stored in "x" which is the memory chunk size
        Object[] l = new Object[y];             //creates an array of Object type of size y
        s1 = scn.nextLine();                    //Takes the input as a string
        s2 = s1.split(" ");               //splits the string into y parts

        /*converts the String parts to Integer and takes the inputs in an array
         *This part can be executed for different types (i.e. Double(Double.parseDouble(String)) etc.)
         *just the conversion part will be different
         *we can also take as strings */
        for(int i=0;i<y;i++){
            l[i] = Integer.parseInt(s2[i]);
        }

        //Arr<Object> obj = new Arr<>(x,l);                         //object of Arr declared

        LL<Object> obj = new LL<>(x,l);                          //object of LL declared

        print(obj);                                             // First print operation after input

        /* infinite loop for options */
        for(;;){
            s1 = scn.nextLine();
            s2 = s1.split(" ");
            int z = Integer.parseInt(s2[0]); //takes the first part of the input and assigns it in z
            if(z==0)                         //"z" works as the function #number (if z=0 then the infinite loop stops and the main thread ends)
                break;
            /*if z is not 0 then by switch-case the number of function is executed
             *and if the number is not between 1 to 13, then the default case is executed*/
            switch (z){
                case 1: obj.clear();
                        print(obj);
                        System.out.println("-1");
                        break;
                case 2: obj.insert(Integer.parseInt(s2[1]));
                        print(obj);
                        System.out.println("-1");
                        break;
                case 3: obj.append(Integer.parseInt(s2[1]));
                        print(obj);
                        System.out.println("-1");
                        break;
                case 4: Object r_it = obj.remove();
                        if(r_it == null){
                            System.out.println("The list is empty you cannot remove anything!");
                            print(obj);
                            break;
                        }
                        print(obj);
                        System.out.println(r_it);
                        break;
                case 5: obj.moveToStart();
                        print(obj);
                        System.out.println("-1");
                        break;
                case 6: obj.moveToEnd();
                        print(obj);
                        System.out.println("-1");
                        break;
                case 7: obj.prev();
                        print(obj);
                        System.out.println("-1");
                        break;
                case 8: obj.next();
                        print(obj);
                        System.out.println("-1");
                        break;
                case 9: print(obj);
                        System.out.println(obj.length());
                        break;
                case 10: print(obj);
                        System.out.println(obj.currPos());
                        break;
                case 11: obj.moveToPos(Integer.parseInt(s2[1]));
                         print(obj);
                         System.out.println("-1");
                         break;
                case 12: print(obj);
                         System.out.println(obj.getValue());
                         break;
                case 13: print(obj);
                         System.out.println(obj.Search(Integer.parseInt(s2[1])));
                         break;
                default: System.out.println("Enter a valid option");
                         break;
            }
        }
    }
}













/*  Arr<Object> obj = new Arr<>(x); //if we want to instantiate by only memory size
            for(int i=0;i<y;i++){
            // System.out.println(s2[i]); //if we want to instantiate by only memory size
            obj.append(s2[i]);
        }
*/

