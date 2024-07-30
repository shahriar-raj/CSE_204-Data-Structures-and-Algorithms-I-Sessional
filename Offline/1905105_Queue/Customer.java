public class Customer{
    private int e_time,s_time;

    public Customer(int e, int s){
        setE_time(e);
        setS_time(s);
    }

    public Customer(){
    }
    public void setE_time(int e_time) {
        this.e_time = e_time;
    }

    public void setS_time(int s_time) {
        this.s_time = s_time;
    }

    public int getE_time() {
        return e_time;
    }

    public int getS_time() {
        return s_time;
    }
}