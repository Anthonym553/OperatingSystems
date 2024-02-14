// Matt Miranda, Anthony Miranda, Jenna Morrill
// February 20, 2023
// Assignment 1 Question 3

#include<stdio.h>
#include<sys/wait.h>
#include<stdlib.h>
#include<unistd.h>
  
int main() {

int i, pid;

printf("Enter a number: ");
scanf("%d",&i);

// Returns process ID
pid = fork();
  
// First checks if the child was created successfully, if it was, it loops through and checks the number to see if its 1, 
// if not, it divides the number by 2 if its even or multiples it by 3 and adds 1 if its odd. Also checks if the number that was entered is negative
if ( pid < 0 ) {
	printf("Child failed to be created\n");
	exit(0);
}
else if (pid == 0) {
	if(i > 0) 
	{
		while(i > 0){
			printf("%d ",i);
			if (i == 1) {
				break;
			}
			else if (i % 2 == 0) {
				i = i / 2;
			}	
			else {
				i = (3 * i) + 1;
		}
			
	}
}
else {
	printf("\nThe number you entered must be positive");
}
	exit(0);
}

// Parent process waits for child process to stop
else {
	wait(NULL);
}
  
return 0;
}