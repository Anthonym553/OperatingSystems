package scheduling;
/**

 * FCFS scheduling algorithm.
 */
 
import java.util.*;

public class FCFS implements Algorithm
{
    //Variables to hold different values for the algorithm
    private List<Task> queue;
    private Task currentTask;

    private int tasksRun;

    //Constructor
    public FCFS(List<Task> queue) {
        this.queue = queue;

        tasksRun = queue.size();
    }

    //Method to run the algorithm
    public void schedule() {
        System.out.println("FCFS Scheduling \n");

        //While the queue is not empty, run the algorithm
        while (!queue.isEmpty()) {
            //Pick the next task to run
            currentTask = pickNextTask();
            
            //Run the task for the burst time
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
