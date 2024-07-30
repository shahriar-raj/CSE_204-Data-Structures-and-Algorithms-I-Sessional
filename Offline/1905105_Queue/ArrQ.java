public class ArrQ<T> implements Queue<T>{
    private int memory, front, rear;
    private int x = 10;
    private T[] list;

    @SuppressWarnings("unchecked")
    public ArrQ(){
        memory  = x+1;
        rear = 0;
        front = 1;
        list = (T[])new Object[memory];
    }

    @SuppressWarnings("unchecked")
    public ArrQ(int n){
        memory = n+1;
        rear = 0;
        front = 1;
        list = (T[])new Object[memory];
    }

    @SuppressWarnings("unchecked")
    public ArrQ(T[] array){
        memory = array.length+1;
        list = (T[])new Object[memory];
        for(int i=1;i<memory;i++) {
            list[i] = array[i-1];
        }
        front = 1;
        rear = array.length;
    }

    @SuppressWarnings("unchecked")
    public void memory_update(){
        int l = memory-1;
//        System.out.println(memory+"aage");
        T[] temp = (T[]) new Object[memory-1];
        for(int i=0;i<memory-1;i++) {
            temp[i] = dequeue();
//            System.out.println(front + "   " + rear);
        }
        memory = ((memory-1)*2)+1;
        front = 1;
        rear = 0;
//        System.out.println(memory+" hehe");
        list = (T[]) new Object[memory];
        for(int i=0;i<l;i++) {
            enqueue(temp[i]);
//            System.out.println(front + "   " + rear);
        }
    }

    @Override
    public void clear() {
        rear = 0;
        front = 1;
    }

    @Override
    public void enqueue(T item) {
        if((rear+2)%memory==front){
            memory_update();
        }
        rear = (rear+1) % memory;
        list[rear] = item;
    }

    @Override
    public T dequeue() {
        if(length()==0)
            return null;
        T item = list[front];
        front = (front+1)%memory;
        return item;
    }

    @Override
    public int length() {
        return ((rear+memory)-front+1)%memory;
    }

    @Override
    public T frontValue() {
        if(length()==0)
            return null;
        return list[front];
    }

    @Override
    public T rearValue() {
        if(length()==0)
            return null;
        return list[rear];
    }

    @Override
    public T leaveQueue() {
        if(length()==0)
            return null;
        T item = list[rear];
        rear = (rear+memory-1)%memory;
        return item;
    }
}


//public class ArrQ <T> implements Queue<T>{
//    private int memory, rear;
//    private int x = 10;
//    private T[] list;
//
//    @SuppressWarnings("unchecked")
//    public ArrQ(){
//        memory = this.x;
//        rear = 0;
//        list = (T[]) new Object[memory];
//    }
//
//    @SuppressWarnings("unchecked")
//    public ArrQ(int x){
//        memory = x;
//        this.x = x;
//        rear = 0;
//        list = (T[]) new Object[memory];
//    }
//
//    public ArrQ( T[] l){
//        memory = this.x = l.length;
//        list = l;
//        rear = l.length;
//    }
//
//    @SuppressWarnings("unchecked")
//    public void memory_update(){
//        T[] temp = (T[])new Object[memory];
//        for(int i=0;i<rear;i++)
//            temp[i] = list[i];
//        memory = 2*memory;
//        list = (T[])new Object[memory];
//        for(int i=0;i<rear;i++)
//            list[i] = temp[i];
//    }
//
//    @Override
//    public void clear(){
//        rear = 0;
//    }
//
//    @Override
//    public void enqueue(T item) {
//        if(rear==memory)
//            memory_update();
//        list[rear++] = item;
//    }
//
//    @Override
//    public T dequeue() {
//        if(rear==0)
//            return null;
//        T item = list[0];
//        for(int i=0;i<rear-1;i++){
//            list[i] = list[i+1];
//        }
//        rear--;
//        return item;
//    }
//
//    @Override
//    public int length() {
//        return rear;
//    }
//
//    @Override
//    public T frontValue() {
//        if(rear == 0)
//            return null;
//        return list[0];
//    }
//
//    @Override
//    public T rearValue() {
//        if(rear == 0)
//            return null;
//        return list[rear-1];
//    }
//
//    @Override
//    public T leaveQueue() {
//        if(rear==0)
//            return null;
//        return list[--rear];
//    }
//}
