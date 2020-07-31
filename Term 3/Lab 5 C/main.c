/*
============================================================================
Name : main.c
Author : <<< Nabeel Nazir (nazi0022) >>>
Version : Lab 5
Description : File I/O in C, Ansi-style
Status :
Builds clean; no warning(s) : << true >>
Requirement #1 - FileRead.txt in src/ : << complete >>
Requirement #2 - Open FileRead.txt read (only) : << complete >>
Requirement #3 - Open FileOut.txt write (only) : << complete >>
Requirement #4 - Check file open for success : << complete >>
Requirement #5 - Process FileRead.txt word-by-word: << complete >>
Requirement #6 - Display total words and chars : << complete >>
============================================================================
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    setvbuf(stdout, NULL, _IONBF, 0);
    setvbuf(stderr, NULL, _IONBF, 0);
    FILE *fp;
    fp = fopen("FileOut.txt", "w");

    FILE *fp2;
    char *filename = "FileRead.txt";

    fp2 = fopen(filename, "r");
    if (fp2 == NULL)
    {
        printf("Could not open file %s", filename);
        return 1;
    }

    char c;
    int count = 0;
    int charCount = 0;
    printf("The word I read from FileRead.txt -> ");
    while ((c = fgetc(fp2)) != EOF)
    {
        if (c == ' ' || c == '\n')
        {
            printf("\n");
            fprintf(fp, "\n");
            count++;
            printf("The word I read from FileRead.txt -> ");
        }
        else
        {
            printf("%c", c);
            fprintf(fp, "%c", c);
            charCount++;
        }
    }

    printf("\n\nTotal number of words in file: %d", count + 1);
    printf("\nTotal number of characters in file (sans white-space): %d", charCount);

    fclose(fp2);
    fclose(fp);
    printf("\nExiting...");
    return 0;
}
