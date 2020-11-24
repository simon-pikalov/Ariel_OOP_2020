package exp_2;

public class Task implements Runnable {
    private static final float kTASK_STEPS = 6.f;
    private String name;

    public Task(String name) {
        this.name = name;
    }

    /**
     * Executes the task witch has %kTASKS_STEPS% steps
     */
    private void exe() {
        try {
            System.out.println(name + " Started!");
            for (int i = 0; i <= kTASK_STEPS; ++i) {
                System.out.println(String.format("Executing task: %s %.2f%%", name, 100 * i / kTASK_STEPS));

                Thread.sleep(100);
            }

            System.out.println(name + " complete");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        exe();
    }
} 
