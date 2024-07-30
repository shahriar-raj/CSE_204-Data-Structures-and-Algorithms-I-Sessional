import java.util.Scanner;

public class OATS<T> {
    private int memory = 10;
    private T[] OATS_Arr;
    Arr<Object> front;
    Arr<Object> back;
    public OATS(){
        T[] OATS_Arr = (T[]) new Object[memory];
        front = new Arr<Object>(OATS_Arr,1);
        back = new Arr<Object>(OATS_Arr,-1);
    }

    private void memory_update(){
        Arr<Object> tempA = new Arr<>(OATS_Arr,1);
        Arr<Object> tempB = new Arr<>(OATS_Arr,-1);
        OATS_Arr = (T[]) new Object[memory*2];
        front = front = new Arr<Object>(OATS_Arr,1);
        back = new Arr<Object>(OATS_Arr,-1);
        int a = tempA.length();
        int b = tempB.length();
        for(int i=0;i<a;i++)
            pushA((T) tempA.pop());
        for(int i=0;i<b;i++)
            pushB((T) tempB.pop());

    }
    public void pushA(T item){
        if(OATS_Arr.length== (front.length()+ back.length()))
            memory_update();
        front.push(item);
    }

    public Object popA(){
        return front.pop();
    }

    public Object TopValueA(){
        return front.topValue();
    }

    public void pushB(T item){
        if(OATS_Arr.length== (front.length()+ back.length()))
            memory_update();
        back.push(item);
    }

    public Object popB(){
        return back.pop();
    }

    public Object TopValueB(){
        return back.topValue();
    }

    public static void main(String[] args) {
        OATS obj1 = new OATS();
        Scanner scn = new Scanner(System.in);
        String s1 = scn.nextLine();
        String[] s2 = s1.split(" ");
        switch (Integer.parseInt(s2[0])){
            case 1:
                obj1.pushA(s2[1]);
                break;
            case 2:
                obj1.popA();
                break;
        }
    }
}
