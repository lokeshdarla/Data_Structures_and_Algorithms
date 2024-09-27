#include <stdio.h>

struct Process {
    int id;        
    int burstTime; 
    int remainingTime; 
    int waitingTime;   
    int turnAroundTime; 
};

void roundRobin(struct Process proc[], int n, int quantum) {
    int time = 0;  
    int completed = 0; 

    while (completed < n) {
        for (int i = 0; i < n; i++) {
            if (proc[i].remainingTime > 0) {
                if (proc[i].remainingTime > quantum) {
                    time += quantum;
                    proc[i].remainingTime -= quantum;
                } else {
                    time += proc[i].remainingTime;
                    proc[i].remainingTime = 0;
                    completed++;
                    proc[i].turnAroundTime = time;
                    proc[i].waitingTime = proc[i].turnAroundTime - proc[i].burstTime;
                }
            }
        }
    }
}

void display(struct Process proc[], int n) {
    printf("\nProcess ID\tBurst Time\tWaiting Time\tTurnaround Time\n");
    for (int i = 0; i < n; i++) {
        printf("%d\t\t%d\t\t%d\t\t%d\n", proc[i].id, proc[i].burstTime, proc[i].waitingTime, proc[i].turnAroundTime);
    }
}

int main() {
    int n, quantum;
    
    printf("Enter the number of processes: ");
    scanf("%d", &n);

    struct Process proc[n];

    for (int i = 0; i < n; i++) {
        printf("Enter burst time for process %d: ", i + 1);
        scanf("%d", &proc[i].burstTime);
        proc[i].id = i + 1;
        proc[i].remainingTime = proc[i].burstTime;
    }

    printf("Enter time quantum: ");
    scanf("%d", &quantum);

    roundRobin(proc, n, quantum);

    display(proc, n);

    return 0;
}
