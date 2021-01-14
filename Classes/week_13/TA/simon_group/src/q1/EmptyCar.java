package q1;

import java.util.Date;

public class EmptyCar implements car {
    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public boolean open(String key) {
        return false;
    }

    @Override
    public Date lastRun() {
        return null;
    }
}
