public class Counter {
    private int _count;

    public void setCounter(int count){
        _count=count;
    }
    public int getCounter(){
        return _count;
    }
    public void increment() {
        _count = _count + 1;
    }
}
