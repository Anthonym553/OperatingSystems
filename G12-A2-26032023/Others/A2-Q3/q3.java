import java.util.Random;

public class q3 {
    // global variable to store the number of points inside the circle
    private static int pointsInCircle = 0;

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java q3 <numPoints>");
            System.exit(1);
        }

        int numPoints = Integer.parseInt(args[0]);

        // create a thread to generate random points
        Thread t = new Thread(() -> {
            Random rand = new Random();
            for (int i = 0; i < numPoints; i++) {
                double x = rand.nextDouble(); // generate random x-coordinate
                double y = rand.nextDouble(); // generate random y-coordinate
                if (x * x + y * y <= 1) { // check if point is inside the circle
                    synchronized (q3.class) {
                        pointsInCircle++;
                    }
                }
            }
        });

        // start the thread
        t.start();

        try {
            // wait for the thread to finish
            t.join();
        } catch (InterruptedException e) {
            System.err.println(e);
        }

        // calculate the estimated value of pi
        double pi = 4.0 * pointsInCircle / numPoints;
        System.out.println("Estimated value of pi: " + pi);
    }
}
