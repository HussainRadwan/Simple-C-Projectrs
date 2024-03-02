#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX 1000

const char* getColumn(char *line, int cno) {
    const char* tok;
    for(tok = strtok(line, "$"); tok && *tok; tok = strtok(NULL, "$\n")) {
        if(!--cno)
            return tok;
    }
    return NULL;
}

int menuChoice() {
    printf("\nMENU:\n");
    printf("1. Sort data in ascending order according to students' IDs and then display it.\n");
    printf("2. Sort data in ascending order according to students' names and then display it.\n");
    printf("3. Sort data in descending order according to students' scores and then display it.\n");
    printf("4. Ask the user to enter a student ID and display his score.\n");
    printf("5. Ask the user to enter a student name and display his score.\n");
    printf("6. Exit the program.\n");
    printf("Enter your choice: ");
    int choice;
    scanf("%d", &choice);
    return choice;
}

void displayRecord(int ids[], char names[][50], double scores[], int n) {
        printf("%-10s %-50s %-10s\n", "ID", "Name", "Score");
        for(int i = 0; i < n; i++) {
            printf("%-10d %-50s %-10.2lf\n", ids[i], names[i], scores[i]);
        }
}

void sortAscendingByID(int ids[], char names[][50], double scores[], int n) {
    int min_index;
    char *tempc = malloc(sizeof(char) * 50);
    for(int i = 0; i < n; i++) {
        min_index = i;
        for(int j = i+1; j < n; j++) {
            if(ids[j] < ids[min_index])
                min_index = j;
        }
        // swapping
        int tempi = ids[i];
        ids[i] = ids[min_index];
        ids[min_index] = tempi;

        strcpy(tempc, names[i]);
        strcpy(names[i], names[min_index]);
        strcpy(names[min_index], tempc);

        double tempd = scores[i];
        scores[i] = scores[min_index];
        scores[min_index] = tempd;
    }
    displayRecord(ids, names, scores, n);
    char ch;
    printf("Do you want to save the result to a file? (y/n) ");
    scanf(" %c", &ch);
    if(ch == 'y' || ch == 'Y') {
        printf("Enter filename to save the result: ");
        char filename[30];
        scanf("%s", filename);
        FILE *fp = fopen(filename, "w");
        fprintf(fp, "Records sorted in ascending order of ids:\n\n");
        fprintf(fp, "%-10s %-50s %-10s\n", "ID", "Name", "Score");
        for(int i = 0; i < n; i++) {
            fprintf(fp, "%-10d %-50s %-10.2lf\n", ids[i], names[i], scores[i]);
        }
        fclose(fp);
    }
}

void sortAscendingByName(int ids[], char names[][50], double scores[], int n) {
    int min_index;
    char *tempc = malloc(sizeof(char) * 50);
    for(int i = 0; i < n; i++) {
        min_index = i;
        for(int j = i+1; j < n; j++) {
            if(strcmp(names[j], names[min_index]) < 0)
                min_index = j;
        }
        // swapping
        int tempi = ids[i];
        ids[i] = ids[min_index];
        ids[min_index] = tempi;

        strcpy(tempc, names[i]);
        strcpy(names[i], names[min_index]);
        strcpy(names[min_index], tempc);

        double tempd = scores[i];
        scores[i] = scores[min_index];
        scores[min_index] = tempd;

    }
    displayRecord(ids, names, scores, n);
    char ch;
    printf("Do you want to save the result to a file? (y/n) ");
    scanf(" %c", &ch);
    if(ch == 'y' || ch == 'Y') {
        printf("Enter filename to save the result: ");
        char filename[30];
        scanf("%s", filename);
        FILE *fp = fopen(filename, "w");
        fprintf(fp, "Records sorted in ascending order of names:\n\n");
        fprintf(fp, "%-10s %-50s %-10s\n", "ID", "Name", "Score");
        for(int i = 0; i < n; i++) {
            fprintf(fp, "%-10d %-50s %-10.2lf\n", ids[i], names[i], scores[i]);
        }
        fclose(fp);
    }
}

