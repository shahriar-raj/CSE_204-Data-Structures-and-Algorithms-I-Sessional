import java.util.Scanner;
/* Object Declaration in line 55,56 & 67,68 & 79,80 */
public class TNL<T> {

    /*print function for Arr type object
     *the print function is executed by traversing through the whole list from start position(0) to last position(length-1)
     *the current position is stored in a temporary "l" variable and after the print statements are executed the current position once again becomes "l */
    public static void output(int k,Arr<Integer> obj){ //Takes two parameters; "k" is the total stands i.e. rickshaw stands and obj is the object of the BUS/TRAIN/RICKSHAW
        int l = obj.currPos();
        obj.moveToStart();
        for(int i=0,obj_i=0;i<k;i++){  //i is the loop count
            if(i == obj.getValue()) {
                System.out.print(obj.getValue());
                obj_i++;                            //obj_i is the match count
                if(i<k-1 && obj_i<obj.length())     //this condition is here so that it doesn't want to cross the last position
                    obj.next();
            }
            if(obj_i==obj.length())                 // if all the list items are printed, the loop is terminated and the next "," is not printed
                break;
            System.out.print(",");
        }
        System.out.println();
        obj.moveToPos(l);
    }

    /*print function for LL type object
    * works same as the Arr type print function*/
    public static void output(int k,LL<Integer> obj){
        int l = obj.currPos();
        obj.moveToStart();
        for(int i=0,obj_i=0;i<k;i++){
            if(i == obj.getValue()) {
                System.out.print(obj.getValue());
                obj_i++;
                if(i<k-1 && obj_i<obj.length())
                    obj.next();
            }
            if(obj_i==obj.length())
                break;
            System.out.print(",");
        }
        System.out.println();
        obj.moveToPos(l);
    }

    public static void main(String[] args) {
        int k, l, m;
        Integer[] rickshaw, bus, train;
        Scanner scn = new Scanner(System.in);
        k = scn.nextInt();                         //input of the number of total stands
        rickshaw = new Integer[k];
        for(int i=0;i<k;i++)
            rickshaw[i] = i;                        //assigns the rickshaw stands in an array

       // Arr<Integer> RICKSHAW = new Arr<>(k,rickshaw);
        LL<Integer> RICKSHAW = new LL<>(k,rickshaw);          //creates a list for Rickshaw stands and passes the previously created array as parameter and k as memory chunk size

        Scanner scn1 = new Scanner(System.in);
        l = scn1.nextInt();                                  //input of the number of bus stands
        Scanner scn2 =new Scanner(System.in);
        String s3 = scn2.nextLine();
        String[] s4 = s3.split(" ");
        bus = new Integer[l];
        for(int i=0;i<l;i++)
            bus[i] = Integer.parseInt(s4[i]);       //assigns the bus stands in an array

        //Arr<Integer> BUS = new Arr<>(k,bus);
        LL<Integer> BUS = new LL<>(k,bus);                  //creates a list for Bus stands and passes the previously created array as parameter and k as memory chunk size

        Scanner scn3 =new Scanner(System.in);
        m = scn3.nextInt();                                 //input of the number of train stands
        Scanner scn4 =new Scanner(System.in);
        s3 = scn4.nextLine();
        s4 = s3.split(" ");
        train = new Integer[m];
        for(int i=0;i<m;i++)
            train[i] = Integer.parseInt(s4[i]);              //assigns the train stands in an array

        //Arr<Integer> TRAIN = new Arr<>(k,train);
        LL<Integer> TRAIN = new LL<>(k,train);              //creates a list for Bus stands and passes the previously created array as parameter and k as memory chunk size

        Scanner scn5 = new Scanner(System.in);
        int T = scn5.nextInt();                             //inputs the task number

        switch (T){
            case 1:output(RICKSHAW.length(), RICKSHAW);
                   output(RICKSHAW.length(), BUS);
                   output(RICKSHAW.length(), TRAIN);
                   break;
            default:
                    System.out.println("Invalid Input");
                    break;
        }
    }


}
