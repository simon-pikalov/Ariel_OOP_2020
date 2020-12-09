package proxy;

import java.util.ArrayList;
import java.util.List;

public class ExpensiveObjectProxy implements ExpensiveObject {
    private static ExpensiveObject object;

    @Override
    public void process() {
        if (object == null) {
            object = new ExpensiveObjectImpl();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        object.process();
    }

    public static void main(String[] args) {
        ExpensiveObject object = new ExpensiveObjectProxy();
        List<ExpensiveObject> expensiveObjectList = new ArrayList<>();
        expensiveObjectList.add(object);

        object.process();
        object.process();
    }

}