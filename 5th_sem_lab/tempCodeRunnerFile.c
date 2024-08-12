#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <time.h>

int EditDistance(char *str1, char *str2, int m, int n) {
    int dp[m + 1][n + 1];

    // Base cases: Initialize first row and column
    for (int i = 0; i <= m; i++) {
        dp[i][0] = i;
    }
    for (int j = 0; j <= n; j++) {
        dp[0][j] = j;
    }

    // Fill the dp table using the recursive relationship
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            if (str1[i - 1] == str2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1]; // No cost for match
            } else {
                dp[i][j] = 1 + min(dp[i - 1][j],  // Insertion
                                   min(dp[i][j - 1],  // Deletion
                                       dp[i - 1][j - 1])); // Substitution
            }
        }
    }

    return dp[m][n]; // Minimum edit distance
}

int main() {
    char str1[100], str2[100];
    int m, n, i;
    double time;
    clock_t start = clock();

    printf("Enter first string: ");
    fgets(str1, 100, stdin);  // Get input from user
    m = strlen(str1) - 1;     // Remove trailing newline

    printf("Enter second string: ");
    fgets(str2, 100, stdin);
    n = strlen(str2) - 1;

    // Calculate and display edit distance
    time = ((double)(clock() - start) + 1000) / CLOCKS_PER_SEC;
    printf("Edit distance: %d\n", EditDistance(str1, str2, m, n));
    printf("Time taken: %lf milliseconds\n", time);

    return 0;
}
