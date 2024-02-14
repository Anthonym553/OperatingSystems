#include <stdio.h>
#include <pthread.h>
#include <stdlib.h>

double avg;
int max, min;

// Function to calculate average
void *calc_avg(void *arg) {
    int *num_list = (int *) arg;
    int count = num_list[0];
    double sum = 0;
    for (int i = 1; i <= count; i++) {
        sum += num_list[i];
    }
    avg = sum / count;
    pthread_exit(NULL);
}

// Function to calculate maximum
void *calc_max(void *arg) {
    int *num_list = (int *) arg;
    int count = num_list[0];
    max = num_list[1];
    for (int i = 2; i <= count; i++) {
        if (num_list[i] > max) {
            max = num_list[i];
        }
    }
    pthread_exit(NULL);
}

// Function to calculate minimum
void *calc_min(void *arg) {
    int *num_list = (int *) arg;
    int count = num_list[0];
    min = num_list[1];
    for (int i = 2; i <= count; i++) {
        if (num_list[i] < min) {
            min = num_list[i];
        }
    }
    pthread_exit(NULL);
}

int main(int argc, char *argv[]) {
    // Checks if the executable is being ran correctly
    if (argc < 2) {
        fprintf(stderr, "Usage: %s num1 num2 num3 ...\n", argv[0]);
        exit(1);
    }

    int count = argc - 1;
    int *num_list = malloc((count + 1) * sizeof(int));
    num_list[0] = count;
    for (int i = 0; i < count; i++) {
        num_list[i+1] = atoi(argv[i+1]);
    }

    pthread_t threads[3];
    int rc;

    // Creates thread for calulating average
    rc = pthread_create(&threads[0], NULL, calc_avg, (void *) num_list);
    if (rc) {
        fprintf(stderr, "Error creating thread\n");
        exit(1);
    }

    // Creates thread for calculating maximum
    rc = pthread_create(&threads[1], NULL, calc_max, (void *) num_list);
    if (rc) {
        fprintf(stderr, "Error creating thread\n");
        exit(1);
    }

    // Creates thread for calculating minimum
    rc = pthread_create(&threads[2], NULL, calc_min, (void *) num_list);
    if (rc) {
        fprintf(stderr, "Error creating thread\n");
        exit(1);
    }

    for (int i = 0; i < 3; i++) {
        rc = pthread_join(threads[i], NULL);
        if (rc) {
            fprintf(stderr, "Error joining thread\n");
            exit(1);
        }
    }

    // Prints results
    printf("The average value is %.2f\n", avg);
    printf("The minimum value is %d\n", min);
    printf("The maximum value is %d\n", max);

    // Frees memory used by the list of numbers
    free(num_list);
    pthread_exit(NULL);
}
