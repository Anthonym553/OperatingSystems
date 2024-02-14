// Matt Miranda, Anthony Miranda, Jenna Morrill
// Februrary 20, 2023
// Assignment 1 Question 2

#include <stdlib.h>
#include <unistd.h>

int main() {
    //create a new process
	int pid = fork();

	if(pid!=0) {
		sleep(20);
	} 
	else {
		exit(0);
	}
	
	return 0;
}
