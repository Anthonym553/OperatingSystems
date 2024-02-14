// Matt Miranda, Anthony Miranda, Jenna Morrill
// February 20, 2023
// Assignment 1 Question 5

#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/types.h>
#include<string.h>
#include<sys/wait.h>
#include<ctype.h>
  
int main() {

	// Creates variables for the two pipes, and string entered by the user
	int pipe1[2]; 
	int pipe2[2]; 
	char buffer[30];
	
	// Lets the user know if either pipe cannot be created
	if (pipe(pipe1) < 0) {
		fprintf(stderr, "Pipe one cannot be created");
		return 1;
	}
	if (pipe(pipe2) < 0) {
		fprintf(stderr, "Pipe two cannot be created");
		return 1;
	}
	
	// Gets the string from the user and makes the last character in the array null
	printf("Enter a string : ");
	fgets(buffer,sizeof(buffer),stdin);
	buffer[strlen(buffer)-1]='\0';
	int pid = fork();
  
	// Parent process where the first pipe is closed and the string is written to that pipe. Program then waits for child process 
	// before closing the second pipe and reading from it
	if (pid > 0) {
		close(pipe1[0]); 
		write(pipe1[1], buffer, strlen(buffer) + 1);
		close(pipe1[1]);
  
		wait(NULL);
		close(pipe2[1]);
  
		read(pipe2[0], buffer, sizeof(buffer));
		printf("Parent received string: '%s' from child\n", buffer);
		close(pipe2[0]);
	}
	
	// Lets user know if fork process failed due to a negative pid
	else if (pid < 0) {
	fprintf(stderr, "Fork failed, the pid cannot be negative" );
	return 1;
	}

	// Child process that first closes the first pipe and reads from it, then both pipes are closed and the user 
	// sees what the child receives from the parent
	else {
		close(pipe1[1]); 
		read(pipe1[0], buffer, sizeof(buffer));
		close(pipe1[0]);
		close(pipe2[0]);
		printf("Child received string: '%s' from parent\n",buffer);
		

		//For loop which simply changes the case of each letter to the opposite type
		for(i = 0; i < strlen(buffer); i++) {
			if(islower(buffer[i])) {
				buffer[i]=toupper(buffer[i]);
			}
			
			else if(isupper(buffer[i])) {
				buffer[i]=tolower(buffer[i]);
			}
			
		}
		
		//Writes the new buffer and displays in on pipe2 
		write(pipe2[1], buffer, strlen(buffer) + 1);
		close(pipe2[1]);
		exit(0);
	}
}
