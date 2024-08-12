/*Using the Rail Fence algorithm with depth 3, write a program to encrypt the message �I love my 
college�.*/

#include <stdio.h>
#include <string.h>

void railFenceEncrypt(char* message, int depth) {
    int len = strlen(message);
    char fence[depth][len];
    char encryptedMessage[len];
    int row, col;
    int direction = 1;

    for (int i = 0; i < depth; i++) {
        for (int j = 0; j < len; j++) {
            fence[i][j] = '\0';
        }
    }

    row = 0;
    col = 0;

    for (int i = 0; i < len; i++) {
        fence[row][col] = message[i];
        if (row == 0) {
            direction = 1;
        }
        else if (row == depth - 1) {
            direction = -1;
        }
        row += direction;
        col++;
    }

    int index = 0;
    for (int i = 0; i < depth; i++) {
        for (int j = 0; j < len; j++) {
            if (fence[i][j] != '\0') {
                encryptedMessage[index++] = fence[i][j];
            }
        }
    }

    encryptedMessage[len] = '\0';

    printf("Encrypted message: %s\n", encryptedMessage);
}

int main() {
    char message[] = "I love my college";
    int depth = 3;

    railFenceEncrypt(message, depth);

    return 0;
}
