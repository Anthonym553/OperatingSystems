package scheduling;

import java.util.*;

public class SJF implements Algorithm
{
	//Variables to hold different values for the algorithm
    private List<Task> queue;
    private Task currentTask;

    private int tasksRun;

	//Constructor
    public SJF(List<Task> queue) {
        this.queue = queue;
		//Sort the queue by burst time
        Collections.sort(this.queue, new Comparator<Task>() {
            public int compare(Task t1, Task t2) {
                return t1.getBurst() - t2.getBurst();
            }
        });

        tasksRun = queue.size();
    }

	//Method to run the algorithm
    public void schedule() {
        System.out.println("SJF Scheduling \n");

		//While the queue is not empty, run the algorithm
        while (!queue.isEmpty()) {
            currentTask = pickNextTask();
            
            CPU.run(currentTask, currentTask.getBurst());

            // remove the task
            queue.remove(currentTask);
        }
    }

	//Method to pick the next task to run
    public Task pickNextTask() {
        return queue.get(0);
    }
}

