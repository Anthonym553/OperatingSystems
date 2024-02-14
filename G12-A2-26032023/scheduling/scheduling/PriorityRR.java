package scheduling;

import java.util.*;

public class PriorityRR implements Algorithm
{
	//Variables to hold different values for the algorithm
    private static final int QUANTUM = 10
    private List<Task> queue;
    private Task currentTask;

    private int tasksRun;
    private int remainingQuantum;

	//Constructor
    public PriorityRR(List<Task> queue) {
        this.queue = queue;
        this.remainingQuantum = QUANTUM;

        tasksRun = queue.size();
    }

	//Method to run the algorithm
    public void schedule() {
        System.out.println("Priority Round Robin Scheduling (quantum = " + QUANTUM + ")\n");

		//While the queue is not empty, run the algorithm
        while (!queue.isEmpty()) {
            currentTask = pickNextTask();

			// if the current task's burst is greater than the remaining quantum
            if (currentTask.getBurst() > remainingQuantum) {
                CPU.run(currentTask, remainingQuantum);
                currentTask.setBurst(currentTask.getBurst() - remainingQuantum);
                remainingQuantum = 0;
                queue.add(currentTask);
            } 
			// if the current task's burst is less than the remaining quantum
			else {
                CPU.run(currentTask, currentTask.getBurst());
                queue.remove(currentTask);
                remainingQuantum = QUANTUM;
            }

            // check if priority of any task has changed
            for (Task t : queue) {
                if (t.getPriority() < currentTask.getPriority()) {
                    t.setPriority(t.getPriority() + 1);
                }
            }
        }
    }

    public Task pickNextTask() {
        // sort the queue by priority
        Collections.sort(queue, new Comparator<Task>() {
            public int compare(Task t1, Task t2) {
                return t1.getPriority() - t2.getPriority();
            }
        });

        return queue.get(0);
    }
}
