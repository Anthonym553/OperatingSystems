package scheduling;

import java.util.*;

public class Priority implements Algorithm {
    // variables to hold different values for the algorithm
    private List<Task> queue;
    private Task currentTask;

    private int tasksRun;

    // constructor
    public Priority(List<Task> queue) {
        this.queue = queue;

        tasksRun = queue.size();
    }

    // method to run the algorithm
    public void schedule() {
        System.out.println("Priority Scheduling \n");

        // while the queue is not empty, run the algorithm
        while (!queue.isEmpty()) {
            currentTask = pickNextTask();
            CPU.run(currentTask, currentTask.getBurst());

            // remove the task
            queue.remove(currentTask);
        }
    }

    // method to pick the next task to run
    public Task pickNextTask() {
        return Collections.min(queue, new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                return Integer.compare(t1.getPriority(), t2.getPriority());
            }
        });
    }
}
