public class Arr<T> implements List<T> {
    private int memory;
    private int listSize;
    private int curr;
    private int x = 10;
    private T[] list;
    /*Constructor with no parameters, creates an empty list with default memory size of "x"*/
    Arr(){
        memory = this.x;
        listSize = 0;
        curr = 0;
        list = (T[]) new Object[memory];
    }

    /*Constructor with one parameter(memory chunk size), creates an empty list with user given memory size of "x"*/
    Arr(int x){
        memory = x;
        listSize = 0;
        curr = 0;
        this.x = x;
        list = (T[]) new Object[memory];
    }

    /*Constructor with two parameters, creates an list with user given memory size of "x" and instantiates the list with user given array*/
    Arr(int x, T[] l){
        memory = x;
        listSize = l.length;
        curr = 0;
        this.x = x;
        list = (T[]) new Object[memory];
        for(int i=0;i<listSize;i++){
            list[i] = l[i];
        }
        //System.out.println(list.length);
    }

    @Override
    public void clear() {
        memory = 0;
        listSize = 0;  //clears the list
        //print();
    }

    public void insert(T item){
        if(listSize==memory){
            memory = memory + x;                // when the list size becomes equal to the memory size and the user conducts an insert operation, this part is executed
            T[] temp;                           // the "memory" variable is incremented by x and another temporary array of objects is created
            temp = list;                        //the reference of list is passed to temp
            list = (T[]) new Object[memory];    //another list is created with the incremented memory
            for(int i=0; i<listSize; i++){
                list[i] = temp[i];              //and the members of temp is copied to the list
            }
          //  System.out.println("size incremented");
        }
        for(int i=listSize;i>curr;i--){
            list[i] = list[i-1];                //all the members of the list right to the bar shifts one place to the right
        }
        list[curr] = item;                      //and a new item given by the user is inserted after the bar or in the
        listSize++;
       // print();
    }

    @Override
    public void append(T item) {
        if(listSize==memory){
            memory = memory + x;
            T[] temp;
            temp = (T[]) new Object[memory]; //almost same as insert (no shifting)
            temp = list;
            list = (T[]) new Object[memory];
            for(int i=0; i<listSize; i++){
                list[i] = temp[i];
            }
            //System.out.println("size incremented");
        }
        list[listSize] = item;
        listSize++;                                             // adds an item at last
       // System.out.println("inserted"+listSize);
       // print();
    }

    @Override
    public T remove(){
        if(listSize == 0)
            return null;
        T item = list[curr];                //stores the removed iem to return
        for(int i=curr;i<listSize-1;i++){   //almost reverse of insert
            list[i] = list[i+1];
        }
        if(curr == listSize-1 && curr>0)
            curr--;
        listSize--;
      //  print();
        return item;                        //returns the removed item
    }

    @Override
    public void moveToStart(){
        curr = 0;                           //moves to the first position(0)
    }

    @Override
    public void moveToEnd(){
        if(listSize>0)                      //moves to the last position(length - 1)
            curr = listSize-1;
    }

    @Override
    public void prev(){
        if(curr>0)
            curr-=1;                        // moves to the previous position
        else
            System.out.println("This operation cannot be executed");
    }

    @Override
    public void next(){
        if(curr<listSize-1)
            curr+=1;                        // moves to the next position
        else
            System.out.println("This operation cannot be executed");
    }

    @Override
    public int length(){
        return listSize;                    //returns the list size
    }

    @Override
    public int currPos() {
        return curr;                        //returns the current position
    }

    @Override
    public void moveToPos(int pos) {
        if(pos>=0 && pos<=listSize)
            curr = pos;
        else
            System.out.println("This operation cannot be executed");
    }

    @Override
    public T getValue() {
        return list[curr];
    }

    @Override
    public int Search(T item) {
        int f=-1;                       //instantiates the "f" variable with -1
        for(int i=0;i<listSize;i++){   //traverses through the list from start
            if(list[i].equals(item))   //if the item is found stores the position in f
                f=i;
        }
        return f;                       //returns "f"
    }
}
