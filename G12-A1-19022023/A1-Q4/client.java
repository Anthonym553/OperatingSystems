package assg1_3000;

/**
 * @author Anthony Miranda, Matt Miranda, Jenna Morrill
 * 20 FEB 2023
 * Question 4
 */

import java.io.*;
import java.net.*;
import java.util.Scanner;

/*
 * Client class that works alongside server class to establish a connection and receive user input.
 */

public class client {
	
	public static void main(String args[]) throws IOException{
		
		
		//Socket establishing connection with server
		try (Socket client = new Socket("localhost", 8000)) {
			
			System.out.println("Client connection established");
			
			//Obtain the message
			DataOutputStream message = new DataOutputStream(client.getOutputStream());
			
			System.out.println("Input client message: ");
			 
			//Obtaining message from client
			Scanner kbd1 = new Scanner(System.in);
			String userInput = kbd1.nextLine();
			
			//Client message is then written for server use
			message.writeUTF(userInput);
			
			
			message.close();
			kbd1.close();
		}
	}
}
