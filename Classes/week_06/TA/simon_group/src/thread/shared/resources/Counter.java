package thread.shared.resources;

public class Counter{
    public Integer count ;

    public Counter() {
        this.count = 0;
    }


    public void increment (){
       count++;
    }

    public Integer getCount() {
        return count;
    }


}