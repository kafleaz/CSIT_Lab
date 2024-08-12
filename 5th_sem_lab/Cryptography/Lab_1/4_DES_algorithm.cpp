/*Write a program to demonstrate the calculation of initial permutation of a plain text in DES 
algorithm.*/

#include <stdio.h>

// Initial Permutation (IP) table
int initial_permutation_table[] = {
    58, 50, 42, 34, 26, 18, 10, 2,
    60, 52, 44, 36, 28, 20, 12, 4,
    62, 54, 46, 38, 30, 22, 14, 6,
    64, 56, 48, 40, 32, 24, 16, 8,
    57, 49, 41, 33, 25, 17, 9, 1,
    59, 51, 43, 35, 27, 19, 11, 3,
    61, 53, 45, 37, 29, 21, 13, 5,
    63, 55, 47, 39, 31, 23, 15, 7
};
void initial_permutation(char* plain_text, char* initial_permuted_text) {
    for (int i = 0; i < 64; i++) {
        int bit_position = initial_permutation_table[i] - 1;
        int byte_position = bit_position / 8;
        int bit_offset = 7 - (bit_position % 8);

        // Extract the bit from the byte
        char bit = (plain_text[byte_position] >> bit_offset) & 1;

        // Set the corresponding bit in the initial_permuted_text
        initial_permuted_text[i / 8] |= (bit << (7 - (i % 8)));
    }
}


int main() {
    char plain_text[] = "kafleaz9098";
    char initial_permuted_text[8] = {0};  // Initialize with zeros

    initial_permutation(plain_text, initial_permuted_text);

    printf("Plaintext: %s\n", plain_text);
    printf("Initial Permuted Text: ");
    for (int i = 0; i < 8; i++) {
        printf("%02X ", (unsigned char)initial_permuted_text[i]);
    }
    printf("\n");

    return 0;
}