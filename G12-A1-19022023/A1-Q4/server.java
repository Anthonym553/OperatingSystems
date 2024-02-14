package assg1_3000;

/**
 * @author Anthony Miranda, Matt Miranda, Jenna Morrill
 * 20 FEB 2023
 * Question 4
 */

import java.net.*;
import java.io.*;

/*
 * Server class that works alongside client in order to establish a connection and echo a given message from client.
 */

public class server {
	public static void main(String args[]) throws IOException{
		
		//Server Socket is created to listen for incoming client request
		try (ServerSocket serverSocket = new ServerSocket(8000)) {
			
			
			System.out.println("Server is Ready");
			
			//Server socket waits to accept client request
			Socket clientSocket = serverSocket.accept();
			System.out.println("Connection succesful");
			
			//Receives input from client
			DataInputStream clientInput = new DataInputStream(clientSocket.getInputStream());
			
			//variable to contain client message
			String message = clientInput.readUTF();
			
			//Echo from server sent back
			System.out.println("Echo from server: " + message);
			
			clientSocket.close();
		}
		
	}
}
