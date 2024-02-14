package scheduling;

import java.util.*;

public class RR implements Algorithm
{
    //variables to hold different values for the algorithm
    private static final int QUANTUM = 10
    private List<Task> queue;
    private Task currentTask;

    //constructor
    public RR(List<Task> queue) {
        this.queue = queue;
    }

    //method to run the algorithm
    public void schedule() {
        System.out.println("Round Robin Scheduling (time quantum = " + QUANTUM + ")\n");

        // run until all tasks are completed
        while (!queue.isEmpty()) {
            currentTask = pickNextTask();
            
            // run the current task for the specified time quantum
            CPU.run(currentTask, Math.min(QUANTUM, currentTask.getBurst()));

            // update the task's burst time
            currentTask.setBurst(currentTask.getBurst() - QUANTUM);

            // if the task is not finished, add it back to the end of the queue
            if (currentTask.getBurst() > 0) {
                queue.add(currentTask);
            }
        }
    }

    public Task pickNextTask() {
        // select the first task in the queue
        Task nextTask = queue.get(0);
        
        // move the first task to the end of the queue
        queue.remove(0);
        queue.add(nextTask);
        
        return nextTask;
    }
}
