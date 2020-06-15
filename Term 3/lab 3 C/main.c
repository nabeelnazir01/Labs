#include <stdio.h>
#include "users.h"
#include "commands.h"
#include "tools.h"
int main(int argc, const char * argv[]) {
    
    if (canCopy()) {
        processInput("user input");
        char * userName = username();
        printf("Well done, you've complied and run the program correctly %s\n", userName);
    }
    
    return 0;
}
