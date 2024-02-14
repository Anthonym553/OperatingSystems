#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

void *fibonacci(void *arg);

// Declare the shared variables
int *fib_seq;
int num_fib;

int main(int argc, char *argv[]) {
    pthread_t fib_thread;
    int rc;

    // Check that the correct number of command line arguments are passed
    if (argc != 2) {
        fprintf(stderr, "Usage: %s num_fib\n", argv[0]);
        exit(1);
    }

    // Convert the input argument to an integer
    num_fib = atoi(argv[1]);

    // Allocate memory for the Fibonacci sequence array
    fib_seq = (int *) malloc(num_fib * sizeof(int));

    // Create the Fibonacci thread
    rc = pthread_create(&fib_thread, NULL, fibonacci, NULL);
    if (rc) {
        fprintf(stderr, "Error creating thread\n");
        exit(1);
    }

    // Wait for the Fibonacci thread to finish
    rc = pthread_join(fib_thread, NULL);
    if (rc) {
        fprintf(stderr, "Error joining thread\n");
        exit(1);
    }

    // Output the Fibonacci sequence
    printf("Fibonacci sequence: ");
    for (int i = 0; i < num_fib; i++) {
        printf("%d ", fib_seq[i]);
    }
    printf("\n");

    // Free the memory allocated for the Fibonacci sequence array
    free(fib_seq);

    pthread_exit(NULL);
}

void *fibonacci(void *arg) {
    // Compute the Fibonacci sequence
    fib_seq[0] = 0;
    fib_seq[1] = 1;
    for (int i = 2; i < num_fib; i++) {
        fib_seq[i] = fib_seq[i-1] + fib_seq[i-2];
    }

    pthread_exit(NULL);
}