void sortDescendingByScore(int ids[], char names[][50], double scores[], int n) {
    int max_index;
    char *tempc = malloc(sizeof(char) * 50);
    for(int i = 0; i < n; i++) {
        max_index = i;
        for(int j = i+1; j < n; j++) {
            if(scores[j] > scores[max_index])
                max_index = j;
        }
        // swapping
        int tempi = ids[i];
        ids[i] = ids[max_index];
        ids[max_index] = tempi;

        strcpy(tempc, names[i]);
        strcpy(names[i], names[max_index]);
        strcpy(names[max_index], tempc);

        double tempd = scores[i];
        scores[i] = scores[max_index];
        scores[max_index] = tempd;

    }
    displayRecord(ids, names, scores, n);
    char ch;
    printf("Do you want to save the result to a file? (y/n) ");
    scanf(" %c", &ch);
    if(ch == 'y' || ch == 'Y') {
        printf("Enter filename to save the result: ");
        char filename[30];
        scanf("%s", filename);
        FILE *fp = fopen(filename, "w");
        fprintf(fp, "Records sorted in descending order of score:\n\n");
        fprintf(fp, "%-10s %-50s %-10s\n", "ID", "Name", "Score");
        for(int i = 0; i < n; i++) {
            fprintf(fp, "%-10d %-50s %-10.2lf\n", ids[i], names[i], scores[i]);
        }
        fclose(fp);
    }
}

void searchById(int ids[], char names[][50], double scores[], int n) {
    int id, i;
    printf("Enter student ID: ");
    scanf("%d", &id);
    for(i = 0; i < n; i++) {
        if(ids[i] == id) {
            break;
        }
    }
    if(i != n) {
        printf("The score is %.2lf\n", scores[i]);
    }
    else {
        printf("Student ID not found!\n");
    }
}

void searchByName(int ids[], char names[][50], double scores[], int n) {
    int i;
    char name[50];
    printf("Enter student name: ");
    scanf(" %[^\n]%*c", name);

    for(i = 0; i < n; i++) {
        if(strcmp(name, names[i]) == 0) {
            break;
        }
    }
    if(i != n) {
        printf("The score is %.2lf\n", scores[i]);
    }
    else {
        printf("Student Name not found!\n");
    }
}

int main() {
    char names[MAX][50];
    int ids[MAX];
    double scores[MAX];
    char filename[30];
    printf("Enter filename: ");
    scanf("%s", filename);
    FILE *fp = fopen(filename, "r");
    if(!fp) {
        printf("File could not be opened.\n");
        exit(0);
    }
    int c = 0;
    char line[100];
    while(fgets(line, 100, fp)) {
        char *temp = strdup(line);
        ids[c] = atoi(getColumn(temp, 1));
        temp = strdup(line);
        strcpy(names[c], getColumn(temp, 2));
        double score_types[5];
        for(int i = 0; i < 5; i++) {
            temp = strdup(line);
            score_types[i] = atof(getColumn(temp, i+3));
        }
        scores[c] = 0.15 * score_types[0] + 0.15 * score_types[1] + 0.25 * score_types[2] +
                    0.10 * score_types[3] + 0.35 * score_types[4];
        c++;
    }
    fclose(fp);
    displayRecord(ids, names, scores, c);

    int choice;
    do {
        choice = menuChoice();

        switch (choice)
        {
        case 1:
            sortAscendingByID(ids, names, scores, c);
            break;
        case 2:
            sortAscendingByName(ids, names, scores, c);
            break;
        case 3:
            sortDescendingByScore(ids, names, scores, c);
            break;
        case 4:
            searchById(ids, names, scores, c);
            break;
        case 5:
            searchByName(ids, names, scores, c);
            break;
        case 6:
            printf("Exitting..\n");
            break;
        default:
            printf("Invalid choice!\n");
            break;
        }
    }while(choice != 6);
}
