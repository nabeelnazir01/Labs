
#include "commands.h"
#include "defs.h"

int copyCommand () {
    return COPY_COMMAND;
}

int cutCommand () {
    return CUT_COMMAND;
}

int pasteCommand() {
    return PASTE_COMMAND;
}

int canCopy () {
    return copyCommand() == 1001;
}

int canCut () {
    return cutCommand()== 1002;
}

int canPaste () {
    return pasteCommand() == 1003;
}
