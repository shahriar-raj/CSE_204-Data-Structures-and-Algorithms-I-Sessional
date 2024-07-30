public class Arr <T> implements Stack<T>{
    private int memory,top = 0;
    private int x = 10;
    private int i_c = 1;
    private T[] list;

    @SuppressWarnings("unchecked")
    public Arr(){
        memory = this.x;
        top = 0;
        list = (T[]) new Object[memory];
    }

    @SuppressWarnings("unchecked")
    public Arr(int x){
        memory = x;
        top = 0;
        this.x = x;
        list = (T[]) new Object[memory];
    }

    public Arr( T[] l, int x){
        memory = this.x = l.length;
        list = l;
        i_c = x;
        if(i_c==1) {
            top = l.length;
        }
        else{
            top = memory-l.length-1;
        }
    }

    @SuppressWarnings("unchecked")
    private void memory_update(int i_c){
        T[] temp = (T[]) new Object[memory];
        if(i_c==1) {
            temp = list;
            memory = memory*2;
            list = (T[]) new Object[memory];
            for(int i=0; i<top; i++){
                list[i] = temp[i];
            }
        }
        else{
            int j =0;
            for(int i = memory-1; i>top; i--){
                temp[j++] = list[i];
            }
            top = memory*2-1-memory;
            memory = memory*2;
            list = (T[]) new Object[memory];
            j = 0;
            for(int i=memory-1;i>top;i--){
                list[i] = temp[j++];
            }
        }
    }

    @Override
    public void clear() {
        if(i_c==1)
            top = 0;
        else
            top = memory-1;
    }

    @Override
    public void push(T item) {
        //System.out.println(i_c);
        if(i_c==1){
            if(top==memory)
                memory_update(i_c);
            list[top++]=item;
        }
        else{
            if(top==-1)
                memory_update(i_c);
            list[top--]=item;
        }
    }

    @Override
    public T pop() {
        if(i_c==1){
            if(top==0)
                return null;
            return list[--top];
        }
        else{
            if(top==memory-1)
                return null;
            return list[++top];
        }
    }

    @Override
    public int length() {
        if(i_c==1)
            return top;
        else
            return memory-1-top;
    }

    @Override
    public T topValue() {
        if(i_c==1){
            if(top==0)
                return null;
            return list[top-1];
        }
        else {
            if(top == memory-1)
                return null;
            return list[top+1];
        }
    }

    public void setDirection(int i) {
            i_c = i;
            if(i_c==1)
                top = 0;
            else
                top = memory-1;
    }
}
