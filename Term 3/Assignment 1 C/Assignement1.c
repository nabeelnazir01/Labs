/**
 * Title:  Assignment 1 - Student Registration System
 * Course: CST8234 - C Language
 * Term:   Summer 2020
 *
 *  Team:
 *  	Student #1: Nabeel Nazir (nazi0022)
 *  	Student #2: Justin Warkus-Fortin (wark0025)
 *
 *  Status:
 *
 * 		Requirement #1: complete
 *      Requirement #2: complete
 *      Requirement #3: complete
 *      Requirement #4: complete
 *      Requirement #5: complete
 *      Requirement #6: complete
 *      Requirement #7: complete
 *      Requirement #8: complete
 *
 */

#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
#include "helper.h"

void menu()
{

    printf("Please select one of the following options.\n");
    printf("1) Add student to a course\n");
    printf("2) Remove student from a course\n");
    printf("3) See registration table\n");
    printf("4) Quit\n");
    fflush(stdout);
}

void addremStudents(int studentID[], int studentNum, char *courseCode[],
                    int numCourses, int regTable[studentNum][numCourses], int choice)
{

    printf("Please enter student ID \n");
    fflush(stdout);
    int stID;
    scanf("%d", &stID);
    int i;
    for (i = 0; i < studentNum; i++)
    {

        if (studentID[i] == stID)
        {

            printf("Please enter course code \n");
            fflush(stdout);
            char *courseID = (char *)malloc(sizeof(char) * 8);
            scanf("%s", courseID);
            int j;
            for (j = 0; j < numCourses; j++)
            {

                if (strcmp(courseCode[j], courseID) == 0)
                {
                    regTable[i][j] = choice;
                    i = studentNum;
                    break;
                }
                else if ((j == numCourses - 1) && (strcmp(courseCode[j], courseID) != 0))
                {
                    printf("Course code is not in the database\n");
                    fflush(stdout);
                }
            }
        }
        else if ((i == studentNum - 1) && (studentID[i] != stID))
        {
            printf("Student id is not in the database\n");
            fflush(stdout);
        }
    }
}

void printIntArray(int array[], size_t length)
{
    int index;
    printf("[");
    for (index = 0; index < length; index++)
    {
        printf("%d", array[index]);
        if (index < length - 1)
        {
            printf(", ");
        }
    }
    printf("]\n");
}

/* used to print any 1D char array */
void printStringArray(char *array[], size_t length)
{
    int index;
    printf("[");
    for (index = 0; index < length; index++)
    {
        printf("%s", array[index]);
        if (index < length - 1)
        {
            printf(", ");
        }
    }
    printf("]\n");
}

/*
 Used to initialize any integer 2d array.
 This is important so that the complier correctly reserve the needed space in memory.
 You won't be able to use these arrays otherwise.
 
 Usage:
 int array[rowSize][columnSize];
 initilaize2DArray((int *)array, rowSize, columnSize);
 */
void initilaize2DArray(int *array, size_t rowSize, size_t columnSize)
{
    int row, column;
    for (row = 0; row < rowSize; row++)
    {
        for (column = 0; column < columnSize; column++)
        {
            *(array + row * columnSize + column) = -1;
        }
    }
}

/*
 Convience method to print integer 2D arrays
 
 Usage:
 int array[rowSize][columnSize];
 print2DArray((int *)array, rowSize, columnSize);
 */
void print2DArray(int *array, size_t rowSize, size_t columnSize)
{
    int row, column;
    printf("[ ");
    for (row = 0; row < rowSize; row++)
    {
        printf("[ ");
        for (column = 0; column < columnSize; column++)
        {
            printf("%d", *(array + row * columnSize + column));
            if (column < columnSize - 1)
            {
                printf(", ");
            }
        }
        printf(" ]");
        if (row < rowSize - 1)
        {
            printf(", ");
        }
    }
    printf(" ]\n");
}

int main(void)
{

    int studentNum;
    printf("Please enter the number of students you wish to enter \n");
    fflush(stdout);
    scanf("%d", &studentNum);
    int studentID[studentNum];

    for (int i = 0; i < studentNum; i++)
    {
        printf("Please enter student id for student %d \n", i + 1);
        fflush(stdout);
        scanf("%i", &studentID[i]);
        int idLength = log10(studentID[i]) + 1;
        while (idLength != 5)
        {
            printf("Student ID must be 5 digits.\nPlease enter student id for student %d \n", i + 1);
            fflush(stdout);
            scanf("%i", &studentID[i]);
            idLength = log10(studentID[i]) + 1;
        }
    }
    printIntArray(studentID, studentNum);

    int numCourses;
    printf("Please enter the number of courses you wish to enter \n");
    fflush(stdout);
    scanf("%d", &numCourses);
    char *courseCode[numCourses];

    for (int i = 0; i < numCourses; i++)
    {
        courseCode[i] = (char *)malloc(sizeof(char) * 8);
        printf("Please enter course code for course %d \n", i + 1);
        fflush(stdout);
        scanf("%s", courseCode[i]);
        while (strlen(courseCode[i]) != 7)
        {
            printf("Course code must be 7 characters long.\nPlease enter course code for course %d \n", i + 1);
            fflush(stdout);
            scanf("%s", courseCode[i]);
        }
    }
    printStringArray(courseCode, numCourses);
    int regTable[studentNum][numCourses];
    initilaize2DArray(*(regTable), studentNum, numCourses);

    int selection;

    while (selection != 4)
    {
        menu();

        scanf("%i", &selection);
        fflush(stdout);

        switch (selection)
        {
        case 1:
            addremStudents(studentID, studentNum, courseCode, numCourses, regTable, 1);
            print2DArray(*(regTable), studentNum, numCourses);
            break;
        case 2:
            addremStudents(studentID, studentNum, courseCode, numCourses, regTable, 0);
            print2DArray(*(regTable), studentNum, numCourses);
            break;
        case 3:
            print2DArray(*(regTable), studentNum, numCourses);
            break;
        case 4:
            printf("Exiting");
            break;
        default:
            puts("Invalid input");
            break;
        }
    }

    return EXIT_SUCCESS;
}
