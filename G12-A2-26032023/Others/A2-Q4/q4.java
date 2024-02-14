import java.net.*;
import java.io.*;

public class q4 {

    // Create a ServerSocket object that listens for client connections on port 6013
    public static void main(String[] args){

        try {
            ServerSocket sock = new ServerSocket(6013);

            // Infinite loop to listen for client connections
            while (true){
                Socket client = sock.accept();

                // Create a new thread to handle the client
                Thread thread = new Thread(new ClientHandler(client));
                thread.start();
            }
        } catch (IOException ioe){
            // Handle exceptions
            System.err.println(ioe);
        }
    }
}

class ClientHandler implements Runnable {
    private Socket client;

    // Constructor that takes the client socket as an argument
    public ClientHandler(Socket client) {
        this.client = client;
    }

    // Method that defines the behavior of the thread
    public void run() {
        try {
            // Create a PrintWriter object to send the current date and time to the client
            PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
            pout.println(new java.util.Date().toString());
            client.close();
        } catch (IOException ioe) {
            // Handle exceptions
            System.err.println(ioe);
        }
    }
}
