package thread.shared.resources;

public class Counter{
    public int count ;

    public Counter() {
        this.count = 0;
    }


    public void increment (){
       count++;
    }

    public int getCount() {
        return count;
    }


}