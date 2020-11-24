public class MyInt {
    private int _t;
    public MyInt(int t) {_t = t;}
    synchronized public int get() {return _t;}
    synchronized public void inc() {
        _t++;
        if(_t%1000==0) {
            long id = Thread.currentThread().getId();
         //   System.out.println("id: "+id+"  "+_t);
        }
    }
}
