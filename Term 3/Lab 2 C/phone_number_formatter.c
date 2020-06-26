/**
* File: phone_number_formatter.c
* Author: Nabeel Nazir (nazi0022) >>
* Status:
* Compiles without warning(s): << True >>
* Requirement #1 - exit on input of 0: << complete >>
* Requirement #2 - not a 7-digit number: << complete >>
* Requirement #3 - invalid phone number: << complete >>
* Requirement #4 - formatted phone number: << complete >>
* Requirement #5 - loops until input of 0: << complete >>
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main() {
	setvbuf(stdout, NULL, _IONBF, 0);
	setvbuf(stderr, NULL, _IONBF, 0);
	char str[100];
	printf("Please enter a phone number: ");
	scanf("%s", str);
	while (str[0] != '0' || strlen(str) != 1) {
		if (strlen(str) > 7 || strlen(str) < 7) {
			printf("Not 7 digits long!");
		} else if (str[0] == '1' || str[0] == '0') {
			printf("Invalid Number!");
		} else {
			printf("The formatted phone number is: %c%c%c-%c%c%c%c", str[0],
					str[1], str[2], str[3], str[4], str[5], str[6]);
		}
		printf("\nPlease enter a phone number: ");
		scanf("%s", str);
	}
	printf("Exiting...");
	return 0;
}
